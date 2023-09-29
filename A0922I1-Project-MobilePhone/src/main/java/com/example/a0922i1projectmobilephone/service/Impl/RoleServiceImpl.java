package com.example.a0922i1projectmobilephone.service.Impl;

import com.example.a0922i1projectmobilephone.entity.Role;
import com.example.a0922i1projectmobilephone.entity.RoleName;
import com.example.a0922i1projectmobilephone.repository.IRoleRepository;
import com.example.a0922i1projectmobilephone.service.IRoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {
    final IRoleRepository roleRepository;

    public RoleServiceImpl(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByRoleName(RoleName roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
