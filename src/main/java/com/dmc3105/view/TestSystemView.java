package com.dmc3105.view;

import com.dmc3105.model.entity.Test;
import com.dmc3105.model.entity.TestResults;
import java.awt.event.ActionListener;
import java.util.List;

public interface TestSystemView {
    
    void showFrame();
    void showMainMenu();
    void startTest(Test test);
    void showTestResults(TestResults results);
    void addActionListener(ActionListener actionListener);
    void removeActionListener(ActionListener actionListener);
    void showFileChooserDialog();
    void showError(String error);
    List<String> getAnswers();
    void showTestEditor();
}
