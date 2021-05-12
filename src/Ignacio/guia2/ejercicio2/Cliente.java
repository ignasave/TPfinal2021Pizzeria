package Ignacio.guia2.ejercicio2;

import java.util.UUID;

public class Cliente {
    private UUID id;
    private String name;
    private String email;
    private int discount;

    public Cliente(String name, String email, int discount) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.discount = discount;
    }

    public Cliente() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", discount=" + discount +
                '}';
    }
}
