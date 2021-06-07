package com.company.Menu;

import javax.swing.*;
import java.util.ArrayList;


public class Menu extends JFrame {

    private OptionList lastOptionList = null;

    public Menu() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setFocusable(true);
    }

    public void showOptionsMenu(ArrayList<String> options, String title, CallbackAction[] callbackActions) {
        if(lastOptionList != null) {
            removeKeyListener(lastOptionList);
            remove(lastOptionList);
        }
        OptionList panel = new OptionList(options, title, callbackActions);
        lastOptionList = panel;
        add(panel);
        addKeyListener(panel);
    }
}

