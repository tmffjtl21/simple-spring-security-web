package com.tjlee.springsecurity.domain;

import javax.persistence.*;
import java.util.Objects;

//@Entity
public class Item {
    private int itemId;
    private String name;
    private Integer price;
    private String stockquantity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID", nullable = false)
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "NAME", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "PRICE", nullable = true)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "STOCKQUANTITY", nullable = true, length = 45)
    public String getStockquantity() {
        return stockquantity;
    }

    public void setStockquantity(String stockquantity) {
        this.stockquantity = stockquantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return itemId == item.itemId &&
                Objects.equals(name, item.name) &&
                Objects.equals(price, item.price) &&
                Objects.equals(stockquantity, item.stockquantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, name, price, stockquantity);
    }
}
