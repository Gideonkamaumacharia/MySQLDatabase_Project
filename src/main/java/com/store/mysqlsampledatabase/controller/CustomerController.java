package com.store.mysqlsampledatabase.controller;

import com.store.mysqlsampledatabase.model.Customer;
import com.store.mysqlsampledatabase.service.customerServices.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/getCustomers")
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> customers = customerService.getCustomers();
        return ResponseEntity.ok(customers);
    }

    @PostMapping("/saveCustomers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.saveCustomer(customer);
        return ResponseEntity.ok(savedCustomer);
    }


}
