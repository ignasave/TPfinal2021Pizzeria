package com.company.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

class OptionList extends JPanel implements KeyListener {
    private ArrayList<String> options;
    private String title;
    private int selectedOption;
    private CallbackAction[] callbackActions;

    private final Font textFont = new Font("Tahoma", 0, 14);
    private final Font titleFont = new Font("Tahoma", 0, 16);

    public OptionList(ArrayList<String> options, String title, CallbackAction[] callbackActions) {

        setBackground(Color.DARK_GRAY);
        setForeground(Color.WHITE);
        setFont(textFont);

        this.options = options;
        this.title = title;
        this.selectedOption = 0;
        this.callbackActions = callbackActions;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Lista
        int y = 40;
        int incremental = 18;
        for(int i = 0; i < options.size(); i++) {
            g.drawString(options.get(i), 45, y + (incremental * i));
        }
        //Puntero
        g.drawString(">>", 15, y + (incremental * selectedOption) );

        //Titulo
        setFont(titleFont);
        g.drawString(title, 40, y - incremental - 3 );
        setFont(textFont);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                if(selectedOption + 1 < options.size()){
                    selectedOption++;
                }
                paintComponent(this.getGraphics());
                break;
            case KeyEvent.VK_UP:
                if(selectedOption > 0) {
                    selectedOption--;
                }
                paintComponent(this.getGraphics());
                break;
            case KeyEvent.VK_ENTER:
                callbackActions[selectedOption].callback();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}