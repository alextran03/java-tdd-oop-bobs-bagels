package com.booleanuk.core;

import com.booleanuk.core.items.Bagel;
import com.booleanuk.core.items.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.booleanuk.core.items.Item.SKU;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasketTest {
    private Inventory inventory;
    private Item bagel1;
    private Item bagel2;

    @BeforeEach
    public void setUp() {
        this.inventory = new Inventory();
        this.bagel1 = new Bagel("Plain Bagel", SKU.BGLP, 0.39, "Plain");
        this.bagel2 = new Bagel("Sesame Bagel", SKU.BGLS, 0.49, "Sesame");
        this.inventory.addItem(bagel1);
        this.inventory.addItem(bagel2);
    }

    @Test
    public void testAddItemToBasket() {
        Basket basket = new Basket(inventory);
        basket.addItem(bagel1);
        assertEquals(1, basket.getSize());
        assertEquals(10, basket.getCapacity());
    }

    @Test
    public void testRemoveItemFromBasket() {
        Basket basket = new Basket(inventory);
        basket.addItem(bagel1);
        basket.removeItem(bagel1);
        assertEquals(0, basket.getSize());
    }

    @Test
    public void testAddingItemToFullBasketThrowsException() {
        Basket basket = new Basket(inventory, 1);
        basket.addItem(bagel1);
        try {
            basket.addItem(bagel2);
        } catch (IllegalStateException e) {
            assertEquals("Basket is full", e.getMessage());
        }
    }

    @Test
    public void removeNonExistentItemFromBasketThrowsExecption() {
        Basket basket = new Basket(inventory);

        assertThrows(IllegalArgumentException.class, () -> {
            basket.removeItem(bagel1);
        });
    }

    @Test
    public void checkTotalCostOfItemsInBasket() {
        Basket basket = new Basket(inventory);
        basket.addItem(bagel1);
        basket.addItem(bagel2);

        assertEquals(0.88, basket.calculateTotalCost(), 0.001);
    }

    @Test
    public void basketRejectsItemNotStockedInGivenInventory() {
        Inventory emptyInventory = new Inventory();
        Basket basket = new Basket(emptyInventory);

        assertThrows(IllegalArgumentException.class, () -> {
            basket.addItem(bagel1);
        });
    }

    @Test
    public void basketAcceptsItemWhenStubStockHasIt() {
        Stock testStock = sku -> sku.equals(SKU.BGLP.name());
        Basket basket = new Basket(testStock);

        basket.addItem(bagel1);

        assertEquals(1, basket.getSize());
    }
}
