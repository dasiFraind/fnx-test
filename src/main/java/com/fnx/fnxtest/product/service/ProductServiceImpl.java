package com.fnx.fnxtest.product.service;

import com.fnx.fnxtest.exception.AppException;
import com.fnx.fnxtest.exception.enums.ErrorCode;
import com.fnx.fnxtest.product.dto.Product;
import com.fnx.fnxtest.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findByUserId(String userId) {
        List<Product> productsByUser = productRepository.findByUserId(userId);
        if(!productsByUser.isEmpty()){
            return productsByUser;
        }
        throw new AppException(ErrorCode.PRODUCT_NOT_FOUND);
    }

    @Override
    public void addProductToUser(String userId, String productId) {

        Boolean isProductByUserExist = productRepository.findByUserId(userId).contains(productId);
        if(isProductByUserExist){
            throw new AppException(ErrorCode.PRODUCT_ALREADY_EXISTS);
        }
        productRepository.addProductToUser(userId, productId);
    }

    @Override
    public Product addProduct(Product product) {
        Product productExist = productRepository.findProductById(product.getId());
        if(productExist != null){
            throw new AppException(ErrorCode.PRODUCT_ALREADY_EXISTS);
        }
        productRepository.addProduct(product);
        return product;
    }

    @Override
    public void removeProduct(Product product) {
        productRepository.removeProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {
        productRepository.updateProduct(product);
        return product;
    }

    @Override
    public Product findProductById(String id){
        Product product = productRepository.findProductById(id);
        if(product != null){
            return product;
        }
        throw new AppException(ErrorCode.PRODUCT_NOT_FOUND);
    }
}
