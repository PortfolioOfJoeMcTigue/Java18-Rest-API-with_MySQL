package com.mctigue.ready_set_cert_api.service.impl;

import com.mctigue.ready_set_cert_api.model.*;
import com.mctigue.ready_set_cert_api.service.ExamStatsService;
import com.mctigue.ready_set_cert_api.service.TestInformationService;
import com.mctigue.ready_set_cert_api.service.UserExamResultsService;
import com.mctigue.ready_set_cert_api.service.UserService;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

@Service
public class UserExamResultsServiceImpl implements UserExamResultsService {

    private UserService userService;
    private TestInformationService testInformationService;
    private ExamStatsService examStatsService;

    public UserExamResultsServiceImpl(UserService userService,
                                      TestInformationService testInformationService,
                                      ExamStatsService examStatsService) {
        this.userService = userService;
        this.testInformationService = testInformationService;
        this.examStatsService = examStatsService;
    }

    public UserExamResults retrieveUserResults(Integer examId, Integer userId) {

        UserExamResults userResults = new UserExamResults();
        String userName = getUserName(userId);
        String examName = getExamName(examId);
        Integer percentageToPass = getExamPassingPercentage(examId);
        HashMap<String, Integer> userDateOfExamWithPercentageCorrect = getUsersResultPercentage(examId, userId);
        userResults.setUserName(userName);
        userResults.setExamName(examName);
        userResults.setPercentageToPass(percentageToPass);
        userResults.setUserExamDateTimeAndResultPercentage(userDateOfExamWithPercentageCorrect);

        return userResults;
    }

    public String getUserName(Integer userId) {
        List<User> user = userService.getUserName(userId);
        return user.get(0).getUserName();
    }

    public String getExamName(Integer examId) {
        return testInformationService.getExamNameById(examId);
    }

    public Integer getExamPassingPercentage(Integer examId) {
        return testInformationService.getExamPassingPercentageById(examId);
    }

    public HashMap<String, Integer> getUsersResultPercentage(Integer examId, Integer userId) {
        HashMap<String, Integer> dateResultMap = new HashMap<>();
        List<ExamStats> examStats = examStatsService.getExamStatsByExamIdAndUserId(examId, userId);
        for (ExamStats exam : examStats) {
            Double totalQuestions = (double) exam.getTotalQuestions();
            Double NumberOfWrongAnswers = (double) exam.getTotalWrongAnswers();
            Double percentageAchieved = (totalQuestions - NumberOfWrongAnswers) / totalQuestions * 100;
            dateResultMap.put( exam.getDateTaken(), Integer.valueOf( percentageAchieved.intValue() ) );
        }
        return dateResultMap;
    }
}




