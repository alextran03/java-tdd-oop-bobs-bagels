package com.booleanuk.core;
import com.booleanuk.core.items.Item;
import com.booleanuk.core.items.Item.SKU;
import java.util.Map;
import java.util.HashMap;

public class Inventory implements Stock{
    private Map<SKU, Item> stock;

    public Inventory() {
        this.stock = new HashMap<>();
    }

    public double getPrice(SKU sku) {
        return this.stock.get(sku).getPrice();
    }

    public Item getItem(SKU sku) {
      if (!this.stock.containsKey(sku)) {
          throw new IllegalArgumentException("Item not stocked");
      }
      return this.stock.get(sku);
    }

    public void addItem(Item item) {
        this.stock.put(item.getSKU(), item);
    }

    public boolean hasItem(String sku) {
        try {
            SKU skuEnum = SKU.valueOf(sku);
            return this.stock.containsKey(skuEnum);
        } catch (IllegalArgumentException e) {
            return false;
        }

    }

}
