package com.booleanuk.core;
import org.junit.jupiter.api.Test;

import com.booleanuk.core.items.Bagel;
import com.booleanuk.core.items.Filling;
import com.booleanuk.core.items.Item;
import com.booleanuk.core.items.Item.SKU;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

public class InventoryTest {
    private Inventory inventory;

    @BeforeEach
    public void setUp() {
        this.inventory = new Inventory();
    }


    @Test
    public void checkCostOfBagel() {
        Item bagel = new Bagel("Bagel", SKU.BGLP, 0.39, "Plain");
        inventory.addItem(bagel);

        assertEquals(0.39, inventory.getPrice(SKU.BGLP), 0.001);
    }

    @Test
    public void checkCostOfFilling () {
        Item filling = new Filling("Filling", SKU.FILB, 0.12, "Bacon");
        inventory.addItem(filling);

        assertEquals(0.12, inventory.getPrice(SKU.FILB), 0.001);
    } 
}
