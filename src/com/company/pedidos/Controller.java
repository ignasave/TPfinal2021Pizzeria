package com.company.pedidos;

import com.company.Product.Beverage;
import com.company.Product.Food;
import com.company.Product.Product;
import com.company.RawMaterial.RawMaterial;
import com.company.persona.Client;
import com.company.persona.Employee;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) throws IOException {

        //        String foodType, String description, RawMaterial[] ingredients
//        RawMaterial harina = new RawMaterial("Harina", 50);
//        RawMaterial queso = new RawMaterial("Queso", 100);
//        RawMaterial tomate = new RawMaterial("Tomate", 60);
//        RawMaterial aceitunas = new RawMaterial("Aceitunas verdes", 60);
//        RawMaterial aceitunasNegras = new RawMaterial("Aceitunas negras", 60);
//        RawMaterial rucula = new RawMaterial("Rúcula", 60);
//        RawMaterial jamonCrudo = new RawMaterial("Jamón Crudo", 60);
//        RawMaterial calabresa= new RawMaterial("Calabresa", 60);
//        RawMaterial cebolla = new RawMaterial("Cebolla", 60);
//
//        ArrayList<RawMaterial> muzzarella = new ArrayList<>();
//
//        muzzarella.add(harina);
//        muzzarella.add(queso);
//        muzzarella.add(tomate);
//        muzzarella.add(aceitunas);
//
//
//        Food pizzaMuzza = new Food("Pizza muzzarella", 200, 350, "Pizza",
//                "muzzarella",muzzarella );
//        Food pizzaCalabresa = new Food("Pizza calabresa", 250, 450, "Pizza",
//                "Calabresa",muzzarella );
//        Food pizzaRucula = new Food("Pizza Rucula y jamón crudo", 250, 450, "Pizza",
//                "Rúcula y jamón crudo",muzzarella );
//        Food pizzaFugazzetta = new Food("Pizza fugazzetta", 220, 400, "Pizza",
//                "Fugazzetta",muzzarella );
//
//
//        List<Food>newOrder = new ArrayList<>();
//        ArrayList<Product>options = new ArrayList<>();
//        options.add(pizzaCalabresa);
//        options.add(pizzaMuzza);
//        options.add(pizzaRucula);
//        options.add(pizzaFugazzetta);
//        ArrayList<RawMaterial> pizzaMuzzarella = new ArrayList<>();


//        fillFileOptions("Food.json",options);
//        readFileOptions("Food.json", newOrder);
//
//        System.out.println("VIENDO EL ARRAY DE LA ORDEN-------------------------------\n");
//        newOrder.forEach((v)->System.out.println(v));
//
//        Product newProduct = createFood(muzzarella,"Pizza","muzza",300);
//        createProductOrder(newProduct);

        ArrayList newListOfProducts = new ArrayList();
        newListOfProducts = selectProduct();


        System.out.println("------------------------------------\n\n");
        newListOfProducts.forEach((v)-> {
            if (v instanceof Food)
                ((Food) v).showFood();
            else if (v instanceof Beverage)
                System.out.println(v.toString());

        });

    }

    public static Food createFood (ArrayList<RawMaterial>materials,String name, String type, int price){
        Food newFood = new Food (name + type, price, price+150, name,
                type,materials);
        return newFood;
    }

    public static List<Product> createProductOrder(Product product){
        List<Product> listOrder = new ArrayList<>();
        listOrder.add(product);

        return listOrder;
    }

    public static ArrayList<Product> selectProduct () throws IOException {

        ArrayList<Product> newOrder = new ArrayList<>();

        Scanner reader = new Scanner(System.in);
        boolean out = false;
        int option; //Guardaremos la opcion del usuario
        while(!out){
            System.out.println("«1. Pizza»");
            System.out.println("«2. Empanada»");
            System.out.println("«3. Bebida»");
            System.out.println("«6. Salir»");
            System.out.println("«Escribe una de las opciones»");
            option = reader.nextInt();
            switch(option){
                case 1:
                    System.out.println("Menú Pizzas");
                        selectPizza(newOrder);
//                    System.in.read();

                    break;
                case 2:
                    System.out.println("Menu Empanadas");

//

//                    System.in.read();
                    break;
                case 3:

                    break;
                case 6:
                    out=true;
                    break;
                default:
                    System.out.println("«Solo números entre 1 y 6»");
            }

        }
        return newOrder;

    }

    public static void selectEmpanadas(ArrayList<Product> newOrder){

        ArrayList<Product>materials;

        Scanner reader = new Scanner(System.in);
        boolean out = false;
        int option; //Guardaremos la opcion del usuario
        while(!out){
            System.out.println("«1. Emp. Humita»");
            System.out.println("«2. Emp. JyQ»");
            System.out.println("«3. Emp. Carne»");
            System.out.println("«4. Emp. Verdura»");
            System.out.println("«6. Salir»");
            System.out.println("«Escribe una de las opciones»");
            option = reader.nextInt();
            switch(option){
                case 1:
                    System.out.println("Has seleccionado la opcion 1");

//                    Food newFood = createFood(muzzarella,"Pizza","Muzzarella",300);
//                    newOrder.add(newFood);
//                    System.in.read();

                    break;
                case 2:
                    System.out.println("Has seleccionado la opcion 2");

//                    Food newFood2 = createFood(muzzarella,"Pizza","Calabresa",300);
//                    newOrder.add(newFood2);

//                    System.in.read();
                    break;
                case 3:
                    System.out.println("Has seleccionado la opcion 3");

//                    Food newFood3 = createFood(muzzarella,"Pizza","Fugazzetta",300);
//                    newOrder.add(newFood3);

//                    System.in.read();
                    break;
                case 4:
                    System.out.println("Has seleccionado la opción 4");
//                    Food newFood4 = createFood(muzzarella,"Pizza","Rúcula y jamón crudo",300);
//                    newOrder.add(newFood4);
                    break;

                case 5:
                    System.out.println("Has seleccionado la opción 5");
//                    Food newFood5 = createFood(muzzarella,"Pizza","Napolitana",300);
//                    newOrder.add(newFood5);
//                    System.in.read();

                    break;
                case 6:
                    out=true;
                    break;
                default:
                    System.out.println("«Solo números entre 1 y 6»");
            }

        }
    }

    public static void selectPizza(ArrayList<Product> newOrder) throws IOException {

        RawMaterial harina = new RawMaterial("Harina", 50);
        RawMaterial queso = new RawMaterial("Queso", 100);
        RawMaterial tomate = new RawMaterial("Tomate", 60);
        RawMaterial aceitunas = new RawMaterial("Aceitunas verdes", 60);

        ArrayList<RawMaterial> muzzarella = new ArrayList<>();

        muzzarella.add(harina);
        muzzarella.add(queso);
        muzzarella.add(tomate);
        muzzarella.add(aceitunas);


        Scanner reader = new Scanner(System.in);
        boolean out = false;
        int option; //Guardaremos la opcion del usuario
        while(!out){
            System.out.println("«1. Pizza Muzza»");
            System.out.println("«2. Pizza Calabresa»");
            System.out.println("«3. Pizza Fugazzetta»");
            System.out.println("«4. Pizza Rúcula y jamón»");
            System.out.println("«5. Pizza Napolitana»");
            System.out.println("«6. Salir»");
            System.out.println("«Escribe una de las opciones»");
            option = reader.nextInt();
            switch(option){
                case 1:
                    System.out.println("Has seleccionado la opcion 1");

                    Food newFood = createFood(muzzarella,"Pizza","Muzzarella",300);
                    newOrder.add(newFood);
//                    System.in.read();

                    break;
                case 2:
                    System.out.println("Has seleccionado la opcion 2");

                    Food newFood2 = createFood(muzzarella,"Pizza","Calabresa",300);
                    newOrder.add(newFood2);

//                    System.in.read();
                    break;
                case 3:
                    System.out.println("Has seleccionado la opcion 3");

                    Food newFood3 = createFood(muzzarella,"Pizza","Fugazzetta",300);
                    newOrder.add(newFood3);

//                    System.in.read();
                    break;
                case 4:
                    System.out.println("Has seleccionado la opción 4");
                    Food newFood4 = createFood(muzzarella,"Pizza","Rúcula y jamón crudo",300);
                    newOrder.add(newFood4);
                    break;

                case 5:
                    System.out.println("Has seleccionado la opción 5");
                    Food newFood5 = createFood(muzzarella,"Pizza","Napolitana",300);
                    newOrder.add(newFood5);
//                    System.in.read();

                    break;
                case 6:
                    out=true;
                    break;
                default:
                    System.out.println("«Solo números entre 1 y 6»");
            }

        }
//        return newOrder;
    }

    //region FILE
    public static void fillFileOptions (String nameFile, ArrayList<Product> food){
            /// el gson ahora tiene formato mas facil de leer
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            /** guardando un archivo con informacion json */

            BufferedWriter fSalida = null;

            try {
                fSalida = new BufferedWriter(new FileWriter(new File(nameFile)));

                gson.toJson(food, food.getClass(), fSalida);

            } catch (IOException e) {
                e.printStackTrace();

            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                if(fSalida != null) {
                    try {
                        fSalida.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public static void readFileOptions (String nameFile, List<Food>productList){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            BufferedReader reader = null;

            try {
                reader = new BufferedReader(new FileReader(new File(nameFile)));

                productList = gson.fromJson(reader, (new TypeToken<List<Food>>() {}.getType()));

//                System.out.println(productList.getNombre());
//                System.out.println("VIENDO ARCHIVO--------------------------------\n");
//                productList.forEach((v)->System.out.println(v));

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



    //tiene que llegar los datos del cliente y la comida a pedir

    //to fill the archive
    public Order createOrder (Client client, ArrayList<Product> newArray,
     float finalPrice, float productPrice,float totalPrice, LocalDateTime dateTime){

        Order newOrder = new Order(client, newArray, finalPrice, productPrice,
        totalPrice, dateTime);

        return newOrder;
    }

    public Delivery createOrderDelivery (Client client, ArrayList<Product> newArray, Employee
            employee, float finalPrice, float productPrice,float totalPrice, LocalDateTime dateTime,float deliveryFloat
    , LocalDateTime out){

        Delivery newDelivery = new Delivery(client, newArray, finalPrice, productPrice,
                totalPrice, dateTime,  deliveryFloat, employee, out);

        return newDelivery;
    }



    //to manage the app
    public void modifyOrder (){

    }
    public void deleteOrder(){

    }

}
