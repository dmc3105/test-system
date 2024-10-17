package com.dmc3105.view.card;

import com.dmc3105.model.entity.Question;
import com.dmc3105.model.entity.Test;
import java.awt.CardLayout;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.swing.border.EmptyBorder;

public class QuestionSliderCard extends AbstractCard {
    private final CardLayout CARDS = new CardLayout();
    private final List<QuestionCard> QUESTION_CARDS = new LinkedList<>();
    private final int QUESTION_COUNT;
    private int currentQuestionIndex = 0;
    
    public QuestionSliderCard(Test test) {
        this.setLayout(CARDS);
        
        List<Question> questions = test.getAllQuestions();
        Collections.shuffle(questions);
        QUESTION_COUNT = questions.size();
        
        int i = 0;
        for (var question : questions) {
            QuestionCard questionCard = new QuestionCard(question);
            QUESTION_CARDS.add(questionCard);
            this.add(questionCard, String.valueOf(i));
            i++;
        }
    }
    
    public void showNextQuestion() {
        if (currentQuestionIndex == QUESTION_COUNT - 1)
            throw new IllegalStateException();
        currentQuestionIndex++;
        CARDS.show(this, String.valueOf(currentQuestionIndex));
    }
    
    public void showPreviousQuestion() {
        if (currentQuestionIndex == 0)
            throw new IllegalStateException();
        currentQuestionIndex--;
        CARDS.show(this, String.valueOf(currentQuestionIndex));
        
    }
    
    public boolean isLastQuestion() {
        return currentQuestionIndex == QUESTION_COUNT - 1;
    }
    
    public boolean isFirstQuestion() {
        return currentQuestionIndex == 0;
    }
    
    public List<String> getAnswers() {
        List<String> answers = new LinkedList<>();
        
        for (var questionCard : QUESTION_CARDS) {
            answers.add(questionCard.getSelectedRadioButtonText());
        }
        
        return answers;
    }
}
