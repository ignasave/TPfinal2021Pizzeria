package com.company.Shop;

import com.company.Stock.Stock;

public class Shop {
    private Stock stock;

    //region CONSTRUCTORS
    public Shop(Stock stock) {
        this.stock = stock;
    }

    public Shop() {
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
}
