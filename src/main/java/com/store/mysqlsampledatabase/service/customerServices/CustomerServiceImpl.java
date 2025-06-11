package com.store.mysqlsampledatabase.service.customerServices;

import com.store.mysqlsampledatabase.model.Customer;
import com.store.mysqlsampledatabase.model.Employee;
import com.store.mysqlsampledatabase.repository.CustomerRepository;
import com.store.mysqlsampledatabase.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
     private final EmployeeRepository employeeRepository;

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer){
        if(customer.getSalesRepresentative() != null){
            Employee employee = employeeRepository.findById(customer.getSalesRepresentative().getId())
                    .orElseThrow(() -> new NoSuchElementException("Employee Not found!!!"));
            customer.setSalesRepresentative(employee);
        }
        return customerRepository.save(customer);
    }
}

