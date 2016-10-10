package com.johnny.mybaits.crud.annotation;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.johnny.mybaits.bean.User;

/*
 * 测试: CRUD操作的注解的实现
 */
public interface UserMapper {
	//org.apache.ibatis.binding.BindingException: Type interface com.johnny.mybaits.crud.UserMapperAnnotation is not known to the MapperRegistry.
	//mybatis配置文件没有配置<mapper class="com.johnny.mybaits.crud.annotation.UserMapper"/>
	@Insert("insert into users(name, age) values(#{name}, #{age})")
	public int add(User user);
	
	@Delete("delete from users where id=#{id}")
	public int deleteById(int id);
	
	@Update("update users set name=#{name},age=#{age} where id=#{id}")
	public int update(User user);
	
	@Select("select * from users where id=#{id}")
	public User getById(int id);
	
	@Select("select * from users")
	public List<User> getAll();
}
