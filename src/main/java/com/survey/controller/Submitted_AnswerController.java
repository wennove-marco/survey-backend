package com.survey.controller;

import com.survey.model.Submitted_Answer;
import com.survey.repository.Submitted_AnswerRepository;
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

public class Submitted_AnswerController {

    @Autowired
    Submitted_AnswerRepository repository;

    @GetMapping("/submitted-answer")
    public ResponseEntity<List<Submitted_Answer>> getSubmittedAnswer() {
        try {
            List<Submitted_Answer> submitted_answers = new ArrayList<>();

            submitted_answers.addAll(repository.findAll());

            if (submitted_answers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(submitted_answers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/submitted-answer/{id_submitted_survey}")
    public ResponseEntity<List<Submitted_Answer>> getSurveyById_submitted_survey(@PathVariable("id_submitted_survey") Long id_submitted_survey) {
        try {
            List<Submitted_Answer> submitted_answers = new ArrayList<>();

            repository.findById_submitted_survey(id_submitted_survey).forEach(submitted_answers::add);

            if (submitted_answers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(submitted_answers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(
            value = "/submitted-answer",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Submitted_Answer> createSubmittedAnswer(@RequestBody Submitted_Answer submitted_answer) {
        try {
            Submitted_Answer newSubmittedAnswer = repository.save(new Submitted_Answer(submitted_answer.getId_submitted_survey(), submitted_answer.getId_question_answer()));
            return new ResponseEntity<>(newSubmittedAnswer, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}