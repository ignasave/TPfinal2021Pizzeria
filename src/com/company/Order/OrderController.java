package com.company.Order;

import com.company.BeverageBrand.BeverageBrand;
import com.company.BeverageType.BeverageType;
import com.company.Person.EmployeeController;
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
    public Food createFood(ArrayList<RawMaterial> materials, String name, String type, float price) {
        Food newFood = new Food(name + type, price + 150, price, name,
                type, materials);
        return newFood;
    }

    //region LIST RAWMATERIALS
    //Genera una array de materia prima harcodeada (borrar luego)

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

    public boolean createListRawMaterial (ArrayList<RawMaterial> rawMaterialsList, ArrayList<String> recipe, StockController stockController) {
       boolean flag = checkRawMaterialList(recipe, stockController);
        if (flag){
            for (int i = 0; i < recipe.size(); i++) {
                rawMaterialsList.add(stockController.getStock().searchMaterialByName(recipe.get(i)));
            }
        }
       return flag;
    }

    public void add2Order (ArrayList<RawMaterial> rawMaterialsList, ArrayList<Product> newOrder,
                           String name, String type, StockController stockController){

        if (stockController.checkRawMaterial(rawMaterialsList)) {
            float price = calculateRawMaterialPrice(rawMaterialsList);
            Food newFood = createFood(rawMaterialsList, name, type, price);
            newOrder.add(newFood);
        }
    }

    //endregion

    //region MENU


    public void menuOrders(EmployeeController employeeController) {
        //descargo todos los pedidos que tengo para trabajarlo localmente
        ArrayList<Order> orderList = new ArrayList<>();
        ArrayList<Employee> employeeList = new ArrayList<>();


        File orderFile = new File("Orders.json");


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
                    ArrayList<Product> products = selectProduct();
                    storeOrder(createOrder(products), orderList);
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

    public void selectTypeOrder (EmployeeController employeeController) throws IOException {
        //descargo todos los pedidos que tengo para trabajarlo localmente
        ArrayList<Order> orderList = new ArrayList<>();
        File orderFile = new File("Orders.json");

        if (!orderFile.exists())
            System.out.println("El archivo no existe, va a ser creado a continuación");
        else
            readOrderFile(orderFile, orderList);

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
                    System.out.println("Take away");
                    ArrayList<Product> products = selectProduct();
                    storeOrder(createOrder(products), orderList);
                    break;
                case 2:
                    System.out.println("Delivery\n");
                    System.out.println("Escriba la dirección de destino: ");
                    String address = reader.nextLine();

                    ArrayList<Product> products2 = selectProduct();

                    Employee employee = employeeController.getEmployeeDelivery();
                    storeOrder(createOrderDelivery(products2,address, employee), orderList);
                    break;


                case 9:
                    out = true;
                    break;
                default:
                    System.out.println("Valor incorrecto");
            }
        }
    }

    //endregion


    //region SELECTORS

    //pasar a modo menu
    public ArrayList<Product> selectProduct(){

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
    public void selectEmpanadas(ArrayList<Product> newOrder, StockController stockController) {


        ArrayList<RawMaterial> rawMaterialsList = new ArrayList<>();
        Food newFood = new Food();
        ArrayList<String> recipe = new ArrayList<>();

        Scanner reader = new Scanner(System.in);
        boolean out = false;
        int option; //Guardaremos la opcion del usuario
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
                    createListRawMaterial(rawMaterialsList,recipe,stockController);

                    add2Order(rawMaterialsList,newOrder,"Empanada","Humita",stockController);
                    break;
                case 2:
                    recipe.add("Jamón");
                    recipe.add("Queso");
                    createListRawMaterial(rawMaterialsList,recipe,stockController);

                    add2Order(rawMaterialsList,newOrder,"Empanada","JYQ",stockController);
                    break;
                case 3:
                    recipe.add("Carne");
                    recipe.add("Cebolla");
                    createListRawMaterial(rawMaterialsList,recipe,stockController);

                    add2Order(rawMaterialsList,newOrder,"Empanada","Carne",stockController);
                    break;
                case 4:
                    recipe.add("Verdura");
                    recipe.add("Queso");
                    createListRawMaterial(rawMaterialsList,recipe,stockController);

                    add2Order(rawMaterialsList,newOrder,"Empanada","Verdura",stockController);
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


        ArrayList<String> recipe = new ArrayList<>();


        Scanner reader = new Scanner(System.in);
        boolean out = false;
        int option; //Guardaremos la opcion del usuario
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
                    createListRawMaterial(rawMaterialsList,recipe,stockController);

                    add2Order(rawMaterialsList,newOrder,"Pizza","Muzzarella",stockController);

            break;
            case 2:

                recipe.add("Calabresa");
                recipe.add("Aceitunas");

                createListRawMaterial(rawMaterialsList,recipe,stockController);

                add2Order(rawMaterialsList,newOrder,"Pizza","Calabresa",stockController);

                break;
            case 3:

                recipe.add("Cebolla");
                createListRawMaterial(rawMaterialsList,recipe,stockController);
                add2Order(rawMaterialsList,newOrder,"Pizza","Fugazzetta",stockController);

                break;
            case 4:

                recipe.add("Rucula");
                recipe.add("Jamon Crudo");
                recipe.add("Aceituna");

                createListRawMaterial(rawMaterialsList,recipe,stockController);
                add2Order(rawMaterialsList,newOrder,"Pizza","Rucula",stockController);
                break;
            case 5:

                recipe.add("Tomate");
                recipe.add("Aceituna");
                createListRawMaterial(rawMaterialsList,recipe,stockController);
                add2Order(rawMaterialsList,newOrder,"Pizza","Napolitana",stockController);
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
    public float calculateRawMaterialPrice (ArrayList<RawMaterial> rawMaterialsList){
        float price = 0;
        for (RawMaterial rawMaterial:rawMaterialsList) {
            price = rawMaterial.getPrice();
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

    //endregion

    //region ORDER
    public Order createOrder(ArrayList<Product> products) {
        LocalDateTime time = LocalDateTime.now();

        float productPrice = calculateProductPrice(products);
        float finalPrice = calculateFinalPrice(products);

        Order newOrder = new Order(products, finalPrice, productPrice,
                finalPrice, time);

        return newOrder;
    }

    public Delivery createOrderDelivery(ArrayList<Product> products,String address, Employee
            employee) {

        LocalDateTime time = LocalDateTime.now();
        LocalDateTime timeOut = time.plusMinutes(30);
        float productPrice = calculateProductPrice(products);
        float finalPrice = calculateFinalPrice(products);
        float totalPrice = finalPrice + Delivery.DELIVERY_PRICE;

        Delivery newDelivery = new Delivery(products, finalPrice, productPrice,
                totalPrice, time, employee, timeOut,address);

        return newDelivery;
    }

    //endregion

    //region ORDERS STORE

    //guardo todas las ordenes de forma local del día para poder trabajarlas y modificarlas de ser necesario
    public void storeOrder(Order newOrder, ArrayList<Order> orderList) {
        orderList.add(newOrder);
    }
    // al terminar el día guardo todas las ordenes de la lista a un archivo para no perder datos.

    public void saveOrdersDay(String nameFile, ArrayList<Order> orderList) {
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
