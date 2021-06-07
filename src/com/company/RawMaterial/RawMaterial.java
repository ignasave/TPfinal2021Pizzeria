package com.company.RawMaterial;

public class RawMaterial {

    private String name;
    private float price;

    //region CONSTRUCTORS
    public RawMaterial() {
    }

    public RawMaterial(String name, float price) {
        this.name = name;
        this.price = price;
    }
    //endregion

    //region GETTER & SETTER
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
    //endregion


    @Override
    public String toString() {
        return "RawMaterial{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

