package com.survey.repository;

import com.survey.model.Survey_Table;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Survey_TableRepository extends JpaRepository<Survey_Table, Long> {
    //Optional<Survey_Table> findById_mail(String id_mail);
    Optional<Survey_Table> findById(long id_survey);
    Page<Survey_Table> findAll(Pageable pageable);
}