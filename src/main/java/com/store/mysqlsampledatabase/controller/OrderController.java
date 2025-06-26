package com.store.mysqlsampledatabase.controller;

import com.store.mysqlsampledatabase.model.Order;
import com.store.mysqlsampledatabase.service.orderServices.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/getOrders")
    ResponseEntity<List<Order>> getOrders() {
        List<Order> orders = orderService.getOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/getOrder/{orderNumber}")
    ResponseEntity<Order> getOrder(@PathVariable Integer orderNumber) {
        Order order = orderService.getOrder(orderNumber);
        return ResponseEntity.ok(order);
    }

    @PostMapping("/saveOrder")
    ResponseEntity<Order> saveOrder(@RequestBody Order order) {
        Order savedOrder = orderService.addOrder(order);
        return ResponseEntity.ok(savedOrder);
    }

    @PatchMapping("/orders/{orderNumber}")
    public ResponseEntity<Order> updateOrderFields(
            @PathVariable Integer orderNumber,
            @RequestBody Map<String, Object> updates) {
        Order updatedOrder = orderService.updateOrder(orderNumber, updates);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/delete/order/{orderNumber}")
    ResponseEntity<?> deleteOrder(@PathVariable Integer orderNumber) {
        orderService.deleteOrder(orderNumber);
        return ResponseEntity.ok().body(
                Map.of("Message","Order deleted successfully!")
        );
    }
}
