package com.mctigue.ready_set_cert_api.service;
;
import com.mctigue.ready_set_cert_api.model.ExamStats;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExamStatsService {
    public List<ExamStats> getExamStats();
    public List<ExamStats> getExamStatsByExamId(Integer examId);
    public List<ExamStats> getExamStatsByExamIdAndUserId(Integer examId, Integer userId);
    public void addExamStats(ExamStats examStats);
}
