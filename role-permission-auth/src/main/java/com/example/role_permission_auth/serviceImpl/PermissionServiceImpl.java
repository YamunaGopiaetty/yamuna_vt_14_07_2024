package com.example.role_permission_auth.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.role_permission_auth.model.Permission;
import com.example.role_permission_auth.repository.PermissionRepository;
import com.example.role_permission_auth.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService{
	
	 private final PermissionRepository permissionRepository;

	    @Autowired
	    public PermissionServiceImpl(PermissionRepository permissionRepository) {
	        this.permissionRepository = permissionRepository;
	    }

	    @Override
	    public Permission findByName(String name) {
	        return permissionRepository.findByName(name);
	    }
}
