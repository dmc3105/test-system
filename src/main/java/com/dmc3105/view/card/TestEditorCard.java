package com.dmc3105.view.card;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class TestEditorCard extends AbstractCard {
    
    public static final String GO_TO_MAIN_MENU = "goToMainMenu";
    public static final String CLEAR_TEST = "clearTest";
    public static final String SAVE_TEST = "saveTest";
    public static final String LOAD_TEST = "loadTest";
    public static final String ADD_QUESTION = "addQuestion";
    public static final String REMOVE_QUESTION = "removeQuestion";
    
    private final TestControlsButtonsGrid TEST_CONTROLS_BUTTON_GRID = new TestControlsButtonsGrid();
    private final AddRemoveQuestionButtonGrid ADD_REMOVE_QUESTION_BUTTON_GRID = new AddRemoveQuestionButtonGrid();
    
    public TestEditorCard() {
        this.setLayout(new BorderLayout(10, 10));
        addMargin();
        
        this.add(new QuestionList(), BorderLayout.CENTER);
        this.add(TEST_CONTROLS_BUTTON_GRID, BorderLayout.SOUTH);
        this.add(new AddRemoveQuestionButtonGrid(), BorderLayout.EAST);
        this.add(new QuestionLabel(), BorderLayout.NORTH);
        
        TEST_CONTROLS_BUTTON_GRID.goBackButton.addActionListener(e -> invokeListeners(GO_TO_MAIN_MENU));
        TEST_CONTROLS_BUTTON_GRID.clearButton.addActionListener(e -> invokeListeners(CLEAR_TEST));
        TEST_CONTROLS_BUTTON_GRID.saveButton.addActionListener(e -> invokeListeners(SAVE_TEST));
        TEST_CONTROLS_BUTTON_GRID.loadButton.addActionListener(e -> invokeListeners(LOAD_TEST));
        //TODO here
    }
    
    private void addMargin() {
        setBorder(new EmptyBorder(20, 20, 20, 20));
    }
    private class AddRemoveQuestionButtonGrid extends JPanel {
        private JButton addButton;
        private JButton removeButton;
        
        private final GridBagConstraints gbc;
        
        public AddRemoveQuestionButtonGrid() {
            LayoutManager layout = new GridBagLayout();
            gbc = new GridBagConstraints();
            gbc.insets = new Insets(0, 0, 10, 0);
            gbc.fill = GridBagConstraints.BOTH;
            this.setLayout(layout);
            
            initAddButton();
            initRemoveButton();
        }
        
        private void initAddButton() {
            addButton = new JButton("+");
            addButton.setFont(STANDARD_FONT);
            gbc.gridx = 1;
            gbc.gridy = 1;
            this.add(addButton, gbc);
        }
        
        private void initRemoveButton() {
            removeButton  = new JButton("-");
            removeButton.setFont(STANDARD_FONT);
            gbc.gridx = 1;
            gbc.gridy = 2;
            this.add(removeButton, gbc);
        }
    }
    private static class QuestionList extends JPanel {
        public QuestionList() {
            initQuestionList();
        }
        
        void initQuestionList() {
            this.setLayout(new BorderLayout());
            
            JList list = new JList();
            list.setFont(STANDARD_FONT);
            this.add(new JScrollPane(list));
        }
    }
    private static class QuestionLabel extends JLabel {
        
        public QuestionLabel() {
            initQuestionListLabel();
        }
        
        public void initQuestionListLabel() {
            setText("Список вопросов");
            setFont(STANDARD_FONT);
        }
    }
    private static class TestControlsButtonsGrid extends JPanel{
        public JButton goBackButton;
        public JButton clearButton;
        public JButton saveButton;
        public JButton loadButton;
        
        public TestControlsButtonsGrid() {
            initButtonsGrid();
        }
        
        private void initButtonsGrid() {
            goBackButton = new JButton("Назад");
            goBackButton.setFont(STANDARD_FONT);
            
            clearButton = new JButton("Очистить");
            clearButton.setFont(STANDARD_FONT);
            
            saveButton = new JButton("Сохранить тест");
            saveButton.setFont(STANDARD_FONT);
            
            loadButton = new JButton("Загрузить тест");
            loadButton.setFont(STANDARD_FONT);
            
            GridLayout layout = new GridLayout(1, 4);
            layout.setHgap(5);
            this.setLayout(layout);
            this.add(goBackButton);
            this.add(clearButton);
            this.add(saveButton);
            this.add(loadButton);
        }
    }
}
