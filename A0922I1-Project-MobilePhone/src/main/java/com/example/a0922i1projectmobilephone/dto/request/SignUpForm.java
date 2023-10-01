package com.example.a0922i1projectmobilephone.dto.request;

import com.example.a0922i1projectmobilephone.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

public class SignUpForm {
    private String nameEmployee;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthdayEmployee;
    private String addressEmployee;
    private String numberPhoneEmployee;
    private String positionEmployee;
    private User user;
    private Set<String> role;

    public SignUpForm() {
    }

    public SignUpForm(String nameEmployee, Date birthdayEmployee, String addressEmployee, String numberPhoneEmployee, String positionEmployee, User user, Set<String> role) {
        this.nameEmployee = nameEmployee;
        this.birthdayEmployee = birthdayEmployee;
        this.addressEmployee = addressEmployee;
        this.numberPhoneEmployee = numberPhoneEmployee;
        this.positionEmployee = positionEmployee;
        this.user = user;
        this.role = role;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public Date getBirthdayEmployee() {
        return birthdayEmployee;
    }

    public void setBirthdayEmployee(Date birthdayEmployee) {
        this.birthdayEmployee = birthdayEmployee;
    }

    public String getAddressEmployee() {
        return addressEmployee;
    }

    public void setAddressEmployee(String addressEmployee) {
        this.addressEmployee = addressEmployee;
    }

    public String getNumberPhoneEmployee() {
        return numberPhoneEmployee;
    }

    public void setNumberPhoneEmployee(String numberPhoneEmployee) {
        this.numberPhoneEmployee = numberPhoneEmployee;
    }

    public String getPositionEmployee() {
        return positionEmployee;
    }

    public void setPositionEmployee(String positionEmployee) {
        this.positionEmployee = positionEmployee;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}

