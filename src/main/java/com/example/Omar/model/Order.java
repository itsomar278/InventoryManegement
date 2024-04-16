package com.example.Omar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private int orderId;

    @Column(name = "Date")
    private Date date;

    @Column(name = "Status")
    private String status;

    @Column(name = "TotalAmount")
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customer customer;

}
