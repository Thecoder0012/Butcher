package com.example.butcher.product.controller;

import com.example.butcher.product.model.Product;
import com.example.butcher.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    private List<Product> findAll() {
        return productService.findAll();
    }

    @PostMapping
    public Product save(@RequestBody Product product ){
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public Product delete(@PathVariable Long id) {
        return productService.delete(id);
    }

    @PatchMapping("/{id}")
    public Product update(@RequestBody Product product, @PathVariable Long id) {
        return productService.update(product, id);
    }
}
