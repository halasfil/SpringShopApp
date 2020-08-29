package com.sda.shop.controller;

import com.sda.shop.dto.CreateProductDto;
import com.sda.shop.dto.EditProductDto;
import com.sda.shop.model.Product;
import com.sda.shop.repo.InMemoryProductRepo;
import com.sda.shop.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class Controller {

    @Autowired
    private InMemoryProductRepo productRepo;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateProductDto createProductDto) {
        productRepo.addProduct(createProductDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List> findAll() {
        List<Product> products = productRepo.findAll();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteById(@RequestParam Integer id) {
        return productRepo.deleteById(id) ? ResponseEntity.ok(HttpStatus.ACCEPTED) : ResponseEntity.ok(HttpStatus.CONFLICT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> edit(@PathVariable Integer id, @RequestBody EditProductDto editProductDto) {

        return ResponseEntity.ok(productRepo.editProduct(id, editProductDto));
    }

}
