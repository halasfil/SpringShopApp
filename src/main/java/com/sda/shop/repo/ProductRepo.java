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

    List<Product> filterBy(Integer price, Integer quantity, String name, String description, String imageUrl);

    List<Product> filterByRange(Integer minPrice, Integer maxPrice, Integer minQuantity, Integer maxQuantity, String name);


}
