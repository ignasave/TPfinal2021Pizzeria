package com.company.Person;

import com.company.Utils.Utils;

import java.util.Locale;
import java.util.UUID;

public class Employee extends Person {

    private float wage;
    private boolean active = true;
    private int dni;
    private String id;
    private boolean extern;

    //region CONSTRUCTORS
    public Employee() {
    }


    public Employee(String name, String lastname, float wage, boolean active, int dni, boolean extern) {
        super(name, lastname);
        this.wage = wage;
        this.active = active;
        this.dni = dni;
        this.id = Utils.generateUniqueID();
        this.extern = extern;

    }

    //endregion

    //region GETTER & SETTER

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public float getWage() {
        return wage;
    }

    public void setWage(float wage) {
        this.wage = wage;
    }

    public String getId() {
        return this.id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    //endregion

    //region HELPERS
    @Override
    public String toString() {
        return super.toString() +
                "\nWage: " + getWage();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Employee))
            return false;

        Employee employee = (Employee) o;
        boolean answer = super.equals(o) && this.dni == employee.getDni();

        return answer;
    }

    @Override
    public int hashCode() {
        int answer = super.hashCode();
        answer += 31 * Integer.hashCode(this.dni);
        return answer;
    }

    //endregion
}
