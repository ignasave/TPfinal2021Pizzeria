package com.company.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntField extends JPanel implements ActionListener {

    private TextField textField;
    private JButton button;
    private String buttonName;
    private IntCallbackAction callbackAction;

    private final Font textFont = new Font("Tahoma", 0, 14);

    public IntField(String buttonName, String labelName, IntCallbackAction callbackAction) {
        setBackground(Color.DARK_GRAY);
        setFont(textFont);

        this.callbackAction = callbackAction;

        this.textField = new TextField(16);

        this.buttonName = buttonName;
        this.button = new JButton(buttonName);

        button.addActionListener(this);
        JLabel label = new JLabel(labelName);
        label.setForeground(Color.white);

        add(label);
        add(textField);
        add(button);
    }


    @Override
    public void actionPerformed(ActionEvent evt) {
        String command = evt.getActionCommand();
        if (command.toString().equals(buttonName)) {
            try {
                int result = Integer.parseInt(textField.getText());
                callbackAction.callback(result);
            } catch (Exception e) {
                //ERROR
            }
        }
    }
}
