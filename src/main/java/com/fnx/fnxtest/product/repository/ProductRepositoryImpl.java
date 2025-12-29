package com.fnx.fnxtest.product.repository;

import com.fnx.fnxtest.product.dto.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final Map<String, Product> products = new HashMap<>();

    private final Map<String, List<String>> productsByUsers = new HashMap<>();

    public ProductRepositoryImpl() {

        products.put("p1", new Product("p1", "bed", 1000.0));
        products.put("p2", new Product("p2", "table", 2000.0));
        products.put("p3", new Product("p3", "chair", 500.0));

        productsByUsers.put("user1", new ArrayList<>(List.of("p1")));
        productsByUsers.put("user2", new ArrayList<>(List.of("p2")));
        productsByUsers.put("user3", new ArrayList<>(List.of("p2", "p3")));
    }

    @Override
    public List<Product> findByUserId(String userId) {
        return productsByUsers
                .getOrDefault(userId, List.of())
                .stream()
                .map(products::get)
                .filter(Objects::nonNull)
                .toList();
    }

    @Override
    public void addProductToUser(String userId, String productId) {
        productsByUsers
                .computeIfAbsent(userId, id -> new ArrayList<>())
                .add(productId);
    }

    @Override
    public Product addProduct(Product product) {
        products.put(product.getId(), product);
        return product;
    }

    @Override
    public void removeProduct(Product product) {
        String productId = product.getId();
        products.remove(productId);

        productsByUsers
                .values()
                .forEach(ids -> ids.remove(productId));
    }

    @Override
    public Product updateProduct(Product product) {

        products.put(product.getId(), product);
        return product;
    }

    @Override
    public Product findProductById(String id) {
        return products.get(id);
    }

}

