package com.sda.shop.repo;

import com.sda.shop.dto.CreateProductDto;
import com.sda.shop.dto.EditProductDto;
import com.sda.shop.model.Product;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public boolean deleteById(Integer id) {
        return productList.removeIf(product -> id.equals(product.getId()));
    }

    @Override
    public Product editProduct(Integer id, EditProductDto editProductDto) {
        Optional<Product> productOptional = productList
                .stream()
                .filter(product1 -> product1.getId().equals(id))
                .findFirst();

        if (productOptional.isEmpty()) {
            return null;
        }

        Integer oldPrice = productOptional.get().getPrice();
        Integer oldQuantity = productOptional.get().getQuantity();
        String oldImageUrl = productOptional.get().getImageUrl();
        String oldDescription = productOptional.get().getDescription();

        if (editProductDto.getPrice() != null) {
            oldPrice = editProductDto.getPrice();
        }

        if (editProductDto.getQuantity() != null) {
            oldQuantity = editProductDto.getQuantity();
        }
        if (editProductDto.getImageUrl() != null) {
            oldImageUrl = editProductDto.getImageUrl();
        }
        if (editProductDto.getDescription() != null) {
            oldDescription = editProductDto.getDescription();
        }
        Product productNew = Product.builder()
                .id(id)
                .price(oldPrice)
                .quantity(oldQuantity)
                .imageUrl(oldImageUrl)
                .description(oldDescription)
                .build();

        int index = productList.indexOf(productOptional.get());
        productList.set(index, productNew);
        return productNew;
    }

    @Override
    public List<Product> filterBy(Integer price, Integer quantity, String name, String description, String imageUrl) {
        Stream<Product> productStream = productList.stream();

        if (price != null) {
            productStream = productStream.filter(p -> p.getPrice().equals(price));
        }
        if (quantity != null) {
            productStream = productStream.filter(p -> p.getQuantity().equals(quantity));
        }
        if (name != null) {
            productStream = productStream.filter(p -> p.getName().equals(name));
        }
        if (description != null) {
            productStream = productStream.filter(p -> p.getDescription().equals(description));
        }
        if (imageUrl != null) {
            productStream = productStream.filter(p -> p.getImageUrl().equals(imageUrl));
        }
        return productStream.collect(Collectors.toList());
    }

    @Override
    public List<Product> filterByRange(Integer minPrice, Integer maxPrice, Integer minQuantity, Integer maxQuantity, String name) {
        Stream<Product> productStream = productList.stream();
        if (minPrice != null) {
            productStream = productStream.filter(p -> p.getPrice() >= minPrice);
        }
        if (maxPrice != null) {
            productStream = productStream.filter(p -> p.getPrice() <= maxPrice);
        }
        if (minQuantity != null) {
            productStream = productStream.filter(p -> p.getPrice() >= minQuantity);
        }
        if (maxQuantity != null) {
            productStream = productStream.filter(p -> p.getPrice() <= maxQuantity);
        }
        if (name != null) {
            productStream = productStream.filter(p -> p.getName().equals(name));
        }

        return productStream.collect(Collectors.toList());
    }

}
