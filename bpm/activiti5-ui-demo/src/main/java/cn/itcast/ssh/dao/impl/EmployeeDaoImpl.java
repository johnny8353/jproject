package cn.itcast.ssh.dao.impl;

import java.util.List;

import org.hibernate.Query;

import cn.itcast.ssh.dao.IEmployeeDao;
import cn.itcast.ssh.domain.Employee;

public class EmployeeDaoImpl extends BaseDao implements IEmployeeDao{
	
	/**使用用户名作为查询条件，查询用户对象*/
	@Override
	public Employee findEmployeeByName(String name) {
		String hql = "from Employee o where o.name = ?";
//		List<Object> list = this.getHibernateTemplate().find(hql,Employee.class, name);
		Query query = this.getSession().createQuery(hql);
		query.setString(0, name);
		List<Employee> list = query.list();
		Employee employee = null;
		if(list!=null && list.size()>0){
			employee = (Employee) list.get(0);
		}
		return employee;
	}
}
