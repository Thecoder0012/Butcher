package com.example.butcher.product.service;

import com.example.butcher.product.model.Product;
import com.example.butcher.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {


    private final ProductRepository productRepository;


    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public Product delete(Long id){
        productRepository.deleteById(id);
        return null;
    }

    public Product update(Product product,Long id){
        Product existingProduct = productRepository.findById(id).orElse(null);
        existingProduct.setId(product.getId());
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setWeight(product.getWeight());
        return productRepository.save(existingProduct);
    }

}
