package com.company.BeverageType;

import com.company.BeverageProp.BeverageProp;

public enum BeverageType implements BeverageProp {
    WATER("Agua"),
    SODA("Gaseosa"),
    ALCOHOLIC("Con Alcohol"),
    JUICE("Jugo");

    //region FIELDS & CONSTRUCTOR & METHODS
    String name;

    BeverageType(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
    //endregion
}
