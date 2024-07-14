package com.example.role_permission_auth.annotation;

import com.example.role_permission_auth.model.LogicEnum;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {
	String[] permissions(); 
    LogicEnum type() default LogicEnum.All; 
}
