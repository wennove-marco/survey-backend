package com.survey.controller;

import com.survey.model.Survey_Composition;
import com.survey.repository.Survey_CompositionRepository;
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

public class Survey_CompositionController {

    @Autowired
    Survey_CompositionRepository repository;

    @GetMapping("/survey-composition")
    public ResponseEntity<List<Survey_Composition>> getSurveyComposition() {
        try {
            List<Survey_Composition> survey_composition = new ArrayList<>();

            survey_composition.addAll(repository.findAll());

            if (survey_composition.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(survey_composition, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/survey-composition/{id_survey}")
    public ResponseEntity<List<Survey_Composition>> getSurveyById_survey(@PathVariable("id_survey") Long id_survey) {
        try {
            List<Survey_Composition> survey_composition = new ArrayList<>();

            repository.findById_survey(id_survey).forEach(survey_composition::add);

            if (survey_composition.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(survey_composition, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(
            value = "/survey-composition",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Survey_Composition> createSurveyComposition(@RequestBody Survey_Composition survey_composition) {
        try {
            Survey_Composition newSurveyComposition = repository.save(new Survey_Composition(survey_composition.getId_survey(), survey_composition.getId_question_answer()));
            return new ResponseEntity<>(newSurveyComposition, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}