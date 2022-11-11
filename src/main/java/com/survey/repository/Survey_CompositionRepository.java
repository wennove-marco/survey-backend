package com.survey.repository;

import com.survey.model.Survey_Composition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List; 

public interface Survey_CompositionRepository extends JpaRepository<Survey_Composition, Long> {
    @Query("select s from Survey_Composition s where s.id_survey = ?1")
    List<Survey_Composition> findById_survey(Long id_survey);

    Page<Survey_Composition> findAll(Pageable pageable);
}
