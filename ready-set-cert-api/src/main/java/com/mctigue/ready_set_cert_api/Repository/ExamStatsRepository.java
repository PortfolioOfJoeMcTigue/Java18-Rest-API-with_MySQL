package com.mctigue.ready_set_cert_api.Repository;

import com.mctigue.ready_set_cert_api.model.ExamStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamStatsRepository extends JpaRepository<ExamStats, Integer> {
}
