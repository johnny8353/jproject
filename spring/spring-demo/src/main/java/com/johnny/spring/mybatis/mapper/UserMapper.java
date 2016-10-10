package com.johnny.spring.mybatis.mapper;

import java.util.List;

import com.johnny.spring.mybatis.bean.User;
/*
 * 约定
 */

public interface UserMapper {

	void save(User user);

	void update(User user);

	void delete(int id);

	User findById(int id);

	List<User> findAll();

}
