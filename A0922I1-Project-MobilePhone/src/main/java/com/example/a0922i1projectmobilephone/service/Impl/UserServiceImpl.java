package com.example.a0922i1projectmobilephone.service.Impl;

import com.example.a0922i1projectmobilephone.entity.Role;
import com.example.a0922i1projectmobilephone.entity.User;
import com.example.a0922i1projectmobilephone.repository.IRoleRepository;
import com.example.a0922i1projectmobilephone.repository.IUserRepository;
import com.example.a0922i1projectmobilephone.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    final IUserRepository userRepository;
    @Autowired
    IRoleRepository roleRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public Boolean existsByUsername(String userName) {
        return userRepository.existsByUsername(userName);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

}
