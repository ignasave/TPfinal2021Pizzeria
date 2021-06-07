package com.company.Shop;

import com.company.Menu.CallbackAction;
import com.company.Menu.IntCallbackAction;
import com.company.Menu.Menu;
import com.company.Menu.IntField;
import com.company.Stock.Stock;

import java.util.ArrayList;

public class Shop {
    private Stock stock;
    private Menu menu;

    //region CONSTRUCTORS
    public Shop() {
        this.stock = new Stock();
        this.menu = new Menu();
    }
    //endregion

    //region GETTER & SETTER

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
    //endregion

    public void initializeShop() {
        mainMenu();
        /*menu.add(new IntField("Comprar","Etiqueta" , new IntCallbackAction() { public void callback(int response) {
            System.out.println(response);
        }}));*/
    }

    private void buyRawMaterialMenu() {
        ArrayList<String> options = new ArrayList<String>() {{
            add("Materia Prima Nueva");
            add("Materia Prima Existente");
        }};
        String title = "Comprar Materia Prima";
        CallbackAction[] callbackActions = new CallbackAction[] {

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
