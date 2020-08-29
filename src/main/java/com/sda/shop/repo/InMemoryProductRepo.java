package com.sda.shop.repo;

import com.sda.shop.dto.CreateProductDto;
import com.sda.shop.model.Product;

import java.util.List;
import java.util.Optional;

public class InMemoryProductRepo implements ProductRepo {


    @Override
    public void saveProduct() {
        Product product = Product.builder()
                .name(CreateProductDto.)

    }

    @Override
    public Optional<Product> findProductById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}
