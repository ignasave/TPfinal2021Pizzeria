package com.company.BeverageBrand;

import com.company.BeverageProp.BeverageProp;

public enum BeverageBrand implements BeverageProp {
    COCACOLA("CocaCola"),
    QUILMES("Quilmes"),
    MANAOS("Manaos"),
    VILLAVICENCIO("VillaVicencio"),
    BAGIO("Bagio");

    //region FIELDS & CONSTRUCTOR & METHODS
    String name;

    BeverageBrand(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
    //endregion
}
