package com.employee.service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    /**
     * Method to add employee
     *
     * @param employee - the employee object
     * @return Employee entity
     */
    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    /**
     * Method to return all employee
     *
     * @return Employee list
     */
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    /**
     * Method to fetch employee by id
     *
     * @param id - employee id to be fetched
     * @return Employee entity
     */
    public Optional<Optional<Employee>> getEmployee(String id) {
        return Optional.of(repository.findById(Long.valueOf(id)));
    }

    /**
     * Method to delete employee by id
     *
     * @param id - employee id to be deleted
     */
    public void deleteEmployee(String id) {
        repository.deleteById(Long.valueOf(id));
    }
}