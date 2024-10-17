package com.dmc3105.model.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Question implements Serializable {
    private final String questionText;
    private final String rightAnswer;
    
    private final List<String> answers;
    
    public Question(String questionText, String rightAnswer, String... possibleAnswers) {
        this.questionText = questionText;
        this.rightAnswer = rightAnswer;
        this.answers = new LinkedList<>();
        
        this.answers.add(rightAnswer);
        this.answers.addAll(Arrays.asList(possibleAnswers));
    }
    
    public boolean isAnswerRight(String answer) {
        return rightAnswer.equals(answer);
    }
    
    public List<String> getAllAnswers() {
        return answers;
    }
    
    public String getQuestionText() {
        return questionText;
    }
}
