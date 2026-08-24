package com.booleanuk.core;

import com.booleanuk.core.items.Bagel;
import com.booleanuk.core.items.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasketTest {
    private Basket basket;

    @BeforeEach
    public void setUp() {
        this.basket = new Basket();
    }

    @Test
    public void newBasketIsEmpty() {
        assertEquals(0, this.basket.getSize());
    }

    @Test
    public void newBasketHasDefaultCapacityOfTen() {
        assertEquals(10, this.basket.getCapacity());
    }

    @Test
    public void addingItemIncreasesSize() {
        Item bagel = new Bagel("Bagel", Item.SKU.BGLP, 0.39, "Plain");

        this.basket.add(bagel);

        assertEquals(1, this.basket.getSize());
    }
}
