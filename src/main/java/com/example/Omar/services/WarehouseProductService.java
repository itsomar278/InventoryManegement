package com.example.Omar.services;

import com.example.Omar.model.WarehouseProduct;
import com.example.Omar.DataAccess.WarehouseProductRepository;
import com.example.Omar.utils.Exceptions.EmptyResultException;
import com.example.Omar.utils.Exceptions.ResourceExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseProductService {

    @Autowired
    private WarehouseProductRepository warehouseProductRepository;

    public List<WarehouseProduct> getAllWarehouseProducts() {
        return warehouseProductRepository.findAll();
    }

    public WarehouseProduct getWarehouseProductById(int id) {
        return warehouseProductRepository.findById(id)
                .orElseThrow(() -> new EmptyResultException("Warehouse product not found"));
    }

    public WarehouseProduct addProductToWarehouse(WarehouseProduct warehouseProduct) {
        boolean productExistsInWarehouse = warehouseProductRepository.existsByProductAndWarehouse(
                warehouseProduct.getProduct(), warehouseProduct.getWarehouse());

        if (productExistsInWarehouse) {
            throw new ResourceExistsException("Product with the same ID already exists in the warehouse");
        }
        return warehouseProductRepository.save(warehouseProduct);
    }

    public WarehouseProduct updateWarehouseProduct(int id, WarehouseProduct updatedWarehouseProduct) {
        WarehouseProduct existingWarehouseProduct = warehouseProductRepository.findById(id)
                .orElseThrow(() -> new EmptyResultException("Warehouse product not found"));

        existingWarehouseProduct.setProduct(updatedWarehouseProduct.getProduct());
        existingWarehouseProduct.setWarehouse(updatedWarehouseProduct.getWarehouse());
        existingWarehouseProduct.setQuantity(updatedWarehouseProduct.getQuantity());

        return warehouseProductRepository.save(existingWarehouseProduct);
    }

    public void deleteWarehouseProduct(int id) {
        if (!warehouseProductRepository.existsById(id)) {
            throw new EmptyResultException("Warehouse product not found");
        }
        warehouseProductRepository.deleteById(id);
    }

    public boolean hasEnoughQuantity(int warehouseProductId, int quantity) {
        WarehouseProduct warehouseProduct = warehouseProductRepository.findById(warehouseProductId)
                .orElseThrow(() -> new EmptyResultException("Warehouse product not found"));
        return warehouseProduct.getQuantity() >= quantity;
    }

    public void decreaseQuantity(int warehouseProductId, int quantity) {
        WarehouseProduct warehouseProduct = warehouseProductRepository.findById(warehouseProductId)
                .orElseThrow(() -> new EmptyResultException("Warehouse product not found"));

        int currentQuantity = warehouseProduct.getQuantity();
        if (currentQuantity >= quantity) {
            warehouseProduct.setQuantity(currentQuantity - quantity);
            warehouseProductRepository.save(warehouseProduct);
        } else {
            throw new IllegalArgumentException("Not enough quantity available in the warehouse product");
        }
    }
}
