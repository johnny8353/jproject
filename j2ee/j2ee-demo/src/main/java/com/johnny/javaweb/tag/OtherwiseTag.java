package com.johnny.javaweb.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class OtherwiseTag extends SimpleTagSupport{

	@Override
	public void doTag() throws JspException, IOException {
		ChooseTag chooseTag = (ChooseTag) getParent();
		
		if(chooseTag.isFlag()){
			getJspBody().invoke(null);
		}
	}
	
}
