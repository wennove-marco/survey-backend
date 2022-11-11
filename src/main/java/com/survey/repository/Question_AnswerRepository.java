package com.survey.repository;

import com.survey.model.Question_Answer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Question_AnswerRepository extends JpaRepository<Question_Answer, Long> {
    Page<Question_Answer> findAll(Pageable pageable);
}
