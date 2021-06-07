package com.company.BeverageType;

public enum BeverageType {
    WATER("Agua"),
    SODA("Gaseosa"),
    ALCOHOLIC("Con Alcohol"),
    JUICE("Jugo");

    //region FIELDS & CONSTRUCTOR & METHODS
    private final String name;

    BeverageType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    //endregion
}
