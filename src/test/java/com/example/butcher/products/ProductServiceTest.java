package com.example.butcher.products;


import com.example.butcher.product.Product;
import com.example.butcher.product.repository.ProductRepository;
import com.example.butcher.product.service.ProductService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {


    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;


    @Test
    public void fetchAllProductsTest(){

        // arrange, (all requirements such as lists, variables etc).
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Beef",5000,100));
        productList.add(new Product("Calf",20000,100));
        productList.add(new Product("Chicken",7000,100));
        when(productRepository.findAll()).thenReturn(productList);

       // act (operation gets executed)
       boolean isEqualTo = productService.fetchAll().size() == 3; // This is what we want to test

        // we are asserting that this is true, if our result is what we expected it to be.
       assertTrue(isEqualTo);
    }

    @Test
    public void saveProduct(){

        // arrange
        Product product = new Product("Beef",5000,100);
        when(productRepository.save(product)).thenReturn(product);

        // act
        Product productTest = productService.save(product);

        // assert (is the actual product the one we instantiated in the beginning)
        assertEquals(product,productTest);
    }




}
