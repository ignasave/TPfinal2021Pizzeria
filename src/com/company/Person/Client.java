package com.company.Person;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person {

    private String address;
    private String telNumber;

    //region CONSTRUCTOR

    public Client() {
    }

    public Client(String firstName, String lastName, String address, String telNumber) {
        super(firstName, lastName);
        this.address = address;
        this.telNumber = telNumber;
    }

    //endregion

    //region GETTER & SETTER

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

    //endregion

    //region HELPER

    @Override
    public String toString() {
        return "Client{" + super.toString() +
                "address='" + address + '\'' +
                ", telNumber='" + telNumber + '\'' +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Client))
            return false;

        Client client = (Client) o;
        boolean answer = super.equals(o) && this.telNumber == client.getTelNumber();

        return answer;
    }

    @Override
    public int hashCode() {
        int answer = super.hashCode();
        answer += 31 * this.telNumber.hashCode();
        return answer;
    }

    //endregion

}