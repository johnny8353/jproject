/**
 <b>zte.app</b>. 框架页面加载过程中的功能函数
*/

//document ready function
jQuery(function($) {
  try {
	zte.frame.init();
  } catch(e) {}
});

(function($ , undefined) {
	if( !('zte' in window) ) window['zte'] = {};
	
	zte.frame = {
		functions: {},
		
		init: function(initAnyway) {
			//initAnyway used to make sure the call is from our RequireJS app and not a document ready event!
			var initAnyway = !!initAnyway && true;
			if(typeof requirejs !== "undefined" && !initAnyway) return;
			
			for(var func in zte.frame.functions) if(zte.frame.functions.hasOwnProperty(func)) {
				zte.frame.functions[func]();
			}
		}
	};

	//根据权限数据,显示菜单
	zte.frame.functions.enableSidebar = function() {
		if($('#sidebar').length > 0){
			/*
			var menus = {};
			//从服务器接口获取用户菜单权限
			var ajax_params = {'url': 'test1.html', 'method' : 'POST', 'data': null,
					headers: {
			            "Accept" : "text/plain; charset=utf-8",
			            "Content-Type": "text/plain; charset=utf-8"
			        }
			};
	
			$.ajax(ajax_params)	
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
				
				//zte.notify.ShowInfo("菜单权限处理完成");
				//zte.notify.ShowError("错误信息测试");
			});
			*/
		}
	};
	
	//设置TAB页工作窗口高度,窗口大小变化的时候自动调整
	zte.frame.functions.resizeFrame = function() {
		if($('#navbar').length > 0 && $('#footer-content').length > 0 && $('#tab-list').length > 0 && $('#tab-content').length > 0){
			 $(window).resize(function(){
				 $('#tab-content').height( $(window).height() - $("#navbar").height() - parseInt($("#navbar").css("margin-bottom")) - parseInt($("#navbar").css("margin-top"))
						 - $("#footer-content").height() - parseInt($("#footer-content").css("margin-bottom")) - parseInt($("#footer-content").css("margin-top"))
						 - $("#tab-list").height() - parseInt($("#tab-list").css("margin-bottom")) - parseInt($("#tab-list").css("margin-top"))
			             - parseInt($('#tab-content').css("margin-bottom")) - parseInt($('#tab-content').css("margin-top"))
			             - 6
			    );  
			 })
			 $(window).resize();
		}
	};
	


})(jQuery);