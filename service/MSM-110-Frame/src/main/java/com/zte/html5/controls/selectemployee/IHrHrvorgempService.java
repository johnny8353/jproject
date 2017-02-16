package com.zte.html5.controls.selectemployee;

import java.util.*;
import java.io.Serializable;
import org.springframework.stereotype.Service;

/**
 *服务接口类 
 */
public interface IHrHrvorgempService{
	
	public List<KeyValueSearchEmpResponse> getList(String seekInfo,String orderField,String order) throws Exception;
		
	public long getCount(String seekInfo,String orderField,String order) throws Exception;
	
	public List<KeyValueSearchEmpResponse> getPage(String seekInfo,String orderField,String order,Long page,Long rows) throws Exception;

	public KeyValueSearchEmpResponse getEmpMsg(KeyValueSearchEmpResponse temp);
	
}