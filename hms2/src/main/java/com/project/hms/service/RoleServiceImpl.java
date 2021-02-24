package com.project.hms.service;

import com.project.hms.model.Role;
import com.project.hms.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.List;


@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void updateRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void deleteRole(int id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role getRole(int id) {
        return roleRepository.findById(id).get();
    }
    @Override
    public List<Role> getAllRole() {
        return (List<Role>) roleRepository.findAll();
    }
}
