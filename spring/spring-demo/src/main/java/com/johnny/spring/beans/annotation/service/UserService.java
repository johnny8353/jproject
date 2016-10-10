package com.johnny.spring.beans.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.johnny.spring.beans.annotation.repository.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	
	//默认情况下, 当 IOC 容器里存在多个类型兼容的 Bean 时, 通过类型的自动装配将无法工作. 此时可以在 @Qualifier 注解里提供 Bean 的名称.
	//Spring 允许对方法的入参标注 @Qualifiter 已指定注入 Bean 的名称

	@Autowired
	public void setUserRepository(@Qualifier("userRepositoryImpl") UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	public void save(){
		
		System.out.println("UserService save...");
		userRepository.save();
	}
}
