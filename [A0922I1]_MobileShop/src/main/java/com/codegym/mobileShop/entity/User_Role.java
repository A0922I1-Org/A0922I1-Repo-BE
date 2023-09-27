package com.codegym.mobileShop.entity;

import javax.persistence.*;

public class User_Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private int user_role_id;
     private int role_id;
    @ManyToOne
    @JoinColumn(name = "roles_id", referencedColumnName = "roles_id")
    private Roles roles;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Users user;

    public User_Role() {
    }

    public User_Role(int user_role_id, int role_id, Roles roles, Users user) {
        this.user_role_id = user_role_id;
        this.role_id = role_id;
        this.roles = roles;
        this.user = user;
    }

    public int getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(int user_role_id) {
        this.user_role_id = user_role_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
