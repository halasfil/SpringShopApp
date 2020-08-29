package com.sda.shop.repo;

import com.sda.shop.dto.CreateProductDto;
import com.sda.shop.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepo {
    void addProduct(CreateProductDto createProductDto);
    Optional<Product> findProductById(Integer id);
    List<Product> findAll();
}
