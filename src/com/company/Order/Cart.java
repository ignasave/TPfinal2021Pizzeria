package com.company.Order;

import java.util.ArrayList;

public class Cart <T>{
    private ArrayList<T> products = new ArrayList<>();
    private int maxSize;

    //region CONSTRUCTORS
    public Cart(){

    }
    public Cart (int tope){
        this.maxSize = tope;
    }
    //endregion

    //region GETTER & SETTER

    public ArrayList<T> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<T> products) {
        this.products = products;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    //endregion

    public boolean addProducts (T product){
        if(this.maxSize < this.products.size()){
            products.add(product);
        }
        return false;
    }
}
