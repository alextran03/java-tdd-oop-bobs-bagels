package com.booleanuk.core.user;
import com.booleanuk.core.Basket;
import com.booleanuk.core.Inventory;
import com.booleanuk.core.items.Item;

public class Manager extends User {
    public void setBasketCapacity(Basket basket, int capacity) {
        basket.maxCapacity(capacity);
    }

    public void addItemToInventory(Inventory inventory, Item item) {
            inventory.addItem(item);
    }
}
