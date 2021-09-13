package com.albertsonspoc.UserShop.dto;

public class CartDto {

    private int id;
    private int productId;
    private String userName;
    private int quantity;
    private float price;
    private String productName;
    private String productImage;

    public CartDto() {
    }

    public CartDto(int id, int productId, String userName, int quantity, float price, String productName, String productImage) {
        this.id = id;
        this.productId = productId;
        this.userName = userName;
        this.quantity = quantity;
        this.price = price;
        this.productName = productName;
        this.productImage = productImage;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
}
