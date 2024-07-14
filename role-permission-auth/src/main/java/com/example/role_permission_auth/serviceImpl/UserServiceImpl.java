package com.example.role_permission_auth.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.role_permission_auth.model.User;
import com.example.role_permission_auth.repository.UserRepository;
import com.example.role_permission_auth.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

}
