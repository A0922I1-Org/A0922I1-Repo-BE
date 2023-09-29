package com.example.a0922i1projectmobilephone.dto.request;

import com.example.a0922i1projectmobilephone.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SignUpForm {
    private String nameEmployee;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthdayEmployee;
    private String addressEmployee;
    private String numberPhoneEmployee;
    private String positionEmployee;
    private User user;
    private Set<String> role;

}

