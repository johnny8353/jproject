package com.zte.html5.frame.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class ValidationException extends Exception{

	private BindingResult result;
	
	private Map<String,String> resultMap = new Hashtable<String,String>();
	
	public BindingResult getResult() {
		return result;
	}
	
	public Map<String,String> getResultMap() {
		
		return resultMap;
	}

	public ValidationException(BindingResult result)
	 {
		this.result = result;
		
		for(ObjectError objectError : this.result.getAllErrors()){
			//result.
			String code = objectError.getCodes()[0];
			resultMap.put(code.substring(code.indexOf(".")+1),objectError.getDefaultMessage());
		}

		//super("");
	 } 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
