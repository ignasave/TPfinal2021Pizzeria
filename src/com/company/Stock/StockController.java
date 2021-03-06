package com.company.Stock;

import com.company.Accounting.Expenses;
import com.company.BeverageBrand.BeverageBrand;
import com.company.BeverageType.BeverageType;
import com.company.Product.Beverage;
import com.company.Product.Product;
import com.company.RawMaterial.RawMaterial;
import com.company.Utils.Utils;

import java.util.ArrayList;
import java.util.Scanner;

public class StockController {
    private Stock stock;

    public StockController() {/*
                               * RawMaterial harina = new RawMaterial("Harina", 50); RawMaterial queso = new
                               * RawMaterial("Queso", 100);
                               * 
                               * Map<RawMaterial, Integer> rawMaterials = new HashMap<>();
                               * rawMaterials.put(harina, 0); rawMaterials.put(queso, 1);
                               * 
                               * Map<Beverage, Integer> beverages = new HashMap<Beverage, Integer>(); Beverage
                               * coca = new Beverage(BeverageBrand.COCACOLA, 1, BeverageType.SODA);
                               * 
                               * beverages.put(coca, 0);
                               * 
                               * this.stock = new Stock(rawMaterials, beverages);
                               */
        this.stock = new Stock();
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    // RAW MATTER
    private void buyNewRawMatter() {
        Scanner reader = new Scanner(System.in);
        Utils.cls();
        System.out.println("«Ingrese el nombre: »");
        String name = reader.nextLine();
        Utils.cls();
        if (!stock.searchMaterialNameExists(name)) {
            System.out.println("«Ingrese el precio: »");
            int price = reader.nextInt();
            Utils.cls();
            System.out.println("«Ingrese la cantidad: »");
            int quantity = reader.nextInt();
            RawMaterial rawMaterial = new RawMaterial(name, price);
            stock.addNewStock(rawMaterial, quantity);
            new Expenses(rawMaterial, quantity);
            stock.saveMaterialsToFile("RawMaterials.json");
        } else {
            System.out.println("El nombre ya existe!");
            Utils.pressToContinue();
        }
    }

    private void buyExistentRawMatter() {
        Scanner reader = new Scanner(System.in);
        Utils.cls();
        stock.showRawMaterials();
        System.out.println("«Ingrese el nombre que quiere comprar: »");
        String name = reader.nextLine();
        RawMaterial rawMaterial = stock.searchMaterialByName(name);
        if (rawMaterial != null) {
            Utils.cls();
            System.out.println("«Ingrese la cantidad: »");
            int quantity = reader.nextInt();
            stock.addToExistentStock(rawMaterial, quantity);
            new Expenses(rawMaterial, quantity);
            stock.saveMaterialsToFile("RawMaterials.json");
        } else {
            System.out.println("Input incorrecto!");
            Utils.pressToContinue();
        }

    }

    private void removeRawMatter() {
        Scanner reader = new Scanner(System.in);
        Utils.cls();
        stock.showRawMaterials();
        System.out.println("«Ingrese el nombre que quiere deshacer: »");
        String name = reader.nextLine();
        RawMaterial rawMaterial = stock.searchMaterialByName(name);
        if (rawMaterial != null) {
            Utils.cls();
            System.out.println("«Ingrese la cantidad: »");
            int quantity = reader.nextInt();
            stock.removeFromExistentStock(rawMaterial, quantity);
            stock.saveMaterialsToFile("RawMaterials.json");
        } else {
            System.out.println("Input incorrecto!");
            Utils.pressToContinue();
        }
    }

    private void rawMatterMenu() {
        Scanner reader = new Scanner(System.in);
        boolean out = false;
        int option; 
        while (!out) {
            Utils.cls();
            System.out.println("«1. Comprar Materia Prima Nueva»");
            System.out.println("«2. Comprar Materia Prima Existente»");
            System.out.println("«3. Deshacer Materia Prima»");
            System.out.println("«9. Atras»");
            System.out.println("«Escribe una de las opciones»");
            option = reader.nextInt();
            switch (option) {
                case 1:
                    buyNewRawMatter();
                    break;
                case 2:
                    buyExistentRawMatter();
                    break;
                case 3:
                    removeRawMatter();
                    break;
                case 9:
                    out = true;
                    break;
                default:
                    System.out.println("«Solo números entre 1 y 6»");
            }

        }
    }

    // BEVERAGES
    private void buyNewBeverage() {
        Scanner reader = new Scanner(System.in);

        Utils.cls();
        System.out.println("«Ingrese el nombre: »");
        String name = reader.nextLine();

        Utils.cls();
        System.out.println("«Ingrese el precio de venta: »");
        int sellPrice = reader.nextInt();

        Utils.cls();
        System.out.println("«Ingrese el precio de costo: »");
        int costPrice = reader.nextInt();

        Utils.cls();
        BeverageBrand beverageBrand = null;
        int option; 
        while (beverageBrand == null) {
            Utils.cls();
            System.out.println("«1." + BeverageBrand.COCACOLA.getName() + "»");
            System.out.println("«2." + BeverageBrand.MANAOS.getName() + "»");
            System.out.println("«3." + BeverageBrand.QUILMES.getName() + "»");
            System.out.println("«4." + BeverageBrand.VILLAVICENCIO.getName() + "»");
            System.out.println("«5." + BeverageBrand.BAGIO.getName() + "»");
            System.out.println("«Ingrese el numero de la marca: »");
            option = reader.nextInt();
            switch (option) {
                case 1:
                    beverageBrand = BeverageBrand.COCACOLA;
                    break;
                case 2:
                    beverageBrand = BeverageBrand.MANAOS;
                    break;
                case 3:
                    beverageBrand = BeverageBrand.QUILMES;
                    break;
                case 4:
                    beverageBrand = BeverageBrand.VILLAVICENCIO;
                    break;
                case 5:
                    beverageBrand = BeverageBrand.BAGIO;
                    break;
                default:
                    System.out.println("«Solo números entre 1 y 6»");
            }
        }

        Utils.cls();
        System.out.println("«Ingrese el tamaño en litros: »");
        float sizeInL = reader.nextFloat();

        Utils.cls();
        BeverageType beverageType = null;
        int option2; 
        while (beverageType == null) {
            Utils.cls();
            System.out.println("«1." + BeverageType.WATER.getName() + "»");
            System.out.println("«2." + BeverageType.SODA.getName() + "»");
            System.out.println("«3." + BeverageType.JUICE.getName() + "»");
            System.out.println("«4." + BeverageType.ALCOHOLIC.getName() + "»");
            System.out.println("«Ingrese el numero del tipo de bebida: »");
            option2 = reader.nextInt();
            switch (option2) {
                case 1:
                    beverageType = beverageType.WATER;
                    break;
                case 2:
                    beverageType = beverageType.SODA;
                    break;
                case 3:
                    beverageType = beverageType.JUICE;
                    break;
                case 4:
                    beverageType = beverageType.ALCOHOLIC;
                    break;
                default:
                    System.out.println("«Solo números entre 1 y 6»");
            }
        }
        Utils.cls();
        System.out.println("«Ingrese la cantidad: »");
        int quantity = reader.nextInt();
        Beverage beverage = new Beverage(name, sellPrice, costPrice, beverageBrand, sizeInL, beverageType);
        stock.addNewStock(beverage, quantity);
        new Expenses(beverage, quantity);
        stock.saveBeveragesToFile("Beverages.json");
    }

    private void buyExistentBeverage() {
        Scanner reader = new Scanner(System.in);
        Utils.cls();
        stock.showBeverages();
        System.out.println("«Ingrese el id que quiere comprar: »");
        String id = reader.nextLine();
        Beverage beverage = stock.searchBeverageById(id);
        if (beverage != null) {
            Utils.cls();
            System.out.println("«Ingrese la cantidad: »");
            int quantity = reader.nextInt();
            stock.addToExistentStock(beverage, quantity);
            new Expenses(beverage, quantity);
            stock.saveBeveragesToFile("Beverages.json");
        } else {
            System.out.println("Input incorrecto!");
            Utils.pressToContinue();
        }
    }

    public void sellBeverage(ArrayList<Product> productsList) {
        Scanner reader = new Scanner(System.in);
        Utils.cls();
        stock.showBeverages();
        System.out.println("«Ingresar ID de bebida a vender: »");
        String id = reader.nextLine();
        Beverage beverage = stock.searchBeverageById(id);
        if (beverage != null) {
            Utils.cls();
            System.out.println("«Ingrese la cantidad: »");
            int quantity = reader.nextInt();
            stock.removeFromExistentStock(beverage, quantity);
            productsList.add(beverage);
        } else {
            System.out.println("Input incorrecto!");
            Utils.pressToContinue();
        }
    }

    public boolean checkRawMaterial(ArrayList<RawMaterial> rawMaterialsList) {
        Integer value;
        boolean available = true;

        for (RawMaterial rawMaterial : rawMaterialsList) {
            value = this.stock.getRawMaterials().get(rawMaterial);
            if (value == 0) {
                System.out.println(rawMaterial.getName() + " No disponible ");
                available = false;
            }
        }
        return available;
    }

    private void removeBeverage() {
        Scanner reader = new Scanner(System.in);
        Utils.cls();
        stock.showBeverages();
        System.out.println("«Ingrese el id que quiere remover: »");
        String id = reader.nextLine();
        Beverage beverage = stock.searchBeverageById(id);
        if (beverage != null) {
            Utils.cls();
            System.out.println("«Ingrese la cantidad: »");
            int quantity = reader.nextInt();
            stock.removeFromExistentStock(beverage, quantity);
            stock.saveBeveragesToFile("Beverages.json");
        } else {
            System.out.println("Input incorrecto!");
            Utils.pressToContinue();
        }
    }

    private void beveragesMenu() {
        Scanner reader = new Scanner(System.in);
        boolean out = false;
        int option; 
        while (!out) {
            Utils.cls();
            System.out.println("«1. Comprar Bebidas Nueva»");
            System.out.println("«2. Comprar Bebidas Existente»");
            System.out.println("«3. Deshacer Bebidas»");
            System.out.println("«9. Atras»");
            System.out.println("«Escribe una de las opciones»");
            option = reader.nextInt();
            switch (option) {
                case 1:
                    buyNewBeverage();
                    break;
                case 2:
                    buyExistentBeverage();
                    break;
                case 3:
                    removeBeverage();
                    break;
                case 9:
                    out = true;
                    break;
                default:
                    System.out.println("«Solo números entre 1 y 6»");
            }

        }
    }

    // STOCK
    private void readStock() {
        Scanner reader = new Scanner(System.in);
        Utils.cls();
        System.out.println("---------- Bebidas ----------");
        stock.showBeverages();
        System.out.println("------- Materia Prima -------");
        stock.showRawMaterials();
        System.out.println("«Atras -> (cualquiera)»");
        Utils.pressToContinue();
    }

    public void stockMenu() {
        Scanner reader = new Scanner(System.in);
        boolean out = false;
        int option; 
        while (!out) {
            Utils.cls();
            System.out.println("«1. Materia Prima»");
            System.out.println("«2. Bebidas»");
            System.out.println("«3. Ver Stock»");
            System.out.println("«9. Atras»");
            System.out.println("«Escribe una de las opciones»");
            option = reader.nextInt();
            switch (option) {
                case 1:
                    rawMatterMenu();
                    break;
                case 2:
                    beveragesMenu();
                    break;
                case 3:
                    readStock();
                    break;
                case 9:
                    out = true;
                    break;
                default:
                    System.out.println("«Solo números entre 1 y 6»");
            }

        }
    }

}
