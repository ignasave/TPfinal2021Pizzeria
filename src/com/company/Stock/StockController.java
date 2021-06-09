package com.company.Stock;

import com.company.BeverageBrand.BeverageBrand;
import com.company.BeverageType.BeverageType;
import com.company.Product.Beverage;
import com.company.RawMaterial.RawMaterial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StockController {
    private Stock stock;

    public StockController() {
        RawMaterial harina = new RawMaterial("Harina", 50);
        RawMaterial queso = new RawMaterial("Queso", 100);
        RawMaterial tomate = new RawMaterial("Tomate", 60);

        Map<RawMaterial, Integer> rawMaterials = new HashMap<>();
        rawMaterials.put(harina, 0);
        rawMaterials.put(queso, 1);

        Map<Beverage, Integer> beverages = new HashMap<Beverage, Integer>();
        Beverage coca = new Beverage(BeverageBrand.COCACOLA, 1, BeverageType.SODA);
        Beverage bagio = new Beverage(BeverageBrand.BAGIO, 2, BeverageType.JUICE);

        beverages.put(coca, 0);

        this.stock = new Stock(rawMaterials, beverages);
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

}
