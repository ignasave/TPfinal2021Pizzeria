package com.company.Menu;

import com.company.Stock.RawMaterialList;

import javax.swing.*;
import java.util.ArrayList;


public class Menu extends JFrame {

    private OptionList lastOptionList = null;
    private RawMaterialList lastRawMaterialList = null;
    private IntField lastIntField = null;
    private StringField lastStringField = null;
    private FloatField lasFloatField = null;

    public Menu() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setFocusable(true);
    }

    public void clearScreen() {
        if(lastOptionList != null) {
            removeKeyListener(lastOptionList);
            remove(lastOptionList);
        }
        if(lastRawMaterialList != null){
            removeKeyListener(lastRawMaterialList);
            remove(lastRawMaterialList);
        }
        if(lastIntField != null){
            lastIntField.button.removeActionListener(lastIntField);
            lastIntField.setVisible(false);
        }
        if(lastStringField != null){
            lastStringField.button.removeActionListener(lastStringField);
            lastStringField.setVisible(false);
        }
        if(lasFloatField != null){
            lasFloatField.button.removeActionListener(lasFloatField);
            lasFloatField.setVisible(false);
        }
    }

    public void showOptionsMenu(ArrayList<String> options, String title, CallbackAction[] callbackActions) {
        clearScreen();
        OptionList panel = new OptionList(options, title, callbackActions);
        lastOptionList = panel;
        add(panel);
        addKeyListener(panel);
    }

    public void showRawMaterialList(RawMaterialList rawMaterialList) {
        clearScreen();
        lastRawMaterialList = rawMaterialList;
        add(rawMaterialList);
        addKeyListener(rawMaterialList);
    }

    public void showIntField(IntField intField){
        clearScreen();
        lastIntField = intField;
        add(intField);
    }

    public void showStringField(StringField stringField){
        clearScreen();
        lastStringField = stringField;
        add(stringField);
    }

    public void showFloatField(FloatField floatField){
        clearScreen();
        lasFloatField = floatField;
        add(floatField);
    }
}

