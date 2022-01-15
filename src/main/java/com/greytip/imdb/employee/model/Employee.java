package com.greytip.imdb.employee.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    @Column(name = "employee_id")
    private Integer id;

    @Column( name = "employee_name")
    @NotNull( message = "Name is mandatory" )
    private String name;

    @Column( name = "email" )
    @Email( message = "Provided email is not a valid" )
    private String email;

    @Column( name = "phone" )
    private Long phone;

    @Column( name = "dept_id")
    private Integer deptId;

    @Column( name = "desg_id")
    private Integer desgId;


}
