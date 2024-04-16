package com.example.Omar.DataAccess;

import com.example.Omar.model.Product;
import com.example.Omar.model.Warehouse;
import com.example.Omar.model.WarehouseProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseProductRepository extends JpaRepository<WarehouseProduct, Integer> {
    boolean existsByProductAndWarehouse(Product product, Warehouse warehouse);
}
