package com.company.Shop;

import com.company.Stock.Stock;
import com.company.Stock.StockController;
import com.company.Utils.Utils;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    private StockController stockController;


    //region CONSTRUCTORS
    public Shop() {
        this.stockController = new StockController();

    }
    //endregion

    //region GETTER & SETTER

    //endregion

    public void mainMenu() {

        Scanner reader = new Scanner(System.in);
        boolean out = false;
        int option; //Guardaremos la opcion del usuario
        while (!out) {
            Utils.cls();
            System.out.println("«1. Stock»");
            System.out.println("«2. Pedidos»");
            System.out.println("«3. Empleados»");
            System.out.println("«4. Caja»");
            System.out.println("«9. Cerrar»");
            System.out.println("«Escribe una de las opciones»");
            option = reader.nextInt();
            switch (option) {
                case 1:
                    stockController.stockMenu();
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
