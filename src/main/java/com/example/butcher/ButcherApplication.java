package com.example.butcher;

import com.example.butcher.order.model.Order;
import com.example.butcher.order.repository.OrderRepository;
import com.example.butcher.product.model.Product;
import com.example.butcher.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class ButcherApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ButcherApplication.class, args);
    }

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Beef",100,200));
        productList.add(new Product("Calf",150,250));
        productList.add(new Product("Chicken",130,150));
        productRepository.saveAll(productList);

        List<Order> ordersList = new ArrayList<>();
        ordersList.add(new Order("Mo", LocalDateTime.now(), productList.get(0)));
        ordersList.add(new Order("Jasper", LocalDateTime.now(), productList.get(1)));
        ordersList.add(new Order("Christian", LocalDateTime.now(), productList.get(2)));
        orderRepository.saveAll(ordersList);

    }
}
