package com.employee.controller;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller class to handle operations related to Employee
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger logger = LogManager.getLogger(EmployeeController.class);

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    /**
     * Method to add employee
     *
     * @param employee - the employee object
     * @return Employee response entity
     */
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        logger.info("Request received to add employee");
        return new ResponseEntity<>(service.addEmployee(employee), HttpStatus.CREATED);
    }

    /**
     * Method to return all employee
     *
     * @return Employee list response entity
     */
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        logger.info("Request received to fetch all employees");
        return new ResponseEntity<>(service.getAllEmployees(), HttpStatus.OK);
    }

    /**
     * Method to fetch employee by id
     *
     * @param id - employee id to be fetched
     * @return Employee response entity
     */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Optional<Employee>>> getEmployee(@PathVariable String id) {
        logger.info("Request received to fetch employee with ID : {}", id);
        return new ResponseEntity<>(service.getEmployee(id), HttpStatus.OK);
    }

    /**
     * Method to delete employee by id
     *
     * @param id - employee id to be deleted
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String id) {
        logger.info("Request received to delete employee with ID : {}", id);
        service.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}