package com.sda.shop.dto;

import lombok.Data;

@Data
public class CreateProductDto {
    private Integer price;
    private Integer quantity;
    private String name;
    private String description;
    private String imageUrl;
}
