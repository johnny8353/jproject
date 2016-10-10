package com.johnny.activiti.k_personalTask02;

import java.io.InputStream;
import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
/**
说明：
1）	在类中使用delegateTask.setAssignee(assignee);的方式分配个人任务的办理人，此时张无忌是下一个任务的办理人
2）	通过processEngine.getTaskService().setAssignee(taskId, userId);将个人任务从一个人分配给另一个人，此时张无忌不再是下一个任务的办理人，而换成了周芷若
3）	在开发中，可以将每一个任务的办理人规定好，例如张三的领导是李四，李四的领导是王五，这样张三提交任务，就可以查询出张三的领导是李四，通过类的方式设置下一个任务的办理人

个人任务及三种分配方式：
    1：在taskProcess.bpmn中直接写 assignee=“张三丰"
    2：在taskProcess.bpmn中写 assignee=“#{userID}”，变量的值要是String的。
         使用流程变量指定办理人
    3，使用TaskListener接口，要使类实现该接口，在类中定义：
         delegateTask.setAssignee(assignee);// 指定个人任务的办理人
    
 使用任务ID和办理人重新指定办理人：
     processEngine.getTaskService()//
                           .setAssignee(taskId, userId);
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
		System.out.println("流程实例ID:"+pi.getId());//流程实例ID    101
		System.out.println("流程定义ID:"+pi.getProcessDefinitionId());//流程定义ID   helloworld:1:4
	}
	
	/**查询当前人的个人任务*/
	@Test
	public void findMyPersonalTask(){
		String assignee = "张翠山";
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
		String taskId = "5804";
		processEngine.getTaskService()//与正在执行的任务管理相关的Service
					.complete(taskId);
		System.out.println("完成任务：任务ID："+taskId);
	}
	
	//可以分配个人任务从一个人到另一个人（认领任务）
	@Test
	public void setAssigneeTask(){
		//任务ID
		String taskId = "104";
		//指定的办理人
		String userId = "张翠山";
		processEngine.getTaskService()//
					.setAssignee(taskId, userId);
	}

}
