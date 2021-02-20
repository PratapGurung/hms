package com.project.hms.service;

import com.project.hms.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoleService {
    void saveRole(Role role);
    void updateRole(Role role);
    void deleteRole(int id);
    Role getRole(int id);
    List<Role> getAllRole();
}
