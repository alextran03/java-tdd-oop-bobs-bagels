package com.booleanuk.core.userTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Inventory;
import com.booleanuk.core.items.Bagel;
import com.booleanuk.core.items.Item;
import com.booleanuk.core.items.Item.SKU;
import com.booleanuk.core.user.Manager;


public class ManagerTest {

    @Test 
    public void changeCapacityOfBasket() {
        Inventory inventory = new Inventory();
        Item bagel1 = new Bagel("Plain Bagel", SKU.BGLP, 0.39, "Plain");
        Item bagel2 = new Bagel("Sesame Bagel", SKU.BGLS, 0.49, "Sesame");
        inventory.addItem(bagel1);
        inventory.addItem(bagel2);
        Basket basket = new Basket(inventory, 1);
        basket.addItem(bagel1);
        try {
            basket.addItem(bagel2);
        } catch (IllegalStateException e) {
            assertEquals("Basket is full", e.getMessage());
        }
        Manager manager = new Manager();
        manager.setBasketCapacity(basket, 2);
        basket.addItem(bagel2);
        assertEquals(2, basket.getSize());
    }

    @Test
    public void addItemToInventory () {
        Inventory inventory = new Inventory();
        Manager manager = new Manager();
        Item bagel1 = new Bagel("Plain Bagel", SKU.BGLP, 0.39, "Plain");
        Item bagel2 = new Bagel("Sesame Bagel", SKU.BGLS, 0.49, "Sesame");
        manager.addItemToInventory(inventory, bagel1);
        manager.addItemToInventory(inventory, bagel2);

        assertEquals("Plain Bagel", inventory.getItem(SKU.BGLP).getName());
        assertEquals("Sesame Bagel", inventory.getItem(SKU.BGLS).getName());
 
    }


    
}
