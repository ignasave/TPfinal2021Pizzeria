package com.company.Product;

import com.company.BeverageBrand.BeverageBrand;
import com.company.BeverageType.BeverageType;

public class Beverage extends Product{
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
