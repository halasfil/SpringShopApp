package com.sda.shop.controller;

import com.sda.shop.dto.CreateProductDto;
import com.sda.shop.model.Product;
import com.sda.shop.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class Controller {

    private ProductRepo productRepo;

    @Autowired
    public Controller(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateProductDto createProductDto){
        productRepo.addProduct(createProductDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List> findAll() {
        List<Product> products = productRepo.findAll();
        return ResponseEntity.ok(products);
    }




}
