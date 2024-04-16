package com.example.Omar.services;

import com.example.Omar.model.Product;
import com.example.Omar.DataAccess.ProductRepository;
import com.example.Omar.utils.Exceptions.EmptyResultException;
import com.example.Omar.utils.Exceptions.ResourceExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EmptyResultException("Product not found"));
    }

    public Product createProduct(String name, String category, double price, int supplierId) {
        if (productRepository.existsByName(name)) {
            throw new ResourceExistsException("Product with the same name already exists");
        }
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setCategory(category);
        newProduct.setPrice(price);
        newProduct.setSupplierId(supplierId);
        return productRepository.save(newProduct);
    }

    public Product updateProduct(int id, String name, String category, double price, int supplierId) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new EmptyResultException("Product not found"));

        if (!existingProduct.getName().equals(name) && productRepository.existsByName(name)) {
            throw new ResourceExistsException("Another product with the same name already exists");
        }
        existingProduct.setName(name);
        existingProduct.setCategory(category);
        existingProduct.setPrice(price);
        existingProduct.setSupplierId(supplierId);
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(int id) {
        if (!productRepository.existsById(id)) {
            throw new EmptyResultException("Product not found");
        }
        productRepository.deleteById(id);
    }
}
