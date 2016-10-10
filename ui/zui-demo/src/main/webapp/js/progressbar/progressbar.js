(function($) {
    //Main Method
    $.fn.reportprogress = function(val,maxVal) {            
        var max=100;
        if(maxVal)
            max=maxVal;
        return this.each(
            function(){        
                var div=$(this);
                var innerdiv=div.find(".progress");
                
                if(innerdiv.length!=1){                        
                    innerdiv=$("<div class='progress'></div>");                    
                    div.append("<div class='text'>&nbsp;</div>");
                    $("<span class='text'>&nbsp;</span>").css("width",div.width()).appendTo(innerdiv);                    
                    div.append(innerdiv);                    
                }
                var width=Math.round(val/max*100);
                innerdiv.css("width",width+"%");    
                div.find(".text").html(width+"%");
            }
        );
    };
})(jQuery);

var pct=0;
var handle=0;
function update(){
		$("#progressbar").reportprogress(++pct);
		if(pct==100){                                                //设定总长度值
			clearInterval(handle);
			pct=0;
		}
}
jQuery(function($){
	$(document).ready(
		function(){
			
				handle=setInterval("update()",100);               //设定增长的时间
		}
	);
});