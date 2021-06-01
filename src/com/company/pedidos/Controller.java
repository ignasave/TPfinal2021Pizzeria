package com.company.pedidos;

import com.company.Product.Beverage;
import com.company.Product.Food;
import com.company.Product.Product;
import com.company.RawMaterial.RawMaterial;
import com.company.persona.Client;
import com.company.persona.Employee;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    public static void main(String[] args) {
        List<Product> newList = new ArrayList<>();
    }

    public static void fillFileOptions (){
            /// el gson ahora tiene formato mas facil de leer
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

//        String foodType, String description, RawMaterial[] ingredients
            Food pizzaMuzza = new Food("Pizza", 200, 350, ),;
//            persona.setNombre("julian");

            /** guardando un archivo con informacion json */

            BufferedWriter fSalida = null;

            try {
                fSalida = new BufferedWriter(new FileWriter(new File("Food.json")));

                gson.toJson(newFood, newFood.getClass(), fSalida);

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



//    public static ArrayList<Product> selectProducts (ArrayList<Food> listProduct, String name, String pizzaType){
//        ArrayList<Product> orderList = new ArrayList<>();
//
//        listProduct.forEach((v)->{
//            if(name == v.getName())
//                if(pizzaType == v.getFoodType())
//        });
//    }


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
