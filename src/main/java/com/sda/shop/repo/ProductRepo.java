package com.sda.shop.repo;

import com.sda.shop.dto.CreateProductDto;
import com.sda.shop.dto.EditProductDto;
import com.sda.shop.model.Product;

import java.util.List;

public interface ProductRepo {
    void addProduct(CreateProductDto createProductDto);
    List<Product> findAll();
    boolean deleteById(Integer id);
    Product editProduct(Integer id, EditProductDto editProductDto);

}
