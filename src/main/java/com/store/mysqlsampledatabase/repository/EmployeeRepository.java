package com.store.mysqlsampledatabase.repository;

import com.store.mysqlsampledatabase.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
