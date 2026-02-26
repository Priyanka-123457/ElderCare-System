package com.eldercare.backend.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Add a product (elderly seller)
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // View all products (buyer)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // View products by seller (elderly)
    public List<Product> getProductsBySeller(Long sellerId) {
        return productRepository.findBySellerId(sellerId);
    }

    // Calculate total income for a seller
    public double getTotalIncomeForSeller(Long sellerId) {
        List<Product> products = productRepository.findBySellerId(sellerId);

        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}