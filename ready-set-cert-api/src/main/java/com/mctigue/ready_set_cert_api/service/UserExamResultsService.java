package com.mctigue.ready_set_cert_api.service;

import com.mctigue.ready_set_cert_api.model.UserExamResults;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;

@Service
public interface UserExamResultsService {
    public UserExamResults retrieveUserResults(Integer examId, Integer userId);
    public String getUserName(Integer userId);
    public String getExamName(Integer examId);
    public Integer getExamPassingPercentage(Integer examId);
    public HashMap<String, Integer> getUsersResultPercentage(Integer examId, Integer userId);
}




