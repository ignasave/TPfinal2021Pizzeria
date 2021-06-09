package com.company.Shop;

import com.company.Order.Order;
import com.company.Order.OrderController;
import com.company.Stock.Stock;
import com.company.Stock.StockController;
import com.company.Utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    private StockController stockController;
    private OrderController orderController;


    //region CONSTRUCTORS
    public Shop() {
        this.stockController = new StockController();
        this.orderController = new OrderController();
    }
    //endregion

    //region GETTER & SETTER

    //endregion

<<<<<<< HEAD
    public void mainMenu() throws IOException {

=======
    public void mainMenu() {
>>>>>>> dev
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
                    orderController.menuOrders();
                    break;
                case 3:

                    break;
                case 9:
                    out = true;
                    break;
                default:
                    System.out.println("Opción Incorrecta");
            }

        }
    }


}
