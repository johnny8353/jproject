/**
 * 主页实现菜单动态加载插件
 * @author 李鑫
 */
(function ($) {
  $.fn.sidebarMenu = function (options) {
    options = $.extend({}, $.fn.sidebarMenu.defaults, options || {});
    var target = $(this);
    // 先清空菜单
    target.empty();
    if (options.data) {
      init(target, options.data);
    }
    else {
      if (!options.url) return; 
      zte.ajax.postUrl(options.url,
              {"bo":{},"sort":"","order":"desc"},
              function(ret) {
	             if(ret != null && ret.code != null && ret.code.code=='0000' && ret.bo != null){
	                init(target, ret.bo);
	             }
	             else{
	                //根据操作结果显示提示信息
				    zte.notify.ShowResult(ret);
	             }
	            return;
	          },
	          true //制定服务器端进行权限校验
          );
    }
    var url = window.location.pathname;
    function init(target, data) {
      $.each(data, function (i, item) {
        var li = $('<li></li>');
        var a = $('<a></a>');
        var b = $('<b class="arrow"></b>');
        var icon = $('<i class="menu-icon"></i>');
        icon.addClass(item.icon);
        var text = $('<span></span>');
        text.addClass('menu-text').text(item.text);
        a.append(icon);
        a.append(text);
        //a.attr('href', '#');
        if (item.menus&&item.menus.length>0) {        
          a.addClass('dropdown-toggle');
          mb = $('<b class="arrow fa fa-angle-down"></b>');
          a.append(mb);
          li.append(a);
          var menus = $('<ul></ul>');
          menus.addClass('submenu');
          init(menus, item.menus);
          li.append(menus);
        }
        else {
          a.attr('url', item.url);
          a.attr('data-addtab',  'menu' + item.id);
          li.append(a);
          li.append(b);
        }
        target.append(li);
      });
    }
  }
 
  $.fn.sidebarMenu.defaults = {
    url: null,
    param: null,
    data: null
  };
})(jQuery);