package com.albertsonspoc.UserShop.dto;

import java.util.Date;

public class OrderTileDto {

    private String orderId;
    private String productName;
    private int productId;
    private String productImage;
    private int quantity;
    private float total;
    private float price;
    private String status;
    private Date lastUpdatedAt;
    private String address;

    public OrderTileDto() {
    }

    public OrderTileDto(String orderId, String productName, int productId, String productImage,
                        int quantity, float total, float price, String status, Date lastUpdatedAt, String address) {
        this.orderId = orderId;
        this.productName = productName;
        this.productId = productId;
        this.productImage = productImage;
        this.quantity = quantity;
        this.total = total;
        this.price = price;
        this.status = status;
        this.lastUpdatedAt = lastUpdatedAt;
        this.address = address;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Date lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "OrderTileDto{" +
                "orderId='" + orderId + '\'' +
                ", productName='" + productName + '\'' +
                ", productId=" + productId +
                ", productImage='" + productImage + '\'' +
                ", quantity=" + quantity +
                ", total=" + total +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", lastUpdatedAt=" + lastUpdatedAt +
                ", address='" + address + '\'' +
                '}';
    }
}
