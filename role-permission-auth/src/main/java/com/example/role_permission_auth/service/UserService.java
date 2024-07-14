package com.example.role_permission_auth.service;

import com.example.role_permission_auth.model.User;

public interface UserService {
	
	 User findByEmail(String email);

}
