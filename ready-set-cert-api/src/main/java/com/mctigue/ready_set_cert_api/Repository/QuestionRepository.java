package com.mctigue.ready_set_cert_api.Repository;

import com.mctigue.ready_set_cert_api.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
