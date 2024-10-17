package com.dmc3105.model.entity;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test implements Iterable<Question>, Serializable {
    List<Question> questions = new LinkedList<>();
    
    public void addQuestion(Question question) {
        questions.add(question);
    }
    
    public void removeQuestion(Question question) {
        questions.remove(question);
    }
    
    public List<Question> getAllQuestions() { return questions; }
    
    @Override
    public Iterator<Question> iterator() {
        return questions.iterator();
    }
}
