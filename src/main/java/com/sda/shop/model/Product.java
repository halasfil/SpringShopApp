package com.sda.shop.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Builder
@Getter
@Setter

public class Product {
    private Integer id;
    private Integer price;
    private Integer quantity;
    private String name;
    private String description;
    private String imageUrl;
    private LocalDateTime creationTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(price, product.price) &&
                Objects.equals(quantity, product.quantity) &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(imageUrl, product.imageUrl) &&
                Objects.equals(creationTime, product.creationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, quantity, name, description, imageUrl, creationTime);
    }
}
