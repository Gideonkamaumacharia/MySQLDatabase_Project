package com.store.mysqlsampledatabase.service.employeeServices;

import com.store.mysqlsampledatabase.DTOs.EmployeeDTO;
import com.store.mysqlsampledatabase.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployee(int employeeNumber);
    List<Employee> getEmployees();
    Employee addEmployee(EmployeeDTO employee);
    //Employee updateEmployee(Employee employee);
    //Employee deleteEmployee(Employee employee);


}
