package com.example.Omar.utils.request;

import com.example.Omar.model.Order;
import com.example.Omar.model.OrderWarehouseProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private Order order;
    private List<OrderWarehouseProduct> orderWarehouseProducts;

}
