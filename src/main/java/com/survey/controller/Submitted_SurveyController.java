package com.survey.controller;

import com.survey.model.Submitted_Survey;
import com.survey.repository.Submitted_SurveyRepository;
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

public class Submitted_SurveyController {

    @Autowired
    Submitted_SurveyRepository repository;

    @GetMapping("/submitted-survey")
    public ResponseEntity<List<Submitted_Survey>> getSubSurveys() {
        try {
            List<Submitted_Survey> surveys = new ArrayList<>();

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
            value = "/submitted-survey",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Submitted_Survey> createSubSurvey(@RequestBody Submitted_Survey survey) {
        try {
            Submitted_Survey newSubSurvey = repository.save(new Submitted_Survey(survey.getId_survey(), survey.getId_mail()));
            return new ResponseEntity<>(newSubSurvey, HttpStatus.CREATED);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
