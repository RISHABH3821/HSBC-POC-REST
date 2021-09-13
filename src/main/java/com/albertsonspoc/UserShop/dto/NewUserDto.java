package com.albertsonspoc.UserShop.dto;

public class NewUserDto {

    private String fullName, userName, address, email, phone, password;

    public NewUserDto(String fullName, String userName, String address, String email, String phone, String password) {
        this.fullName = fullName;
        this.userName = userName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public NewUserDto() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "NewUserDto{" +
                "fullName='" + fullName + '\'' +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
