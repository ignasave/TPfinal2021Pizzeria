package com.company.pedidos;

import com.company.Product.Product;
import com.company.persona.Client;
import com.company.persona.Employee;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Delivery extends Order {

//    Precio delibery: float
//    Repartidor: Empleado
//    Fecha de salida del reparto: Datetime
//    Direccion: String

    public static final float DELIVERYPRICE = 50;
    private Employee employee;
    private LocalDateTime out;
    private String address;


    //region CONSTRUCTORS
    public Delivery() {
    }


    public Delivery(Client client, ArrayList<Product> newArray, float finalPrice, float productPrice, float totalPrice, LocalDateTime dateTime, Employee employee, LocalDateTime out) {
        super(client, newArray, finalPrice, productPrice, totalPrice, dateTime);
        this.employee = employee;
        this.out = out;
    }

    //endregion

    //region GETTER & SETTER

    public float getDeliveryPrice() {
        return DELIVERYPRICE;
    }

//    public void setDeliveryFloat(float deliveryFloat) {this.deliveryFloat = deliveryFloat;}

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDateTime getOut() {
        return out;
    }

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
                "\ndeliveryFloat: " + getDeliveryPrice() +
                "\nemployee: " + getOut() +
                "\nout: " + getOut() +
                "\naddress: " + getAddress();
    }

    //endregion

}
