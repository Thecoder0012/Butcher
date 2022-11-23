package com.example.butcher.product;

import com.example.butcher.order.Order;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private double weight;
    @OneToOne
    Order order;

    public Product(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;

    }
}
