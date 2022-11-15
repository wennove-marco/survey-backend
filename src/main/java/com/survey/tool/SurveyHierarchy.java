package com.survey.tool;

import java.util.ArrayList;
import java.util.List;

import com.survey.model.Question;

public class SurveyHierarchy {

	public SurveyHierarchy() {
	}
	
	private List<Question> questions = new ArrayList<Question>();

	public void setQuestions(ArrayList<Question> questions) {
		//this.questions = questions;
	}
	
	public List<Question> getQuestions() {
        return this.questions;
    }
 

}
