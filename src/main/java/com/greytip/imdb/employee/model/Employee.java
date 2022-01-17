package com.greytip.imdb.employee.model;


import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {


    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    @Column(name = "employee_id")
    private Integer id;


    @Column( name = "employee_name")
    @NotNull( message = "Name is mandatory" )
    private String name;


    @NotNull( message = "Email cannot be left blank" )
    @Email( message = "Provided email is not a valid" )
    private String email;


    @Size( min = 10, max = 10 , message = "phone number should be 10 digits")
    @NotNull
    private String phone;


    @Column( name = "dept_id")
    private Integer deptId;


    @Column( name = "desg_id")
    private Integer desgId;


}
