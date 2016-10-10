package com.johnny.javaweb.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class WhenTag extends SimpleTagSupport{

	private boolean test;
	
	public void setTest(boolean test) {
		this.test = test;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		if(test){
			ChooseTag chooseTag = (ChooseTag) getParent();
			boolean flag = chooseTag.isFlag();
			
			if(flag){
				getJspBody().invoke(null);
				chooseTag.setFlag(false);
			}
		}
	}
	
}
