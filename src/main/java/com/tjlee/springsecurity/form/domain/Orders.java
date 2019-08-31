package com.tjlee.springsecurity.form.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Objects;

//@Entity
public class Orders {
    private int orderId;
    private int memberId;
    private Integer deliveryId;
    private Date orderdate;
    private String status;
    private OrderItem orderItemByOrderId;
    private Delivery deliveryByOrderId;
    private Member memberByOrderId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "MEMBER_ID", nullable = false)
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "DELIVERY_ID", nullable = true)
    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    @Basic
    @Column(name = "ORDERDATE", nullable = true)
    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    @Basic
    @Column(name = "STATUS", nullable = true, length = 10)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return orderId == orders.orderId &&
                memberId == orders.memberId &&
                Objects.equals(deliveryId, orders.deliveryId) &&
                Objects.equals(orderdate, orders.orderdate) &&
                Objects.equals(status, orders.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, memberId, deliveryId, orderdate, status);
    }

    @OneToOne(mappedBy = "itemByOrderItemId")
    public OrderItem getOrderItemByOrderId() {
        return orderItemByOrderId;
    }

    public void setOrderItemByOrderId(OrderItem orderItemByOrderId) {
        this.orderItemByOrderId = orderItemByOrderId;
    }

    @OneToOne
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "DELIVERTY_ID", nullable = false)
    public Delivery getDeliveryByOrderId() {
        return deliveryByOrderId;
    }

    public void setDeliveryByOrderId(Delivery deliveryByOrderId) {
        this.deliveryByOrderId = deliveryByOrderId;
    }

    @OneToOne
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "MEMBER_ID", nullable = false)
    public Member getMemberByOrderId() {
        return memberByOrderId;
    }

    public void setMemberByOrderId(Member memberByOrderId) {
        this.memberByOrderId = memberByOrderId;
    }
}
