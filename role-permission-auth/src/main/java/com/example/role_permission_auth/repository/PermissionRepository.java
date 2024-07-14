package com.example.role_permission_auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.role_permission_auth.model.Permission;


public interface PermissionRepository extends JpaRepository<Permission, Long>{

	Permission findByName(String name);
}
