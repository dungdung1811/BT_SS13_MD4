package com.ra.model.entity;

public class Product {
    private Integer id;
    private String productName;
    private Double price;
    private  Category category;
    private String image;

    public Product() {

    }

    public Product(Integer id, String productName, Double price, Category category, String image) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
