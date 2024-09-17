package com.mctigue.ready_set_cert_api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

import java.sql.Timestamp;

@Entity
@Table(name = "exam_stats")
public class ExamStats {

    @Id
    @Column
    private Integer id;
    @Column
    private Integer examId;
    @Column
    private Integer userId;
    @Column
    private Integer totalQuestions;
    @Column
    private Integer totalWrongAnswers;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column
    private String dateTaken;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(Integer totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public Integer getTotalWrongAnswers() {
        return totalWrongAnswers;
    }

    public void setTotalWrongAnswers(Integer totalWrongAnswers) {
        this.totalWrongAnswers = totalWrongAnswers;
    }

    public String getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(String dateTaken) {
        this.dateTaken = dateTaken;
    }

    @Override
    public String toString() {
        return "ExamStats{" +
                "id=" + id +
                ", examId=" + examId +
                ", userId=" + userId +
                ", totalQuestions=" + totalQuestions +
                ", totalWrongAnswers=" + totalWrongAnswers +
                ", dateTaken=" + dateTaken +
                '}';
    }
}
