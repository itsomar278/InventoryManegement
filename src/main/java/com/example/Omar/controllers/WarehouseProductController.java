package com.example.Omar.controllers;

import com.example.Omar.model.WarehouseProduct;
import com.example.Omar.services.WarehouseProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse-products")
public class WarehouseProductController {

    @Autowired
    private WarehouseProductService warehouseProductService;

    @GetMapping
    public ResponseEntity<List<WarehouseProduct>> getAllWarehouseProducts() {
        List<WarehouseProduct> warehouseProducts = warehouseProductService.getAllWarehouseProducts();
        return new ResponseEntity<>(warehouseProducts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WarehouseProduct> getWarehouseProductById(@PathVariable int id) {
        WarehouseProduct warehouseProduct = warehouseProductService.getWarehouseProductById(id);
        return new ResponseEntity<>(warehouseProduct, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WarehouseProduct> addProductToWarehouse(@RequestBody WarehouseProduct warehouseProduct) {
        WarehouseProduct newWarehouseProduct = warehouseProductService.addProductToWarehouse(warehouseProduct);
        return new ResponseEntity<>(newWarehouseProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WarehouseProduct> updateWarehouseProduct(
            @PathVariable int id, @RequestBody WarehouseProduct updatedWarehouseProduct) {
        WarehouseProduct updatedProduct = warehouseProductService.updateWarehouseProduct(id, updatedWarehouseProduct);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarehouseProduct(@PathVariable int id) {
        warehouseProductService.deleteWarehouseProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
