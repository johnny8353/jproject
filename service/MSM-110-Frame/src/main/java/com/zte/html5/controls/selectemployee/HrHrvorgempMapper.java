package com.zte.html5.controls.selectemployee;

import java.util.List;
import java.util.Map;

/**
 * 数据访问接口类
 */
public interface HrHrvorgempMapper {

	public long getCount(Map<String, Object> map);

	public List<KeyValueSearchEmpResponse> getEmpIdPage(Map<String, Object> map);
	
	public List<KeyValueSearchEmpResponse> getEmpIdList(Map<String, Object> map);

	public KeyValueSearchEmpResponse getEmpMsg(Map<String, Object> map);
}