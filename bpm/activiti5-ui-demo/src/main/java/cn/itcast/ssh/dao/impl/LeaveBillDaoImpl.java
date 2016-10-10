package cn.itcast.ssh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import cn.itcast.ssh.dao.ILeaveBillDao;
import cn.itcast.ssh.domain.Employee;
import cn.itcast.ssh.domain.LeaveBill;
import cn.itcast.ssh.utils.SessionContext;

public class LeaveBillDaoImpl extends BaseDao implements ILeaveBillDao {

	/**查询自己的请假单的信息*/
	@Override
	public List<LeaveBill> findLeaveBillList() {
		//从Session中获取当前用户
		Employee employee = SessionContext.get();
		String hql = "from LeaveBill o where o.user=?";//指定当前用户的请假单
		Query query = this.getSession().createQuery(hql);
		query.setEntity(0, employee);
		List<LeaveBill> list = query.list();
		List<LeaveBill> leaveBillList = new ArrayList<>();
//		List<Object> list = this.getHibernateTemplate().find(hql,employee);
//		for (int i = 0; i < list.size(); i++) {
//			leaveBillList.add((LeaveBill) list.get(i));
//		}
		return list;
	}
	
	/**保存请假单*/
	@Override
	public void saveLeaveBill(LeaveBill leaveBill) {
		this.getSession().save(leaveBill);
	}
	
	/**使用请假单ID，查询请假单的对象*/
	@Override
	public LeaveBill findLeaveBillById(Long id) {
		return (LeaveBill) this.getSession().get(LeaveBill.class, id);
	}
	
	/**更新请假单*/
	@Override
	public void updateLeaveBill(LeaveBill leaveBill) {
		this.getSession().update(leaveBill);
	}
	
	/**使用请假单ID，删除请假单*/
	@Override
	public void deleteLeaveBillById(Long id) {
		//2：使用请假单ID，查询请假单信息，获取对象LeaveBill
		LeaveBill bill = this.findLeaveBillById(id);
		//3：执行删除
		this.getSession().delete(bill);
	}
}
