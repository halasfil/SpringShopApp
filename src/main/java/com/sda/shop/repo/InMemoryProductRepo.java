package com.sda.shop.repo;

import com.sda.shop.dto.CreateProductDto;
import com.sda.shop.model.Product;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class InMemoryProductRepo implements ProductRepo {

    private static List<Product> productList;

    private static AtomicInteger idCounter;

    public InMemoryProductRepo() {
        productList = new ArrayList<>();
        idCounter = new AtomicInteger(1);
    }

    @Override
    public void addProduct(CreateProductDto createProductDto) {
        Product product = Product.builder()
                .id(idCounter.getAndIncrement())
                .price(createProductDto.getPrice())
                .quantity(createProductDto.getQuantity())
                .name(createProductDto.getName())
                .description(createProductDto.getDescription())
                .imageUrl(createProductDto.getImageUrl())
                .creationTime(LocalDateTime.now())
                .build();
        productList.add(product);
    }



    @Override
    public Optional<Product> findProductById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }


}
