package com.company.Product;

import com.company.RawMaterial.RawMaterial;
import com.company.persona.Employee;

public class Food extends Product{
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

    public Food(String name, float sellPrice, float costPrice, String foodType, String description, RawMaterial[] ingredients) {
        super(name, sellPrice, costPrice);
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


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Food))
            return false;

        Food food = (Food) o;
        boolean answer = super.equals(o) && this.foodType == food.getFoodType();

        return answer;
    }
}


