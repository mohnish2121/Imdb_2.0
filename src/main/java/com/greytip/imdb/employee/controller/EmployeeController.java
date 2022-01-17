package com.greytip.imdb.employee.controller;

import com.greytip.imdb.employee.model.Employee;
import com.greytip.imdb.employee.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping
    @ApiOperation(
            value = "Returns list of employees",
            notes = "Returns list of all employees",
            response = Employee.class
    )
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        log.info("Extracted list of employees");
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    @ApiOperation(
            value = "Returns an Employee",
            notes = "Find employee by name",
            response = Employee.class
    )
    public Employee getEmployee( @PathVariable String name )
    {
        log.info("Extracted employee with the name:" + name );
        return employeeService.getEmployee( name );
    }

    @PostMapping
    @ApiOperation(
            value = "Add an employee",
            notes = "Adds a new employee",
            response = Employee.class
    )
    public ResponseEntity<Employee> addEmployee( @Valid @RequestBody Employee newEmployee ) {

        return new ResponseEntity<>( employeeService.addNewEmployee( newEmployee ), HttpStatus.OK );

    }


    @DeleteMapping
    @ApiOperation(
            value = "Delete an employee",
            notes = "It deletes an employee specified",
            response = String.class
    )
    public ResponseEntity<String> removeEmployee (
            @ApiParam(value = "Id value for employee you wanna delete", required = true)
            @RequestParam Integer id
    ) {
        employeeService.removeEmployee(id);
        return new ResponseEntity<>("{}",HttpStatus.OK);
    }


    @PutMapping
    @ApiOperation(
            value = "Edit an employee",
            notes = "Edit an existing employee details",
            response = Employee.class
    )
    public ResponseEntity<Employee> updateEmployee( @RequestBody Employee employee ) {
        Employee udatedEmployee  = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(udatedEmployee,HttpStatus.OK);
    }

}
