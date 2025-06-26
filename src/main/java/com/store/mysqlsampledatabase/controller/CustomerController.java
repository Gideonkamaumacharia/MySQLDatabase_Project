package com.store.mysqlsampledatabase.controller;

import com.store.mysqlsampledatabase.DTOs.CustomerDTO;
import com.store.mysqlsampledatabase.model.Customer;
import com.store.mysqlsampledatabase.model.Employee;
import com.store.mysqlsampledatabase.repository.CustomerRepository;
import com.store.mysqlsampledatabase.repository.EmployeeRepository;
import com.store.mysqlsampledatabase.service.customerServices.CustomerService;
import com.store.mysqlsampledatabase.service.employeeServices.EmployeeService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final EmployeeRepository employeeRepository;


    @GetMapping("/getCustomers")
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> customers = customerService.getCustomers();
        return ResponseEntity.ok(customers);
    }

    @PostMapping("/saveCustomers")
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setCustomerName(dto.getCustomerName());
        customer.setContactFirstName(dto.getContactFirstName());
        customer.setContactLastName(dto.getContactLastName());
        customer.setAddressLine1(dto.getAddressLine1());
        customer.setPhone(dto.getPhone());
        customer.setCreditLimit(dto.getCreditLimit());
        customer.setCity(dto.getCity());
        customer.setCountry(dto.getCountry());

        if (dto.getSalesRepId() != null) {
            Employee rep = employeeRepository.findById(dto.getSalesRepId())
                    .orElseThrow(() -> new NoSuchElementException("Rep not found"));
            customer.setSalesRepresentative(rep);
    }


    return ResponseEntity.ok(customerService.saveCustomer(customer));


}}
