package com.dmc3105.model;

import com.dmc3105.controller.TestController;
import com.dmc3105.model.entity.Question;
import com.dmc3105.model.entity.Test;
import com.dmc3105.model.entity.TestResults;
import com.dmc3105.utils.TestSerializer;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestSystemModel {
    private TestController controller;
    private Test openedTest = null;
    
    public void setController(TestController controller) {
        this. controller = controller;
    }
    
    public boolean isTestOpen() {
        return openedTest != null;
    }
    
    public Test getOpenedTest() {
        return openedTest;
    }
    
    public void openTestFromFile(File file) throws IOException, ClassNotFoundException {
        TestSerializer serializer = new TestSerializer(file.getAbsolutePath());
        openedTest = serializer.deserialize();
    }
    
    public TestResults checkTestResults(Test test, List<String> answers) {
        int maxPoints = answers.size();
        int earnedPoints = 0;
        List<Question> questions = test.getAllQuestions();
        if (test.getAllQuestions().size() != answers.size())
            throw new IllegalArgumentException("The Count of questions is not equals to the answers count");
        for (int i = 0; i < answers.size(); i++) {
            if (questions.get(i).isAnswerRight(answers.get(i))) {
                earnedPoints++;
            }
        }
        
        return new TestResults(maxPoints, earnedPoints);
    }
    
    public void closeTest() {
        openedTest = null;
    }
}
