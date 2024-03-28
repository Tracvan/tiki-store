package com.codegym.tikistore.model;

public class Product {
    private int productId;
    private String productName;
    private double price;
    private int quantity;
    private String image;
    private String type;

    public Product(String productName,
                   double price,
                   int quantity,
                   String type,
                   String image) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.type = type;
    }

    public Product(int productId, String productName, double price, int quantity, String type, String image) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.type = type;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
