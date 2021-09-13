package com.albertsonspoc.UserShop.dto;

public class ProductDetailDto {
    private int id;
    private String productName;
    private String description;
    private Float price;
    private String imageUrl;
    private Float originalPrice;

    public ProductDetailDto() {
    }

    public ProductDetailDto(int id, String productName, String description, Float price, String imageUrl, Float originalPrice) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.originalPrice = originalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Float getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Float originalPrice) {
        this.originalPrice = originalPrice;
    }
}
