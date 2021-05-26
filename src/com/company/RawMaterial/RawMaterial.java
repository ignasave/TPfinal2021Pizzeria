package com.company.RawMaterial;

public class RawMaterial {
    private String name;
    private float price;

    public RawMaterial() {
    }

    public RawMaterial(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
