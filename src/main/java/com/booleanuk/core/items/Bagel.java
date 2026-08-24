package com.booleanuk.core.items;
import java.util.ArrayList;
import java.util.List;

public class Bagel extends Item{
    private List<Filling> fillings;

    public Bagel(String name, SKU sku, double price, String variant) {
        super(name, price, variant, sku);
        this.fillings = new ArrayList<>();
    }

    public void addFilling(Filling filling) {
        this.fillings.add(filling);
    }
    
      public List<Filling> getFillings() {
      return this.fillings;
  }
    
}
