package com.johnny.javase.generic.practise;

import java.util.HashMap;
import java.util.List;

/*
 * 创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方法来操作 User 对象，
使用 Junit 单元测试类进行测试。

 */
public class TestDAO {
	public static void main(String[] args) {
		DAO<User> dao = new DAO<User>();
		
		dao.map = new HashMap<String,User>();
		
		dao.save("1001", new User(1, 32, "梁朝伟"));
		dao.save("1002", new User(2,34,"汤唯"));
		dao.save("1003", new User(3,23,"刘嘉玲"));
		User u = dao.get("1002");
		System.out.println(u);
		dao.update("1002", new User(4,45,"成龙"));
		dao.delete("1003");
		List<User> list = dao.list();
		System.out.println(list);
		
	}
}
