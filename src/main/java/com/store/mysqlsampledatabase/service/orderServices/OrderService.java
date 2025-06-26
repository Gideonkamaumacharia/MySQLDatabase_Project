package com.store.mysqlsampledatabase.service.orderServices;

import com.store.mysqlsampledatabase.model.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<Order> getOrders();
    Order getOrder(Integer orderNumber);
    Order addOrder(Order order);
    void deleteOrder(Integer orderNumber);
    Order updateOrder(Integer orderNumber, Map<String, Object> updates);
}
