package com.greytip.imdb.employee.service;

import com.greytip.imdb.employee.model.Employee;
import com.greytip.imdb.employee.repository.EmployeeRepository;
import com.greytip.imdb.exceptions.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> getAllEmployees() {
         return employeeRepository.findAll();

    }

    public Employee addNewEmployee(Employee newEmployee) {
        return employeeRepository.save(newEmployee);

    }

    public void removeEmployee(Integer id) {
        Optional<Employee> maybeEmployee = employeeRepository.findById( id );
        if( maybeEmployee.isPresent() ) {
            employeeRepository.deleteById( id );
        } else {
            throw new ApiRequestException( "No employee found with id : " + id );
        }
    }

    public Employee updateEmployee( Employee employee) {
        Optional<Employee> maybeEmployee = employeeRepository.findById(employee.getId());
        if( maybeEmployee.isPresent() ) {
            Employee existingEmployee = maybeEmployee.get();
            existingEmployee.setName( employee.getName() );
            existingEmployee.setEmail( employee.getEmail() );
            existingEmployee.setPhone( employee.getPhone() );
            existingEmployee.setDeptId( employee.getDeptId() );
            existingEmployee.setDesgId( employee.getDesgId() );

            return employeeRepository.save(existingEmployee);
        }
        else  {
            throw new ApiRequestException( "No employee found with id : " + employee.getId() );
        }


    }

    public Employee getEmployee(String name) {
        Optional<Employee> maybeEmployee = employeeRepository.findByName(name);

        if( ! maybeEmployee.isPresent() ){
            throw new ApiRequestException( "No employee found with the name : " + name );
        }
        return maybeEmployee.get();
    }
}
