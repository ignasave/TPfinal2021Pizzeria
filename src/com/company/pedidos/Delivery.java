package com.company.pedidos;

import com.company.Product.Product;
import com.company.persona.Employee;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Delivery extends Order {

//    Precio delibery: float
//    Repartidor: Empleado
//    Fecha de salida del reparto: Datetime
//    Direccion: String

    private float deliveryFloat;
    private Employee employee;
    private LocalDateTime out;
    private String address;

    //region CONSTRUCTORS
    public Delivery(){}


    public Delivery(ArrayList<Product> newArray, float finalPrice, float productPrice, float totalPrice, LocalDateTime dateTime, float deliveryFloat, Employee employee, LocalDateTime out, String address) {
        super(newArray, finalPrice, productPrice, totalPrice, dateTime);
        this.deliveryFloat = deliveryFloat;
        this.employee = employee;
        this.out = out;
        this.address = address;
    }

    //endregion

    //region GETTER & SETTER

    public float getDeliveryFloat() {
        return deliveryFloat;
    }

    public void setDeliveryFloat(float deliveryFloat) {
        this.deliveryFloat = deliveryFloat;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDateTime getOut() { return out; }

//    public void setOut(LocalDateTime out) {
//        this.out = out;
//    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //endregion

    //region HELPERS

    @Override
    public String toString() {
        return "\nDelivery " +
                "\ndeliveryFloat: " + getDeliveryFloat() +
                "\nemployee: " + getOut() +
                "\nout: " + getOut() +
                "\naddress: " + getAddress();
    }

    //endregion

}