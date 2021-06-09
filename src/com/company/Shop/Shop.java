package com.company.Shop;

import com.company.Menu.CallbackAction;
import com.company.Menu.IntCallbackAction;
import com.company.Menu.Menu;
import com.company.Menu.IntField;
import com.company.Stock.Stock;
import com.company.Stock.StockController;

import java.util.ArrayList;

public class Shop {
    private StockController stockController;
    private Menu menu;

    //region CONSTRUCTORS
    public Shop() {
        this.stockController = new StockController();
        this.menu = new Menu();
    }
    //endregion

    //region GETTER & SETTER

    //endregion

    public void initializeShop() {
        mainMenu();
    }
    
    private void buyRawMaterialMenu() {
        ArrayList<String> options = new ArrayList<String>() {{
            add("Materia Prima Nueva");
            add("Materia Prima Existente");
        }};
        String title = "Comprar Materia Prima";

        CallbackAction[] callbackActions = new CallbackAction[] {
                new CallbackAction() {  public void callback() { stockController.buyNewRawMaterial(menu); } },
                new CallbackAction() {  public void callback() { stockController.buyExistentRawMaterial(menu); } },
        };

        menu.showOptionsMenu(options,title,callbackActions);
    }

    private void rawMaterialMenu() {
        ArrayList<String> options = new ArrayList<String>() {{
            add("Comprar Materia Prima");
            add("Deshacer Materia Prima");
        }};
        String title = "Materia Prima";
        CallbackAction[] callbackActions = new CallbackAction[] {
                new CallbackAction() {  public void callback() { buyRawMaterialMenu(); } },
                new CallbackAction() {  public void callback() { stockController.removeRawMaterial(menu); } },
        };

        menu.showOptionsMenu(options,title,callbackActions);
    }

    private void stockMenu() {
        ArrayList<String> options = new ArrayList<String>() {{
            add("Materia Prima");
            add("Bebidas");
            add("Ver Stock");
        }};
        String title = "Stock";
        CallbackAction[] callbackActions = new CallbackAction[] {
                new CallbackAction() {  public void callback() { rawMaterialMenu(); } },
        };

        menu.showOptionsMenu(options,title,callbackActions);
    }

    private void mainMenu() {
        ArrayList<String> options = new ArrayList<String>() {{
                add("Stock");
                add("Pedidos");
                add("Empleados");
                add("Facturacion");
            }};
        String title = "Menu Principal";
        CallbackAction[] callbackActions = new CallbackAction[] {
                new CallbackAction() {  public void callback() { stockMenu(); } },
        };

        menu.showOptionsMenu(options,title,callbackActions);
    }

}
