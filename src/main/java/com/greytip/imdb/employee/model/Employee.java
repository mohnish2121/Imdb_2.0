package com.greytip.imdb.employee.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @SequenceGenerator(
            name = "employee_sequense",
            sequenceName = "employee_sequense",
            allocationSize = 1
    )
    @GeneratedValue( strategy= GenerationType.AUTO )
    @Column(name = "employee_id")
    private Integer id;

    @Column( name = "employee_name")
    private String name;

    @Column( name = "email")
    private String email;

    @Column( name = "phone" )
    private Long phone;

    @Column( name = "dept_id")
    private Integer deptId;

    @Column( name = "desg_id")
    private Integer desgId;


}
