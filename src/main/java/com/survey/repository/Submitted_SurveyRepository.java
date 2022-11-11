package com.survey.repository;

import com.survey.model.Submitted_Survey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository; 

public interface Submitted_SurveyRepository extends JpaRepository<Submitted_Survey, Long> {
    Page<Submitted_Survey> findAll(Pageable pageable);
}
