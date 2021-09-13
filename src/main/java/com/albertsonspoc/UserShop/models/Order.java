package com.albertsonspoc.UserShop.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String orderId;

    @ManyToOne
    @JoinColumn(name = "ProductId")
    @JsonManagedReference
    private Product product;

    @ManyToOne
    @JoinColumn(name = "UserId")
    @JsonManagedReference
    private User user;

    private String address;

    private Integer quantity = 0;

    private Float pricePerUnit;

    private Date createdAt;

    private Date modifiedAt;

    private String modifiedBy;

    private String orderStatus;

    @PrePersist
    public void prePersist() {
        Date now = new Date();
        setCreatedAt(now);
        setModifiedAt(now);
        setModifiedBy(user.getUserName());
    }

    @PreUpdate
    public void preUpdate() {
        setModifiedAt(new Date());
    }

    public Order() {
    }

    public Order(Integer id, String orderId, Product product, User user, String address, Integer quantity, Float pricePerUnit, Date createdAt, Date modifiedAt, String modifiedBy, String orderStatus) {
        this.id = id;
        this.orderId = orderId;
        this.product = product;
        this.user = user;
        this.address = address;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.modifiedBy = modifiedBy;
        this.orderStatus = orderStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Float pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", product=" + product +
                ", user=" + user +
                ", address='" + address + '\'' +
                ", quantity=" + quantity +
                ", pricePerUnit=" + pricePerUnit +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
