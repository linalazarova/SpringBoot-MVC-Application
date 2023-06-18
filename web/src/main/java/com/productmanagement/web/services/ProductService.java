package com.productmanagement.web.services;

import com.productmanagement.web.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    List<Product> searchProducts(String query);
    Product saveProduct(Product product);
    Product findProductById(long id);
    void updateProduct(Product product);
    void deleteProduct(Long id);
}
