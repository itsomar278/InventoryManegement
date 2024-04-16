package com.example.Omar.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "OrderWarehouseProduct")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderWarehouseProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderWarehouseProductID")
    private int orderWarehouseProductId;

    @ManyToOne
    @JoinColumn(name = "OrderID")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WarehouseProductID")
    private WarehouseProduct warehouseProduct;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "Price")
    private double price;

}
