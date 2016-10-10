package com.johnny.webservice.axis1.datatype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public class DataTypeWSImpl implements DataTypeWS {
	@WebResult(name = "result")
	@Override
	public boolean addStudent(@WebParam(name="student") Student s) {
		System.out.println("server addStudent() "+s);
		return true;
	}

	@WebResult(name = "result")
	@Override
	public Student getStudentById(@WebParam(name="id2") int id) {
		System.out.println("server getStudentById() "+id);
		return new Student(id, "CAT", 1000);
	}

	@WebResult(name = "result")
	@Override
	public List<Student> getStudentsByPrice(@WebParam(name="price") float price) {
		System.out.println("server getStudentsByPrice() "+price);
		List<Student> list = new ArrayList<>();
		list.add(new Student(1, "TOM1", price+1));
		list.add(new Student(2, "TOM2", price+2));
		list.add(new Student(3, "TOM3", price+3));
		return list;
	}

//	在做webServices复杂类型值传递时，返回值的类型不要用接口类型。例如(List应该改为ArrayList,Map改为HashMap等)
	
	@WebResult(name = "result")
	@Override
	public Map<Integer, Student> getAllStudentsMap() {
		System.out.println("server getAllStudentsMap() ");
		Map<Integer, Student> map = new HashMap<>();
		map.put(1, new Student(1, "JACK1", 2345));
		map.put(3, new Student(3, "JACK3", 2375));
		map.put(2, new Student(2, "JACK2", 12345));
		return map;
	}
}
