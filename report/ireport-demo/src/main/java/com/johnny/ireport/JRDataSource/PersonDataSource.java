package com.johnny.ireport.JRDataSource;

import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import com.johnny.ireport.bean.Person;
import com.johnny.ireport.service.PersonService;

/**
 * 填充JaserperReort数据
 * 
 * @author 张明学
 * 
 */
public class PersonDataSource implements JRDataSource {
	private int index = -1;

	private List<Person> personList = new PersonService().getAllPerson();

	public Object getFieldValue(JRField field) throws JRException {
		Object value = null;
		String fieldName = field.getName();
		if ("person_Id".equals(fieldName)) {
			value = personList.get(index).getPerson_Id();
		} else if ("person_name".equals(fieldName)) {
			value = personList.get(index).getPerson_name();
		} else if ("person_age".equals(fieldName)) {
			value = personList.get(index).getPerson_age();
		} else if ("person_address".equals(fieldName)) {
			value = personList.get(index).getPerson_address();
		}
		return value;
	}

	public boolean next() throws JRException {
		index++;
		return index < personList.size();
	}

}
