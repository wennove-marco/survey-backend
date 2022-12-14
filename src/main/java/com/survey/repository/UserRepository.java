package com.survey.repository;

import com.survey.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository; 

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByMail(String mail);
    Page<User> findAll(Pageable pageable);
}