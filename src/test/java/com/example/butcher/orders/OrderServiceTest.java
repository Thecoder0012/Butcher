package com.example.butcher.orders;

import com.example.butcher.order.model.Order;
import com.example.butcher.order.repository.OrderRepository;
import com.example.butcher.order.service.OrderService;
import com.example.butcher.product.model.Product;
import com.example.butcher.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void findAllOrdersTest(){
        List<Order> orderList = new ArrayList<>();

        orderList.add(new Order("Mo", LocalDateTime.now(), new Product("Beef",5000,100)));
        orderList.add(new Order("Yo", LocalDateTime.now(), new Product("Chicken",1000,300)));

        when(orderRepository.findAll()).thenReturn(orderList);

        boolean isEqualTo = orderService.findAll().size() == 2;
        assertTrue(isEqualTo);


    }
    @Test
    public void saveOrder () {
        Order order = new Order("Mo", LocalDateTime.now(), new Product("Beef",5000,100));
        when(orderRepository.save(order)).thenReturn(order);

        Order orderTest = orderService.save(order);

        assertEquals(order,orderTest);


    }

    @Test
    public void updateOrder (){
        Order existingorder = new Order("Mo", LocalDateTime.now(), new Product("Beef",5000,100));
        Order neweorder = new Order("yo", LocalDateTime.now(), new Product("lam",400,300));

        List<Order> orders = orderService.findAll();
        existingorder.setId(1L);

        orders.add(existingorder);

       // when(orderService.update(orders.get(0).getId())).thenReturn(neweorder);

        //assertEquals("yo", neweorder.getCustomerName());

        //assertFalse(orders.size()==0);





    }

}
