package com.example.a0922i1projectmobilephone.controller;


import com.example.a0922i1projectmobilephone.dto.reponse.JwtResponse;
import com.example.a0922i1projectmobilephone.dto.reponse.ReponseMessage;
import com.example.a0922i1projectmobilephone.dto.request.SignInForm;
import com.example.a0922i1projectmobilephone.dto.request.SignUpForm;
import com.example.a0922i1projectmobilephone.entity.Employee;
import com.example.a0922i1projectmobilephone.entity.Role;
import com.example.a0922i1projectmobilephone.entity.RoleName;
import com.example.a0922i1projectmobilephone.entity.User;
import com.example.a0922i1projectmobilephone.security.jwt.JwtProvider;
import com.example.a0922i1projectmobilephone.security.userprincal.UserPrinciple;
import com.example.a0922i1projectmobilephone.service.Impl.EmployeeServiceImpl;
import com.example.a0922i1projectmobilephone.service.Impl.RoleServiceImpl;
import com.example.a0922i1projectmobilephone.service.Impl.UserServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import static jdk.nashorn.internal.objects.NativeArray.forEach;

@RequestMapping("/api/auth")
@RestController
public class AuthController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    EmployeeServiceImpl employeeService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;


    @PostMapping("/signUp")
    public ResponseEntity<?> register(@RequestBody SignUpForm signUpForm) {
        if (userService.existsByUsername(signUpForm.getUser().getUsername())) {
            return new ResponseEntity<>(new ReponseMessage("user đã tồn tại"), HttpStatus.OK);
        }
        if (userService.existsByEmail(signUpForm.getUser().getEmail())) {
            return new ResponseEntity<>(new ReponseMessage("email đã tồn tại"), HttpStatus.OK);
        }
        //Xử lý Role
        Set<String> strRoles = signUpForm.getRole();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role ->{
            switch (role.toUpperCase()){
                case "ADMIN":
                    Role adminRole = roleService.findByRoleName(RoleName.ADMIN);
                    roles.add(adminRole);
                    break;
                case "BUSINESS":
                    Role businessRole = roleService.findByRoleName(RoleName.BUSINESS);
                    roles.add(businessRole);
                    break;
                case "STORAGE":
                    Role storageRole = roleService.findByRoleName(RoleName.STORAGE);
                    roles.add(storageRole);
                    break;
                case "SALE":
                    Role saleRole = roleService.findByRoleName(RoleName.SALE);
                    roles.add(saleRole);
                    break;
            }
        });
        Employee employee = new Employee(
                signUpForm.getNameEmployee(),
                signUpForm.getAddressEmployee(),
                signUpForm.getBirthdayEmployee(),
                signUpForm.getPositionEmployee(),
                signUpForm.getUser().getUsername(),
                signUpForm.getUser().getEmail(),
                signUpForm.getUser().getAvatar(),
                passwordEncoder.encode(signUpForm.getUser().getPassword())
        );
        BeanUtils.copyProperties(signUpForm, employee);
        employee.getUser().setPassword(passwordEncoder.encode(signUpForm.getUser().getPassword()));
        employee.getUser().setRole(roles);
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>(new ReponseMessage("Tạo account thành công!!!"), HttpStatus.OK);
    }


    @GetMapping("/signIn")
    public ResponseEntity<?> login(@RequestBody SignInForm signInForm){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(token, userPrinciple.getUsername(), userPrinciple.getAuthorities()));
    }
}
