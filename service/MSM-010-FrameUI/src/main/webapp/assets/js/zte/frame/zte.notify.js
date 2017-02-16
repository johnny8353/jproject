/**
 <b>zte.app</b>. Calls sidebar functions, demo ajax, some fixes, etc
*/

(function($ , undefined) {
	if( !('zte' in window) ) window['zte'] = {};
	
	if(top != null && top['zte'] != null && (top['zte'].notify != null)){
	  //如果顶层窗口已创建该服务，则直接引用该服务对象
	  zte.notify = top['zte'].notify;
	}
	else{
  	Date.prototype.format = function(format){ 
  		var o = { 
    		"M+" : this.getMonth()+1, //month 
    		"d+" : this.getDate(), //day 
    		"h+" : this.getHours(), //hour 
    		"m+" : this.getMinutes(), //minute 
    		"s+" : this.getSeconds(), //second 
    		"q+" : Math.floor((this.getMonth()+3)/3), //quarter 
    		"S" : this.getMilliseconds() //millisecond 
  		};
  
  		if(/(y+)/.test(format)) { 
  		  format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
  		} 
  
  		for(var k in o) { 
    		if(new RegExp("("+ k +")").test(format)) { 
    		  format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length)); 
    		} 
  		} 
  		return format; 
  	};
  	
  	
  	zte.notify = {
  			
  		//显示提示信息
  		ShowInfo: function(msg) {
  			var text = zte.notify.getInfoText(msg);			
  			var n = noty({
                  text        : text,
                  type        : 'information',
                  dismissQueue: false,
                  layout      : 'bottomRight',
                  closeWith   : ['click'],
                  theme       : 'relax',
                  timeout     : 5000,
                  maxVisible  : 3,
                  animation   : {
                      open  : 'animated bounceInRight',
                      close : 'animated bounceOutRight',
                      easing: 'swing',
                      speed : 500
                  }
              });
              //console.log('html: ' + n.options.id);
  		},
  		
  		//显示错误信息
  		ShowError: function(msg) {
  			var text = zte.notify.getErrorText(msg);	
  			var n = noty({
                  text        : text,
                  type        : 'error',
                  dismissQueue: false,
                  layout      : 'bottomRight',
                  closeWith   : ['click'],
                  theme       : 'relax',
                  maxVisible  : 3,
                  animation   : {
                      open  : 'animated bounceInRight',
                      close : 'animated bounceOutRight',
                      easing: 'swing',
                      speed : 500
                  }
              });
              //console.log('html: ' + n.options.id);
  		},
  		
      //分析服务器返回对象，显示执行结果
  		ShowResult: function(ret,msg) {
    	   //框架能识别的返回编码,包括成功和异常
  			var text = (msg == null)?"":(msg+", ");
          if (ret != null && ret.code != null) {
              if (ret != null && ret.code != null && ret.code.code != '0000') {
                //服务器端返回失败对象
            	var bomsg = "";
            	if(ret.bo != null) bomsg = JSON.stringify(ret.bo);
                this.ShowError(text + "服务器异常," + ret.code.msg + ":" + bomsg);
              }else{
                //服务器端返回成功对象
            	this.ShowInfo(text + "服务器操作成功!");
              }
          } else {
              //其他异常
              ShowError(text + "操作发生错误，未获取到服务器端封装对象");
          }
      },
      
  		getInfoText: function(msg) {
  			var now = new Date(); 
  			var nowStr = now.format("yyyy-MM-dd hh:mm:ss"); 
  			var text = '<div class="activity-item"> <i class="fa fa-shopping-cart text-success"></i> <div class="activity"> ' + msg + ' <span>' + nowStr + '</span> </div> </div>';;
  			return text;
  		},
  		
  		getErrorText: function(msg) {
  			var date = new Date(); 
  			var datestr = date.format("yyyy-MM-dd hh:mm:ss"); 
  			var text = '<div class="activity-item"> <i class="fa fa-shopping-cart text-danger"></i> <div class="activity"> ' + msg + ' <span>' + datestr + '</span> </div> </div>';;
  			return text;
  		},
  		
  	}
	}

})(jQuery);