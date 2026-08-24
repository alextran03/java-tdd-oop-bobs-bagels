package com.booleanuk.core.items;

public abstract class Item {
    public enum SKU {
        BGLO, BGLP, BGLE, BGLS, 
        COFB, COFW, COFC, COFL,
        FILB, FILE, FILC, FILX, FILS, FILH,
        UNKOWN
    }

    String name;
    double price;
    String variant;
    SKU sku;

    public Item(String name, double price, String variant, SKU sku) {
        this.name = name;
        this.price = price;
        this.variant = variant;
        this.sku = sku;
    }

    public double getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public String getVariant() {
        return this.variant;
    }

    public SKU getSKU() {
        return this.sku;
    }   
}
