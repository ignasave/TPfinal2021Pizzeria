package com.company.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FloatField extends JPanel implements ActionListener {

    private TextField textField;
    public JButton button;
    private String buttonName;
    private FloatCallbackAction callbackAction;

    private final Font textFont = new Font("Tahoma", 0, 14);

    public FloatField(String buttonName, String labelName, FloatCallbackAction callbackAction) {
        setBackground(Color.DARK_GRAY);
        setFont(textFont);
        setVisible(true);

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
                float result = Float.parseFloat(textField.getText());
                callbackAction.callback(result);
            } catch (Exception e) {
                //ERROR
            }
        }
    }
}
