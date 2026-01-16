package com.employee.repository;

import com.employee.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository class to store Employee data
 */
public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
