package com.mctigue.ready_set_cert_api.service;

import com.mctigue.ready_set_cert_api.model.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {
    public List<Question> getQuestions();
    public void addQuestion(Question question);
    public Question getQuestionById(Integer id);
    public void deleteQuestion(int id);
}
