package com.dmc3105.controller;

import com.dmc3105.model.TestSystemModel;
import com.dmc3105.model.entity.TestResults;
import com.dmc3105.view.TestSystemView;
import com.dmc3105.view.card.MainMenu;
import com.dmc3105.view.card.PassTestCard;
import com.dmc3105.view.card.TestResultsCard;
import com.sun.tools.javac.Main;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestController {
    
    private final TestSystemModel model;
    private final TestSystemView view;
    
    public TestController(TestSystemModel model, TestSystemView view) {
        this.model = model;
        this.view = view;
        
        view.addActionListener(e -> {
            String command = e.getActionCommand();
            
            if (command.equals(MainMenu.TEST_PASS_STARTED)) {
                view.showFileChooserDialog();
                if (model.isTestOpen()) {
                    view.startTest(model.getOpenedTest());
                }
            }
            if (command.equals(PassTestCard.TEST_PASSED)) {
                List<String> answers = view.getAnswers();
                TestResults results = model.checkTestResults(model.getOpenedTest(), answers);
                view.showTestResults(results);
                model.closeTest();
            }
            if (command.equals(TestResultsCard.GO_TO_MAIN_MENU)) {
                view.showMainMenu();
            }
            if (command.equals(MainMenu.TEST_EDITOR_OPENED)) {
                view.showTestEditor();
            }
        });
    }
    
    public void Start() {
        view.showFrame();
        view.showMainMenu();
    }
    
    public void openTestFromFile(File file) throws IOException, ClassNotFoundException {
        model.openTestFromFile(file);
    }
}
