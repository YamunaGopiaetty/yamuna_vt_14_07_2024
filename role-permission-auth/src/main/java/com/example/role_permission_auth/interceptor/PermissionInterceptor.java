package com.example.role_permission_auth.interceptor;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.role_permission_auth.annotation.Permission;
import com.example.role_permission_auth.model.LogicEnum;
import com.example.role_permission_auth.model.Role;
import com.example.role_permission_auth.model.User;
import com.example.role_permission_auth.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PermissionInterceptor implements HandlerInterceptor{
	
	 private final UserService userService;

	    @Autowired
	    public PermissionInterceptor(UserService userService) {
	        this.userService = userService;
	    }

	    @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	        if (handler instanceof HandlerMethod) {
	            HandlerMethod handlerMethod = (HandlerMethod) handler;
	            Method method = handlerMethod.getMethod();
	            
	            if (method.isAnnotationPresent(Permission.class)) {
	                Permission permissionAnnotation = method.getAnnotation(Permission.class);
	                String[] requiredPermissions = permissionAnnotation.permissions();
	                LogicEnum logic = permissionAnnotation.type();

	                User user = getCurrentUser(); // Fetch current user (e.g., from token or session)
	                
	                boolean hasPermission = checkPermissions(user, requiredPermissions, logic);
	                
	                if (!hasPermission) {
	                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
	                    return false;
	                }
	            }
	        }
	        return true;
	    }

	    private User getCurrentUser() {
	        
	        return userService.findByEmail("example@example.com"); 
	    }

	    private boolean checkPermissions(User user, String[] requiredPermissions, LogicEnum logic) {
	       
	        Set<String> userPermissions = getUserPermissions(user);

	        if (logic == LogicEnum.All) {
	            return userPermissions.containsAll(Arrays.asList(requiredPermissions));
	        } else if (logic == LogicEnum.Any) {
	            for (String permission : requiredPermissions) {
	                if (userPermissions.contains(permission)) {
	                    return true;
	                }
	            }
	            return false;
	        }

	        return false;
	    }

	    private Set<String> getUserPermissions(User user) {
	       
	        Set<String> permissions = new HashSet<>();
	        for (Role role : user.getRoles()) {
	            for (com.example.role_permission_auth.model.Permission permission : role.getPermissions()) {
	                permissions.add(permission.getName());
	            }
	        }
	        return permissions;
	    }

}
