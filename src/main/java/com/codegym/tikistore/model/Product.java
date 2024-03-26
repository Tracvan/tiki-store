package com.codegym.tikistore.model;

public class Product {
    private String productName;
    private double price;
    private int quantity;
    private String image;
    private String type;

    public Product(String productName,
                   double price,
                   int quantity,
                   String image,
                   String type) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.type = type;
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
