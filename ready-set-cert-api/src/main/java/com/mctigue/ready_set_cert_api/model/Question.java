package com.mctigue.ready_set_cert_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @Column
    private Integer id;
    @Column
    private String examName;
    @Column
    private Integer questionNumber;
    @Column
    private String question;
    @Column
    private String scenario;
    @Column
    private String choice_1;
    @Column
    private String choice_2;
    @Column
    private String choice_3;
    @Column
    private String choice_4;
    @Column
    private String choice_5;
    @Column
    private String answer;
    @Column
    private String why;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Integer questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public String getChoice_1() {
        return choice_1;
    }

    public void setChoice_1(String choice_1) {
        this.choice_1 = choice_1;
    }

    public String getChoice_2() {
        return choice_2;
    }

    public void setChoice_2(String choice_2) {
        this.choice_2 = choice_2;
    }

    public String getChoice_3() {
        return choice_3;
    }

    public void setChoice_3(String choice_3) {
        this.choice_3 = choice_3;
    }

    public String getChoice_4() {
        return choice_4;
    }

    public void setChoice_4(String choice_4) {
        this.choice_4 = choice_4;
    }

    public String getChoice_5() {
        return choice_5;
    }

    public void setChoice_5(String choice_5) {
        this.choice_5 = choice_5;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", examName='" + examName + '\'' +
                ", questionNumber='" + questionNumber + '\'' +
                ", question='" + question + '\'' +
                ", scenario='" + scenario + '\'' +
                ", choice_1='" + choice_1 + '\'' +
                ", choice_2='" + choice_2 + '\'' +
                ", choice_3='" + choice_3 + '\'' +
                ", choice_4='" + choice_4 + '\'' +
                ", choice_5='" + choice_5 + '\'' +
                ", answer='" + answer + '\'' +
                ", why='" + why + '\'' +
                '}';
    }
}
