package com.example.role_permission_auth.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.role_permission_auth.model.Role;
import com.example.role_permission_auth.repository.RoleRepository;
import com.example.role_permission_auth.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	 private final RoleRepository roleRepository;

	    @Autowired
	    public RoleServiceImpl(RoleRepository roleRepository) {
	        this.roleRepository = roleRepository;
	    }

	    @Override
	    public Role findById(Long id) {
	        return roleRepository.findById(id).orElse(null);
	    }
}
