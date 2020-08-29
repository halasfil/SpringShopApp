package com.sda.shop.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter


public class Product {
    private Integer id;
    private Integer price;
    private Integer quantity;
    private String name;
    private String description;
    private String imageUrl;
    private LocalDateTime creationTime;


}
