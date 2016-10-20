package com.johnny.monitor.model;

import java.util.ArrayList;
import java.util.List;

public class SystemListBO {
	List<SystemBO> systemBOList = new ArrayList<SystemBO>();

	public List<SystemBO> getSystemBOList() {
		return systemBOList;
	}

	public void setSystemBOList(List<SystemBO> systemBOList) {
		this.systemBOList = systemBOList;
	}

	@Override
	public String toString() {
		return "SystemListBO [systemBOList=" + systemBOList + "]";
	}

	
}
