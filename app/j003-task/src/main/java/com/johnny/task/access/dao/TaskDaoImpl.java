package com.johnny.task.access.dao;

import org.springframework.stereotype.Repository;

import com.johnny.common.access.dao.HibernateBaseDaoImpl;
import com.johnny.task.access.vo.TaskVO;
@Repository
public class TaskDaoImpl extends HibernateBaseDaoImpl<TaskVO> implements TaskDao {

}
