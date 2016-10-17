package com.johnny.activiti.myfirst;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SayHelloToLeaveTest {
	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	RepositoryService repositoryService = processEngine.getRepositoryService();
	long begin = 0L;
	long end = 0L;

	@Before
	public void before() {
		begin = System.currentTimeMillis();
	}

	@After
	public void after() {
		end = System.currentTimeMillis();
		System.out.println("spend ---- " + (end - begin));
	}

	/** 部署流程定义  repositoryService.deploy() 
		1.starting SchemaOperationsProcessEngineBuild 查询版本
			==>  Preparing: select * from ACT_GE_PROPERTY where NAME_ = ? 
			==> Parameters: schema.version(String)
		2.starting DeployCmd
			①.starting GetNextIdBlockCmd
				==>  Preparing: select * from ACT_GE_PROPERTY where NAME_ = ? 
				==> Parameters: next.dbid(String)
				==>  Preparing: update ACT_GE_PROPERTY SET REV_ = ?, VALUE_ = ? where NAME_ = ? and REV_ = ? 
				==> Parameters: 12(Integer), 1101(String), next.dbid(String), 11(Integer)
			②.	
				==>  Preparing: select * from ACT_RE_PROCDEF where KEY_ = ? and (TENANT_ID_ = '' or TENANT_ID_ is null) 
				and VERSION_ = (select max(VERSION_) from ACT_RE_PROCDEF where KEY_ = ? and (TENANT_ID_ = '' or TENANT_ID_ is null)) 
				==> Parameters: SayHelloToLeave(String), SayHelloToLeave(String)
				
				==>  Preparing: select * from ACT_RU_JOB where HANDLER_TYPE_ = ? and HANDLER_CFG_ = ? 
				==> Parameters: timer-start-event(String), SayHelloToLeave(String)
				
				==>  Preparing: insert into ACT_RE_DEPLOYMENT(ID_, NAME_, CATEGORY_, TENANT_ID_, DEPLOY_TIME_) values(?, ?, ?, ?, ?) 
				==> Parameters: 1001(String), SayHelloToLeave(String), null, (String), 2016-10-13 12:47:35.161(Timestamp)
				
				==>  Preparing: insert into ACT_GE_BYTEARRAY(ID_, REV_, NAME_, BYTES_, DEPLOYMENT_ID_, GENERATED_) values (?, 1, ?, ?, ?, ?) 
				==> Parameters: 1002(String), SayHelloToLeave.bpmn(String), java.io.ByteArrayInputStream@16afba3(ByteArrayInputStream), 1001(String), false(Boolean)
				
				==>  Preparing: insert into ACT_GE_BYTEARRAY(ID_, REV_, NAME_, BYTES_, DEPLOYMENT_ID_, GENERATED_) values (?, 1, ?, ?, ?, ?) 
				==> Parameters: 1003(String), SayHelloToLeave.png(String), java.io.ByteArrayInputStream@13e2817(ByteArrayInputStream), 1001(String), false(Boolean)
				
				==>  Preparing: insert into ACT_RE_PROCDEF(ID_, REV_, CATEGORY_, NAME_, KEY_, VERSION_, DEPLOYMENT_ID_, RESOURCE_NAME_, DGRM_RESOURCE_NAME_, 
				DESCRIPTION_, HAS_START_FORM_KEY_, SUSPENSION_STATE_, TENANT_ID_) values (?, 1, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
				==> Parameters: SayHelloToLeave:1:1004(String), http://www.activiti.org/test(String), SayHelloToLeave(String), SayHelloToLeave(String), 
				1(Integer), 1001(String), SayHelloToLeave.bpmn(String), SayHelloToLeave.png(String), null, false(Boolean), 1(Integer), (String)
	 *  */
	@Test
	public void deploymentProcessDefinition() {
		InputStream inputStreamBpmn = this.getClass().getResourceAsStream(
				"SayHelloToLeave.bpmn");
		InputStream inputStreamPng = this.getClass().getResourceAsStream(
				"SayHelloToLeave.png");

		Deployment deployment = repositoryService// 与流程定义和部署对象相关的Service 
				.createDeployment()// 创建一个部署对象
				.name("SayHelloToLeave")// 添加部署的名称
				.addInputStream("SayHelloToLeave.bpmn", inputStreamBpmn)//
				.addInputStream("SayHelloToLeave.png", inputStreamPng)//
				.deploy();// 完成部署
		System.out.println("部署ID：" + deployment.getId());//
		System.out.println("部署名称：" + deployment.getName());//
	}

	/**
	 * 查询流程定义	    
	1.starting SchemaOperationsProcessEngineBuild 查询版本
		==>  Preparing: select * from ACT_GE_PROPERTY where NAME_ = ? 
		==> Parameters: schema.version(String)
		 
	==>  Preparing: select distinct RES.* from ACT_RE_PROCDEF RES WHERE RES.KEY_ = ? and RES.DEPLOYMENT_ID_ = ? order by RES.ID_ asc LIMIT ? OFFSET ? 
	==> Parameters: SayHelloToLeave(String), 301(String), 2147483647(Integer), 0(Integer)
	 */
	@Test
	public void testDefinition() {
		ProcessDefinition processDefinition = repositoryService
				.createProcessDefinitionQuery()
				.processDefinitionKey("SayHelloToLeave").deploymentId("301")
				.singleResult();
		assertEquals("SayHelloToLeave", processDefinition.getKey());
	}

	/** 
	  	启动流程runtimeService.startProcessInstanceByKey
		starting StartProcessInstanceCmd
	 		==>  Preparing: select * from ACT_RE_PROCDEF where KEY_ = ? and (TENANT_ID_ = '' or TENANT_ID_ is null) 
	 		and VERSION_ = (select max(VERSION_) from ACT_RE_PROCDEF where KEY_ = ? and (TENANT_ID_ = '' or TENANT_ID_ is null)) 
	 		==> Parameters: SayHelloToLeave(String), SayHelloToLeave(String)
	 		
	 		==>  Preparing: select * from ACT_RE_DEPLOYMENT where ID_ = ? 
	 		==> Parameters: 1001(String)
	 		
	 		==>  Preparing: select * from ACT_GE_BYTEARRAY where DEPLOYMENT_ID_ = ? order by NAME_ asc 
	 		==> Parameters: 1001(String)
	 		
	 		==>  Preparing: select * from ACT_RE_PROCDEF where DEPLOYMENT_ID_ = ? and KEY_ = ? and (TENANT_ID_ = '' or TENANT_ID_ is null) 
	 		==> Parameters: 1001(String), SayHelloToLeave(String)
	 		
	 	starting GetNextIdBlockCmd 
	 		==>  Preparing: select * from ACT_GE_PROPERTY where NAME_ = ? 
	 		==> Parameters: next.dbid(String)
	 		==>  Preparing: update ACT_GE_PROPERTY SET REV_ = ?, VALUE_ = ? where NAME_ = ? and REV_ = ? 
	 		==> Parameters: 14(Integer), 1301(String), next.dbid(String), 13(Integer)
	 	initializing ProcessInstance
	 		takes transition (startevent1)--flow1-->(usertask1)
	 	inserting: ProcessInstance[1201]	
	 		==>  Preparing: insert into ACT_RU_EXECUTION (ID_, REV_, PROC_INST_ID_, BUSINESS_KEY_, PROC_DEF_ID_, ACT_ID_, IS_ACTIVE_, IS_CONCURRENT_, IS_SCOPE_,IS_EVENT_SCOPE_, PARENT_ID_, SUPER_EXEC_, SUSPENSION_STATE_, CACHED_ENT_STATE_, TENANT_ID_) values ( ?, 1, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) 
	 		==> Parameters: 1201(String), 1201(String), null, SayHelloToLeave:1:1004(String), usertask1(String), true(Boolean), false(Boolean), true(Boolean), false(Boolean), null, null, 1(Integer), 2(Integer), (String)
	 	inserting: HistoricProcessInstanceEntity[superProcessInstanceId=null]	
	 		==>  Preparing: insert into ACT_HI_PROCINST ( ID_, PROC_INST_ID_, BUSINESS_KEY_, PROC_DEF_ID_, START_TIME_, END_TIME_, DURATION_, START_USER_ID_, START_ACT_ID_, END_ACT_ID_, SUPER_PROCESS_INSTANCE_ID_, DELETE_REASON_, TENANT_ID_ ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) 
	 		==> Parameters: 1201(String), 1201(String), null, SayHelloToLeave:1:1004(String), 2016-10-13 14:27:02.557(Timestamp), null, null, null, startevent1(String), null, null, null, (String)
	 	inserting: HistoricActivityInstanceEntity[activityId=startevent1, activityName=Start]
	 		==>  Preparing: insert into ACT_HI_ACTINST ( ID_, PROC_DEF_ID_, PROC_INST_ID_, EXECUTION_ID_, ACT_ID_, TASK_ID_, CALL_PROC_INST_ID_, ACT_NAME_, ACT_TYPE_, ASSIGNEE_, START_TIME_, END_TIME_, DURATION_, TENANT_ID_ ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) 
			==> Parameters: 1202(String), SayHelloToLeave:1:1004(String), 1201(String), 1201(String), startevent1(String), null, null, Start(String), startEvent(String), null, 2016-10-13 14:27:02.557(Timestamp), 2016-10-13 14:27:02.566(Timestamp), 9(Long), (String)
		inserting: VariableInstanceEntity[id=1203, name=applyUser, type=string, textValue=johnnyHuang黄福强]
			==>  Preparing: insert into ACT_RU_VARIABLE (ID_, REV_, TYPE_, NAME_, PROC_INST_ID_, EXECUTION_ID_, TASK_ID_, BYTEARRAY_ID_, DOUBLE_, LONG_ , TEXT_, TEXT2_) values ( ?, 1, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) 
			==> Parameters: 1203(String), string(String), applyUser(String), 1201(String), 1201(String), null, null, null, null, johnnyHuang黄福强(String), null
		inserting: HistoricVariableInstanceEntity[id=1203, name=applyUser, revision=0, type=string, textValue=johnnyHuang黄福强]
			==>  Preparing: insert into ACT_HI_VARINST (ID_, PROC_INST_ID_, EXECUTION_ID_, TASK_ID_, NAME_, REV_, VAR_TYPE_, BYTEARRAY_ID_, DOUBLE_, LONG_ , TEXT_, TEXT2_, CREATE_TIME_, LAST_UPDATED_TIME_) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) 
			==> Parameters: 1203(String), 1201(String), 1201(String), null, applyUser(String), 0(Integer), string(String), null, null, null, johnnyHuang黄福强(String), null, 2016-10-13 14:27:02.557(Timestamp), 2016-10-13 14:27:02.557(Timestamp)
		inserting: VariableInstanceEntity[id=1204, name=days, type=integer, longValue=3, textValue=3]
		inserting: HistoricVariableInstanceEntity[id=1204, name=days, revision=0, type=integer, longValue=3, textValue=3]
		inserting: HistoricActivityInstanceEntity[activityId=usertask1, activityName=领导审批]
			==>  Preparing: insert into ACT_HI_ACTINST ( ID_, PROC_DEF_ID_, PROC_INST_ID_, EXECUTION_ID_, ACT_ID_, TASK_ID_, CALL_PROC_INST_ID_, ACT_NAME_, ACT_TYPE_, ASSIGNEE_, START_TIME_, END_TIME_, DURATION_, TENANT_ID_ ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) 
			==> Parameters: 1405(String), SayHelloToLeave:1:1304(String), 1401(String), 1401(String), usertask1(String), 1406(String), null, 领导审批(String), userTask(String), 李四(String), 2016-10-13 15:04:13.26(Timestamp), null, null, (String)
		inserting: Task[id=1206, name=领导审批]
			==>  Preparing: insert into ACT_RU_TASK (ID_, REV_, NAME_, PARENT_TASK_ID_, DESCRIPTION_, PRIORITY_, CREATE_TIME_, OWNER_, ASSIGNEE_, DELEGATION_, EXECUTION_ID_, PROC_INST_ID_, PROC_DEF_ID_, TASK_DEF_KEY_, DUE_DATE_, CATEGORY_, SUSPENSION_STATE_, TENANT_ID_) values (?, 1, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) 
			==> Parameters: 1406(String), 领导审批(String), null, null, 50(Integer), 2016-10-13 15:04:13.26(Timestamp), null, 李四(String), null, 1401(String), 1401(String), SayHelloToLeave:1:1304(String), usertask1(String), null, null, 1(Integer), (String)
		inserting: org.activiti.engine.impl.persistence.entity.HistoricTaskInstanceEntity@6b653f
			==>  Preparing: insert into ACT_HI_TASKINST ( ID_, PROC_DEF_ID_, PROC_INST_ID_, EXECUTION_ID_, NAME_, PARENT_TASK_ID_, DESCRIPTION_, OWNER_, ASSIGNEE_, START_TIME_, CLAIM_TIME_, END_TIME_, DURATION_, DELETE_REASON_, TASK_DEF_KEY_, FORM_KEY_, PRIORITY_, DUE_DATE_, CATEGORY_, TENANT_ID_ ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) 
			==> Parameters: 1406(String), SayHelloToLeave:1:1304(String), 1401(String), 1401(String), 领导审批(String), null, null, null, 李四(String), 2016-10-13 15:04:13.261(Timestamp), null, null, null, null, usertask1(String), null, 50(Integer), null, null, (String)
		inserting: org.activiti.engine.impl.persistence.entity.HistoricIdentityLinkEntity@1985d31
			==>  Preparing: insert into ACT_RU_IDENTITYLINK (ID_, REV_, TYPE_, USER_ID_, GROUP_ID_, TASK_ID_, PROC_INST_ID_, PROC_DEF_ID_) values (?, 1, ?, ?, ?, ?, ?, ?) 
			==> Parameters: 1407(String), participant(String), 李四(String), null, null, 1401(String), null
			==>  Preparing: insert into ACT_HI_IDENTITYLINK (ID_, TYPE_, USER_ID_, GROUP_ID_, TASK_ID_, PROC_INST_ID_) values (?, ?, ?, ?, ?, ?) 
			==> Parameters: 1407(String), participant(String), 李四(String), null, null, 1401(String)
			
			==> Parameters: 1408(String), candidate(String), null, management(String), 1406(String), null
			==> Parameters: 1409(String), candidate(String), 张三(String), null, 1406(String), null, null
			==> Parameters: 1410(String), participant(String), 张三(String), null, null, 1401(String), null
	 * @throws Exception
	 */
	@Test
	public void testStartProcess() throws Exception {

		RuntimeService runtimeService = processEngine.getRuntimeService();

		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("applyUser", "johnnyHuang黄福强");
		variables.put("days", 3);

		ProcessInstance processInstance = runtimeService
				.startProcessInstanceByKey("SayHelloToLeave", variables);
		assertNotNull(processInstance);
		System.out.println("pid=" + processInstance.getId() + ", pdid="
				+ processInstance.getProcessDefinitionId());
//
//		TaskService taskService = processEngine.getTaskService();
//		Task taskOfDeptLeader = taskService.createTaskQuery()
//				.taskCandidateGroup("deptLeader").singleResult();
//		assertNotNull(taskOfDeptLeader); 
//		assertEquals("领导审批", taskOfDeptLeader.getName());
//
//		taskService.claim(taskOfDeptLeader.getId(), "leaderUser");
//		variables = new HashMap<String, Object>();
//		variables.put("approved", true);
//		taskService.complete(taskOfDeptLeader.getId(), variables);
//
//		taskOfDeptLeader = taskService.createTaskQuery()
//				.taskCandidateGroup("deptLeader").singleResult();
//		assertNull(taskOfDeptLeader);
//
//		HistoryService historyService = processEngine.getHistoryService();
//		long count = historyService.createHistoricProcessInstanceQuery()
//				.finished().count();
//		assertEquals(1, count);
	}
	
	/**
	 * 查询当前人的个人任务
	 ==>  Preparing: select distinct RES.* from ACT_RU_TASK RES WHERE RES.ASSIGNEE_ = ? order by RES.CREATE_TIME_ asc LIMIT ? OFFSET ? 
	 ==> Parameters: 李四(String), 2147483647(Integer), 0(Integer)
	 * */
	@Test
	public void findMyPersonalTask(){
		String assignee = "李四";
		List<Task> list = processEngine.getTaskService()//与正在执行的任务管理相关的Service
						.createTaskQuery()//创建任务查询对象
						/**查询条件（where部分）*/
						.taskAssignee(assignee)//指定个人任务查询，指定办理人
//						.taskCandidateUser(candidateUser)//组任务的办理人查询
//						.processDefinitionId(processDefinitionId)//使用流程定义ID查询
//						.processInstanceId(processInstanceId)//使用流程实例ID查询
//						.executionId(executionId)//使用执行对象ID查询
						/**排序*/
						.orderByTaskCreateTime().asc()//使用创建时间的升序排列
						/**返回结果集*/
//						.singleResult()//返回惟一结果集
//						.count()//返回结果集的数量
//						.listPage(firstResult, maxResults);//分页查询
						.list();//返回列表
		TaskService taskService = processEngine.getTaskService();
		if(list!=null && list.size()>0){
			for(Task task:list){
//				Task '1406' is already claimed by someone else.没有分配才需要进行认领
//				taskService.claim(task.getId(), "johnny");
				System.out.println("任务ID:"+task.getId());
				System.out.println("任务名称:"+task.getName());
				System.out.println("任务的创建时间:"+task.getCreateTime());
				System.out.println("任务的办理人:"+task.getAssignee());
				System.out.println("流程实例ID："+task.getProcessInstanceId());
				System.out.println("执行对象ID:"+task.getExecutionId());
				System.out.println("流程定义ID:"+task.getProcessDefinitionId());
				System.out.println("########################################################");
			}
		}
	}
	
	@Test
	public void testCompleteTask(){
		Map<String, Object> variables = new HashMap<String, Object>();
		TaskService taskService = processEngine.getTaskService();
		Task task = taskService.createTaskQuery().executionId("1801").singleResult();
		variables = new HashMap<String, Object>();
		variables.put("approved", true);
		taskService.complete(task.getId(), variables);
	}
	
	/**
	 * 查询已完成的任务
	 *  ==>  Preparing: select count(distinct RES.ID_) from ACT_HI_PROCINST RES WHERE RES.END_TIME_ is not NULL 
	 */
	@Test
	public void testFindFinishedTask(){
		HistoryService historyService = processEngine.getHistoryService();
		long count = historyService.createHistoricProcessInstanceQuery()
				.finished().count();
		System.out.println(count);
	}
	
	
	
}