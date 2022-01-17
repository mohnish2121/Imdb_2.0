package com.greytip.imdb.employee.repository;

import com.greytip.imdb.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

     Optional<Employee> findByName( String name );

     Optional<Employee> findTopByNameOrEmailOrPhoneOrderById( String name , String email, String phone );

}


//reference purpose
//    @Query( value = "SELECT * FROM employee",
//            nativeQuery = true)
//    List<Employee> getAllEmployees();
//
//    @Query( value = "INSERT INTO employee (employee_name , email, phone,dept_id, desg_id ) " +
//            "values (:name, :email, :phone, :dept_id, :desg_id ) returning * ",
//            nativeQuery = true )
//    Employee addNewEmployee(
//            @Param("name") String name,
//            @Param("email") String email,
//            @Param("phone") Long phone,
//            @Param("dept_id") Integer deptId,
//            @Param("desg_id") Integer desgId
//    );
//
//    @Query( value = "DELETE FROM employee where employee_id = :id returning *",
//            nativeQuery = true )
//    Employee removeEmployee(@Param("id") Integer id);
//
//    @Query( value = "UPDATE employee " +
//            "SET employee_name = :name , email = :email, phone = :phone, dept_id = :dept_id, desg_id = :desg_id " +
//            "WHERE employee_id = :id returning *", nativeQuery = true)
//    Employee updateEmployee(
//            @Param("id") Integer id,
//            @Param("name") String name,
//            @Param("email") String email,
//            @Param("phone") Long phone,
//            @Param("dept_id") Integer deptId,
//            @Param("desg_id") Integer desgId
//    );

