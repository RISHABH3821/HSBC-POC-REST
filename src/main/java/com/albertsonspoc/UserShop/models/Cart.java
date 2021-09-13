package com.albertsonspoc.UserShop.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ProductId")
    @JsonManagedReference
    private Product product;

    @ManyToOne
    @JoinColumn(name = "UserId")
    @JsonManagedReference
    private User user;

    private Integer quantity = 0;

    private Float pricePerUnit;

    private Date createdAt;

    private Date modifiedAt;

    private Boolean orderPlaced;

    public Cart() {
    }

    public Cart(Integer id, Product product, User user, Integer quantity, Float pricePerUnit, Date createdAt, Date modifiedAt, Boolean orderPlaced) {
        this.id = id;
        this.product = product;
        this.user = user;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.orderPlaced = orderPlaced;
    }

    @PrePersist
    public void prePersist() {
        Date now = new Date();
        setCreatedAt(now);
        setModifiedAt(now);
    }

    @PreUpdate
    public void preUpdate() {
        setModifiedAt(new Date());
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

    public Boolean getOrderPlaced() {
        return orderPlaced;
    }

    public void setOrderPlaced(Boolean orderPlaced) {
        this.orderPlaced = orderPlaced;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", product=" + product +
                ", user=" + user +
                ", quantity=" + quantity +
                ", pricePerUnit=" + pricePerUnit +
                ", createdAt='" + createdAt + '\'' +
                ", modifiedAt='" + modifiedAt + '\'' +
                ", orderPlaced=" + orderPlaced +
                '}';
    }
}
