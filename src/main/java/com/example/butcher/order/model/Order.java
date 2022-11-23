package com.example.butcher.order.model;

import com.example.butcher.product.model.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Order {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long id;
    private String customerName;
    private LocalDateTime localDateTime;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Order(String customerName, LocalDateTime localDateTime, Product product) {
        this.customerName = customerName;
        this.localDateTime = localDateTime;
        this.product = product;
    }

}