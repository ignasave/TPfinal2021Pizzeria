package com.company.Product;

import com.company.RawMaterial.RawMaterial;

import java.util.ArrayList;

public class Food extends Product{
    private String foodType;
    private String description;
    private ArrayList<RawMaterial> ingredients;

    //region CONSTRUCTORS

    public Food() {
    }

    public Food(String foodType, String description, ArrayList<RawMaterial> ingredients) {
        this.foodType = foodType;
        this.description = description;
        this.ingredients = ingredients;
    }

    public Food(String name, float sellPrice, float costPrice, String foodType, String description, ArrayList<RawMaterial> ingredients) {
        super(name, sellPrice, costPrice);
        this.foodType = foodType;
        this.description = description;
        this.ingredients = ingredients;
    }

    //endregion

    //region GETTER & SETTER
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

    public ArrayList<RawMaterial> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<RawMaterial> ingredients) {
        this.ingredients = ingredients;
    }
    //endregion

    //region HELPERS
    //endregion
}
