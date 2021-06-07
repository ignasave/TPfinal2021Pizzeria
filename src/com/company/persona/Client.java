package com.company.persona;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person  {


    private String address;
    private String telNumber;
    private static List<Client> clientArray = new ArrayList<>();


    //region Construct

    public Client(){}

    public Client(String firstName, String lastName, String address, String telNumber) {
        super(firstName, lastName);
        this.address = address;
        this.telNumber = telNumber;
    }


    //endregion


    //region getter y setter

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public static List<Client> getClientArray() {
        return clientArray;
    }

    public static void setClientArray(List<Client> clientArray) {
        Client.clientArray = clientArray;
    }

    //endregion


    //region Helper

    @Override
    public String toString() {
        return "Client{" + super.toString() +
                "address='" + address + '\'' +
                ", telNumber='" + telNumber + '\'' +

                '}';
    }


    //endregion

}