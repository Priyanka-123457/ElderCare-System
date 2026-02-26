package com.eldercare.backend.product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Add product (elderly seller)
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // View all products (buyer)
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // View products by seller (elderly)
    @GetMapping("/seller/{sellerId}")
    public List<Product> getProductsBySeller(@PathVariable Long sellerId) {
        return productService.getProductsBySeller(sellerId);
    }

    // Get total income for a seller
    @GetMapping("/seller/{sellerId}/income")
    public double getIncomeForSeller(@PathVariable Long sellerId) {
        return productService.getTotalIncomeForSeller(sellerId);
    }
}