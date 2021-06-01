package com.company.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class Menu extends JFrame {
    public int xd = 0;

    public Menu() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setFocusable(true);
    }

    public void showOptionsMenu(ArrayList<String> options, String title, CallbackAction[] callbackActions) {
        OptionList panel = new OptionList(options, title, callbackActions);
        add(panel);
        addKeyListener(panel);
    }

}

