package com.company.Stock;

import com.company.BeverageBrand.BeverageBrand;
import com.company.BeverageType.BeverageType;
import com.company.Product.Beverage;
import com.company.RawMaterial.RawMaterial;
import com.company.Utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StockController {
    private Stock stock;

    public StockController() {
        RawMaterial harina = new RawMaterial("Harina", 50);
        RawMaterial queso = new RawMaterial("Queso", 100);
        RawMaterial tomate = new RawMaterial("Tomate", 60);

        Map<RawMaterial, Integer> rawMaterials = new HashMap<>();
        rawMaterials.put(harina, 0);
        rawMaterials.put(queso, 1);

        Map<Beverage, Integer> beverages = new HashMap<Beverage, Integer>();
        Beverage coca = new Beverage(BeverageBrand.COCACOLA, 1, BeverageType.SODA);
        Beverage bagio = new Beverage(BeverageBrand.BAGIO, 2, BeverageType.JUICE);

        beverages.put(coca, 0);

        this.stock = new Stock(rawMaterials, beverages);
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }


    public void stockMenu () {

        Scanner reader = new Scanner(System.in);
        boolean out = false;
        int option; //Guardaremos la opcion del usuario
        while (!out) {
            Utils.cls();
            System.out.println("«1. Materia Prima»");
            System.out.println("«2. Bebidas»");
            System.out.println("«3. Ver Stock»");
            System.out.println("«9. Atras»");
            System.out.println("«Escribe una de las opciones»");
            option = reader.nextInt();
            switch (option) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 9:
                    out = true;
                    break;
                default:
                    System.out.println("«Solo números entre 1 y 6»");
            }

        }
    }

}
