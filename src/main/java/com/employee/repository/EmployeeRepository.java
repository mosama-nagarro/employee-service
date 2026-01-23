package com.employee.repository;

import com.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository class to store Employee data
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
