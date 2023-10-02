package com.example.a0922i1projectmobilephone.service;

import com.example.a0922i1projectmobilephone.entity.User;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUserService {
    User findByUsername(String name);
    User findByEmail(String email);
    Boolean existsByUsername (String userName);
    Boolean existsByEmail(String email);
    User save(User user);
}
