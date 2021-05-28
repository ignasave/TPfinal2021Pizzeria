package com.company.pedidos;

import com.company.Product.Beverage;
import com.company.Product.Food;
import com.company.Product.Product;
import com.company.persona.Client;
import com.company.persona.Employee;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Controller {
    public static void main(String[] args) {


        
    }

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
