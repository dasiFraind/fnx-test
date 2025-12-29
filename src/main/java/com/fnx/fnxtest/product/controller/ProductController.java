package com.fnx.fnxtest.product.controller;

import com.fnx.fnxtest.product.dto.Product;
import com.fnx.fnxtest.product.service.ProductService;
import com.fnx.fnxtest.user.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getProductsByUserId")
    public ResponseEntity<List<Product>> getProductsByUserId(@RequestParam String userId) {
        return new ResponseEntity<List<Product>>(productService.findByUserId(userId), HttpStatus.OK);

    }

    @PostMapping("/addProductToUser")
    public void addProductToUser(@RequestParam String userId,
                                 @RequestParam String productId) {
        productService.addProductToUser(userId, productId);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.OK);
    }

    @PostMapping("/removeProduct")
    public void removeProduct(@RequestBody Product product) {
        productService.removeProduct(product);
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return new ResponseEntity<Product>(productService.updateProduct(product), HttpStatus.OK);
    }

    @GetMapping("/getProductById")
    public ResponseEntity<Product> getProductById(@RequestParam String id) {
        return new ResponseEntity<Product>(productService.findProductById(id), HttpStatus.OK);
    }
}

