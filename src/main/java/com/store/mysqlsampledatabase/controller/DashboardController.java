package com.store.mysqlsampledatabase.controller;

import com.store.mysqlsampledatabase.repository.CustomerRepository;
import com.store.mysqlsampledatabase.repository.OrderRepository;
import com.store.mysqlsampledatabase.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dashboard")
public class DashboardController {
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    @GetMapping("/totals")
    public ResponseEntity<Map<String,Long>> getTotals() {
        Map<String,Long> totals = new HashMap<>();
        totals.put("products", productRepository.count());
        totals.put("customers", customerRepository.count());
        totals.put("orders", orderRepository.count());
        return ResponseEntity.ok(totals);
    }
}
