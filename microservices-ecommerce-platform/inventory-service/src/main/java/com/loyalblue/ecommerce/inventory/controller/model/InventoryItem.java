package com.loyalblue.ecommerce.inventory.controller.model;

// A simple class representing an inventory item with an id, name, and price.
public class InventoryItem {
    private int id;
    private String name;
    private int price;

    // Constructor to initialize an InventoryItem with its id, name, and price.
    public InventoryItem(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for price
    public int getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(int price) {
        this.price = price;
    }
}
