package com.johnny.struts2.crud;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class EmployeeAction implements RequestAware, ModelDriven<Employee>,
		Preparable {

	private Dao dao = new Dao();

	private Employee employee;

	public String update() {
		dao.update(employee);
		return "success";
	}

	public void prepareUpdate() {
		employee = new Employee();
	}

	public String edit() {
		System.out.println("employee :" + employee);
		System.out.println("值栈栈顶；"+ ServletActionContext.getContext().getValueStack().peek());
		return "edit";
	}

	public void prepareEdit() {
		// 关于回显: Struts2 表单标签会从值栈中获取对应的属性值进行回显.
		employee = dao.get(employeeId);
	}

	public String save() {
		dao.save(employee);
		return "success";
	}

	public void prepareSave() {
		employee = new Employee();
	}

	public String delete() {
		dao.delete(employeeId);
		return "success";
	}

	public String list() {
		request.put("emps", dao.getEmployees());
		return "list";
	}

	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	private Integer employeeId;

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	// -当用户触发 add 请求时, ModelDriven 拦截器将调用 EmployeeAction 对象的 getModel() 方法,
	// 并把返回的模型(Employee实例)压入到 ValueStack 栈.
	@Override
	public Employee getModel() {
		// 使用 interceptor-stack
		// paramsPrepareParamsStack，在执行ModelDriver拦截器之前先Params拦截器
		/**
		 * params -> modelDriven -> params 所以可以先把请求参数赋给 Action 对应的属性, 再根据赋给
		 * Action 的那个属性值决定压到值栈栈顶的对象, 最后再为栈顶对象的属性赋值.
		 * 
		 * 对于 edit 操作而言: I. 先为 EmployeeAction 的 employeeId 赋值 II. 根据 employeeId
		 * 从数据库中加载对应的对象, 并放入到值栈的栈顶 III. 再为栈顶对象的 employeeId 赋值(实际上此时 employeeId
		 * 属性值已经存在) IV. 把栈顶对象的属性回显在表单中.
		 */
		return employee;
	}

	@Override
	public void prepare() throws Exception {
		System.out.println("prepare...");
	}

}
