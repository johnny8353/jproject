package com.johnny.spring.beans.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.johnny.spring.beans.annotation.Main;
import com.johnny.spring.beans.annotation.service.UserService;

@Controller
public class UserController {
	//默认情况下, 所有使用 @Authwired 注解的属性都需要被设置. 当 Spring 找不到匹配的 Bean 装配属性时, 会抛出异常, 若某一属性允许不被设置, 可以设置 @Authwired 注解的 required 属性为 false
	@Autowired(required=false)
	private Main main;
	
	@Autowired
	private UserService userService;
	
	public void execute(){
		System.out.println("UserController execute...");
		userService.save();
		System.out.println(main);
	}
}
