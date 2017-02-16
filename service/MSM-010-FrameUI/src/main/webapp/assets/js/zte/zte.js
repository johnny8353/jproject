/**
 <b>zte.app</b>. Calls sidebar functions, demo ajax, some fixes, etc
*/

//document ready function
jQuery(function($) {
  try {
	zte.app.init();
  } catch(e) {}
});

(function($ , undefined) {
	if( !('zte' in window) ) window['zte'] = {};
	
	zte.app = {
		functions: {},
		
		init: function(initAnyway) {
			//initAnyway used to make sure the call is from our RequireJS app and not a document ready event!
			var initAnyway = !!initAnyway && true;
			if(typeof requirejs !== "undefined" && !initAnyway) return;
			
			for(var func in zte.app.functions) if(zte.app.functions.hasOwnProperty(func)) {
				zte.app.functions[func]();
			}
		}
	}
	

	//根据权限数据,显示菜单
	/*
	zte.app.functions.enableSidebar = function() {
		var menus = {};
		//从服务器接口获取用户菜单权限
		var ajax_params = {'url': 'test1.html', 'method' : 'POST', 'data': null,
				headers: {
		            "Accept" : "text/plain; charset=utf-8",
		            "Content-Type": "text/plain; charset=utf-8"
		        }
		};

		$.ajax(ajax_params)	
        //.beforeSend(function(jqXHR, settings) {
        //    jqXHR.setRequestHeader('Accept', 'text/plain; charset=utf-8');
        //    jqXHR.setRequestHeader('Content-Type', 'text/plain; charset=utf-8');
        //}),   
		.error(function() {
			
			//alert("error");
		})
		.done(function(result) {
			//alert(result);
			menus = ['menu_41','menu_42'];
			
			//根据菜单权限显示菜单
			for(var pos in menus){
				//找到菜单项元素和父菜单元素,替换为可见样式
		        var menu_li = $('#'+menus[pos]);
		        if(menu_li){
		        	menu_li.removeClass('hidden').parents('.nav-list li').removeClass('hidden');
		        	menu_li.addClass('show').parents('.nav-list li').addClass('show');
		        }
		       
			}
			
			zte.notify.ShowInfo("菜单权限处理完成");
			zte.notify.ShowError("错误信息测试");
		});
		
	}
	*/
	


})(jQuery);