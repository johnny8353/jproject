package com.johnny.spring.beans.annotation.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository{

	@Override
	public void save() {
		System.out.println("UserRepositoryImpl save ...");
	}

}
