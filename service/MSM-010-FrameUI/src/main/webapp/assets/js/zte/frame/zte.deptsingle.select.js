// 作者：李鑫 
// 组件名称：公司部门单选组件
(function($){
	var depts = new Array();
	$.fn.DeptSingleSelect = function () {     
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
	            	data.bo.deptName = query;
					zte.ajax.postUrl("/sysman/BasDepartment/getList.serv", data,
				              function(ret) {
						            depts = ret.bo;
	                                var arr = new Array();
	                                for (var i = 0; i < depts.length; i++){
	                                	arr.push(depts[i].deptCode + "");
	                                }                                                               
	                                process(arr);
					          });
					 },
				 matcher: function(item){
					 return true;
				 },
				 highlighter: function (deptCode) {
	                   return getDeptName(deptCode);
	             },
	             updater: function(deptCode){
	                   return getDeptName(deptCode);
	             }
	        });	    
        });
	};
	
	function getDeptName(deptCode){
		   var deptName = '';
		   for (var i=0; i<depts.length;i++){
			   if (depts[i].deptCode == deptCode){
				   deptName = depts[i].deptName;
				   break;
			   }
		   }
           return deptName;
	}
})(jQuery);