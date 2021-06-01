package com.company.BeverageBrand;

public enum BeverageBrand {
    COCACOLA("CocaCola"),
    QUILMES("Quilmes"),
    MANAOS("Manaos"),
    VILLAVICENCIO("VillaVicencio"),
    BAGIO("Bagio");

    //region FIELDS & CONSTRUCTOR & METHODS
    private final String name;

    BeverageBrand(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    //endregion
}
