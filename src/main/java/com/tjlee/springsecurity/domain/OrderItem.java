package com.tjlee.springsecurity.domain;

import javax.persistence.*;
import java.util.Objects;

//@Entity
@Table(name = "order_item", schema = "hibernate_test", catalog = "")
public class OrderItem {
    private int orderItemId;
    private int orderId;
    private int itemId;
    private Integer orderprice;
    private Integer count;
    private Item itemByOrderItemId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ITEM_ID", nullable = false)
    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    @Basic
    @Column(name = "ORDER_ID", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "ITEM_ID", nullable = false)
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "ORDERPRICE", nullable = true)
    public Integer getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(Integer orderprice) {
        this.orderprice = orderprice;
    }

    @Basic
    @Column(name = "COUNT", nullable = true)
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return orderItemId == orderItem.orderItemId &&
                orderId == orderItem.orderId &&
                itemId == orderItem.itemId &&
                Objects.equals(orderprice, orderItem.orderprice) &&
                Objects.equals(count, orderItem.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderItemId, orderId, itemId, orderprice, count);
    }

    @OneToOne
    @JoinColumn(name = "ORDER_ITEM_ID", referencedColumnName = "ITEM_ID", nullable = false)
    public Item getItemByOrderItemId() {
        return itemByOrderItemId;
    }

    public void setItemByOrderItemId(Item itemByOrderItemId) {
        this.itemByOrderItemId = itemByOrderItemId;
    }
}
