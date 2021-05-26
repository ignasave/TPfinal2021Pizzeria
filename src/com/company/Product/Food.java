package com.company.Product;

import com.company.RawMaterial.RawMaterial;

public class Food {
    private String foodType;
    private String description;
    private RawMaterial[] ingredients;

    public Food() {
    }

    public Food(String foodType, String description, RawMaterial[] ingredients) {
        this.foodType = foodType;
        this.description = description;
        this.ingredients = ingredients;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RawMaterial[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(RawMaterial[] ingredients) {
        this.ingredients = ingredients;
    }
}
