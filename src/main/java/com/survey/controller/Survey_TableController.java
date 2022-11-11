package com.survey.controller;

import com.survey.model.Survey_Table;
import com.survey.repository.Survey_TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("survey/api")

public class Survey_TableController {

    @Autowired
    Survey_TableRepository repository;

    @GetMapping("/surveys")
    public ResponseEntity<List<Survey_Table>> getAllSurveys() {
        try {
            List<Survey_Table> surveys = new ArrayList<>();

            surveys.addAll(repository.findAll());

            if (surveys.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(surveys, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(
            value = "/survey",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Survey_Table> createSurvey(@RequestBody Survey_Table survey) {
        try {
            Survey_Table newSurvey = repository.save(new Survey_Table(survey.getId_mail(), survey.getId_category(), survey.getName(), survey.getDescription(), survey.getPublish_date(), survey.getEnding_date()));
            return new ResponseEntity<>(newSurvey, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
