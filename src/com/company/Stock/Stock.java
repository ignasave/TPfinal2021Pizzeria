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

    public void addToExistentStock (RawMaterial rawMaterial, int quantity) {
        if(rawMaterials.containsKey(rawMaterial)) {
            rawMaterials.put(rawMaterial, rawMaterials.get(rawMaterial) + quantity );
        } else {
            //ERROR
        }
    }

    public void addToExistentStock (Beverage beverage, int quantity) {
        if(beverages.containsKey(beverage)) {
            beverages.put(beverage, beverages.get(beverage) + quantity );
        } else {
            //ERROR
        }
    }

    public void addNewStock (RawMaterial rawMaterial, int quantity) {
        if(!rawMaterials.containsKey(rawMaterial)){
            rawMaterials.put(rawMaterial, quantity);
        } else {
            //ERROR
        }
    }

    public void addNewStock (Beverage beverage, int quantity) {
        if(!beverages.containsKey(beverage)){
            beverages.put(beverage, quantity);
        } else {
            //ERROR
        }
    }

    public void removeFromExistentStock (RawMaterial rawMaterial, int quantity) {
        if(rawMaterials.containsKey(rawMaterial)) {
            int materialQuantity = rawMaterials.get(rawMaterial);
            int res = materialQuantity - quantity;
            if(res < 0) res = 0;
            rawMaterials.put(rawMaterial, res );
        } else {
            //ERROR
        }
    }

    public void removeFromExistentStock (Beverage beverage, int quantity) {
        if(beverages.containsKey(beverage)) {
            int materialQuantity = beverages.get(beverage);
            int res = materialQuantity - quantity;
            if(res < 0) res = 0;
            beverages.put(beverage, materialQuantity - quantity );
        } else {
            //ERROR
        }
    }

    public void saveMaterialsToFile (String nameFile){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(new File(nameFile)));
            gson.toJson(rawMaterials, rawMaterials.getClass(), bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void saveBeveragesToFile (String nameFile){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(new File(nameFile)));
            gson.toJson(beverages, beverages.getClass(), bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(bufferedWriter != null) {
                try {
                    bufferedWriter.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void readMaterialsFromFile (String nameFile) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader bufferedReader = null;
        try{
            bufferedReader = new BufferedReader(new FileReader(new File(nameFile)));
            this.rawMaterials = gson.fromJson(bufferedReader, Map.class);
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
    }

    public void readBeveragesFromFile (String nameFile) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader bufferedReader = null;
        try{
            bufferedReader = new BufferedReader(new FileReader(new File(nameFile)));
            this.beverages = gson.fromJson(bufferedReader, Map.class);
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
    }
}
