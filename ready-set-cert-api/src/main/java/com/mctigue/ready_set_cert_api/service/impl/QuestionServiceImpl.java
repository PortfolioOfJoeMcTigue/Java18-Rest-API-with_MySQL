package com.mctigue.ready_set_cert_api.service.impl;

import com.mctigue.ready_set_cert_api.Repository.QuestionRepository;
import com.mctigue.ready_set_cert_api.model.Question;
import com.mctigue.ready_set_cert_api.service.QuestionService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }

    public void addQuestion(Question question) {
        questionRepository.save(question);
    }

    public Question getQuestionById(Integer id) {
        return getQuestions()
                .stream()
                .filter(question -> (question.getId() == id )).findFirst().orElseThrow();
    }

    public void deleteQuestion(int id) {
        List<Question> questions = questionRepository.findAll();
        for (int x = 0; x < questions.size(); x++) {
            if (questions.get(x).getId() == id) {
                questions.remove(questions.get(x));
            }
        }
    }
}
