package com.sda.shop.dto;

import lombok.Data;

@Data
public class EditProductDto {
    private Integer price;
    private Integer quantity;
    private String description;
    private String imageUrl;
}
