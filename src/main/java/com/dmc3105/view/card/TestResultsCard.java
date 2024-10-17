package com.dmc3105.view.card;

import com.dmc3105.model.entity.TestResults;
import java.awt.BorderLayout;
import java.awt.BufferCapabilities;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TestResultsCard extends AbstractCard {
    public static final String GO_TO_MAIN_MENU = "goToMainMenu";
    private final JPanel MAIN_PANEL;
    
    public TestResultsCard(TestResults results) {
        this.setLayout(new GridBagLayout());
        MAIN_PANEL = new JPanel();
        MAIN_PANEL.setLayout(new BoxLayout(MAIN_PANEL, BoxLayout.Y_AXIS));
        
        initPointsLabel(results);
        initGoToMenuButton();
        
        addMargin();
        
        this.add(MAIN_PANEL);
    }
    
    private void addMargin() {
        MAIN_PANEL.setBorder(new EmptyBorder(20,20,20,20));
    }
    
    
    private void initGoToMenuButton() {
        JButton button = createGoToMenuButton();
        addGoToMenuButton(button);
    }
    
    private JButton createGoToMenuButton() {
        JButton button = new JButton("В главное меню");
        button.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        button.setFont(STANDARD_FONT);
        button.addActionListener(e -> invokeListeners(GO_TO_MAIN_MENU));
        return button;
    }
    
    private void addGoToMenuButton(JButton button) {
        MAIN_PANEL.add(button);
    }
    
    
    private void initPointsLabel(TestResults results) {
        JLabel label = createPointsLabel(results);
        addPointsLabel(label);
    }
    
    private void addPointsLabel(JLabel label) {
        MAIN_PANEL.add(label);
        MAIN_PANEL.add(Box.createRigidArea(new Dimension(0, 5)));
    }
    
    private JLabel createPointsLabel(TestResults results) {
        JLabel label = new JLabel(String.format(
            "Получено %d баллов из %d",
            results.getEarnedPoints(), results.getMaxPoints()
        ));
        
        label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        label.setFont(STANDARD_FONT);
        return label;
    }
}
