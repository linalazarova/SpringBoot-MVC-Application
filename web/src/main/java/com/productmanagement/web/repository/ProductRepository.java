package com.productmanagement.web.repository;

import com.productmanagement.web.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findProductByName(String name);

    @Query("SELECT p from Product p WHERE p.name LIKE concat('%', :query,'%')")
    List<Product> searchProductsByName(String query);

}
