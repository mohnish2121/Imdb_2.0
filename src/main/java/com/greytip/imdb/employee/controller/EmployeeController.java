package com.greytip.imdb.employee.controller;

import com.greytip.imdb.employee.model.Employee;
import com.greytip.imdb.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee( @RequestBody Employee newEmployee ) {
         Employee employee = employeeService.addNewEmployee( newEmployee );
         return new ResponseEntity<Employee>(employee,HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Employee> removeEmployee( @RequestParam Integer id ) {
        Employee employee = employeeService.removeEmployee(id);
        return new ResponseEntity<Employee>(employee,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployee( @RequestBody Employee employee ) {
        Employee udatedEmployee  = employeeService.updateEmployee(employee);
        return new ResponseEntity<Employee>(udatedEmployee,HttpStatus.OK);
    }


}
