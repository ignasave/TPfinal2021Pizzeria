package com.company.Stock;

public class SettingStockError extends Exception {

    public SettingStockError() {
        super();
    }

    public SettingStockError(String mensaje) {
        super(mensaje);
    }
}
