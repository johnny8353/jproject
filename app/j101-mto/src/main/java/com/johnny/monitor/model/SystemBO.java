package com.johnny.monitor.model;

import java.util.List;

import com.johnny.monitor.access.vo.SystemGroupVO;
import com.johnny.monitor.access.vo.SystemInfoVO;

public class SystemBO {
	private SystemGroupVO groupVO;
	private List<SystemInfoVO> systemInfoVOList;
	
	public SystemBO(SystemGroupVO groupVO,
			List<SystemInfoVO> systemInfoVOList) {
		super();
		this.groupVO = groupVO;
		this.systemInfoVOList = systemInfoVOList;
	}

	public SystemGroupVO getGroupVO() {
		return groupVO;
	}

	public void setGroupVO(SystemGroupVO groupVO) {
		this.groupVO = groupVO;
	}


	public List<SystemInfoVO> getSystemInfoVOList() {
		return systemInfoVOList;
	}

	public void setSystemInfoVOList(List<SystemInfoVO> systemInfoVOList) {
		this.systemInfoVOList = systemInfoVOList;
	}

	public SystemBO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SystemBO [groupVO=" + groupVO + ", systemInfoVOList="
				+ systemInfoVOList + "]";
	}
	

}
