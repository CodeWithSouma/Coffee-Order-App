package com.codewithsouma.coffeeorderapp.model;

public class Coffee {
    private String coffeeName;
    private String description;
    private int price;
    private int image;

    public Coffee(String coffeeName, String description, int price, int image) {
        this.coffeeName = coffeeName;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }
}
