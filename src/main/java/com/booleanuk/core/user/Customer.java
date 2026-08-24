package com.booleanuk.core.user;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Inventory;
import com.booleanuk.core.items.Item;
import com.booleanuk.core.items.Item.SKU;

public class Customer extends User {

    public void order(Inventory inventory, Basket basket, SKU sku) {
      Item item = inventory.getItem(sku);
      basket.addItem(item);
  }
    
}
