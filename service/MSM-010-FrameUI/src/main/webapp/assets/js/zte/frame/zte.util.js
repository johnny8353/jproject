/**
 <b>zte.app</b>. Calls sidebar functions, demo ajax, some fixes, etc
*/

(function($ , undefined) {
  if( !('zte' in window) ) window['zte'] = {};
  
  
  zte.util = {
      
    //处理日期时间字符串,取出日期
    getDateStr: function(dateTimeStr) {
    	var dateStr = null;
    	if(dateTimeStr != null){
    		var pos = dateTimeStr.indexOf(' ');
    		if(pos >=0 ){
    			dateStr = dateTimeStr.substring(0,pos);
    		}
    		else{
    			dateStr = dateTimeStr;
    		}
    	}
    	
    	return dateStr;
    },
    
    
    //处理日期字符串,返回日期时间字符串
    getDateTimeStr: function(dateStr) {
    	var dateTimeStr = null;
    	if(dateStr != null){
    		dateTimeStr = dateStr + ' 12:00:00'
    	}
    	
    	return dateTimeStr;
    }
    
    
  };
    
})(jQuery);