package com.example.myapplication.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int productID;
    private String productName;
    private String productUnits;
    private String price;


    public Product(int productID, String productName, String productUnits, String price) {
        this.productID = productID;
        this.productName = productName;
        this.productUnits = productUnits;
        this.price = price;
    }
    public Product( String productName, String productUnits,String price) {
        this.productName = productName;
        this.productUnits = productUnits;
        this.price=price;
    }
    public Product(){}



    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductUnits() {
        return productUnits;
    }

    public void setProductUnits(String productUnits) {
        this.productUnits = productUnits;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
