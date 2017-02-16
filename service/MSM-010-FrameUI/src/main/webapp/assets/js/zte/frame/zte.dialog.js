/**
 <b>zte.app</b>. Calls sidebar functions, demo ajax, some fixes, etc
*/

(function($ , undefined) {
	if( !('zte' in window) ) window['zte'] = {};
  	
  	zte.dialog = {
  	    
  	  dlgHtmlStr:'<div id="zteModal" class="modal fade">\
  	      <div class="modal-dialog" >\
            <div class="modal-content">\
              <div class="modal-header">\
                <button type="button" class="close"\
                   data-dismiss="modal" aria-hidden="true">\
                      &times;\
                </button>\
                <h4 id="zteModalLabel" class="modal-title widget-header-blue">\
                                               标题\
                </h4>\
              </div>\
              <div class="modal-body">\
                  <iframe id="zteModalIframe" width="100%" height="100%" frameborder="0" ></iframe>\
              </div>\
             </div>\
  		    </div>\
  		  </div>',
  		  
  		confirmHtmlStr:'<div id="zteConfirm" class="modal fade">\
	  			<div class="modal-dialog modal-sm" >\
		  			<div class="modal-content">\
			  			<div class="modal-header">\
				  			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">\
				  			&times;\
				  			</button>\
				  			<h4 id="zteModalLabel" class="modal-title widget-header-blue">\
				  			标题\
				  			</h4>\
			  			</div>\
			  			<div class="modal-body">\
			  				<p>内容</p>\
			  			</div>\
			  			<div class="modal-footer">\
				  			<button id="zteConfirmButton" type="button" class="btn btn-sm btn-primary">确认</button>\
				  			<button type="button" class="btn btn-sm btn-default" data-dismiss="modal">关闭</button>\
			  			</div>\
		  			</div>\
	  			</div>\
  			</div>',
  			
  		//显示基于IFRAME的对话框
  		ShowDlg: function(dlgTitle,frameSrc,busiFunc,frameCss,dlgCss){ 		  
  		    //如果页面没有DOM元素，则插入DOM
  		    if($('#zteModal').length <=0){
	  		    $("body").append(this.dlgHtmlStr);   
	  		    //监听关闭事件
	  		    $('#zteModal').on('hidden.bs.modal', function (e) {
	  		      $("#zteModalIframe").attr("src", "");
	  		      if(busiFunc != null){
	  		    	busiFunc();
	  		      }
	  		    });
  		    }
	  		  
	        $("#zteModalIframe").attr("src", frameSrc);
	        $('#zteModal').modal({ show: true, backdrop: 'static' });
	        //var scrollTop = $(document).scrollTop();
	        //60是dialog缺省样式的margin的宽度
	        var wHeight = $(window).height() - 60;
	        var wWidth = $(window).width()  - 60;
	        
	        var this_height, this_width;
	        if(dlgCss&&dlgCss["height"])
	          this_height=dlgCss["height"];
	        else
	          this_height= (wHeight>620)?620:wHeight;
	        
	        if(dlgCss&&dlgCss["width"])
	          this_width=dlgCss["width"];
	        else
	          this_width= (wWidth>800)?800:wWidth;
	        
	        var this_top=(wHeight-this_height)/2;
	        //var this_top=(wHeight-this_height)/2+"px";
	
	        var myDlgCss=dlgCss||{"width":this_width+"px","height":this_height+"px","top":this_top+"px"};
	        var myFrameCss=frameCss||{};//iframe样式
	        $('#zteModal .modal-dialog').css(myDlgCss).find('.modal-content').css({height: '100%',width: '100%'}).find('h4').html(dlgTitle||"").end().find('.modal-body').css({height: '88%',padding: '0px'}).find("#zteModalIframe").css(myFrameCss);

  		},
  		
  		//显示错误信息
  		CloseDlg: function() {
  			if($('#zteModal').length > 0){
  			 $('#zteModal').modal('hide');
  			}
  		},
  		
  		//显示确认对话框
  		ShowConfirmDlg: function(title,content,busiFunc){ 		  
  		    //如果页面没有DOM元素，则插入DOM
  		    if($('#zteConfirm').length <=0){
	  		    $("body").append(this.confirmHtmlStr);   
	  		    //监听确认事件
	  		    $('#zteConfirmButton').on('click', function (e) {  	
	  		    	$('#zteConfirm').modal('hide');
	  		        if(busiFunc != null){
	  		        	busiFunc();
	  		        }
	  		    });
  		    }
	  		        
	        $('#zteConfirm').modal({ show: true, backdrop: 'static' });
	        //var scrollTop = $(document).scrollTop();
	        //60是dialog缺省样式的margin的宽度
	        var wHeight = $(window).height() - 60;
	        var wWidth = $(window).width()  - 60;
	        
	        var this_height, this_width;	        
	        this_height= (wHeight>220)?220:wHeight;
	        this_width= (wWidth>300)?300:wWidth;
	        
	        var this_top=(wHeight-this_height)/2;
	        //var this_top=(wHeight-this_height)/2+"px";
	
	        var myDlgCss={"top":this_top+"px"};
	        $('#zteConfirm .modal-dialog').css(myDlgCss).find('.modal-content').find('h4').html(title||"").end().find('p').html(content||"");
  		},
  		
  	}

})(jQuery);