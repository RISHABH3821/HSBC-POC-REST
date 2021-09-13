package com.albertsonspoc.UserShop.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Lob
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;

    private String ImageUrl;

    private String createdBy;

    private String modifiedBy;

    private Date createdAt;

    private Date modifiedAt;

    private Integer stock;

    private Integer originalStock;

    private Float pricePerUnit;

    private Float originalPricePerUnit;

    public Product() {
    }

    public Product(Integer id, String name, String description, String imageUrl, String createdBy, String modifiedBy, Date createdAt, Date modifiedAt, Integer stock, Integer originalStock, Float pricePerUnit, Float originalPricePerUnit) {
        this.id = id;
        this.name = name;
        this.description = description;
        ImageUrl = imageUrl;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.stock = stock;
        this.originalStock = originalStock;
        this.pricePerUnit = pricePerUnit;
        this.originalPricePerUnit = originalPricePerUnit;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }

    public Float getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Float pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Float getOriginalPricePerUnit() {
        return originalPricePerUnit;
    }

    public void setOriginalPricePerUnit(Float originalPricePerUnit) {
        this.originalPricePerUnit = originalPricePerUnit;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ImageUrl='" + ImageUrl + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", stock=" + stock +
                ", originalStock=" + originalStock +
                ", pricePerUnit=" + pricePerUnit +
                ", originalPricePerUnit=" + originalPricePerUnit +
                '}';
    }
}
