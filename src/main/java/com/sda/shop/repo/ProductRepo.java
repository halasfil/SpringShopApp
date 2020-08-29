package com.sda.shop.repo;

import com.sda.shop.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepo {
    void saveProduct();

    Optional<Product> findProductById(Integer id);

    List<Product> findAll();

    boolean deleteById(Integer id);
}
