package com.mctigue.ready_set_cert_api.service;

import com.mctigue.ready_set_cert_api.model.TestInformation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestInformationService {
    public List<TestInformation> getTestInformation();
    public String getExamNameById(Integer examId);
    public Integer getExamPassingPercentageById(Integer examId);
    public List<TestInformation> getActiveTestInformation();
    public List<TestInformation> getTestInformationByCategory(String category);
    public void addTestInformation(TestInformation testInformation);
    public void deleteQuestion(int id);
}
