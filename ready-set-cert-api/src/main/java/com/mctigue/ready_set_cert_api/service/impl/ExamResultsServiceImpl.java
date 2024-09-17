package com.mctigue.ready_set_cert_api.service.impl;

import com.mctigue.ready_set_cert_api.Repository.ExamResultsRepository;
import com.mctigue.ready_set_cert_api.model.ExamResults;
import com.mctigue.ready_set_cert_api.service.ExamResultsService;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ExamResultsServiceImpl implements ExamResultsService {

    private final ExamResultsRepository examResultsRepository;

    public ExamResultsServiceImpl(ExamResultsRepository examResultsRepository) {
        this.examResultsRepository = examResultsRepository;
    }

    public List<ExamResults> getExamResults() {
        return examResultsRepository.findAll();
    }

    public List<ExamResults> getExamResultsByExam(Integer examId) {
        return getExamResults()
                .stream()
                .filter(examResults -> examResults.getExamId().equals(examId)).toList();
    }

    public List<ExamResults> getExamResultsByExamAndUser(Integer examId, Integer userId) {
        return getExamResultsByExam(examId)
                .stream()
                .filter(examResults -> examResults.getUserId().equals(userId)).toList();
    }

    public ExamResults getLatestExamResultsByExamAndUser(Integer examId, Integer userId) {
        List<ExamResults> examResultsOne = getExamResultsByExamAndUser(examId, userId);
        ArrayList<Timestamp> dateList = new ArrayList<>();
        for (int x = 0; x < examResultsOne.size(); x++) {
            Timestamp currentDate = Timestamp.valueOf(examResultsOne.get(x).getTimeStamp());
            dateList.add(currentDate);
        }
        Timestamp latestExamDate = Collections.max(dateList);
        String compareTimestamp = latestExamDate.toString();
        ExamResults exam = new ExamResults();
        List<ExamResults> examResultsTwo = getExamResultsByExamAndUser(examId, userId);
        for (int x = 0; x < examResultsTwo.size(); x++) {
            if ( examResultsTwo.get(x).getTimeStamp().equals(compareTimestamp) ) {
                exam = examResultsTwo.get(x);
            }
        }
        return exam;
    }

    public List<ExamResults> getExamResultsWhereAnswersAreIncorrect(Integer examId, Integer userId) {
        return getExamResultsByExamAndUser(examId, userId)
                .stream()
                .filter(examResults -> examResults.isAnswerResult().equals(0)).toList();
    }

    public void addExamResults(ExamResults examResults) {
        examResultsRepository.save(examResults);
    }

    public void deleteQuestion(int id) {
        List<ExamResults> examResults = examResultsRepository.findAll();
        for (int x = 0; x < examResults.size(); x++) {
            if (examResults.get(x).getId() == id) {
                examResults.remove(examResults.get(x));
            }
        }
    }
}
