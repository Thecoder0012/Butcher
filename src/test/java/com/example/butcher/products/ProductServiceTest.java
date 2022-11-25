package com.example.butcher.products;


import com.example.butcher.product.model.Product;
import com.example.butcher.product.repository.ProductRepository;
import com.example.butcher.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@Slf4j
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
       boolean isEqualTo = productService.findAll().size() == 3; // This is what we want to test

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

    @Test
    public void updateProduct(){

        // Arrange
        Product product = new Product("Beef", 4000, 80);
        product.setId(1L);

        Product newProduct = new Product();
        newProduct.setId(product.getId());
        newProduct.setName("Beeeef");
        newProduct.setPrice(5000.0);
        newProduct.setWeight(100.0);

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.save(product)).thenReturn(product);

        // act
        Product updatedProduct = productService.update(newProduct,product.getId());

        verify(productRepository,times(1)).findById(1L);
        verify(productRepository,times(1)).save(product);
        verifyNoMoreInteractions(productRepository);

        // assert
        assertTrue(updatedProduct.getPrice() == 5000);
    }




    @Test
    public void deleteProduct(){
        // Arrange
        Product product = new Product("Beef",3000,60);
        product.setId(5L);

        // act
        productService.delete(product.getId());
        verify(productRepository).deleteById(5L);
        boolean condition = product.getId() == 5;

        // assert
        assertTrue(condition);
    }




}
