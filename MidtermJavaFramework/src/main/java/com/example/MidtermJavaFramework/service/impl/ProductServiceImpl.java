package com.example.MidtermJavaFramework.service.impl;

import com.example.MidtermJavaFramework.entity.Product;
import com.example.MidtermJavaFramework.repository.ProductRepository;
import com.example.MidtermJavaFramework.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.saveAndFlush(product);
    }

    @Override
    public void updateProduct(Long id, Product product) {
        Product userDb =productRepository.findById(id).orElse(null);

        if (userDb != null) {
            userDb.setName(product.getName());
            userDb.setCart(product.getCart()); // plaintext password

            productRepository.saveAndFlush(userDb);
        }
    }
}
