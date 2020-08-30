package com.sda.shop.controller;

import com.sda.shop.dto.CreateProductDto;
import com.sda.shop.dto.EditProductDto;
import com.sda.shop.model.Product;
import com.sda.shop.repo.InMemoryProductRepo;
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

    @GetMapping("/filter")
    public ResponseEntity<List<Product>> filterBy(@RequestParam(required = false) Integer price,
                                                  @RequestParam(required = false) Integer quantity,
                                                  @RequestParam(required = false) String name,
                                                  @RequestParam(required = false) String description,
                                                  @RequestParam(required = false) String imageUrl
    ) {
        List<Product> filtered = productRepo.filterBy(price, quantity, name, description, imageUrl);
        return ResponseEntity.ok(filtered);
    }

    @GetMapping("/filterBy")
    public ResponseEntity<List<Product>> filterByRange(@RequestParam(required = false) Integer minPrice,
                                                       @RequestParam(required = false) Integer maxPrice,
                                                       @RequestParam(required = false) Integer minQuantity,
                                                       @RequestParam(required = false) Integer maxQuantity,
                                                       @RequestParam(required = false) String name){

        List<Product> filtered = productRepo.filterByRange(minPrice, maxPrice, minQuantity, maxQuantity, name);
        return ResponseEntity.ok(filtered);
    }


}
