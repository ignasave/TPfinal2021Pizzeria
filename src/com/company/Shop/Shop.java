package com.company.Shop;

import com.company.Accounting.AccountingController;
import com.company.Accounting.StartingDay;
import com.company.Order.Order;
import com.company.Order.OrderController;
import com.company.Person.EmployeeController;
import com.company.Stock.Stock;
import com.company.Stock.StockController;
import com.company.Utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    private StockController stockController;
    private OrderController orderController;
    private EmployeeController employeeController;


    //region CONSTRUCTORS
    public Shop() {
        this.stockController = new StockController();
        stockController.getStock().readMaterialsFromFile("RawMaterials.json");
        stockController.getStock().readBeveragesFromFile("Beverages.json");
        StartingDay startingDay = new StartingDay();
        this.orderController = new OrderController();
        this.employeeController = new EmployeeController();
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
            System.out.println("«3. Mostrar Empleados»");
            System.out.println("«4. Caja»");
            System.out.println("«9. Cerrar»");
            System.out.println("«Escribe una de las opciones»");
            option = reader.nextInt();
            switch (option) {
                case 1:
                    stockController.stockMenu();
                    break;
                case 2:
                    orderController.menuOrders(employeeController);
                    break;
                case 3:
                    employeeController.readEmployeeFile("Employee.json");
                    employeeController.showEmployees();
                    System.out.println("Cualquiera para continuar");
                    Scanner reader1 = new Scanner(System.in);
                    reader1.nextLine();
                    break;
                case 4:
                    AccountingController.accountingMenu();
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
