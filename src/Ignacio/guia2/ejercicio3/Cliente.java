package Ignacio.guia2.ejercicio3;

import java.util.UUID;

public class Cliente {
    private UUID id;
    private String name;
    private char gender;

    public Cliente() {
    }

    public Cliente(String name, char gender) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.gender = gender;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
