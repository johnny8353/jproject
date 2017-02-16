/**
 <b>zte.app</b>. Calls sidebar functions, demo ajax, some fixes, etc
*/

//document ready function
jQuery(function($) {


});

	

(function($ , undefined) {
	if( !('zte' in window) ) window['zte'] = {};
	
	
	// 请求webapi服务地址
	if (zte.url == null){
		zte.url = {};		
		// 设置webapi服务访问地址
		var root = "http://localhost:8091/";
		//var root = "http://10.89.208.188/";
		//部署的webapi服务上下文,需要根据业务系统实际情况修改
		var rootContext ="frame"
		
		// 设置webapi服务根地址
	    zte.url.root = root + rootContext;
		
		// 设置webapi服务上下文
		zte.url.rootContext = rootContext;
	}

	//web storage封装
	zte.storage = {
			
			putjson:function(key,data){
				//data参数是JSON数据,构造结构如下
				//var data = {id:0};  
	            //使用sessionStorage传参
	            sessionStorage[key] = JSON.stringify(data);
			},
			
			getjson:function(key){
				//获取列表界面设置的参数
				var str = sessionStorage[key];
				if(str != null)
					return jQuery.parseJSON(str); 	
				else
					return null;
			}
	};
	
	//令牌身份认证对象。
	//先尝试从本地缓存中获取身份信息,如果没有则创建一个缺省的对象
	if(zte.user == null){
		zte.user = zte.storage.getjson("ZTELonginUser");
	};
	if(zte.user == null){
		zte.user = {    
		    //是否上传令牌进行身份认证由客户端控制，
		    //服务器端对接口调用进行权限控制，如果客户端无身份认证，则服务器端权限验证无法通过，这样不会有安全漏洞		    
		    //定义常量
		    Consts : {
		          'NeedAuthToken':true,  //是否做令牌验证全局开关
		          'HTTP_HEADER_X_AUTH_FLAG':'X-Auth-Flag', //是否令牌验证的HTTP头
		          'HTTP_HEADER_X_AUTH_VALUE':'X-Auth-Value' //存放令牌数据验证的HTTP头
		    },
		    
		    //登陆相关变量
		    isLogin : false,  //是否登陆成功
		    token : '',  //登陆成功后从服务器获取的身份令牌
		    loginUser : null,  //登陆成功后从服务器获取的用户详细信息对象
		    orgId : '' // 当前组织ID
		};
	};
	
	//组织对象
	zte.org = {
			//定义常量
			Consts: {
				'HTTP_HEADER_X_ORG_ID':'X-Org-Id' // 组织ID
			}
	}
	
	//多语言对象。
	zte.lang = {    
	    
      //定义常量
      Consts : {
        'NeedLangId':true,  //是否上传多语言ID全局开关
        'HTTP_HEADER_X_LANG_ID':'X-Lang-Id',  //存放多语言ID的HTTP头
        'ZH':{lang : 'zh', langId : '2052'},  //中文常量
        'EN':{lang : 'en', langId : '1033'},  //英文常量
        'LocaleKey':'Frame-Lang'  //本地多语言标志KEY
      },
      
      
      //获取客户端多语言设置
      getLang:function(){
    	  //缺省为中文
    	  var lang = this.Consts.ZH;
    	  
    	  //从sessionStorage中获取语言设置
    	  var str = sessionStorage[this.Consts.LocaleKey];
    	  if(str != null){
    		  lang = jQuery.parseJSON(str);
    	  }
    	  
		  return lang;
	  },
		
	  //设置客户端多语言
      setLang:function(localestr){
    	  //缺省为中文
    	  var lang = this.Consts.ZH;
    	  if('en' == localestr || 'EN' == localestr){
    		  lang = this.Consts.EN;
    	  }
    	  
    	  //把多语言保存到sessionStorage中,所有页面可以共用
    	  sessionStorage[this.Consts.LocaleKey] = JSON.stringify(lang);
	  }

	};
	
	//日期格式化函数
	zte.date = {
			
			format:function (date, format){
			    //date = new Date();
			    var map = {
			        "yy": date.getYear(),
			        "M": date.getMonth() + 1, //月份
			        "d": date.getDate(), //日
			        "h": date.getHours(), //小时
			        "m": date.getMinutes(), //分
			        "s": date.getSeconds(), //秒  
			        "q": Math.floor((date.getMonth() + 3) / 3), //季度
			        "S": date.getMilliseconds() //毫秒
			    };

			    format = format.replace(/([yMdhmsqS])+/g, function(all, t){
			        var v = map[t];
			        if (v !== undefined) {
			            if (all.length > 1) {
			                v = "0" + v;
			                v = v.substr(v.length - 2);
			            }
			            return v;
			        }
			        else if (t === "y") {
			            return (date.getFullYear() + "").substr(4 - all.length);
			        }
			        return all;
			    });
			    return format;
			}
			 
	}
  
	//JQUERY DATATABLE相关配置
	zte.datatable = { 
		  
	};
	//JQUERY DATATABLE语言资源
	zte.datatable.lang = {    
	  "aLengthMenu": [[10, 20, 50, 100,-1],[10,20,50,100, "全部"]],
	  "oLanguage": {   
		  "sProcessing":   "处理中...",
			"sLengthMenu":   "显示 _MENU_ 项结果",
			"sZeroRecords":  "没有匹配结果",
			"sInfo":         "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
			"sInfoEmpty":    "显示第 0 至 0 项结果，共 0 项",
			"sInfoFiltered": "(由 _MAX_ 项结果过滤)",
			"sInfoPostFix":  "",
			"sSearch":       "搜索:",
			"sUrl":          "",
			"sEmptyTable":     "表中数据为空",
			"sLoadingRecords": "载入中...",
			"sInfoThousands":  ",",
			"oPaginate": {
				"sFirst":    "首页",
				"sPrevious": "上页",
				"sNext":     "下页",
				"sLast":     "末页"
			},
			"oAria": {
				"sSortAscending":  ": 以升序排列此列",
				"sSortDescending": ": 以降序排列此列"
			}        
	   }
	};
	//JQUERY DATATABLE 按钮定义
	zte.datatable.buttons = {
		buttons: [       
		  {
			"extend": "colvis",
			"text": "<i class='fa fa-search bigger-110 blue'></i> <span class='hidden'>显示隐藏字段</span>",
			"className": "btn btn-white btn-primary btn-bold",
			columns: ':not(:first)'
			//columns: ':not(:first):not(:last)'
		  },
		  {
			"extend": "copy",
			"text": "<i class='fa fa-copy bigger-110 pink'></i> <span class='hidden'>拷贝到剪贴板</span>",
			"className": "btn btn-white btn-primary btn-bold"
		  },
		  {
			"extend": "csv",
			"text": "<i class='fa fa-database bigger-110 orange'></i> <span class='hidden'>导出CSV文件</span>",
			"className": "btn btn-white btn-primary btn-bold"
		  },
		  {
			"extend": "excel",
			"text": "<i class='fa fa-file-excel-o bigger-110 green'></i> <span class='hidden'>导出excel</span>",
			"className": "btn btn-white btn-primary btn-bold"
		  },
		  {
			"extend": "pdf",
			"text": "<i class='fa fa-file-pdf-o bigger-110 red'></i> <span class='hidden'>导出PDF</span>",
			"className": "btn btn-white btn-primary btn-bold"
		  },
		  {
			"extend": "print",
			"text": "<i class='fa fa-print bigger-110 grey'></i> <span class='hidden'>打印</span>",
			"className": "btn btn-white btn-primary btn-bold",
			autoPrint: false,
			message: 'This print was produced using the Print button for DataTables'
		  }		  
		]
	};
  
  // jquery 按钮数据初始化
  zte.control = {
	  
	  /** 初始下拉列表
	   ** settings 配置参数 json格式
	   ** settings --> selector 选择器
	   ** settings --> data 绑定源数据 json格式
	   ** settings --> verifyData 校验数据
	   ** settings --> code
	   ** settings --> name  options 对应的名称
	   ** settings --> value options 对应的value
	   ** settings --> verifValue
	   ** settings --> isNameVal true:同时显示Name和Value,false:只显示name
	   **/
	  slt:function(settings)
	  {   
		  if(settings == null ) return; 
		  // $(settings.selector).append("<option value=''>..请选择..</option>");
		  
		  var name  = settings.name;
		  var code 	= settings.code;
		  var value = settings.value;
		  var data 	= settings.data;
		  var verifValue = settings.verifValue;
		  if(data == null ) return ;
		  var verifyData =  settings.verifyData;
		  if(verifyData == null ) verifyData = {} ;
		 
		  var html="";
		  for (var i = 0; i < data.length; i++) 
		  {
		   	  html +="<option title='"+ data[i][value]+ "'";
			  for (var j = 0 ; j< verifyData.length; j++)
			  {
				  if(data[i][value] == verifyData[j][verifValue])
				  {
					   html += " selected ='selected'";
				  }
			  }
			  
			  if(settings.isNameVal) html +=" value='" + data[i][value] + "'>"+data[i][name]+'&nbsp;'+data[i][code];
			  else html +=" value='" + data[i][value]+ "'>"+data[i][name];

			  html +=" </option>";
			  ///alert(html);
			  $(settings.selector).append(html);
			  
			  html = "";
		 }
	  },
	  /** 单选列表
	   ** settings 配置参数 json格式
	   ** settings --> selector 选择器
	   ** settings --> data 绑定源数据 json格式
	   ** settings --> verifyData 校验数据
	   ** settings --> name  options 对应的名称
	   ** settings --> value options 对应的value
	   **/
	  radioList:function(settings)
	  {
		  
		  if(settings == null ) return; 
		  var name  = settings.name;
		  var value = settings.value;
		  var data 	= settings.data;
		  var verifValue = settings.verifValue;
		  if(data == null ) return ;
		  var verifyData =  settings.verifyData;
		  if(verifyData == null ) verifyData ="" ;
		 												
		  var html;
		  var checked ="";
		  for (var i = 0; i < data.length; i++) 
		  {
			  // 判断是否选择
			  if(data[i][value] == verifyData) checked =" checked ='checked' ";
			  html = " <label class='checkbox-inline'>" ;
			  html += "  <input type='radio' name='rdo_"+settings.selector+"' id='rdo_"+settings.selector+"_Dict_"+i+"' value='"+data[i][value]+"' "+ checked +"/> " + data[i][name];
			  html += " </label>";
			  $(settings.selector).append(html);
			  html = "";
			  checked="";
		 }
	  },
	  /** 复选框列表
	   ** settings 配置参数 json格式
	   ** settings --> selector 选择器
	   ** settings --> data 绑定源数据 json格式
	   ** settings --> verifyData 校验数据
	   ** settings --> name  options 对应的名称
	   ** settings --> value options 对应的value
	   **/
	  ckbList:function(settings)
	  {
		  
		  if(settings == null ) return; 
		  var name  = settings.name;
		  var value = settings.value;
		  var data 	= settings.data;
		  if(data == null ) return ;
		  var verifyData =  settings.verifyData;
		  if(verifyData == null ) verifyData ="" ;
		 												
		  var html;
		  var checked ="";
		  var verifys = verifyData.split(',');
		  for (var i = 0; i < data.length; i++) 
		  {
			  // 判断是否选择
			  for(var k=0;k<verifys.length;k++)
			  {
			   if(data[i][value] == verifys[k]) checked =" checked ='checked' ";
			  }
			  html = " <label class='checkbox-inline'>" ;
			  html += "  <input type='checkbox' id='"+settings.selector+"_ckb_Dict_"+i+"' value='"+data[i][value]+"' "+ checked +"/> " + data[i][name];
			  html += " </label>";
			  $(settings.selector).append(html);
			  html = "";
			  checked="";

		 }
	  },
	  /** 获取列表选择的值(以逗号【,】分割)
	   ** selector 选择器
	   ** 返回选中值
	   **/
	  getCkbValue:function(selector)
	  {
		  var chkValue="";
		  // $('div input[type=checkbox])
		  $(selector).each(function(){ 
			  if(chkValue !="")
			  {
				chkValue+=",";
			  }
			  chkValue += $(this).val(); 
		 });
		return chkValue;
	  }
  };
})(jQuery);