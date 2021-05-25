package com.example.MidtermJavaFramework.controller;

import com.example.MidtermJavaFramework.entity.Account;
import com.example.MidtermJavaFramework.entity.Product;
import com.example.MidtermJavaFramework.repository.ProductRepository;
import com.example.MidtermJavaFramework.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello everyone!";
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<?> getAllProducts(){
        List<Product> products = productService.getAllProduct();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    /*
    @GetMapping("")
    public List<Product> getAllAccounts() {
        return productRepository.findAll();
    }
*/
    @GetMapping("/create")
    public void createProductByName(String name){
        Product product = new Product();
        product.setName(name);
        productService.addProduct(product);
    }
    @PostMapping(value = "/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        System.out.println("ProductController.addProduct");
        System.out.println("product = " + product);

        productService.addProduct(product);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productRepository.findById(id).get();
    }

    @PutMapping("/{id}")
    public void updateAccount(@PathVariable Long id,
                              @RequestBody Product product) {

        System.out.println("ProductController.updateProduct");
        System.out.println("id = " + id);
        productService.updateProduct(id, product);
    }
    @PatchMapping("/{id}")
    public Product updateProductCount(@PathVariable Long id,
                                    @RequestParam Integer count) {
        Product product = productRepository.findById(id).get();
        product.setCount(count);
        return productRepository.saveAndFlush(product);
    }
    @DeleteMapping("/{id}")
    void deleteCart(@PathVariable Long id){
        productRepository.deleteById(id);
    }
}
