package com.codegym.mobileShop.entity;

import javax.persistence.*;
import java.util.Set;

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    private String user_name;
    private String password;
    private int employee_id;
    @OneToMany(mappedBy = "user" ,fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<User_Role> user_role;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employees employees;

    public Users() {
    }

    public Users(int user_id, String user_name, String password, int employee_id, Set<User_Role> user_role, Employees employees) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.password = password;
        this.employee_id = employee_id;
        this.user_role = user_role;
        this.employees = employees;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public Set<User_Role> getUser_role() {
        return user_role;
    }

    public void setUser_role(Set<User_Role> user_role) {
        this.user_role = user_role;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }
}
