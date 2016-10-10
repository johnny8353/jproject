package com.johnny.javase.generic.practise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * 定义个泛型类 DAO<T>，在其中定义一个Map 成员变量，Map 的键为 String 类型，值为 T 类型。

分别创建以下方法：
public void save(String id,T entity)： 保存 T 类型的对象到 Map 成员变量中
T get(String id)：从 map 中获取 id 对应的对象
void update(String id,T entity)：替换 map 中key为id的内容,改为 entity 对象
List<T> list()：返回 map 中存放的所有 T 对象
void delete(String id)：删除指定 id 对象

 */
public class DAO<T> {
	Map<String,T> map;
	
	public void delete(String id){
		map.remove(id);
	}
	public List<T> list(){
		List<T> list = new ArrayList<T>();
		for(String s : map.keySet()){
			list.add(map.get(s));
		}
		return list;
	}
	
	public void update(String id,T entity){
		//map.remove(id);
		map.put(id, entity);
	}
	
	public T get(String id){
		return map.get(id);
	}
	public void save(String id,T entity){
		map.put(id, entity);
	}
}
