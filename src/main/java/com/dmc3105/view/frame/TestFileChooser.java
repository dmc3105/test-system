package com.dmc3105.view.frame;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TestFileChooser extends JFileChooser {
    
    public TestFileChooser() {
        this.changeToParentDirectory();
        this.setFileFilter(new FileNameExtensionFilter("Test serialized data (.ser)", "ser"));
        this.setSize(400,400);
    }
}
