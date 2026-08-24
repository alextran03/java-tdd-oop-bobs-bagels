package com.booleanuk.core;

import com.booleanuk.core.items.Item;
import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Item> items;
    private int capacity;
    private Stock stock;

    public Basket(Stock stock) {
        this(stock, 10);
    }

    public Basket(Stock stock, int capacity) {
        this.stock = stock;
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {

        if (!this.stock.hasItem(item.getSKU().name())) {
            throw new IllegalArgumentException("Item not stocked");
        }

        if (this.items.size() >= this.capacity) {
            throw new IllegalStateException("Basket is full");
        }
        this.items.add(item);
    }

    public void removeItem(Item item) {
        if (!this.items.contains(item)) {
            throw new IllegalArgumentException("Item not found in basket");
        }
        this.items.remove(item);
    }

    public void maxCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double calculateTotalCost(){
        double total = 0;
        for (Item item : this.items) {
            total += item.getPrice(); 
        }
        return total;
    }

    public int getSize() {
        return this.items.size();
    }

    public int getCapacity() {
        return this.capacity;
    }
    
    public List<Item> getItems() {
        return this.items;
    }

}
