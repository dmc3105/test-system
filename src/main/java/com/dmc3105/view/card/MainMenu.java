package com.dmc3105.view.card;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends AbstractCard {
    
    public static final String TEST_PASS_STARTED = "testPassStarted";
    public static final String TEST_EDITOR_OPENED = "testEditorOpened";
    public JLabel helloLabel;
    public JPanel mainPanel;
    
    
    public MainMenu() {
        initMainPanel();
    }
    
    private void initMainPanel() {
        this.setLayout(new GridBagLayout());
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        initHelloLabel();
        MainMenuButtonsGrid buttonsGrid = new MainMenuButtonsGrid();
        mainPanel.add(buttonsGrid);
        
        buttonsGrid.openTestEditorButton.addActionListener(e -> invokeListeners(TEST_EDITOR_OPENED));
        buttonsGrid.startTestButton.addActionListener(e -> invokeListeners(TEST_PASS_STARTED));
        this.add(mainPanel);
    }
    
    private void initHelloLabel() {
        helloLabel = new JLabel("Выберите режим работы программы");
        helloLabel.setFont(STANDARD_FONT);
        helloLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        
        mainPanel.add(helloLabel);
    }
    
    
    
    private static class MainMenuButtonsGrid extends JPanel {
        private JButton openTestEditorButton;
        private JButton startTestButton;
        private final JPanel MAIN_PANEL = new JPanel();
        
        public MainMenuButtonsGrid() {
            GridLayout layout = new GridLayout(2, 1);
            layout.setVgap(10);
            MAIN_PANEL.setLayout(layout);
            
            initCreateTestButton();
            initStartTestButton();
            this.add(MAIN_PANEL);
        }
        
        private void initCreateTestButton() {
            openTestEditorButton = new JButton("Открыть редактор тестов");
            openTestEditorButton.setFont(STANDARD_FONT);
            openTestEditorButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            MAIN_PANEL.add(openTestEditorButton);
        }
        
        private void initStartTestButton() {
            startTestButton = new JButton("Пройти тест");
            startTestButton.setFont(STANDARD_FONT);
            startTestButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            MAIN_PANEL.add(startTestButton);
        }
    }
}
