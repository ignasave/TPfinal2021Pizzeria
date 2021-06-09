package com.company.Stock;

import com.company.Menu.CallbackAction;
import com.company.Menu.CallbackActionGeneric;
import com.company.RawMaterial.RawMaterial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class RawMaterialList extends JPanel implements KeyListener {

    private ArrayList<RawMaterial> rawMaterials;
    private int selectedOption;
    private CallbackActionGeneric<RawMaterial> callbackActionRawMaterial;

    private final Font textFont = new Font("Tahoma", 0, 14);
    private final Font titleFont = new Font("Tahoma", 0, 16);

    public RawMaterialList(ArrayList<RawMaterial> rawMaterials, CallbackActionGeneric<RawMaterial> callbackActionRawMaterial) {

        setBackground(Color.DARK_GRAY);
        setForeground(Color.WHITE);
        setFont(textFont);

        this.callbackActionRawMaterial = callbackActionRawMaterial;
        this.rawMaterials = rawMaterials;
        this.selectedOption = 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Lista
        int y = 40;
        int incremental = 18;
        for(int i = 0; i < rawMaterials.size(); i++) {
            g.drawString(rawMaterials.get(i).getName(), 45, y + (incremental * i));
        }
        //Puntero
        g.drawString(">>", 15, y + (incremental * selectedOption) );

        //Titulo
        setFont(titleFont);
        g.drawString("Seleccionar raw material", 40, y - incremental - 3 );
        setFont(textFont);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                if(selectedOption + 1 < rawMaterials.size()){
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
                RawMaterial rawMaterial = rawMaterials.get(selectedOption);
                callbackActionRawMaterial.callback(rawMaterial);
                break;
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}
