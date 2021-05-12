package Ignacio.guia2.ejercicio2;

import Ignacio.guia2.ejercicio1.Autor;

import java.time.LocalDate;
import java.util.UUID;

public class Factura {
    private UUID id;
    private float totalAmount;
    private LocalDate date;
    private Cliente client;
    private ItemVenta[] sellItems;

    public Factura() {
    }

    public Factura( Cliente client, ItemVenta[] sellItems) {
        this.id = UUID.randomUUID();
        this.date = LocalDate.now();
        this.client = client;
        this.totalAmount = 0;
        this.sellItems = sellItems;
    }

    public UUID getId() {
        return id;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public Cliente getClient() {
        return client;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public void calculateTotalAmount(Boolean withDisc) {
        float totalAmount = 0;
        for (ItemVenta actualItem: sellItems) {
            totalAmount += actualItem.getuPrice();
        }
        if(withDisc){
            float discMult = (float)this.client.getDiscount() / 100;
            totalAmount = totalAmount - ( totalAmount * discMult);
        }

        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "ID: " + id + "  TotalAmount: " + totalAmount + "  Date: " + date + "Cliente: " + client;
    }
}
