package com.example.Omar.services;

import com.example.Omar.model.Warehouse;
import com.example.Omar.DataAccess.WarehouseRepository;
import com.example.Omar.utils.Exceptions.EmptyResultException;
import com.example.Omar.utils.Exceptions.ResourceExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    public Warehouse getWarehouseById(int id) {
        return warehouseRepository.findById(id)
                .orElseThrow(() -> new EmptyResultException("Warehouse not found"));
    }

    public Warehouse createWarehouse(String name, String location, int capacity) {
        if (warehouseRepository.existsByName(name)) {
            throw new ResourceExistsException("Warehouse with the same name already exists");
        }

        Warehouse newWarehouse = new Warehouse();
        newWarehouse.setName(name);
        newWarehouse.setLocation(location);
        newWarehouse.setCapacity(capacity);
        return warehouseRepository.save(newWarehouse);
    }

    public Warehouse updateWarehouse(int id, String name, String location, int capacity) {
        Warehouse existingWarehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new EmptyResultException("Warehouse not found"));

        if (!existingWarehouse.getName().equals(name) && warehouseRepository.existsByName(name)) {
            throw new ResourceExistsException("Another warehouse with the same name already exists");
        }

        existingWarehouse.setName(name);
        existingWarehouse.setLocation(location);
        existingWarehouse.setCapacity(capacity);
        return warehouseRepository.save(existingWarehouse);
    }

    public void deleteWarehouse(int id) {
        if (!warehouseRepository.existsById(id)) {
            throw new EmptyResultException("Warehouse not found");
        }
        warehouseRepository.deleteById(id);
    }
}
