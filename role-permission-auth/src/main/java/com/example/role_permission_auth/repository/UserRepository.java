package com.example.role_permission_auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.role_permission_auth.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);

}
