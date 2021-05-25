package com.example.MidtermJavaFramework.service;

import com.example.MidtermJavaFramework.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProduct();
    void addProduct(Product product);
    void updateProduct(Long id, Product product);

}
