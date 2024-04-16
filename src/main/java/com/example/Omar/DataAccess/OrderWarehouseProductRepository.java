package com.example.Omar.DataAccess;

import com.example.Omar.model.OrderWarehouseProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderWarehouseProductRepository extends JpaRepository<OrderWarehouseProduct, Integer> {
}
