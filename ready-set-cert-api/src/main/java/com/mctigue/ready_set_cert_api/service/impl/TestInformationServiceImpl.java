package com.mctigue.ready_set_cert_api.service.impl;

import com.mctigue.ready_set_cert_api.Repository.TestInformationRepository;
import com.mctigue.ready_set_cert_api.model.TestInformation;
import com.mctigue.ready_set_cert_api.service.TestInformationService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestInformationServiceImpl implements TestInformationService {

    private final TestInformationRepository testInformationRepository;

    public TestInformationServiceImpl(TestInformationRepository testInformationRepository) {
        this.testInformationRepository = testInformationRepository;
    }

    public List<TestInformation> getTestInformation() {
        return testInformationRepository.findAll();
    }

    public String getExamNameById(Integer examId) {
        List<TestInformation> info = getTestInformation()
                .stream()
                .filter(testInformation -> testInformation.getId().equals(examId)).toList();
        return info.get(0).getExamName();
    }

    public Integer getExamPassingPercentageById(Integer examId) {
        List<TestInformation> info = getTestInformation()
                .stream()
                .filter(testInformation -> testInformation.getId().equals(examId)).toList();
        return info.get(0).getPassPercentage();
    }

    public List<TestInformation> getActiveTestInformation() {
        Integer active = 1;
        return getTestInformation()
                .stream()
                .filter(testInformation -> testInformation.getActive().equals(active)).toList();
    }

    public List<TestInformation> getTestInformationByCategory(String category) {
        return getTestInformation()
                .stream()
                .filter(testInformation -> testInformation.getCategory().equals(category)).toList();
    }

    public void addTestInformation(TestInformation testInformation) {
        testInformationRepository.save(testInformation);
    }

    public void deleteQuestion(int id) {
        List<TestInformation> testInformations = testInformationRepository.findAll();
        for (int x = 0; x < testInformations.size(); x++) {
            if (testInformations.get(x).getId() == id) {
                testInformations.remove(testInformations.get(x));
            }
        }
    }
}
