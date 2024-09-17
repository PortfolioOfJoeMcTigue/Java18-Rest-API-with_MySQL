package com.mctigue.ready_set_cert_api.service;

import com.mctigue.ready_set_cert_api.model.ExamResults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExamResultsService {
    public List<ExamResults> getExamResults();
    public List<ExamResults> getExamResultsByExam(Integer examId);
    public List<ExamResults> getExamResultsByExamAndUser(Integer examId, Integer userId);
    public ExamResults getLatestExamResultsByExamAndUser(Integer examId, Integer userId);
    public List<ExamResults> getExamResultsWhereAnswersAreIncorrect(Integer examId, Integer userId);
    public void addExamResults(ExamResults examResults);
    public void deleteQuestion(int id);
}
