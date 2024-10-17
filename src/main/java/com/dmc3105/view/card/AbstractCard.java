package com.dmc3105.view.card;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.event.EventListenerList;

public abstract class AbstractCard extends JPanel {
    protected static final Font STANDARD_FONT = new Font("Calibri", Font.PLAIN, 20);
    private final EventListenerList LISTENER_LIST = new EventListenerList();
    
    public void addActionListener(ActionListener actionListener) {
        LISTENER_LIST.add(ActionListener.class, actionListener);
    }
    
    protected void invokeListeners(String command) {
        invokeListeners(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, command));
    }
    
    protected void invokeListeners(ActionEvent actionEvent) {
        for (var actionListener : LISTENER_LIST.getListeners(ActionListener.class)) {
            actionListener.actionPerformed(actionEvent);
        }
    }
    
    public void removeActionListener(ActionListener actionListener) {
        LISTENER_LIST.remove(ActionListener.class, actionListener);
    }

}
