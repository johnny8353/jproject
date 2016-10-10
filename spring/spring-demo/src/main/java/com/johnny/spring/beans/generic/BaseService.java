package com.johnny.spring.beans.generic;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {
	//4.0新特性 
	//如果有匹配到多个泛型会报错
	//public class UserJdbcRepository extends BaseRepository<User>
	//No qualifying bean of type [com.johnny.spring.beans.generic.BaseRepository] is defined: 
	//expected single matching bean but found 2: userJdbcRepository,userRepository
	@Autowired
	private BaseRepository<T> baseRepository;
	
	public void add(){
		System.out.println("BaseService add...");
		System.out.println(baseRepository);
	}
}
