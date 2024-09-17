package com.mctigue.ready_set_cert_api.service.impl;

import com.mctigue.ready_set_cert_api.Repository.ExamStatsRepository;
import com.mctigue.ready_set_cert_api.model.ExamStats;
import com.mctigue.ready_set_cert_api.service.ExamStatsService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamStatsServiceImpl implements ExamStatsService {

    //List<ExamStats> examStats = new ArrayList<>();
    private final ExamStatsRepository examStatsRepository;

    public ExamStatsServiceImpl(ExamStatsRepository examStatsRepository) {
        this.examStatsRepository = examStatsRepository;
    }

    public List<ExamStats> getExamStats() {
        return examStatsRepository.findAll();
    }

    public List<ExamStats> getExamStatsByExamId(Integer examId) {
        return getExamStats()
                .stream()
                .filter(examStats -> examStats.getExamId().equals(examId)).toList();
    }

    public List<ExamStats> getExamStatsByExamIdAndUserId(Integer examId, Integer userId) {
        return getExamStatsByExamId(examId)
                .stream()
                .filter(examStats -> examStats.getUserId().equals(userId)).toList();
    }

    public void addExamStats(ExamStats examStats) {
        examStatsRepository.save(examStats);
    }
}
