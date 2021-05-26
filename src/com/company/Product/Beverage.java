package com.company.Product;

import com.company.BeverageBrand.BeverageBrand;
import com.company.BeverageType.BeverageType;

public class Beverage {
    private BeverageBrand brand;
    private float sizeInLt;
    private BeverageType type;

    public Beverage() {
    }

    public Beverage(BeverageBrand brand, float sizeInLt, BeverageType type) {
        this.brand = brand;
        this.sizeInLt = sizeInLt;
        this.type = type;
    }

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
}
