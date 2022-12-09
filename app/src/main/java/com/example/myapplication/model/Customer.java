package com.example.myapplication.model;

import java.io.Serializable;

public class Customer implements Serializable {
    private int customerId;
    private String customerName;
    private String customerPhone;
    private String customerAge;

    public Customer(int customerId, String customerName, String customerPhone, String customerAge) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerAge = customerAge;
    }
    public Customer() {
        this.customerId = 0;
        this.customerName = "";
        this.customerPhone = "";
        this.customerAge = "";
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(String customerAge) {
        this.customerAge = customerAge;
    }
}
