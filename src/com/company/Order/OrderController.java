package com.company.Order;

import com.company.BeverageBrand.BeverageBrand;
import com.company.BeverageType.BeverageType;
import com.company.Person.EmployeeController;
import com.company.Product.Beverage;
import com.company.Product.Food;
import com.company.Product.Product;
import com.company.RawMaterial.RawMaterial;
import com.company.Person.Employee;
import com.company.Stock.Stock;
import com.company.Stock.StockController;
import com.company.Utils.Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderController {
    private ArrayList<Order> orderList = new ArrayList<>();
    private Cart<Product> productsCart = new Cart<>(30);

    // region SHOW

    public void showOneOrder(Order order) {

        System.out.println("--------------------------------------");
        System.out.println("ID:              " + order.getId());
        System.out.println("Precio final:    " + order.getFinalPrice());
        System.out.println("Precio total:    " + order.getTotalPrice());
        System.out.println("Precio de costo: " + order.getProductPrice());
        System.out.println("Fecha:           " + order.getDateTime());
        System.out.println("Productos ----------------------------");

        order.getProducts().forEach((v) -> System.out.println(v));
        System.out.println("--------------------------------------");

    }

    public void showOrders(ArrayList<Order> orderList) {
        orderList.forEach((v) -> {
            showOneOrder(v);
        });
    }

    // endregion

    public Food createFood(ArrayList<RawMaterial> materials, String name, String type, float price) {
        Food newFood = new Food(name + type, calculateOverPrice(price), price, name, type, materials);
        return newFood;
    }

    // region RAW MATERIAL LIST

    public boolean checkRawMaterialList(ArrayList<String> recipe, StockController stockController) {
        boolean flag = false;
        for (String rawMaterial : recipe) {
            flag = stockController.getStock().searchMaterialNameExists(rawMaterial);
            if (!flag) {
                return flag;
            }
        }
        return flag;
    }

    public boolean createListRawMaterial(ArrayList<RawMaterial> rawMaterialsList, ArrayList<String> recipe,
            StockController stockController) {
        boolean flag = checkRawMaterialList(recipe, stockController);
        if (flag) {
            for (int i = 0; i < recipe.size(); i++) {
                rawMaterialsList.add(stockController.getStock().searchMaterialByName(recipe.get(i)));
            }
        } else{
            Utils.cls();
            System.out.println("Materias primas no disponibles");
            Utils.pressToContinue();
        }
        return flag;
    }

    public void add2Order(ArrayList<RawMaterial> rawMaterialsList, ArrayList<Product> newOrder, String name,
            String type, StockController stockController) {

        if (stockController.checkRawMaterial(rawMaterialsList)) {
            float price = calculateRawMaterialPrice(rawMaterialsList);
            Food newFood = createFood(rawMaterialsList, name, type, price);
            newOrder.add(newFood);
        }
    }

    // endregion

    // region MENU

    public void menuOrders(EmployeeController employeeController) {

        File orderFile = new File("Orders.json");

        if (!orderFile.exists())
            System.out.println("El archivo no existe, va a ser creado a continuación");
        else
            readOrderFile(orderFile);

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
                    selectTypeOrder(employeeController, orderList);
                    saveOrdersDay("Orders.json");
                    break;
                case 2:
                    Utils.cls();
                    showOrders(orderList);
                    Utils.pressToContinue();
                    break;
                case 3:
                    Utils.cls();
                    showOrders(orderList);
                    System.out.println("Seleccionar ID a buscar: ");
                    Scanner sReader = new Scanner(System.in);
                    String idx = sReader.nextLine();
                    Order order = searchOrderByID(orderList, idx);
                    if (order != null) {
                        deleteOrder(idx);
                    } else {
                        System.out.println("El ID ingresado es incorrecto");
                    }
                    Utils.pressToContinue();
                    saveOrdersDay("Orders.json");
                    break;

                case 9:
                    out = true;
                    break;
                default:
                    System.out.println("Valor incorrecto");
            }

        }

    }

    public Order selectTypeOrder(EmployeeController employeeController, ArrayList<Order> orderList) {

        Order order = new Order();

        Scanner reader = new Scanner(System.in);
        boolean out = false;
        int option;
        while (!out) {
            Utils.cls();

            System.out.println("«1. Take away»");
            System.out.println("«2. Delivery»");
            System.out.println("«9. Finalizar »");
            System.out.println("«Escribe una de las opciones»");
            option = reader.nextInt();
            switch (option) {
                case 1:
                    productsCart.getProducts().clear();
                    selectProduct();
                    order = createOrder(this.productsCart.getProducts());
                    orderList.add(order);
                    break;
                case 2:
                    productsCart.getProducts().clear();
                    Utils.cls();
                    System.out.println("Escriba la dirección de destino: ");
                    Scanner sreader = new Scanner(System.in);
                    String address = sreader.nextLine();
                    selectProduct();
                    Employee employee = employeeController.getEmployeeDelivery();
                    storeOrder(createOrderDelivery(this.productsCart.getProducts(), address, employee), orderList);
                    break;
                case 9:
                    out = true;
                    break;
                default:
                    System.out.println("Valor incorrecto");
            }
        }
        return order;
    }

    // endregion

    // region SELECTORS

    public void selectProduct() {

        StockController stockController = new StockController();

        stockController.getStock().readBeveragesFromFile(Stock.beverageFile);
        stockController.getStock().readMaterialsFromFile(Stock.rawMaterialFile);

        Scanner reader = new Scanner(System.in);
        boolean out = false;
        int option;
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
                    selectPizza(stockController);

                    break;
                case 2:
                    System.out.println("Menu Empanadas");
                    selectEmpanadas(stockController);
                    break;
                case 3:
                    stockController.sellBeverage(this.productsCart.getProducts());
                    break;
                case 9:
                    out = true;
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }

        }

    }

    public void selectEmpanadas(StockController stockController) {

        ArrayList<RawMaterial> rawMaterialsList = new ArrayList<>();
        ArrayList<String> recipe = new ArrayList<>();

        Scanner reader = new Scanner(System.in);
        boolean out = false;
        int option;
        while (!out) {
            Utils.cls();
            recipe.clear();

            System.out.println("«1. Emp. Humita»");
            System.out.println("«2. Emp. JyQ»");
            System.out.println("«3. Emp. Carne»");
            System.out.println("«4. Emp. Verdura»");
            System.out.println("«9. Salir»");
            System.out.println("Opción incorrecta");
            option = reader.nextInt();
            switch (option) {
                case 1:
                    recipe.add("Choclo");
                    recipe.add("Queso");
                    if (createListRawMaterial(rawMaterialsList, recipe, stockController)) {
                        add2Order(rawMaterialsList, this.productsCart.getProducts(), "Empanada", "Humita", stockController);
                    }
                    break;
                case 2:
                    recipe.add("Jamón");
                    recipe.add("Queso");
                    if (createListRawMaterial(rawMaterialsList, recipe, stockController)) {
                        add2Order(rawMaterialsList, this.productsCart.getProducts(), "Empanada", "JYQ", stockController);
                    }
                    break;
                case 3:
                    recipe.add("Carne");
                    recipe.add("Cebolla");
                    if (createListRawMaterial(rawMaterialsList, recipe, stockController)) {
                        add2Order(rawMaterialsList, this.productsCart.getProducts(), "Empanada", "Carne", stockController);
                    }
                    break;
                case 4:
                    recipe.add("Verdura");
                    recipe.add("Queso");
                    if (createListRawMaterial(rawMaterialsList, recipe, stockController)) {
                        add2Order(rawMaterialsList, this.productsCart.getProducts(), "Empanada", "Verdura", stockController);
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

    public void selectPizza(StockController stockController) {

        ArrayList<RawMaterial> rawMaterialsList = new ArrayList<>();

        ArrayList<String> recipe = new ArrayList<>();

        Scanner reader = new Scanner(System.in);
        boolean out = false;
        int option;
        while (!out) {
            Utils.cls();

            recipe.clear();

            recipe.add("Harina");
            recipe.add("Queso");
            recipe.add("Pure de Tomate");

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
                    recipe.add("Aceitunas");
                    if (createListRawMaterial(rawMaterialsList, recipe, stockController)) {
                        add2Order(rawMaterialsList, this.productsCart.getProducts(), "Pizza", "Muzzarella", stockController);
                    }
                    break;
                case 2:
                    recipe.add("Calabresa");
                    recipe.add("Aceitunas");

                    if (createListRawMaterial(rawMaterialsList, recipe, stockController)) {
                        add2Order(rawMaterialsList, this.productsCart.getProducts(), "Pizza", "Calabresa", stockController);
                    }
                    break;
                case 3:
                    recipe.add("Cebolla");
                    if (createListRawMaterial(rawMaterialsList, recipe, stockController)) {
                        add2Order(rawMaterialsList, this.productsCart.getProducts(), "Pizza", "Fugazzetta", stockController);
                    }
                    break;
                case 4:
                    recipe.add("Rucula");
                    recipe.add("Jamon Crudo");
                    recipe.add("Aceituna");
                    if (createListRawMaterial(rawMaterialsList, recipe, stockController)) {
                        add2Order(rawMaterialsList, this.productsCart.getProducts(), "Pizza", "Rucula", stockController);
                    }
                    break;
                case 5:
                    recipe.add("Tomate");
                    recipe.add("Aceituna");
                    if (createListRawMaterial(rawMaterialsList, recipe, stockController)) {
                        add2Order(rawMaterialsList, this.productsCart.getProducts(), "Pizza", "Napolitana", stockController);
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

    // endregion

    // region PRICE CALCULATE
    public float calculateRawMaterialPrice(ArrayList<RawMaterial> rawMaterialsList) {
        float price = 0;
        for (RawMaterial rawMaterial : rawMaterialsList) {
            price += rawMaterial.getPrice();
        }
        return price;
    }

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

    private float calculateOverPrice(float price) {
        return (float) (price + (price * 0.3));
    }

    // endregion

    // region ORDER
    public void products2String(ArrayList<Product> products, ArrayList<String> productsName) {
        products.forEach((v) -> {
            productsName.add(v.getName());
        });
    }

    public Order createOrder(ArrayList<Product> products) {
        LocalDateTime time = LocalDateTime.now();

        float productPrice = calculateProductPrice(products);
        float finalPrice = calculateFinalPrice(products);

        ArrayList<String> productsName = new ArrayList<>();
        products2String(products, productsName);

        Order newOrder = new Order(productsName, finalPrice, productPrice, finalPrice, time);

        return newOrder;
    }

    public Delivery createOrderDelivery(ArrayList<Product> products, String address, Employee employee) {

        LocalDateTime time = LocalDateTime.now();
        LocalDateTime timeOut = time.plusMinutes(30);
        float productPrice = calculateProductPrice(products);
        float finalPrice = calculateFinalPrice(products);
        float totalPrice = finalPrice + Delivery.DELIVERY_PRICE;

        ArrayList<String> productsName = new ArrayList<>();
        products2String(products, productsName);

        Delivery newDelivery = new Delivery(productsName, finalPrice, productPrice, totalPrice, time, employee, timeOut,
                address);

        return newDelivery;
    }

    // endregion

    // region FILES

    public void storeOrder(Order newOrder, ArrayList<Order> orderList) {
        orderList.add(newOrder);
    }

    public void saveOrdersDay(String nameFile) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

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

    public void readOrderFile(File nameFile) {
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

    // endregion

    // region SEARCH & DELETE
    public Order searchOrderByID(ArrayList<Order> orderList, String id) {
        Order resultOrder = null;
        for (Order order : orderList) {
            if (order.getId().equals(id))
                resultOrder = order;
        }
        return resultOrder;
    }

    public void deleteOrder(String id) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getId().equals(id)) {
                orderList.remove(i);
                break;
            }
        }
    }
    // endregion
}
