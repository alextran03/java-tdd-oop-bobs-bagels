package com.booleanuk.core.userTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.booleanuk.core.Basket;
import com.booleanuk.core.items.Item.SKU;
import com.booleanuk.core.user.*;
import com.booleanuk.core.*;;
public class CustomerTest {

    @Test
    public void checkIfCustomersOrdersOnlyFromItemsThatAreInStock() {

        Customer customer = new Customer();
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);

        assertThrows(IllegalArgumentException.class, () -> {
            customer.order(inventory, basket, SKU.UNKOWN);
        });


    }


    
}
