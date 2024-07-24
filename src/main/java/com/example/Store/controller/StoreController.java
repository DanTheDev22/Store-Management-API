package com.example.Store.controller;

import com.example.Store.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Store.repository.StoreRepo;

import java.util.List;
import java.util.Optional;

@RestController
public class StoreController {

    @Autowired
    private StoreRepo repo;

    public StoreController(StoreRepo  repo) {
        this.repo = repo;
    }

    @GetMapping("/{id}")
    public Optional<Product> getById (@PathVariable Long id) {
        return repo.findById(id);
    }

    @GetMapping("/get")
    public List<Product> getAll() {
        return repo.findAll();
    }

    @PostMapping("/save")
    public void add (@RequestBody Product product) {
        repo.save(product);
        System.out.println("Saved...");
    }

    @PutMapping("/update/{id}")
    public Product updateInfo (@PathVariable Long id, @RequestBody Product updatedProduct) {
        Optional<Product> optionalProduct = repo.findById(id);

        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setBrand(updatedProduct.getBrand());
            existingProduct.setCategory(updatedProduct.getCategory());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setQuantity(updatedProduct.getQuantity());
            existingProduct.setCreated_at(updatedProduct.getCreated_at());
            return repo.save(existingProduct);
        } else {
            updatedProduct.setId(id);
          return   repo.save(updatedProduct);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById (@PathVariable Long id) {
        if (getById(id).isPresent()) {
            repo.deleteById(id);
            System.out.println("Deleting...");
        }
    }




}

