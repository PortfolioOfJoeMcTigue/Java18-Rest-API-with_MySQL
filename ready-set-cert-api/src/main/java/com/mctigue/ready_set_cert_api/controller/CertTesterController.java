package com.mctigue.ready_set_cert_api.controller;

import com.mctigue.ready_set_cert_api.model.*;
import com.mctigue.ready_set_cert_api.service.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ready-set-cert-api")
public class CertTesterController {

    private final QuestionService questionService;
    private final UserService userService;
    private final TestInformationService testInformationService;
    private final ExamResultsService examResultsService;
    private final ExamStatsService examStatsService;
    private final UserExamResultsService userExamResultsService;

    public CertTesterController(QuestionService questionService, UserService userService,
                                TestInformationService testInformationService,
                                ExamResultsService examResultsService,
                                ExamStatsService examStatsService,
                                UserExamResultsService userExamResultsService ) {

        this.questionService = questionService;
        this.userService = userService;
        this.testInformationService = testInformationService;
        this.examResultsService = examResultsService;
        this.examStatsService = examStatsService;
        this.userExamResultsService = userExamResultsService;
    }

    @GetMapping("/healthcheck")
    public ResponseEntity healthCheckMessage() {
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/exam/testinfo/add")
    public String addTestInformation(@RequestBody TestInformation testInformation) {
        testInformationService.addTestInformation(testInformation);
        return "Test Information for the Exam: '" + testInformation.getExamName() + "' has been successfully saved.";
    }

    @PostMapping("/exam/user/add")
    public String addUserInformation(@RequestBody User user) {
        userService.addUser(user);
        return "User is: '"+ user.getUserName() + "' and their email address is: '"+user.getEmailAddress()+"'.";
    }

    @PostMapping("/exam/question/add")
    public String addQuestion(@RequestBody Question question) {
        questionService.addQuestion(question);
        return "Exam Name: '" + question.getExamName() + "', Question Number: '" + question.getQuestionNumber() + "' has been Saved.";
    }

    @GetMapping("/exam/questions/getall")
    public List<Question> getAllQuestions() {
        return questionService.getQuestions();
    }

    @GetMapping("/exam/question/getbyid/{id}")
    public Question getQuestionById(@PathVariable Integer id) {
        return questionService.getQuestionById(id);
    }

    @GetMapping("/exam/list/active")
    public List<TestInformation> getActiveExamsList() {
        return testInformationService.getActiveTestInformation();
    }

    @GetMapping("/exam/list/all")
    public List<TestInformation> getExamsList() {
        return testInformationService.getTestInformation();
    }

    @GetMapping("/exam/latestexamresults/{exam_id}/{user_id}")
    public ExamResults getLatestExamResultsByExamIdAndUserId(@PathVariable Integer exam_id, @PathVariable Integer user_id) {
        return examResultsService.getLatestExamResultsByExamAndUser(exam_id, user_id);
    }

    @GetMapping("/exam/results/{exam_id}/{user_id}")
    public List<ExamResults> getExamResultsByExamIdAndUserId(@PathVariable Integer exam_id, @PathVariable Integer user_id) {
        return examResultsService.getExamResultsByExamAndUser(exam_id, user_id);
    }

    @GetMapping("/exam/results/needingwork/{exam_id}/{user_id}")
    public List<ExamResults> getExamResultsNeedingWork(@PathVariable Integer exam_id, @PathVariable Integer user_id) {
        return examResultsService.getExamResultsWhereAnswersAreIncorrect(exam_id, user_id);
    }

    @PostMapping("/exam/results/add")
    public String addExamResults(@RequestBody ExamResults examResults) {
        examResultsService.addExamResults(examResults);
        return "Exam results for User ID: "+examResults.getUserId()+" was entered.";
    }

    @PostMapping("/exam/examstats/add")
    public String addExamStats(@RequestBody ExamStats examStats) {
        examStatsService.addExamStats(examStats);
        return "Exam stats for User ID: "+examStats.getUserId()+" was entered.";
    }

    @GetMapping("/exam/examstats/{exam_id}/{user_id}")
    public List<ExamStats> getExamStatsByExamIdAndUserId(@PathVariable Integer exam_id, @PathVariable Integer user_id) {
        return examStatsService.getExamStatsByExamIdAndUserId(exam_id, user_id);
    }

    @GetMapping("/exam/userresults/{exam_id}/{user_id}")
    public UserExamResults getDataForUserExamReport(@PathVariable Integer exam_id, @PathVariable Integer user_id) {
        return userExamResultsService.retrieveUserResults(exam_id, user_id);
    }

}
