package com.company.Product;

import com.company.BeverageBrand.BeverageBrand;
import com.company.BeverageType.BeverageType;

public class Beverage extends Product {
    private BeverageBrand brand;
    private float sizeInLt;
    private BeverageType type;

    //region CONSTRUCTORS
    public Beverage() {
        super();
    }

    public Beverage(BeverageBrand brand, float sizeInLt, BeverageType type) {
        super();
        this.brand = brand;
        this.sizeInLt = sizeInLt;
        this.type = type;
    }

    public Beverage(String name, float sellPrice, float costPrice, BeverageBrand brand, float sizeInLt, BeverageType type) {
        super(name, sellPrice, costPrice);
        this.brand = brand;
        this.sizeInLt = sizeInLt;
        this.type = type;
    }

    //endregion

    //region GETTER & SETTER
    public BeverageBrand getBrand() {
        return brand;
    }

    public void setBrand(BeverageBrand brand) {
        this.brand = brand;
    }

    public float getSizeInLt() {
        return sizeInLt;
    }

    public void setSizeInLt(float sizeInLt) {
        this.sizeInLt = sizeInLt;
    }

    public BeverageType getType() {
        return type;
    }

    public void setType(BeverageType type) {
        this.type = type;
    }
    //endregion

    @Override
    public String show() {
        return super.show() + " | Marca: " + brand.getName() + " | Tamaño en L: " + sizeInLt + " | Tipo de bebida: " + type.getName();
    }

    @Override
    public String toString() {
        return "Beverage{" +
                super.toString() +
                "brand=" + brand +
                ", sizeInLt=" + sizeInLt +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Beverage))
            return false;

        Beverage beverage = (Beverage) o;
        boolean answer = super.equals(o)
                && this.brand == beverage.getBrand()
                && this.sizeInLt == beverage.getSizeInLt();

        return answer;
    }
}
