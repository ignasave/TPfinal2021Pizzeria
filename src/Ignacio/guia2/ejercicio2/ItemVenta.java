package Ignacio.guia2.ejercicio2;

import java.util.UUID;

public class ItemVenta {
    private UUID id;
    private String name;
    private String desc;
    private float uPrice;

    public ItemVenta() {
    }

    public ItemVenta(String name, String desc, float uPrice) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.desc = desc;
        this.uPrice = uPrice;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getuPrice() {
        return uPrice;
    }

    public void setuPrice(float uPrice) {
        this.uPrice = uPrice;
    }
}
