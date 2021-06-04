package com.company.pedidos;

import com.company.Product.Product;
import com.company.persona.Client;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;

public class Order {
    /* Productos: Array<Productos>
    Precio final: float  //costo final + delibery si hay
    Precio de productos: float //costo final
    Costo total: float // costo de materias primas
    id:UUID
    Fecha de Crea: Datetime  */

    private Client client;
    private ArrayList <Product> products;
    private float finalPrice;
    private float productPrice;
    private float totalPrice;
    private String id;
    private LocalDateTime dateTime;

    // region CONSTRUCTORS
    public Order (){}

    public Order(Client client, ArrayList<Product> newArray, float finalPrice, float productPrice, float totalPrice, LocalDateTime dateTime) {
        this.client = client;
        this.products = newArray;
        this.finalPrice = finalPrice;
        this.productPrice = productPrice;
        this.totalPrice = totalPrice;
        this.id= UUID.randomUUID().toString().toUpperCase(Locale.ROOT).substring(0,13);
        this.dateTime = dateTime;
    }

    // endregion

    // region GETTER & SETTER

    public ArrayList<Product> getNewArray() {
        return products;
    }

    public void setNewArray(ArrayList<Product> newArray) {
        this.products = newArray;
    }

    public float getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(float finalPrice) {
        this.finalPrice = finalPrice;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getId (){return this.id;}

    // endregion

    // region HELPERS
    public void showProducts (){
        products.forEach((v)->v.toString());
    }

    public String toString (){
        return "New order : \n" +
                "--------------------------\n" +
                 //showProducts() +
                "\nFinal Price: " + getFinalPrice() +
                "\nProduct Price: " + getProductPrice() +
                "\nTotal Price: " + getTotalPrice() +
                "\nID: " + getId() +
                "\nTime: " + getDateTime();

    }
    // endregion

}
