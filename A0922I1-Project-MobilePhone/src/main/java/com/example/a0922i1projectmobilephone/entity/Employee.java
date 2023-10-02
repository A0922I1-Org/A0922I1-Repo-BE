package com.example.a0922i1projectmobilephone.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeId;
    @Column(name = "name_Employee")
    private String nameEmployee;
    @Column(name = "birthday_employee")
    private Date birthdayEmployee;
    @Column(name = "address_employee")
    private String addressEmployee;
    @Column(name = "number_phone")
    private String numberPhoneEmployee;
    @Column(name = "position_employee")
    private String positionEmployee;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
