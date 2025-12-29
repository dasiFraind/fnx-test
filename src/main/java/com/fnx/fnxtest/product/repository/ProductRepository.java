package com.fnx.fnxtest.product.repository;

import com.fnx.fnxtest.product.dto.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findByUserId(String userId);
    void addProductToUser(String userId, String productId);
    Product addProduct(Product product);
    void removeProduct(Product product);
    Product updateProduct(Product product);
    Product findProductById(String id);
}
