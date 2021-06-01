package com.company.Product;

import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    private float sellPrice = 0;
    private float costPrice = 0;

    //region CONSTRUCTORS
    public Product() {
    }

    public Product(String name, float sellPrice, float costPrice) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.sellPrice = sellPrice;
        this.costPrice = costPrice;
    }
    //endregion

    //region GETTER & SETTER
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

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public float getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(float costPrice) {
        this.costPrice = costPrice;
    }
    //endregion

    //region HELPERS
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sellPrice=" + sellPrice +
                ", costPrice=" + costPrice +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Product))
            return false;

        Product product = (Product) o;
        boolean answer = this.name == product.getName();

        return answer;
    }
    //endregion
}
