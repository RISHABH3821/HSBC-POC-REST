package com.albertsonspoc.UserShop.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullName;

    private String userName;

    private String email;

    private String phone;

    private String password;

    private String address;

    private Date createdAt;

    private Date modifiedAt;

    private Date lastLoginAt;

    @PrePersist
    public void prePersist() {
        Date now = new Date();
        setCreatedAt(now);
        setModifiedAt(now);
        setLastLoginAt(now);
    }

    @PreUpdate
    public void preUpdate() {
        setModifiedAt(new Date());
    }

    public User() {
    }

    public User(Integer id, String fullName, String userName, String email, String phone, String password, String address, Date createdAt, Date modifiedAt, Date lastLoginAt) {
        this.id = id;
        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.address = address;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.lastLoginAt = lastLoginAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Date getLastLoginAt() {
        return lastLoginAt;
    }

    public void setLastLoginAt(Date lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }
}
