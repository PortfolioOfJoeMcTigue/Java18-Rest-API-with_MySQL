package com.mctigue.ready_set_cert_api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
@Table(name = "test_results")
public class ExamResults {

    @Id
    @Column
    private Integer id;

    @Column
    private Integer userId;

    @Column
    private Integer examId;

    @Column
    private Integer questionId;

    @Column
    private Integer referenceId;

    @Column
    private Integer answerResult;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd_hh:mm:ss")
    @Column
    private String timeStamp;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Integer referenceId) {
        this.referenceId = referenceId;
    }

    public Integer isAnswerResult() {
        return answerResult;
    }

    public void setAnswerResult(Integer answerResult) {
        this.answerResult = answerResult;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }


    @Override
    public String toString() {
        return "ExamResults{" +
                "id=" + id +
                ", userId=" + userId +
                ", examId=" + examId +
                ", questionId=" + questionId +
                ", referenceId=" + referenceId +
                ", answerResult=" + answerResult +
                '}';
    }
}
