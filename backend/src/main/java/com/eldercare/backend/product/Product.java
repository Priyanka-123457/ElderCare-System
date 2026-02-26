package com.eldercare.backend.product;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    // Elderly user who sells the product
    @Column(nullable = false)
    private Long sellerId;

    // Required by JPA
    public Product() {
    }

    public Product(String name, double price, Long sellerId) {
        this.name = name;
        this.price = price;
        this.sellerId = sellerId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
}