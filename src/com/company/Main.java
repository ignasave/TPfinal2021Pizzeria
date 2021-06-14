package com.company;

import com.company.BeverageBrand.BeverageBrand;
import com.company.BeverageType.BeverageType;
import com.company.Person.Employee;
import com.company.Person.EmployeeController;
import com.company.Product.Beverage;
import com.company.Product.Product;
import com.company.RawMaterial.RawMaterial;
import com.company.Shop.Shop;
import com.company.Stock.Stock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

/* PRUEBA DE MENU
        Menu menu = new Menu();
        String title = "Opciones";
        ArrayList<String> options = new ArrayList<String>();

        CallbackAction[] callbackActions = new CallbackAction[] {
                new CallbackAction() {  public void callback() { decirAlgo(); } },
                new CallbackAction() {  public void callback() { decirAlgo(); } },
                new CallbackAction() {  public void callback() { decirAlgo(); } },
        };

        options.add("opcion 1");
        options.add("opcion 2");
        options.add("opcion 3");
        menu.showOptionsMenu(options, title, callbackActions);



        Stock stock = new Stock();
        RawMaterial harina = new RawMaterial("Harina", 50);
        RawMaterial queso = new RawMaterial("Queso", 100);
        RawMaterial tomate = new RawMaterial("Tomate", 60);

        Map<RawMaterial, Integer> rawMaterials = new HashMap<RawMaterial, Integer>();
        rawMaterials.put(harina, 0);
        rawMaterials.put(queso, 1);


        Map<Beverage, Integer> beverages = new HashMap<Beverage, Integer>();
        Beverage coca = new Beverage(BeverageBrand.COCACOLA,1, BeverageType.SODA );
        Beverage bagio = new Beverage(BeverageBrand.BAGIO,2, BeverageType.JUICE );

        beverages.put(coca, 0);

        stock.setRawMaterials(rawMaterials);
        stock.setBeverages(beverages);
        Shop shop = new Shop(stock);

        shop.getStock().addToExistentStock(harina, 10);
        shop.getStock().addToExistentStock(coca, 21);
        shop.getStock().addNewStock(bagio, 42);
        shop.getStock().addNewStock(tomate, 22);

        //shop.getStock().saveMaterialsToFile("Materiales.json");
        //shop.getStock().saveBeveragesToFile("Bebidas.json");
        //shop.getStock().readMaterialsFromFile("Materiales.json");
        shop.getStock().readBeveragesFromFile("Bebidas.json");

        //System.out.println(shop.getStock().getRawMaterials().toString());
        //System.out.println(shop.getStock().getBeverages().toString());
        */



//        EmployeeController employeeController = new EmployeeController();
//        Employee employee = new Employee("David", "Cabrera", 50000, true, 36562321, false);
//        Employee employee1 = new Employee("Ignacio", "Bazquez", 200000, true, 38562321, false);
//        Employee employee2 = new Employee("Santiago", "Raho", 90000, true, 20562321, true);
//        Employee employee3 = new Employee("Marcos", "Falso", 10000, false, 40562321, true);
//
//
//        employeeController.getEmployee().add(employee);
//        employeeController.getEmployee().add(employee1);
//        employeeController.getEmployee().add(employee2);
//        employeeController.getEmployee().add(employee3);
//
//        employeeController.saveEmployee("Employee.json");

        Shop shop = new Shop();
        shop.mainMenu();

    }
}
