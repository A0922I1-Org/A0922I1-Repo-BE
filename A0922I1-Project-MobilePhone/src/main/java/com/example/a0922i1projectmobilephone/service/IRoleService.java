package com.example.a0922i1projectmobilephone.service;

import com.example.a0922i1projectmobilephone.entity.Role;
import com.example.a0922i1projectmobilephone.entity.RoleName;


import java.util.Optional;

public interface IRoleService {
    Role findByRoleName(RoleName roleName);
}
