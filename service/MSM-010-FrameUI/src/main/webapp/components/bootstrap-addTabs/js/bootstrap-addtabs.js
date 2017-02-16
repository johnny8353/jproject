/**
 * Website: http://git.oschina.net/hbbcs/bootStrap-addTabs
 *
 * Version : 1.0
 *
 * Created by joe on 2016-2-4.
 */

$.fn.addtabs = function (options) {
    obj = $(this);
    Addtabs.options = $.extend({
        content: '', //直接指定所有页面TABS内容
        close: true, //是否可以关闭
        monitor: 'body', //监视的区域
        iframeUse: true, //使用iframe还是ajax
        iframeHeight: '100%', //固定TAB中IFRAME高度,根据需要自己修改
        method: 'init',
        callback: function () { //关闭后回调函数
        }
    }, options || {});


    $(Addtabs.options.monitor).on('click', '[data-addtab]', function () {
        Addtabs.add({
            id: $(this).attr('data-addtab'),
            title: $(this).attr('title') ? $(this).attr('title') : $(this).html(),
            content: Addtabs.options.content ? Addtabs.options.content : $(this).attr('content'),
            url: $(this).attr('url'),
            ajax: $(this).attr('ajax') ? true : false
        });
        
        //切换菜单激活样式
        //somehow get a reference to our newly clicked(selected) element's parent "LI"
        var new_active = $(this).parent();
        //remove ".active" class from all (previously) ".active" elements
        $('.nav-list li.active').removeClass('active');
        //add ".active" class to our newly selected item and all its parent "LI" elements
        new_active.addClass('active').parents('.nav-list li').addClass('active');
        
    });

    obj.on('click', '.close-tab', function () {
        var id = $(this).prev("a").attr("aria-controls");
        Addtabs.close(id);
    });


    /*
    obj.on('mouseover', '.close-tab', function () {
        $(this).removeClass('glyphicon-remove').addClass('glyphicon-remove-circle');
    })

    obj.on('mouseout', '.close-tab', function () {
        $(this).removeClass('glyphicon-remove-circle').addClass('glyphicon-remove');
    })
    
    obj.on('mouseover', '.close-tab', function () {
        $(this).removeClass('fa-times-circle').addClass('fa-times');
    })

    obj.on('mouseout', '.close-tab', function () {
        $(this).removeClass('fa-times').addClass('fa-times-circle');
    })
    */

    /*
    $(window).resize(function () {
    	Addtabs.options.iframeHeight = $(window).height() - 130;
        //obj.find('iframe').attr('height', Addtabs.options.iframeHeight);
    	obj.find('iframe').height(Addtabs.options.iframeHeight);
        Addtabs.drop();
    });
	*/
};

window.Addtabs = {
    options:{},
    add: function (opts) {
        var id = 'tab_' + opts.id;
        //obj.find('.active').removeClass('active');
        $('li[role = "presentation"].active').removeClass('active'); 
        $('div[role = "tabpanel"].active').removeClass('active');
        //如果TAB不存在，创建一个新的TAB
        if (!$("#" + id)[0]) {
            //创建新TAB的title

            var title = $('<li>', {
                'role': 'presentation',
                'id': 'tab_' + id,
                'class':'addtabs-tab-li'
            }).append(
                $('<a>', {
                    'href': '#' + id,
                    'aria-controls': id,
                    'role': 'tab',
                    'data-toggle': 'tab'
                }).html(opts.title)
            );

            //是否允许关闭
            /*
            if (Addtabs.options.close) {
                title.append(
                    //$('<i>',{class:'close-tab glyphicon glyphicon-remove'})
                	$('<i>',{class:'close-tab glyphicon glyphicon-remove-circle'})	
                );
            }*/
            //是否允许关闭
            var canClose = (opts.close==null)?Addtabs.options.close:opts.close;
            if ( canClose ) {
                title.append(
                	'<button type="button" class="close close-tab" data-dismiss="alert"><i class="ace-icon fa fa-times-circle"></i></button>'
                	//$('<i>',{class:'close-tab fa fa-times-circle'})	
                	//$('<i>',{class:'close-tab glyphicon glyphicon-remove-circle'})	
                );
            }
            
            //创建新TAB的内容
            var content = $('<div>', {
                'class': 'tab-pane',
                'style': 'height:100%',
                'id': id,
                'role': 'tabpanel'
            });

            //是否指定TAB内容
            if (opts.content) {
                content.append(opts.content);
            } else if (Addtabs.options.iframeUse && !opts.ajax) {//没有内容，使用IFRAME打开链接
                content.append(
                    $('<iframe>', {
                        'class': 'iframeClass',
                        //'height': Addtabs.options.iframeHeight,
                        'height': '100%',
                        'frameborder': "",
                        'border': "0",
                        'scrolling': "auto",
                        'src': opts.url
                    })
                );
            } else {
                $.get(opts.url, function (data) {
                    content.append(data);
                });
            }
            //加入TABS
            obj.children('.nav-tabs').append(title);
            obj.children(".tab-content").append(content);
        }       

        //激活TAB
        $("#tab_" + id).addClass('active');
        $("#" + id).addClass("active");
        Addtabs.drop();
        
        //在IFRAME的ONLOAD事件中创建ACE的滚动条
        /*
        $("#" + id).on('click',
        		function(){
	        $("#" + id).ace_scroll({
	            size: Addtabs.options.iframeHeight,
	            styleClass: 'scroll-thin'
	         });
        });
        */
    },
    close: function (id) {
        //如果关闭的是当前激活的TAB，激活他的前一个TAB
        if (obj.find("li.active").attr('id') == "tab_" + id) {
            $("#tab_" + id).prev().addClass('active');
            $("#" + id).prev().addClass('active');
        }
        //关闭TAB
        $("#tab_" + id).remove();
        $("#" + id).remove();
        Addtabs.drop();
        Addtabs.options.callback();
    },
    drop: function () {
        element = obj.find('.nav-tabs');
        //创建下拉标签
        var dropdown = $('<li>', {
            'class': 'dropdown pull-right hidden tabdrop'
        }).append(
            $('<a>', {
                'class': 'dropdown-toggle',
                'data-toggle': 'dropdown',
                'href': '#'
            }).append(
                //$('<i>', {'class': "glyphicon glyphicon-align-justify"})
            	$('<i>', {'class': "fa fa-align-justify"})
            ).append(
                $('<b>', {'class': 'caret'})
            )
        ).append(
            $('<ul>', {'class': "dropdown-menu"})
        )

        //检测是否已增加
        if (!$('.tabdrop').html()) {
            dropdown.prependTo(element);
        } else {
            dropdown = element.find('.tabdrop');
        }
        //检测是否有下拉样式
        if (element.parent().is('.tabs-below')) {
            dropdown.addClass('dropup');
        }
        var collection = 0;

        //检查超过一行的标签页
        element.append(dropdown.find('li'))
            .find('>li')
            .not('.tabdrop')
            .each(function () {
                if (this.offsetTop > 0 || element.width() - $(this).position().left - $(this).width() < 53) {
            	//if (this.offsetTop > 0 || element.width() - $(this).position().left - $(this).width() < 83) {
                    dropdown.find('ul').append($(this));
                    collection++;
                }
            });

        //如果有超出的，显示下拉标签
        if (collection > 0) {
            dropdown.removeClass('hidden');
            if (dropdown.find('.active').length == 1) {
                dropdown.addClass('active');
            } else {
                dropdown.removeClass('active');
            }
        } else {
            dropdown.addClass('hidden');
        }
    }
}