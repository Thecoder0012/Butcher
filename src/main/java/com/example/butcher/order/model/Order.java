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
    private LocalDateTime pickUpTime;
    private int quantityOfProducts;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Order(String customerName, LocalDateTime pickUpTime, int quantityOfProducts, Product product) {
        this.customerName = customerName;
        this.pickUpTime = pickUpTime;
        this.quantityOfProducts = quantityOfProducts;
        this.product = product;
    }

}
