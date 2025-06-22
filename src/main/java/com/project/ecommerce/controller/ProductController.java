package com.project.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private static final List<String> products = Arrays.asList("iPhone", "MacBook", "AirPods");

   @GetMapping
    public List<String> getAllProducts() {
        return products;
    }
    

    // GET /products/{id} - return a single product by ID
    @GetMapping("/{id}")
    public String getProductById(@PathVariable int id) {
        if (id < 0 || id >= products.size()) {
            return "Product not found";
        }
        return products.get(id);
    }

    // POST /products - create a product (mocked)
    @PostMapping
    public String createProduct(@RequestBody String productName) {
        return "Product created: " + productName;
    }

    // PUT /products/{id} - update a product (mocked)
    @PutMapping("/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody String updatedName) {
        return "Product with ID " + id + " updated to: " + updatedName;
    }

    // DELETE /products/{id} - delete a product (mocked)
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        return "Product with ID " + id + " deleted";
    }
}
