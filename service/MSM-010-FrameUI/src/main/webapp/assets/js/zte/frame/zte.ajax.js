/**
 <b>zte.app</b>. Calls sidebar functions, demo ajax, some fixes, etc
*/

(function($ , undefined) {
  if( !('zte' in window) ) window['zte'] = {};
  //设置当前web站点访问地址
  var root = "http://localhost:8090/";
  //var root = "http://10.89.208.188/";
  // 设置当前web站点上下文
  var webContext = "frame-web"
  //var webContext = "html5-pc-2016"
  // 除了登录界面，WEB站点其他界面用户没登录都会跳转到登录界面
  if (zte.user.token == "" && location.href.toLowerCase().indexOf("/html/login.html") == -1) {
	  location.href = root + webContext + "/html/login.html";
  }
		
  zte.ajax = {
      
    /**
     * 和服务器通讯函数
     * @param url: 服务URL地址
     * @param data: 请求参数
     * @param busiFunc: 业务回调函数
     * @param needAuth: 是否需要进行服务端认证
     */
    postUrl: function(url,data,busiFunc) {
      var ajax_params = {
          method: 'POST', 
          url: zte.url.root + url, 
          data : JSON.stringify(data),
          dataType: 'json',
          contentType:'application/json',
          //processData: false,
          headers: {
            //"Accept" : "application/json, text/javascript, */*; charset=utf-8",
            //"Content-Type": "application/json; charset=utf-8"
          },
          //发送请求前，设置请求头
          beforeSend:function(jqXHR, settings) {          
            //如果请求头里面设置了身份验证标志，则添加身份令牌
            //if (zte.user.Consts.NeedAuthToken && settings.headers != null && settings.headers[zte.user.Consts.HTTP_HEADER_X_AUTH_FLAG]=='Y') {
        	//if (zte.user.Consts.NeedAuthToken && settings.headers != null && needAuth != null && needAuth) {
                  //在请求头中设置身份令牌
        	     // jqXHR.setRequestHeader(zte.user.Consts.HTTP_HEADER_X_AUTH_FLAG,'Y');
               jqXHR.setRequestHeader(zte.user.Consts.HTTP_HEADER_X_AUTH_VALUE,zte.user.token);
          	   jqXHR.setRequestHeader(zte.org.Consts.HTTP_HEADER_X_ORG_ID, zte.user.orgId);   	
            //}
            //else{
              //jqXHR.setRequestHeader(zte.user.Consts.HTTP_HEADER_X_AUTH_FLAG,'N');
            //}
            
            //设置多语言参数
            if (zte.lang.Consts.NeedLangId) {
              //在请求头中设置语言ID
              jqXHR.setRequestHeader(zte.lang.Consts.HTTP_HEADER_X_LANG_ID,zte.lang.langId);
            }
            
            //如果请求头里面设置了传输加密标志，则对数据加密
            /*
            if (CryptoService.NeedCryptoRequest && config.headers[CryptoService.HTTP_HEADER_X_CRYPTO_FLAG]=='Y') {
              //在请求头中设置加密类型和HASH
              config.headers[CryptoService.HTTP_HEADER_X_CRYPTO_ALGO] = 'aes';
              config.headers[CryptoService.HTTP_HEADER_X_CHANNEL_HASH] = '123456';
              //加密请求数据
              var datastr = CryptoService.encrypt(JSON.stringify(config.data));
              //$log.debug(datastr);
              config.data = datastr;          
            }
            else{
              config.headers[CryptoService.HTTP_HEADER_X_CRYPTO_FLAG] = 'N';
            }*/
          },
          //请求失败
          error:function(jqXHR, textStatus, errorThrown) {
              //客户端请求异常
              var ret = {
                code : {
                  code : '1001',
                  msg : 'ajax请求失败'
                },
                bo : textStatus + ',' + errorThrown
              };
              
              //将结果委托结业务回调函数
              busiFunc(ret);
              
              //根据返回结果，显示提示信息
              //zte.notify.ShowResult(ret);
          },
          //请求成功
          success:function(data, textStatus, jqXHR) { 
            var ret = data;
            //try{
            //  ret = jQuery.parseJSON(data);
            //}
            //catch(ex){}
            
            //处理返回数据  
            if (ret != null && ret.code != null && ret.code.code == '0000') {         
              if (ret != null && ret.bo != null && ret.bo.rows != null) {
                //获取到列表数据时,结列表增加一个序号字段jsListSeq,这样在列表过滤后,还可以找到记录的位置
                for (var i = 0; i < ret.bo.rows.length; i++) {
                  ret.bo.rows[i].jsListSeq = i;
                }
              }
            }
            
            //将结果委托结业务回调函数
            busiFunc(ret);
    
            //根据返回结果，显示提示信息
            //zte.notify.ShowResult(ret);
          }
      };

      $.ajax(ajax_params);
    },
		rootUrl:function (url){
			return zte.url.root + url;
		}
  };
    
  zte.ajax.test = function() {
    zte.ajax.postUrl("test1.html",{'id':123,'name':'邓测试'},zte.ajax.busiFunc);
    return;
  };
  
  zte.ajax.busiFunc = function(ret) {
    alert(ret);
    return;
  };
    

})(jQuery);