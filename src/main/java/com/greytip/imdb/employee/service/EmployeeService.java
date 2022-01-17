package com.greytip.imdb.employee.service;

import com.greytip.imdb.employee.model.Employee;
import com.greytip.imdb.employee.repository.EmployeeRepository;
import com.greytip.imdb.exceptions.EmployeeNotFoundException;
import com.greytip.imdb.exceptions.DuplicateValueException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> getAllEmployees() {
         return employeeRepository.findAll();

    }

    public Employee addNewEmployee(Employee newEmployee) {

        Optional<Employee> existingEmployee = employeeRepository.findTopByNameOrEmailOrPhoneOrderById(
                newEmployee.getName(),
                newEmployee.getEmail(),
                newEmployee.getPhone()
        );

        if( existingEmployee.isPresent() ){

            Employee employee = existingEmployee.get();
            log.error("there was cannot add employee");

            if( employee.getName().equals( newEmployee.getName() ) ) {
                throw new DuplicateValueException("Employee already exist by name: " + newEmployee.getName() );

            } else if( employee.getPhone().equals( newEmployee.getPhone() )) {
                throw new DuplicateValueException("Employee already exist by phone: " + newEmployee.getPhone() );

            } else {
                throw new DuplicateValueException("Employee already exist by email: " + newEmployee.getEmail() );
            }

        }
//        not a good design
        log.info("Employee added successfully");
        return employeeRepository.save(newEmployee);

    }

    public void removeEmployee(Integer id) {
        Optional<Employee> maybeEmployee = employeeRepository.findById( id );
        maybeEmployee.orElseThrow(()-> new EmployeeNotFoundException( "No employee found with id : " + id  ));
        log.info("employee removed");

    }

    public Employee updateEmployee( Employee employee) {
        Optional<Employee> maybeEmployee = employeeRepository.findById(employee.getId());

        if( maybeEmployee.isPresent() ) {
            Employee existingEmployee = maybeEmployee.get();

            BeanUtils.copyProperties( employee, existingEmployee );

            log.info("employee edited");
            return employeeRepository.save(existingEmployee);
        }
        else  {
            log.error("cant edit this employee");
            throw new EmployeeNotFoundException( "No employee found with id : " + employee.getId() );
        }


    }

    public Employee getEmployee(String name) {

        Optional<Employee> maybeEmployee = employeeRepository.findByName(name);
        return maybeEmployee.orElseThrow( () -> new EmployeeNotFoundException( "No employee found with the name : " + name ) );

    }
}
