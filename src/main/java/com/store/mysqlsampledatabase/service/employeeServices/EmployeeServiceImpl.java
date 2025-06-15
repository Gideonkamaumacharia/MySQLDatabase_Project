package com.store.mysqlsampledatabase.service.employeeServices;

import com.store.mysqlsampledatabase.DTOs.EmployeeDTO;
import com.store.mysqlsampledatabase.model.Employee;
import com.store.mysqlsampledatabase.model.Office;
import com.store.mysqlsampledatabase.repository.EmployeeRepository;
import com.store.mysqlsampledatabase.repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    private final OfficeRepository officeRepository;

    @Override
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(int employeeNumber){
        return employeeRepository.findById(employeeNumber)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + employeeNumber));

    };

    @Override
    public Employee addEmployee(EmployeeDTO dto) {
        Employee employee = new Employee();

        employee.setLastName(dto.lastName);
        employee.setFirstName(dto.firstName);
        employee.setExtension(dto.extension);
        employee.setEmail(dto.email);
        employee.setJobTitle(dto.jobTitle);

        // Fetch Office from DB using officeCode
        Office office = officeRepository.findById(dto.officeCode)
                .orElseThrow(() -> new RuntimeException("Office not found"));
        employee.setOffice(office);

        // Fetch Manager from DB using employee ID
        if (dto.reportsTo != null) {
            Employee manager = employeeRepository.findById(dto.reportsTo)
                    .orElseThrow(() -> new RuntimeException("Manager not found"));
            employee.setReportsTo(manager);
        }

        return employeeRepository.save(employee);
    }



//    @Override
//    public Employee updateEmployee(Employee employee){
//
//    };
//
//    @Override
//    Employee deleteEmployee(Employee employee);
//
//
}
