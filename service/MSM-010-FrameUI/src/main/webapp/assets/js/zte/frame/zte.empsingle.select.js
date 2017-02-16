// 作者：李鑫 
// 组件名称：公司员工单选组件
(function($){
	var users = new Array();
	$.fn.EmpSingleSelect = function () {     
        return this.each(function () {
        	var $this = $(this);
        	$this.typeahead({
	            hint: true,
	            highlight: true,
	            minLength: 1,
	            autoSelect: true,
	            source: function(query, process){
	            	data = {};
	            	data.bo = {};
	            	data.bo.employeeName = query;
					zte.ajax.postUrl("/sysman/BasEmployee/getList.serv", data,
				              function(ret) {
						            users = ret.bo;
	                                var arr = new Array();
	                                for (var i = 0; i < users.length; i++){
	                                	arr.push(users[i].employeeNo + "");
	                                }                                                               
	                                process(arr);
					          });
					 },
				 matcher: function(item){
					 return true;
				 },
				 highlighter: function (employeeNo) {
	                   return getUserName(employeeNo);
	             },
	             updater: function(employeeNo){
	                   return getUserName(employeeNo);
	             }
	        });	    
        });
	};
	
	function getUserName(employeeNo){
		   var userName = '';
		   for (var i=0; i<users.length;i++){
			   if (users[i].employeeNo == employeeNo){
				   userName = users[i].employeeName + users[i].employeeNo;
				   break;
			   }
		   }
           return userName;
	}
})(jQuery);