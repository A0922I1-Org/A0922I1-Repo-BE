package com.codegym.mobileShop.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employee_id;
    private String employee_name;
    private Date birthday;
    private String address;
    private String number_phone;
    private String position;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Users> user;

    public Employees() {
    }

    public Employees(int employee_id, String employee_name, Date birthday, String address, String number_phone, String position, Set<Users> user ) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.birthday = birthday;
        this.address = address;
        this.number_phone = number_phone;
        this.position = position;
        this.user = user;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber_phone() {
        return number_phone;
    }

    public void setNumber_phone(String number_phone) {
        this.number_phone = number_phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Set<Users> getUser() {
        return user;
    }

    public void setUser(Set<Users> user) {
        this.user = user;
    }
}
