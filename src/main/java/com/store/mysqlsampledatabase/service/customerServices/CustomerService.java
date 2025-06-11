package com.store.mysqlsampledatabase.service.customerServices;

import com.store.mysqlsampledatabase.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();

    Customer saveCustomer(Customer customer);

}
