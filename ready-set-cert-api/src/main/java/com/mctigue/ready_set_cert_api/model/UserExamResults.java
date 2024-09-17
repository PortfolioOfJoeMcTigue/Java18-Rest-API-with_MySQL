package com.mctigue.ready_set_cert_api.model;

import java.sql.Timestamp;
import java.util.HashMap;

public class UserExamResults {

    private String userName;
    private String examName;
    private Integer percentageToPass;
    private HashMap<String, Integer> userExamDateTimeAndResultPercentage;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Integer getPercentageToPass() {
        return percentageToPass;
    }

    public void setPercentageToPass(Integer percentageToPass) {
        this.percentageToPass = percentageToPass;
    }

    public HashMap<String, Integer> getUserExamDateTimeAndResultPercentage() {
        return userExamDateTimeAndResultPercentage;
    }

    public void setUserExamDateTimeAndResultPercentage(HashMap<String, Integer> userExamDateTimeAndResultPercentage) {
        this.userExamDateTimeAndResultPercentage = userExamDateTimeAndResultPercentage;
    }

    @Override
    public String toString() {
        return "UserResults{" +
                "userName='" + userName + '\'' +
                ", examName='" + examName + '\'' +
                ", percentageToPass=" + percentageToPass +
                ", userExamDateTimeAndResultPercentage=" + userExamDateTimeAndResultPercentage +
                '}';
    }
}
