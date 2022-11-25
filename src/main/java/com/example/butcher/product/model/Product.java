package com.example.butcher.product.model;

import com.example.butcher.order.model.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Double weight;

    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
    @JsonIgnore
    Order order;

    public Product(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }
}
