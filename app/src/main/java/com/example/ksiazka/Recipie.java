package com.example.ksiazka;

public class Recipie {
    private String name;
    private String ingredients;
    private int imageId;
    private int category;
    private int id;

    public Recipie(String name, String ingredients, int imageId, int category) {
        this.name = name;
        this.ingredients = ingredients;
        this.imageId = imageId;
        this.category = category;
        this.id++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
