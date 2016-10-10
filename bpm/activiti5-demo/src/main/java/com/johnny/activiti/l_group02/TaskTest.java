package com.johnny.activiti.l_group02;

import java.io.InputStream;
import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricIdentityLink;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;
import org.junit.Test;
/**
 说明：
1）	在类中使用delegateTask.addCandidateUser (userId);的方式分配组任务的办理人，此时孙悟空和猪八戒是下一个任务的办理人。
2）	通过processEngine.getTaskService().claim (taskId, userId);将组任务分配给个人任务，也叫认领任务，即指定某个人去办理这个任务，此时由如来去办理任务。
注意：认领任务的时候，可以是组任务成员中的人，也可以不是组任务成员的人，此时通过Type的类型为participant来指定任务的办理人
3）	addCandidateUser()即向组任务添加成员，deleteCandidateUser()即删除组任务的成员。
4）	在开发中，可以将每一个任务的办理人规定好，例如张三的领导是李四和王五，这样张三提交任务，由李四或者王五去查询组任务，
可以看到对应张三的申请，李四或王五再通过认领任务（claim）的方式，由某个人去完成这个任务。

组任务及三种分配方式：
    1：在taskProcess.bpmn中直接写 candidate-users=“小A,小B,小C,小D"
    2：在taskProcess.bpmn中写 candidate-users =“#{userIDs}”，变量的值要是String的。
         	使用流程变量指定办理人
              Map<String, Object> variables = new HashMap<String, Object>();
              variables.put("userIDs", "大大,小小,中中");
    3，使用TaskListener接口，使用类实现该接口，在类中定义：
        //添加组任务的用户
		delegateTask.addCandidateUser(userId1);
		delegateTask.addCandidateUser(userId2);
		组任务分配给个人任务（认领任务）：
		     processEngine.getTaskService().claim(taskId, userId);
		个人任务分配给组任务：
		     processEngine.getTaskService().setAssignee(taskId, null);
		向组任务添加人员：
		     processEngine.getTaskService().addCandidateUser(taskId, userId);
		向组任务删除人员：
		     processEngine.getTaskService().deleteCandidateUser(taskId, userId);
		     
个人任务和组任务存放办理人对应的表：
act_ru_identitylink表存放任务的办理人，包括个人任务和组任务，表示正在执行的任务
act_hi_identitylink表存放任务的办理人，包括个人任务和组任务，表示历史任务
区别在于：如果是个人任务TYPE的类型表示participant（参与者）
		 如果是组任务TYPE的类型表示candidate（候选者）和participant（参与者）

 *
 */
public class TaskTest {

	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	
	/**部署流程定义（从inputStream）*/
	@Test
	public void deploymentProcessDefinition_inputStream(){
		InputStream inputStreamBpmn = this.getClass().getResourceAsStream("task.bpmn");
		InputStream inputStreamPng = this.getClass().getResourceAsStream("task.png");
		Deployment deployment = processEngine.getRepositoryService()//与流程定义和部署对象相关的Service
						.createDeployment()//创建一个部署对象
						.name("任务")//添加部署的名称
						.addInputStream("task.bpmn", inputStreamBpmn)//
						.addInputStream("task.png", inputStreamPng)//
						.deploy();//完成部署
		System.out.println("部署ID："+deployment.getId());//
		System.out.println("部署名称："+deployment.getName());//
	}
	
	/**启动流程实例*/
	@Test
	public void startProcessInstance(){
		//流程定义的key
		String processDefinitionKey = "task";
		ProcessInstance pi = processEngine.getRuntimeService()//与正在执行的流程实例和执行对象相关的Service
						.startProcessInstanceByKey(processDefinitionKey);//使用流程定义的key启动流程实例，key对应helloworld.bpmn文件中id的属性值，使用key值启动，默认是按照最新版本的流程定义启动
		System.out.println("流程实例ID:"+pi.getId());//流程实例ID  
		System.out.println("流程定义ID:"+pi.getProcessDefinitionId());//流程定义ID   
	}
	
	/**查询当前人的个人任务*/
	@Test
	public void findMyPersonalTask(){
		String assignee = "郭靖";
		List<Task> list = processEngine.getTaskService()//与正在执行的任务管理相关的Service
						.createTaskQuery()//创建任务查询对象
						/**查询条件（where部分）*/
						.taskAssignee(assignee)//指定个人任务查询，指定办理人
//						.taskCandidateUser(candidateUser)//组任务的办理人查询
						/**排序*/
						.orderByTaskCreateTime().asc()//使用创建时间的升序排列
						/**返回结果集*/
						.list();//返回列表
		if(list!=null && list.size()>0){
			for(Task task:list){
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
	
	/**查询当前人的组任务*/
	@Test
	public void findMyGroupTask(){
		String candidateUser = "郭靖";
		List<Task> list = processEngine.getTaskService()//与正在执行的任务管理相关的Service
						.createTaskQuery()//创建任务查询对象
						/**查询条件（where部分）*/
						.taskCandidateUser(candidateUser)//组任务的办理人查询
						/**排序*/
						.orderByTaskCreateTime().asc()//使用创建时间的升序排列
						/**返回结果集*/
						.list();//返回列表
		if(list!=null && list.size()>0){
			for(Task task:list){
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
	
	/**完成我的任务*/
	@Test
	public void completeMyPersonalTask(){
		//任务ID
		String taskId = "7204";
		processEngine.getTaskService()//与正在执行的任务管理相关的Service
					.complete(taskId);
		System.out.println("完成任务：任务ID："+taskId);
	}
	
	
	/**查询正在执行的任务办理人表*/
	@Test
	public void findRunPersonTask(){
		//任务ID
		String taskId = "6204";
		List<IdentityLink> list = processEngine.getTaskService()//
					.getIdentityLinksForTask(taskId);
		if(list!=null && list.size()>0){
			for(IdentityLink identityLink:list){
				System.out.println(identityLink.getTaskId()+"   "+identityLink.getType()+"   "+identityLink.getProcessInstanceId()+"   "+identityLink.getUserId());
			}
		}
	}
	/**查询历史任务的办理人表*/
	@Test
	public void findHistoryPersonTask(){
		//流程实例ID
		String processInstanceId = "6201";
		List<HistoricIdentityLink> list = processEngine.getHistoryService()//
						.getHistoricIdentityLinksForProcessInstance(processInstanceId);
		if(list!=null && list.size()>0){
			for(HistoricIdentityLink identityLink:list){
				System.out.println(identityLink.getTaskId()+"   "+identityLink.getType()+"   "+identityLink.getProcessInstanceId()+"   "+identityLink.getUserId());
			}
		}
	}
	
	
	/**拾取任务，将组任务分给个人任务，指定任务的办理人字段*/
	@Test
	public void claim(){
		//将组任务分配给个人任务
		//任务ID
		String taskId = "7204";
		//分配的个人任务（可以是组任务中的成员，也可以是非组任务的成员）
		String userId = "郭靖";
		processEngine.getTaskService()//
					.claim(taskId, userId);
	}
	
	
	/**将个人任务回退到组任务，前提，之前一定是个组任务*/
	@Test
	public void setAssigee(){
		//任务ID
		String taskId = "6204";
		processEngine.getTaskService()//
					.setAssignee(taskId, null);
	}
	
	/**向组任务中添加成员*/
	@Test
	public void addGroupUser(){
		//任务ID
		String taskId = "6204";
		//成员办理人
		String userId = "大H";
		processEngine.getTaskService()//
					.addCandidateUser(taskId, userId);
	}
	
	/**从组任务中删除成员*/
	@Test
	public void deleteGroupUser(){
		//任务ID
		String taskId = "6204";
		//成员办理人
		String userId = "小B";
		processEngine.getTaskService()//
					.deleteCandidateUser(taskId, userId);
	}
	
}
