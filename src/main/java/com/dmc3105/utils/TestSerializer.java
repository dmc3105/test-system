package com.dmc3105.utils;

import com.dmc3105.model.entity.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSerializer {
    private String pathToFile;
    
    public TestSerializer(String file) {
        pathToFile = file;
    }
    
    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }
    
    public String getPathToFile() {
        return pathToFile;
    }
    
    public void serialize(Test test) throws IOException {
        FileOutputStream fos = new FileOutputStream(pathToFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
        
        objectOutputStream.writeObject(test);
        objectOutputStream.close();
    }
    
    public Test deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(pathToFile);
        ObjectInputStream objectInputStream = new ObjectInputStream(fis);
        
        Test result = (Test) objectInputStream.readObject();
        objectInputStream.close();
        return result;
    }
}
