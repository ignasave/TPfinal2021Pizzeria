package com.company.Stock;

import com.company.BeverageBrand.BeverageBrand;
import com.company.BeverageType.BeverageType;
import com.company.Menu.*;
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


    //Raw Materials
    public void buyNewRawMaterial(Menu menu) {
        StringField stringField = new StringField("Siguiente", "Nombre:", new StringCallbackAction() {
            public void callback(String sresult) {
                if (!stock.searchMaterialNameExists(sresult)) {
                    FloatField floatField = new FloatField("Siguiente", "Precio:", new FloatCallbackAction() {
                        public void callback(float fresult) {
                            RawMaterial rawMaterial = new RawMaterial(sresult, fresult);
                            stock.addNewStock(rawMaterial, 0);
                            selectExistentRawMaterialForBuy(rawMaterial, menu);
                        }
                    });
                    menu.showFloatField(floatField);
                }
            }
        });
        menu.showStringField(stringField);
    }

    public void buyExistentRawMaterial(Menu menu) {
        ArrayList<RawMaterial> rawMaterials = new ArrayList<>();
        stock.getRawMaterials().forEach((k, v) -> {
            rawMaterials.add(k);
        });
        CallbackActionGeneric<RawMaterial> callbackActionGeneric = new CallbackActionGeneric<RawMaterial>() {
            public void callback(RawMaterial response) {
                selectExistentRawMaterialForBuy(response, menu);
            }
        };
        RawMaterialList rawMaterialList = new RawMaterialList(rawMaterials, callbackActionGeneric);
        menu.showRawMaterialList(rawMaterialList);
    }

    private void selectExistentRawMaterialForBuy(RawMaterial rawMaterial, Menu menu) {
        IntField intField = new IntField("Comprar", "Cantidad:", new IntCallbackAction() {
            public void callback(int response) {
                stock.addToExistentStock(rawMaterial, response);
                System.out.println(stock.getRawMaterials().toString());
            }
        });
        menu.showIntField(intField);
    }

    public void removeRawMaterial(Menu menu) {
        ArrayList<RawMaterial> rawMaterials = new ArrayList<>();
        stock.getRawMaterials().forEach((k, v) -> {
            rawMaterials.add(k);
        });
        CallbackActionGeneric<RawMaterial> callbackActionGeneric = new CallbackActionGeneric<RawMaterial>() {
            public void callback(RawMaterial response) {
                selectRawMaterialForRemove(response, menu);
            }
        };
        RawMaterialList rawMaterialList = new RawMaterialList(rawMaterials, callbackActionGeneric);
        menu.showRawMaterialList(rawMaterialList);
    }

    private void selectRawMaterialForRemove(RawMaterial rawMaterial, Menu menu) {
        IntField intField = new IntField("Remover", "Cantidad:", new IntCallbackAction() {
            public void callback(int response) {
                stock.removeFromExistentStock(rawMaterial, response);
                System.out.println(stock.getRawMaterials().toString());
            }
        });
        menu.showIntField(intField);
    }

}
