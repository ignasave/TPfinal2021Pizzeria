package com.company.Stock;

import com.company.Product.Beverage;
import com.company.RawMaterial.RawMaterial;

import java.util.Map;

public class Stock {
    Map<RawMaterial, Integer> rawMaterials;
    Map<Beverage, Integer> beverages;

    //region CONSTRUCTORS
    public Stock(Map<RawMaterial, Integer> rawMaterials, Map<Beverage, Integer> beverages) {
        this.rawMaterials = rawMaterials;
        this.beverages = beverages;
    }

    public Stock() {
    }
    //endregion

    //region GETTER & SETTER
    public Map<RawMaterial, Integer> getRawMaterials() {
        return rawMaterials;
    }

    public void setRawMaterials(Map<RawMaterial, Integer> rawMaterials) {
        this.rawMaterials = rawMaterials;
    }

    public Map<Beverage, Integer> getBeverages() {
        return beverages;
    }

    public void setBeverages(Map<Beverage, Integer> beverages) {
        this.beverages = beverages;
    }
    //endregion

    public void addToExistentRawMaterial (RawMaterial rawMaterial, int quantity) {
        if(rawMaterials.containsKey(rawMaterial)) {
            rawMaterials.put(rawMaterial, rawMaterials.get(rawMaterial) + quantity );
        } else {
            //ERROR
        }
    }
}
