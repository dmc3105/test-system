package com.dmc3105.view.card;

import com.dmc3105.model.entity.Question;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class QuestionCard extends AbstractCard {
    private ButtonGroup buttonGroup;
    
    public QuestionCard(Question question) {
        this.setLayout(new BorderLayout());
        
        initQuestionLabel(question);
        initAnswerVariantsPanel(question);
    }
    
    
    private void initQuestionLabel(Question question) {
        JLabel questionLabel = createQuestionLabel(question);
        addQuestionLabel(questionLabel);
    }
    private void addQuestionLabel(JLabel label) {
        add(label, BorderLayout.NORTH);
    }
    private JLabel createQuestionLabel(Question question) {
        JLabel label = new JLabel(question.getQuestionText());
        label.setFont(STANDARD_FONT);
        return label;
    }
    
    private void initAnswerVariantsPanel(Question question) {
        JPanel panel = createAnswerVariantsPanel(question);
        addAnswerVariantsPanel(panel);
    }
    
    private void addAnswerVariantsPanel(JPanel panel)
    {
        this.add(panel);
    }
    
    private JPanel createAnswerVariantsPanel(Question question) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        List<JRadioButton> answerVariantRadioButtons = createAnswerVariantRadioButtons(question);
        addAnswerVariantRadioButtons(panel, answerVariantRadioButtons);
        return panel;
    }
    
    private void addAnswerVariantRadioButtons(JPanel panel, List<JRadioButton> answerVariantRadioButtons) {
        answerVariantRadioButtons.forEach(panel::add);
    }
    
    private List<JRadioButton> createAnswerVariantRadioButtons(Question question) {
        List<JRadioButton> radioButtons = new ArrayList<>();
        buttonGroup = new ButtonGroup();
        List<String> answers = question.getAllAnswers();
        Collections.shuffle(answers);
        for (var answerText : answers) {
            JRadioButton newAnswerRadioButton = new JRadioButton();
            buttonGroup.add(newAnswerRadioButton);
            newAnswerRadioButton.setFont(STANDARD_FONT);
            newAnswerRadioButton.setText(answerText);
            radioButtons.add(newAnswerRadioButton);
        }
        return radioButtons;
    }
    
    public String getSelectedRadioButtonText() {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
}
