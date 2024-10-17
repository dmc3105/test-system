package com.dmc3105.view.frame;

import com.dmc3105.model.entity.Test;
import com.dmc3105.model.entity.TestResults;
import com.dmc3105.view.card.MainMenu;
import com.dmc3105.view.card.PassTestCard;
import com.dmc3105.view.card.TestEditorCard;
import com.dmc3105.view.card.TestResultsCard;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.event.EventListenerList;

public class MainFrame extends JFrame {
    
    private final JPanel MAIN_PANEL = new JPanel(new BorderLayout());
    private final EventListenerList LISTENER_LIST = new EventListenerList();
    
    private PassTestCard currentPassTestCard = null;
    
    public MainFrame() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Тестовая система");
        this.setSize(800,500);
        this.setResizable(false);
        this.setLocationByPlatform(true);
        
        this.add(MAIN_PANEL);
    }
    
    public void showMainMenu() {
        MainMenu mainMenu = new MainMenu();
        mainMenu.addActionListener(e -> invokeAllListeners(e.getActionCommand()));
        showPanel(mainMenu);
    }
    public void startTest(Test test) {
        currentPassTestCard = new PassTestCard(test);
        currentPassTestCard.addActionListener(e -> invokeAllListeners(e.getActionCommand()));
        showPanel(currentPassTestCard);
    }
    
    public void showTestResults(TestResults results) {
        TestResultsCard testResultsCard = new TestResultsCard(results);
        testResultsCard.addActionListener(e -> invokeAllListeners(e.getActionCommand()));
        showPanel(testResultsCard);
    }
    
    public void showTestEditor() {
        TestEditorCard testEditorCard = new TestEditorCard();
        testEditorCard.addActionListener(e -> invokeAllListeners(e.getActionCommand()));
        showPanel(testEditorCard);
    }
    
    public void showPanel(JPanel panel) {
        MAIN_PANEL.removeAll();
        MAIN_PANEL.add(panel);
        MAIN_PANEL.revalidate();
        MAIN_PANEL.repaint();
    }
    
    public void addActionListener(ActionListener actionListener) {
        LISTENER_LIST.add(ActionListener.class, actionListener);
    }
    
    public void removeActionListener(ActionListener actionListener) {
        LISTENER_LIST.remove(ActionListener.class, actionListener);
    }
    
    private void invokeAllListeners(String command) {
        for (var actionListener : LISTENER_LIST.getListeners(ActionListener.class)) {
            actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, command));
        }
    }
    
    public List<String> getAnswers() {
        if (currentPassTestCard == null)
            return Collections.emptyList();
        return currentPassTestCard.getAnswers();
    }
}
