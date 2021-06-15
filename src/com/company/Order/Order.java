package com.company.Order;

import com.company.Utils.Utils;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private ArrayList<String> products;
    private float finalPrice;
    private float productPrice;
    private float totalPrice;
    private String id;
    private LocalDateTime dateTime;

    // region CONSTRUCTORS
    public Order() {
    }

    public Order(ArrayList<String> products, float finalPrice, float productPrice, float totalPrice,
            LocalDateTime dateTime) {

        this.products = products;
        this.finalPrice = finalPrice;
        this.productPrice = productPrice;
        this.totalPrice = totalPrice;
        this.id = Utils.generateUniqueID();
        this.dateTime = dateTime;
    }

    // endregion

    // region GETTER & SETTER

    public ArrayList<String> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<String> products) {
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
        return "New order : \n" + "--------------------------\n" +
        // showProducts() +
                "\nFinal Price: " + getFinalPrice() + "\nProduct Price: " + getProductPrice() + "\nTotal Price: "
                + getTotalPrice() + "\nID: " + getId() + "\nTime: " + getDateTime();

    }
    // endregion

}
