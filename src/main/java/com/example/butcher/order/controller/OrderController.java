package com.example.butcher.order.controller;
import com.example.butcher.order.model.Order;
import com.example.butcher.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@CrossOrigin
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    private List<Order> findAll() {
        return orderService.findAll();
    }

    @PostMapping
    public Order save(@RequestBody Order order){
        return orderService.save(order);
    }

    @DeleteMapping("/{id}")
    public Order delete(@PathVariable Long id) {
        return orderService.delete(id);
    }


    @PatchMapping("/{id}")
    public Order update(@RequestBody Order order, @PathVariable Long id) {
        return orderService.update(order, id);
    }
}



