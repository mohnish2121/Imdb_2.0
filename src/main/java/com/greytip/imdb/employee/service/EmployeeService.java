package com.greytip.imdb.employee.service;

import com.greytip.imdb.employee.model.Employee;
import com.greytip.imdb.employee.repository.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO ;


    public List<Employee> getAllEmployees() {

         return employeeDAO.getAllEmployees();

    }

    public Employee addNewEmployee(Employee newEmployee) {
         return employeeDAO.addNewEmployee(
                newEmployee.getName(),
                newEmployee.getEmail(),
                newEmployee.getPhone(),
                newEmployee.getDeptId(),
                newEmployee.getDesgId()
        );
    }

    public Employee removeEmployee(Integer id) {
        return employeeDAO.removeEmployee( id );
    }

    public Employee updateEmployee( Employee employee) {
        return employeeDAO.updateEmployee(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getDeptId(),
                employee.getDesgId()
        );
    }
}
