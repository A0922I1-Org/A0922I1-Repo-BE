package com.codegym.mobileShop.entity;

import javax.persistence.*;
import java.util.Set;

public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roles_id;
    private String role_name;
    @OneToMany(mappedBy = "roles", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<User_Role> user_roles;

    public Roles() {
    }

    public Roles(int roles_id, String role_name, Set<User_Role> user_roles) {
        this.roles_id = roles_id;
        this.role_name = role_name;
        this.user_roles = user_roles;
    }

    public int getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(int roles_id) {
        this.roles_id = roles_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Set<User_Role> getUser_roles() {
        return user_roles;
    }

    public void setUser_roles(Set<User_Role> user_roles) {
        this.user_roles = user_roles;
    }
}
