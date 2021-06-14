package com.company.Order;

import com.company.Product.Product;
import com.company.Person.Client;
import com.company.Person.Employee;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Delivery extends Order {

    public static final float DELIVERY_PRICE = 50;
    private Employee employee;
    private LocalDateTime out;
    private String address;


    //region CONSTRUCTORS
    public Delivery() {
    }


    public Delivery(ArrayList<Product> products, float finalPrice, float productPrice, float totalPrice,
                    LocalDateTime dateTime, Employee employee, LocalDateTime out, String address) {
        super(products, finalPrice, productPrice, totalPrice, dateTime);
        this.employee = employee;
        this.out = out;
        this.address = address;
    }

    //endregion

    //region GETTER & SETTER

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDateTime getOut() {
        return out;
    }

    public void setOut(LocalDateTime out) {
        this.out = out;
    }

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
                "\ndeliveryFloat: " + DELIVERY_PRICE +
                "\nemployee: " + getOut() +
                "\nout: " + getOut() +
                "\naddress: " + getAddress();
    }

    //endregion

}
