package com.company;

import com.company.Menu.CallbackAction;
import com.company.Menu.Menu;
import com.company.Product.Product;
import com.company.RawMaterial.RawMaterial;
import com.company.Shop.Shop;
import com.company.Stock.Stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        /*Menu menu = new Menu();
        String title = "Opciones";
        ArrayList<String> options = new ArrayList<String>();

        CallbackAction[] callbackActions = new CallbackAction[] {
                new CallbackAction() {  public void callback() {  } },
                new CallbackAction() {  public void callback() {  } },
        };

        options.add("opcion 1");
        options.add("opcion 2");
        options.add("opcion 3");
        //menu.showOptionsMenu(options, title, callbackActions);*/
        Stock stock = new Stock();
        RawMaterial harina = new RawMaterial("Harina", 50);
        RawMaterial queso = new RawMaterial("Queso", 100);
        RawMaterial tomate = new RawMaterial("Tomate", 60);

        Map<RawMaterial, Integer> rawMaterials = new HashMap<RawMaterial, Integer>();
        rawMaterials.put(harina, 0);
        rawMaterials.put(queso, 1);
        rawMaterials.put(tomate, 2);

        stock.setRawMaterials(rawMaterials);
        System.out.println(stock.getRawMaterials().toString());
        Shop shop = new Shop(stock);



    }
}
