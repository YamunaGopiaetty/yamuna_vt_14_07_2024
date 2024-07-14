package com.example.role_permission_auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.role_permission_auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
