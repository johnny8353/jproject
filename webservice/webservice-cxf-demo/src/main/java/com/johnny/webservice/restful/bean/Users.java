package com.johnny.webservice.restful.bean;

import java.util.HashMap;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 类 编 号：
 * 类 名 称：Users
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年9月8日
 * 编码作者：JohnnyHuang 黄福强
 */
@XmlRootElement(name = "UserInfos")
public class Users {
	private List<User> users;

	private User[] userArr;

	private HashMap<String, User> maps;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User[] getUserArr() {
		return userArr;
	}

	public void setUserArr(User[] userArr) {
		this.userArr = userArr;
	}

	public HashMap<String, User> getMaps() {
		return maps;
	}

	public void setMaps(HashMap<String, User> maps) {
		this.maps = maps;
	}

}
