package com.dmc3105.view;

import com.dmc3105.controller.TestController;
import com.dmc3105.model.entity.Test;
import com.dmc3105.model.entity.TestResults;
import com.dmc3105.view.frame.MainFrame;
import com.dmc3105.view.frame.TestFileChooser;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.EventListenerList;

public class TestSystemViewImpl implements TestSystemView {
    
    private final MainFrame MAIN_FRAME;
    private TestController controller;
    private final EventListenerList listenerList = new EventListenerList();
    
    public TestSystemViewImpl() {
        MAIN_FRAME = new MainFrame();
    }
    
    @Override
    public void showFrame() {
        MAIN_FRAME.setVisible(true);
    }
    
    @Override
    public void showMainMenu() {
        MAIN_FRAME.showMainMenu();
    }
    
    @Override
    public void startTest(Test test) {
        MAIN_FRAME.startTest(test);
    }
    
    @Override
    public void showTestResults(TestResults results) {
        MAIN_FRAME.showTestResults(results);
    }
    
    @Override
    public void showFileChooserDialog() {
        TestFileChooser fileChooser = new TestFileChooser();
        int returnVal = fileChooser.showOpenDialog(MAIN_FRAME);
        if (returnVal == TestFileChooser.APPROVE_OPTION) {
            try {
                controller.openTestFromFile(fileChooser.getSelectedFile());
            } catch (IOException | ClassNotFoundException e) {
                showError(e.getMessage());
            }
        }
    }
    
    @Override
    public void showError(String error) {
        JOptionPane.showMessageDialog(MAIN_FRAME, error, "Ошибка!", JOptionPane.ERROR_MESSAGE);
    }
    
    @Override
    public List<String> getAnswers() {
        return MAIN_FRAME.getAnswers();
    }
    
    @Override
    public void showTestEditor() {
        MAIN_FRAME.showTestEditor();
    }
    
    public void addActionListener(ActionListener actionListener) {
        MAIN_FRAME.addActionListener(actionListener);
    }
    
    public void removeActionListener(ActionListener actionListener) {
        MAIN_FRAME.removeActionListener(actionListener);
    }
    
    
    public void setController(TestController controller) {
        this.controller = controller;
    }
}
