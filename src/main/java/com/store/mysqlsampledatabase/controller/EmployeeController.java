package com.store.mysqlsampledatabase.controller;

import com.store.mysqlsampledatabase.DTOs.EmployeeDTO;
import com.store.mysqlsampledatabase.model.Employee;
import com.store.mysqlsampledatabase.service.employeeServices.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/getEmployee/{employeeNumber}")
    public Employee getEmployee(@PathVariable("employeeNumber") int employeeNumber) {
        return employeeService.getEmployee(employeeNumber);
    }

    @PostMapping("/saveEmployee")
    public Employee saveEmployee(@RequestBody EmployeeDTO dto) {
        return employeeService.addEmployee(dto);
    }



}
