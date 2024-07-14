package com.example.role_permission_auth.service;

import com.example.role_permission_auth.model.Permission;

public interface PermissionService {
	
	Permission findByName(String name);
}
