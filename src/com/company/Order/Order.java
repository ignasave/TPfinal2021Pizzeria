package com.company.Order;

import com.company.Product.Product;
import com.company.Person.Client;
import com.company.Utils.Utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;

public class Order {
    private Client client;
    private ArrayList<Product> products;
    private float finalPrice;
    private float productPrice;
    private float totalPrice;
    private String id;
    private LocalDateTime dateTime;

    // region CONSTRUCTORS
    public Order() {
    }

    public Order(Client client, ArrayList<Product> products, float finalPrice, float productPrice, float totalPrice, LocalDateTime dateTime) {
        this.client = client;
        this.products = products;
        this.finalPrice = finalPrice;
        this.productPrice = productPrice;
        this.totalPrice = totalPrice;
        this.id = Utils.generateUniqueID();
        this.dateTime = dateTime;
    }

    // endregion

    // region GETTER & SETTER

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }


    // endregion

    // region HELPERS
    public void showProducts() {
        products.forEach((v) -> v.toString());
    }

    public String toString() {
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
