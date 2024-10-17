package com.dmc3105.view.card;

import com.dmc3105.model.entity.Test;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PassTestCard extends AbstractCard {
    public static final String TEST_PASSED = "testPassed";
    private ButtonsGrid buttonsGrid;
    private final QuestionSliderCard QUESTION_SLIDER_CARD;
    
    public PassTestCard(Test test) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        QUESTION_SLIDER_CARD = createQuestionSlider(test);
        addQuestionSliderCard(QUESTION_SLIDER_CARD);
        initButtonsGrid(QUESTION_SLIDER_CARD);
        
        addMargin();
    }
    
    private void addMargin() {
        setBorder(new EmptyBorder(20, 20, 20, 20));
    }
    
    private void initButtonsGrid(QuestionSliderCard questionSlider) {
        buttonsGrid = createButtonsGrid();
        updateButtonsState();
        
        buttonsGrid.previousQuestionButton.addActionListener(e -> {
            if (!questionSlider.isFirstQuestion())
                questionSlider.showPreviousQuestion();
            updateButtonsState();
        });
        
        buttonsGrid.nextQuestionButton.addActionListener(e -> {
            if (!questionSlider.isLastQuestion())
                questionSlider.showNextQuestion();
            updateButtonsState();
        });
        
        buttonsGrid.endTestButton.addActionListener(e -> {
            invokeListeners(TEST_PASSED);
        });
        
        addButtonsGrid(buttonsGrid);
    }
    
    private void addButtonsGrid(ButtonsGrid buttonsGrid) {
        this.add(buttonsGrid);
    }
    
    private ButtonsGrid createButtonsGrid() {
        return new ButtonsGrid();
    }
    
    private void addQuestionSliderCard(QuestionSliderCard questionSlider) {
        this.add(questionSlider, BorderLayout.CENTER);
    }
    
    private QuestionSliderCard createQuestionSlider(Test test) {
        return new QuestionSliderCard(test);
    }
    
    private void updateButtonsState()
    {
        buttonsGrid.previousQuestionButton.setEnabled(!QUESTION_SLIDER_CARD.isFirstQuestion());
        buttonsGrid.nextQuestionButton.setEnabled(!QUESTION_SLIDER_CARD.isLastQuestion());
    }
    
    public List<String> getAnswers() {
        return QUESTION_SLIDER_CARD.getAnswers();
    }
    
    private static class ButtonsGrid extends JPanel{
        public JButton previousQuestionButton;
        public JButton endTestButton;
        public JButton nextQuestionButton;
        
        public ButtonsGrid() {
            previousQuestionButton = new JButton("Предыдущий вопрос");
            previousQuestionButton.setFont(STANDARD_FONT);
            
            endTestButton = new JButton("Завершить тест");
            endTestButton.setFont(STANDARD_FONT);
            
            nextQuestionButton = new JButton("Следующий вопрос");
            nextQuestionButton.setFont(STANDARD_FONT);
            
            
            GridLayout layout = new GridLayout(3, 1);
            layout.setVgap(5);
            this.setLayout(layout);
            this.add(nextQuestionButton);
            this.add(previousQuestionButton);
            this.add(endTestButton);
        }
    }
    
}
