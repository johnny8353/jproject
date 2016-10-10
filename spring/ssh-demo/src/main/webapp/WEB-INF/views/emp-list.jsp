<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- jQuery文件 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
	
	$(function(){
		//1. 点击 delete 时, 弹出 确定是要删除 xx 的信息吗 ? 若确定, 执行删除, 若不确定, 则取消
		$(".delete").click(function(){
			var lastName = $(this).next(":hidden").val();
			var flag = confirm("确定要删除" + lastName + "的信息吗?");
			if(flag){
				var $tr = $(this).parent().parent();
				//删除, 使用 ajax 的方式
				var url = this.href;
				var args = {"time":new Date()};
				$.post(url, args, function(data){
					//若 data 的返回值为 1, 则提示 删除成功, 且把当前行删除
					if(data == "1"){
						alert("删除成功!");
						$tr.remove();
					}else{
						//若 data 的返回值不是 1, 提示删除失败. 
						alert("删除失败!");
					}
				});	
			}
			
			//取消超链接的默认行为
			return false;
		});		
	})
	
</script>
</head>
<body>
	<a href="${pageContext.request.contextPath}/index.jsp">return index</a><br />
	<h4>Employee List Page</h4>
	
	<s:if test="#request.employees == null || #request.employees.size() == 0">
		没有任何员工信息
	</s:if>
	<s:else>
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td>ID</td>
				<td>LASTNAME</td>
				<td>EMAIL</td>
				<td>BIRTH</td>
				<td>CREATETIME</td>
				<td>DEPT</td>
				<td>DELETE</td>
				<td>EDIT</td>
			</tr>
			<s:iterator value="#request.employees">
				<tr>
					<td>${id }</td>
					<td>${lastName }</td>
					<td>${email }</td>
					<td>
						<s:date name="birth" format="yyyy-MM-dd"/>
					</td>
					<td>
						<s:date name="createTime" format="yyyy-MM-dd hh:mm:ss"/>
					</td>
					<td>${department.departmentName }</td>
					<td>
						<a href="emp-delete?id=${id }" class="delete">Delete</a>
						<input type="hidden" value="${lastName }"/>
					</td>
					<td>
						<a href="emp-input?id=${id }">Edit</a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</s:else>
		
</body>
</html>