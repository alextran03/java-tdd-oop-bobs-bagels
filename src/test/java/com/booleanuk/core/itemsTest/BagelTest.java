package com.booleanuk.core.itemsTest;
import com.booleanuk.core.items.Bagel;
import org.junit.jupiter.api.Test;
import com.booleanuk.core.items.Item.SKU;
import com.booleanuk.core.items.Filling;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BagelTest {

    @Test
    public void addFillingsToBagelTest() {
        Bagel bagel = new Bagel("Plain Bagel", SKU.BGLP, 0.39, "Plain");
        Filling filling = new Filling("Filling", SKU.FILB, 0.12, "Bacon");

        bagel.addFilling(filling);

        assertEquals(1, bagel.getFillings().size());

    }

    @Test
    public void bagelPriceIncludesFillingCost() {
        Bagel bagel = new Bagel ("Plain Bagel", SKU.BGLP, 0.39, "Plain");
        Filling filling = new Filling("Filling", SKU.FILB, 0.12, "Bacon");

        bagel.addFilling(filling);

        assertEquals(0.51, bagel.getPrice(), 0.001);
    }
    
}
