package com.company.Order;

import com.company.BeverageBrand.BeverageBrand;
import com.company.BeverageType.BeverageType;
import com.company.Product.Beverage;
import com.company.Product.Food;
import com.company.Product.Product;
import com.company.RawMaterial.RawMaterial;
import com.company.Person.Client;
import com.company.Person.Employee;
import com.company.Stock.Stock;
import com.company.Stock.StockController;
import com.company.Utils.Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderController {
    public void showOneOrder(Order order) {
        order.toString();
        order.showProducts();
    }

    public void showOrders(ArrayList<Order> orderList) {
        orderList.forEach((v) -> {
            showOneOrder(v);
        });
    }

    //Genera una comida harcodeada (borrar luego)
    public Food createFood(ArrayList<RawMaterial> materials, String name, String type, int price) {
        Food newFood = new Food(name + type, price + 150, price, name,
                type, materials);
        return newFood;
    }

    //region LIST RAWMATERIALS
    //Genera una array de materia prima harcodeada (borrar luego)
    public static void createListRawMaterialEmp(ArrayList<RawMaterial> newList, String type) {
        RawMaterial flour = new RawMaterial("Harina", 5);
        RawMaterial cheese = new RawMaterial("Queso", 20);
        RawMaterial meat = new RawMaterial("Carne", 10);
        RawMaterial jam = new RawMaterial("Jamón", 20);
        RawMaterial cornSauce = new RawMaterial("Humita", 25);
        RawMaterial vegetables = new RawMaterial("vegetales", 25);

        newList.add(flour);
        if (type == "JyQ") {
            newList.add(jam);
            newList.add(cheese);
        } else if (type == "humita")
            newList.add(cornSauce);
        else if (type == "carne")
            newList.add(meat);
        else {
            newList.add(vegetables);
            newList.add(cheese);
        }
    }

    //Genera una array de materia prima harcodeada (borrar luego)
    public static void createListRawMaterialPizza(ArrayList<RawMaterial> newList, String type) {
        RawMaterial harina = new RawMaterial("Harina", 50);
        RawMaterial queso = new RawMaterial("Queso", 100);
        RawMaterial pureTomate = new RawMaterial("Pure de Tomate", 60);
        RawMaterial aceitunas = new RawMaterial("Aceitunas verdes", 30);
        RawMaterial aceitunasNegras = new RawMaterial("Aceitunas negras", 30);
        RawMaterial rucula = new RawMaterial("Rúcula", 40);
        RawMaterial jamonCrudo = new RawMaterial("Jamón Crudo", 100);
        RawMaterial calabresa = new RawMaterial("Calabresa", 80);
        RawMaterial cebolla = new RawMaterial("Cebolla", 20);
        RawMaterial tomate = new RawMaterial("Tomate", 25);

        newList.add(harina);
        newList.add(queso);
        newList.add(pureTomate);
        newList.add(aceitunas);
        if (type == "Napolitana" || type == "napolitana")
            newList.add(tomate);
        else if (type == "Fugazzeta" || type == "fugazzeta") {
            newList.add(cebolla);
            newList.remove(aceitunas);
        } else if (type == "Rucula" || type == "rucula") {
            newList.add(jamonCrudo);
            newList.add(rucula);
            newList.remove(aceitunas);
            newList.add(aceitunasNegras);
        } else if (type == "calabresa" || type == "Calabresa")
            newList.add(calabresa);

    }
    //endregion

    //region MENU

    public void menuOrders() {
        //descargo todos los pedidos que tengo para trabajarlo localmente
        ArrayList<Order> orderList = new ArrayList<>();
        File orderFile = new File ("Orders.json");

        if (!orderFile.exists())
            System.out.println("El archivo no existe, va a ser creado a continuación");
        else
            readOrderFile(orderFile, orderList);

        Scanner reader = new Scanner(System.in);
        boolean out = false;
        int option;
        while (!out) {
            Utils.cls();

            System.out.println("«1. Crear pedido»");
            System.out.println("«2. Ver Pedidos»");
            System.out.println("«3. Eliminar pedido»");
            System.out.println("«9. Finalizar »");
            System.out.println("«Escribe una de las opciones»");
            option = reader.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Creación de pedido");
                    Client client = new Client();//BUSCAR LA FORMA DE PASARLO DESDE OTRO LUGAR
                    ArrayList<Product> products = selectProduct();
                    storeOrder(createOrder(client, products), orderList);
                    break;
                case 2:
                    System.out.println("Lista de pedidos");

                    showOrders(orderList);

                    System.out.println("Seleccione una tecla para finalizar");
                    reader.nextLine();
                    break;
                case 3:
                    System.out.println("Buscador por id");
                    System.out.println("Seleccionar ID a buscar: ");
                    int idx = reader.nextInt(); // cambiar ID por int
                    Order order = searchOrderByID(orderList, idx);
                    showOneOrder(order);

                    System.out.println("Seleccione una tecla para finalizar");
                    reader.nextLine();
                    break;

                case 9:
                    out = true;
                    break;
                default:
                    System.out.println("Valor incorrecto");
            }
            //Una vez realizado los cambios guardo todo al archivo
            saveOrdersDay("Orders.json", orderList);
        }

    }

    //endregion


    //region SELECTORS

    //pasar a modo menu
    public ArrayList<Product> selectProduct()  {

        ArrayList<Product> newOrder = new ArrayList<>();

        StockController stockController = new StockController();

        stockController.getStock().readBeveragesFromFile(Stock.beverageFile);
        stockController.getStock().readMaterialsFromFile(Stock.rawMaterialFile);


        Scanner reader = new Scanner(System.in);
        boolean out = false;
        int option; //Guardaremos la opcion del usuario
        while (!out) {
            Utils.cls();

            System.out.println("«1. Pizza»");
            System.out.println("«2. Empanada»");
            System.out.println("«3. Bebida»");
            System.out.println("«9. Finalizar »");
            System.out.println("«Escribe una de las opciones»");
            option = reader.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Menú Pizzas");
                    selectPizza(newOrder, stockController);

                    break;
                case 2:
                    System.out.println("Menu Empanadas");
                    selectEmpanadas(newOrder, stockController);
                    break;
                case 3:
                    stockController.sellBeverage(newOrder);
                    break;
                case 9:
                    out = true;
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }

        }
        return newOrder;

    }



    //pasar a modo menu
//    public void selectBeverage(ArrayList<Product> newOrder) {
//        Scanner reader = new Scanner(System.in);
//        boolean out = false;
//        int option; //Guardaremos la opcion del usuario
//        while (!out) {
//            Utils.cls();
//
//            System.out.println("«1. Coca Cola 1.25lt»");
//            System.out.println("«2. Coca Cola 2.5lt»");
//            System.out.println("«3. Coca Cola 3lt»");
//            System.out.println("«4. Cerveza Quilmes Cristal»");
//            System.out.println("«5. Cerveza Quilmes 1890»");
//            System.out.println("«6. Cerveza Quilmes Bock»");
//            System.out.println("«7. Sprite 1.25lt»");
//            System.out.println("«8. Sprite 2.5lt»");
//            System.out.println("«9. Salir»");
//            System.out.println("«Escribe una de las opciones»");
//            option = reader.nextInt();
//            switch (option) {
//                case 1:
//
//                    Beverage beverage = new Beverage("Coca cola", 200, 200,
//                            BeverageBrand.COCACOLA, 1.25f, BeverageType.SODA);
//                    newOrder.add(beverage);
//                    System.out.println("Agregado al pedido");
//                    break;
//                case 2:
//                    Beverage beverage1 = new Beverage("Coca cola", 200, 200,
//                            BeverageBrand.COCACOLA, 2.5f, BeverageType.SODA);
//                    newOrder.add(beverage1);
//
//                    System.out.println("Agregado al pedido");
//                    break;
//                case 3:
//                    Beverage beverage2 = new Beverage("Coca cola", 200, 200,
//                            BeverageBrand.COCACOLA, 3f, BeverageType.SODA);
//                    newOrder.add(beverage2);
//
//                    System.out.println("Agregado al pedido");
//                    break;
//                case 4:
//                    Beverage beverage3 = new Beverage("Cristal", 200, 200,
//                            BeverageBrand.QUILMES, 1f, BeverageType.ALCOHOLIC);
//                    newOrder.add(beverage3);
//
//                    System.out.println("Agregado al pedido");
//                    break;
//
//                case 5:
//                    Beverage beverage5 = new Beverage("1890", 200, 200,
//                            BeverageBrand.QUILMES, 1f, BeverageType.ALCOHOLIC);
//                    newOrder.add(beverage5);
//
//                    System.out.println("Agregado al pedido");
//                    break;
//                case 6:
//                    Beverage beverage6 = new Beverage("Bock", 200, 200,
//                            BeverageBrand.QUILMES, 1f, BeverageType.ALCOHOLIC);
//                    newOrder.add(beverage6);
//
//                    System.out.println("Agregado al pedido");
//                    break;
//                case 7:
//                    Beverage beverage7 = new Beverage("Sprite", 200, 200,
//                            BeverageBrand.COCACOLA, 1.25f, BeverageType.SODA);
//                    newOrder.add(beverage7);
//
//                    System.out.println("Agregado al pedido");
//                    break;
//                case 8:
//                    Beverage beverage8 = new Beverage("Sprite", 200, 200,
//                            BeverageBrand.COCACOLA, 2.5f, BeverageType.SODA);
//                    newOrder.add(beverage8);
//
//                    System.out.println("Agregado al pedido");
//                    break;
//
//                case 9:
//                    out = true;
//                    break;
//                default:
//                    System.out.println("«Solo números entre 1 y 9»");
//            }
//
//        }
//    }

    //pasar a modo menu
    public void selectEmpanadas(ArrayList<Product> newOrder, StockController stockController) {


        ArrayList<RawMaterial> rawMaterialsList = new ArrayList<>();
        Food newFood = new Food ();

        Scanner reader = new Scanner(System.in);
        boolean out = false;
        int option; //Guardaremos la opcion del usuario
        while (!out) {
            Utils.cls();

            System.out.println("«1. Emp. Humita»");
            System.out.println("«2. Emp. JyQ»");
            System.out.println("«3. Emp. Carne»");
            System.out.println("«4. Emp. Verdura»");
            System.out.println("«9. Salir»");
            System.out.println("Opción incorrecta");
            option = reader.nextInt();
            switch (option) {
                case 1:
                    rawMaterialsList.clear();
                    createListRawMaterialEmp(rawMaterialsList, "humita");


                    if(stockController.checkRawMaterial(rawMaterialsList)){
                        newFood = createFood(rawMaterialsList, "Empanadas", "humita", 300);
                        newOrder.add(newFood);
                    }

                    break;
                case 2:
                    System.out.println("Has seleccionado la opcion 2");

                    rawMaterialsList.clear();
                    createListRawMaterialEmp(rawMaterialsList, "humita");


                    if(stockController.checkRawMaterial(rawMaterialsList)){
                        newFood = createFood(rawMaterialsList, "Empanadas", "humita", 300);
                        newOrder.add(newFood);
                    }
                    break;
                case 3:
                    System.out.println("Has seleccionado la opcion 3");
                    rawMaterialsList.clear();
                    createListRawMaterialEmp(rawMaterialsList, "humita");


                    if(stockController.checkRawMaterial(rawMaterialsList)){
                        newFood = createFood(rawMaterialsList, "Empanadas", "humita", 300);
                        newOrder.add(newFood);
                    }
                    break;
                case 4:
                    System.out.println("Has seleccionado la opción 4");
                    rawMaterialsList.clear();
                    createListRawMaterialEmp(rawMaterialsList, "humita");


                    if(stockController.checkRawMaterial(rawMaterialsList)){
                        newFood = createFood(rawMaterialsList, "Empanadas", "humita", 300);
                        newOrder.add(newFood);
                    }
                    break;

                case 5:
                    System.out.println("Has seleccionado la opción 5");
                    rawMaterialsList.clear();
                    createListRawMaterialEmp(rawMaterialsList, "humita");


                    if(stockController.checkRawMaterial(rawMaterialsList)){
                        newFood = createFood(rawMaterialsList, "Empanadas", "humita", 300);
                        newOrder.add(newFood);
                    }

                    break;
                case 9:
                    out = true;
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }

        }
    }

    //pasar a modo menu
    public void selectPizza(ArrayList<Product> newOrder, StockController stockController) {

        ArrayList<RawMaterial> rawMaterialsList = new ArrayList<>();
        Food newFood = new Food();

        Scanner reader = new Scanner(System.in);
        boolean out = false;
        int option; //Guardaremos la opcion del usuario
        while (!out) {
            Utils.cls();

            System.out.println("«1. Pizza Muzza»");
            System.out.println("«2. Pizza Calabresa»");
            System.out.println("«3. Pizza Fugazzetta»");
            System.out.println("«4. Pizza Rúcula y jamón»");
            System.out.println("«5. Pizza Napolitana»");
            System.out.println("«9. Salir»");
            System.out.println("«Escribe una de las opciones»");
            option = reader.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Has seleccionado la opcion 1");
                    rawMaterialsList.clear();
                    createListRawMaterialPizza(rawMaterialsList, "muzzarella");


                    if(stockController.checkRawMaterial(rawMaterialsList)){
                        newFood = createFood(rawMaterialsList, "Pizza", "Muzzarella", 300);
                        newOrder.add(newFood);
                    }

                    break;
                case 2:
                    System.out.println("Has seleccionado la opcion 2");
                    rawMaterialsList.clear();
                    createListRawMaterialPizza(rawMaterialsList, "calabresa");

                    if(stockController.checkRawMaterial(rawMaterialsList)){
                        newFood = createFood(rawMaterialsList, "Pizza", "Calabresa", 300);
                        newOrder.add(newFood);
                    }

                    break;
                case 3:
                    System.out.println("Has seleccionado la opcion 3");
                    rawMaterialsList.clear();
                    createListRawMaterialPizza(rawMaterialsList, "fugazzetta");

                    if(stockController.checkRawMaterial(rawMaterialsList)) {
                        newFood = createFood(rawMaterialsList, "Pizza", "Fugazzetta", 300);
                        newOrder.add(newFood);
                    }
                    break;
                case 4:
                    System.out.println("Has seleccionado la opción 4");
                    rawMaterialsList.clear();
                    createListRawMaterialPizza(rawMaterialsList, "rucula");

                    if(stockController.checkRawMaterial(rawMaterialsList)) {
                        newFood = createFood(rawMaterialsList, "Pizza", "Rúcula y jamón crudo", 300);
                        newOrder.add(newFood);
                    }
                    break;
                case 5:
                    System.out.println("Has seleccionado la opción 5");
                    rawMaterialsList.clear();
                    createListRawMaterialPizza(rawMaterialsList, "napolitana");

                    if(stockController.checkRawMaterial(rawMaterialsList)) {
                        newFood = createFood(rawMaterialsList, "Pizza", "Napolitana", 300);
                        newOrder.add(newFood);
                    }
                    break;
                case 9:
                    out = true;
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        }
    }

    //endregion

    //region PRICE CALCULATE
    public float calculateFinalPrice(ArrayList<Product> products) {
        float sellPrice = 0;
        for (Product product : products) {
            sellPrice += product.getSellPrice();
        }
        return sellPrice;
    }

    public float calculateProductPrice(ArrayList<Product> products) {
        float productPrice = 0;
        for (Product product : products) {
            productPrice += product.getCostPrice();
        }
        return productPrice;
    }

    //endregion

    //region ORDER
    public Order createOrder(Client client, ArrayList<Product> products) {
        LocalDateTime time = LocalDateTime.now();

        float productPrice = calculateProductPrice(products);
        float finalPrice = calculateFinalPrice(products);

        Order newOrder = new Order(client, products, finalPrice, productPrice,
                finalPrice, time);

        return newOrder;
    }

    public Delivery createOrderDelivery(Client client, ArrayList<Product> products, Employee
            employee) {

        LocalDateTime time = LocalDateTime.now();
        LocalDateTime timeOut = time.plusMinutes(30);
        float productPrice = calculateProductPrice(products);
        float finalPrice = calculateFinalPrice(products);
        float totalPrice = finalPrice + Delivery.DELIVERY_PRICE;

        Delivery newDelivery = new Delivery(client, products, finalPrice, productPrice,
                totalPrice, time, employee, timeOut);

        return newDelivery;
    }

    //endregion

    //region ORDERS STORE

    //guardo todas las ordenes de forma local del día para poder trabajarlas y modificarlas de ser necesario
    public void storeOrder(Order newOrder, ArrayList<Order> orderList) {
        orderList.add(newOrder);
    }
    // al terminar el día guardo todas las ordenes de la lista a un archivo para no perder datos.

    public void saveOrdersDay( String nameFile, ArrayList<Order> orderList) {
        /// el gson ahora tiene formato mas facil de leer
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        /** guardando un archivo con informacion json */

        BufferedWriter fOut = null;

        try {
            fOut = new BufferedWriter(new FileWriter(new File(nameFile)));

            gson.toJson(orderList, orderList.getClass(), fOut);

        } catch (IOException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (fOut != null) {
                try {
                    fOut.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void readOrderFile(File nameFile, ArrayList<Order> orderList) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(nameFile));

            orderList = gson.fromJson(reader, (new TypeToken<List<Order>>() {
            }.getType()));


        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //endregion

    public Order searchOrderByID(ArrayList<Order> orderList, int index) {
        return orderList.get(index);
    }

    public void discountPrice(Order order2Modify, int percent) {
        float price = order2Modify.getTotalPrice();
        order2Modify.setFinalPrice(((100 - percent) * price) / 100);
    }

    public void increaseOrderPrice(Order order2Modify, int percent) {
        float price = order2Modify.getTotalPrice();
        order2Modify.setFinalPrice(((100 + percent) * price) / 100);
    }

    public void deleteOrder(ArrayList<Order> orderList, int index) {
        orderList.remove(index);
    }

    //------------------------------------------------------------------------

}
