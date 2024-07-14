package com.example.role_permission_auth.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.role_permission_auth.annotation.Permission;
import com.example.role_permission_auth.model.LogicEnum;
import com.example.role_permission_auth.model.User;
import com.example.role_permission_auth.service.UserService;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	private final UserService userService;

    @Autowired
    public BookController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @Permission(permissions = { "AllowRead", "AllowWrite" }, type = LogicEnum.All)
    public String getBook(@PathVariable int id, @RequestParam(value = "num") Optional<Integer> num) {
        User user = userService.findByEmail("example@example.com"); 
        return "hello";
    }
}
