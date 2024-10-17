package com.dmc3105;

import com.dmc3105.controller.TestController;
import com.dmc3105.model.TestSystemModel;
import com.dmc3105.model.entity.Question;
import com.dmc3105.model.entity.Test;
import com.dmc3105.view.TestSystemViewImpl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class App {
    public static void main( String[] args ) throws IOException {
        createTestExampleFile();
        
        TestSystemViewImpl view = new TestSystemViewImpl();
        TestSystemModel model = new TestSystemModel();

        TestController controller = new TestController(model, view);
        view.setController(controller);
        model.setController(controller);
        controller.Start();
    }
    
    private static void createTestExampleFile() throws IOException {
        final String filename = "TestExample.ser";
        
        File file = new File(filename);
        if (!file.exists()) {
            Test test = createTest();
            saveTest(test, file);
        }
    }
    
    public static Test createTest()
    {
        Question question1 = new Question(
            "Сколько цветов в радуге?",
            "7",
            "6",
            "8"
        );
        
        Question question2 = new Question(
            "Сколько зубов у человека?",
            "32",
            "34",
            "36",
            "28"
        );
        
        Question question3 = new Question(
            "Кто написал Войну и мир?",
            "Л. Н. Толстой",
            "А. С. Пушкин",
            "М. Ю. Лермонтов"
        );
        
        Test test = new Test();
        test.addQuestion(question1);
        test.addQuestion(question2);
        test.addQuestion(question3);
        
        return test;
    }
    
    private static void saveTest(Test test, File file) throws IOException {
        OutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(test);
    }
}
