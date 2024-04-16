package com.example.Omar.controllers;

import com.example.Omar.model.Order;
import com.example.Omar.services.OrderService;
import com.example.Omar.utils.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") int id) {
        Order order = orderService.getOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Order> addOrder(@RequestBody OrderRequest orderRequest) {
        Order savedOrder = orderService.addOrder(orderRequest.getOrder(), orderRequest.getOrderWarehouseProducts());
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }
}
