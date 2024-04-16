package com.example.Omar.services;

import com.example.Omar.model.Order;
import com.example.Omar.model.OrderWarehouseProduct;
import com.example.Omar.DataAccess.OrderRepository;
import com.example.Omar.DataAccess.OrderWarehouseProductRepository;
import com.example.Omar.utils.Exceptions.EmptyResultException;
import com.example.Omar.utils.Exceptions.ResourceExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderWarehouseProductRepository orderWarehouseProductRepository;

    @Autowired
    private WarehouseProductService warehouseProductService;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(int id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new EmptyResultException("Order not found"));
    }

    public Order addOrder(Order order, List<OrderWarehouseProduct> orderWarehouseProducts) {

        for (OrderWarehouseProduct owp : orderWarehouseProducts) {
            if (!warehouseProductService.hasEnoughQuantity(owp.getWarehouseProduct().getWarehouseProductId(), owp.getQuantity())) {
                throw new ResourceExistsException("Not enough quantity of warehouse product with ID: " + owp.getWarehouseProduct().getWarehouseProductId());
            }
        }

        double totalAmount = orderWarehouseProducts.stream()
                .mapToDouble(owp -> owp.getPrice() * owp.getQuantity())
                .sum();
        order.setTotalAmount(totalAmount);

        Order savedOrder = orderRepository.save(order);

        for (OrderWarehouseProduct owp : orderWarehouseProducts) {
            warehouseProductService.decreaseQuantity(owp.getWarehouseProduct().getWarehouseProductId(), owp.getQuantity());
            owp.setOrder(savedOrder);
            orderWarehouseProductRepository.save(owp);
        }

        return savedOrder;
    }
}
