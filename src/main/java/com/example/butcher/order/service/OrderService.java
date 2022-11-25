package com.example.butcher.order.service;

import com.example.butcher.order.model.Order;
import com.example.butcher.order.repository.OrderRepository;
import com.example.butcher.product.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order save(Order order){
        return orderRepository.save(order);

    }

    public Order delete(Long id){
        orderRepository.deleteById(id);
        return null;
    }

    public Order update(Order order, Long id){
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Order not found: " + id));
        existingOrder.setCustomerName(order.getCustomerName());
        existingOrder.setQuantityOfProducts(order.getQuantityOfProducts());
        existingOrder.setProduct(order.getProduct());
        existingOrder.setPickUpTime(order.getPickUpTime());
        return orderRepository.save(existingOrder);
    }



}
