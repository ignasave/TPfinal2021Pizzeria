package com.company.Stock;

import com.company.Product.Beverage;
import com.company.Product.Product;
import com.company.RawMaterial.RawMaterial;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Stock {
    Map<RawMaterial, Integer> rawMaterials;
    Map<Beverage, Integer> beverages;
    public static final String rawMaterialFile = "RawMaterials.json";
    public static final String beverageFile = "Beverages.json";

    // region CONSTRUCTORS
    public Stock(Map<RawMaterial, Integer> rawMaterials, Map<Beverage, Integer> beverages) {
        this.rawMaterials = rawMaterials;
        this.beverages = beverages;
    }

    public Stock() {
    }
    // endregion

    // region GETTER & SETTER
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
    // endregion

    public void showBeverages() {
        beverages.forEach((k, v) -> {
            System.out.println(k.show() + " | Existencias: " + v);
        });
    }

    public void showRawMaterials() {
        rawMaterials.forEach((k, v) -> {
            System.out.println(k.show() + " | Existencias: " + v);
        });
    }

    public void addToExistentStock(RawMaterial rawMaterial, int quantity) {
        try{
            if (rawMaterials.containsKey(rawMaterial)) {
                rawMaterials.put(rawMaterial, rawMaterials.get(rawMaterial) + quantity);
            } else {
                throw new SettingStockError("blabla");
            }
        }catch(SettingStockError e){    ///catching error with an exception created by us
            System.out.println(e.getMessage());

        }

    }

    public void addToExistentStock(Beverage beverage, int quantity) {
        try{
            if (beverages.containsKey(beverage)) {
                beverages.put(beverage, beverages.get(beverage) + quantity);
            } else {
                throw new SettingStockError("blabla");
            }
        }catch(SettingStockError e){
            System.out.println(e.getMessage());
        }

    }

    public void addNewStock(RawMaterial rawMaterial, int quantity) {
        try{
            if (!rawMaterials.containsKey(rawMaterial)) {
                rawMaterials.put(rawMaterial, quantity);
            } else {
                throw new SettingStockError("blablaa");
            }
        }catch(SettingStockError e){
            System.out.println(e.getMessage());
        }

    }

    public void addNewStock(Beverage beverage, int quantity) {
        try{
            if (!beverages.containsKey(beverage)) {
                beverages.put(beverage, quantity);
            } else {
                throw new SettingStockError("blabla");
            }
        }catch(SettingStockError e){
            System.out.println(e.getMessage());
        }

    }

    public void removeFromExistentStock(RawMaterial rawMaterial, int quantity) {
        try{
            if (rawMaterials.containsKey(rawMaterial)) {
                int materialQuantity = rawMaterials.get(rawMaterial);
                int res = materialQuantity - quantity;
                if (res < 0)
                    res = 0;
                rawMaterials.put(rawMaterial, res);
            } else {
                throw new SettingStockError("blabla");
            }
        }catch(SettingStockError e){
            System.out.println(e.getMessage());
        }

    }

    public void removeFromExistentStock(Beverage beverage, int quantity) {
        try{
            if (beverages.containsKey(beverage)) {
                int materialQuantity = beverages.get(beverage);
                int res = materialQuantity - quantity;
                if (res < 0)
                    res = 0;
                beverages.put(beverage, res);
            } else {
                throw new SettingStockError("blabla");
            }
        }catch(SettingStockError e){
            System.out.println(e.getMessage());
        }

    }

    public void saveMaterialsToFile(String nameFile) {
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting().create();
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(new File(nameFile)));
            gson.toJson(rawMaterials, bufferedWriter);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void saveBeveragesToFile(String nameFile) {
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting().create();
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(new File(nameFile)));
            gson.toJson(beverages, bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean searchMaterialNameExists(String name) {
        boolean flag = false;
        for (RawMaterial rawMaterialK : rawMaterials.keySet()) {
            if (rawMaterialK.getName().equals(name)) {
                flag = true;
            }
        }
        return flag;
    }

    public RawMaterial searchMaterialByName(String name) {
        RawMaterial rawMaterial = null;
        for (RawMaterial rawMaterialK : rawMaterials.keySet()) {
            if (rawMaterialK.getName().equals(name)) {
                rawMaterial = rawMaterialK;
            }
        }
        return rawMaterial;
    }

    public Beverage searchBeverageById(String id) {
        Beverage beverage = null;
        for (Beverage beverageK : beverages.keySet()) {
            if (beverageK.getId().equals(id)) {
                beverage = beverageK;
            }
        }
        return beverage;
    }

    public void readMaterialsFromFile(String nameFile) {
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting().create();
        BufferedReader bufferedReader = null;
        File file = new File(nameFile);
        if (file.exists()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                this.rawMaterials = gson.fromJson(bufferedReader, (new TypeToken<Map<RawMaterial, Integer>>() {
                }.getType()));
            } catch (IOException e) {
                e.printStackTrace();

            } finally {
                try {
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            this.rawMaterials = new HashMap<RawMaterial, Integer>();
        }
    }

    public void readBeveragesFromFile(String nameFile) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader bufferedReader = null;
        File file = new File(nameFile);
        if (file.exists()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                this.beverages = gson.fromJson(bufferedReader, (new TypeToken<Map<Beverage, Integer>>() {
                }.getType()));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            this.beverages = new HashMap<Beverage, Integer>();
        }
    }

}