$(document).ready(function() {
 	showSearch();
	showTable();
	initDatagrid();
	showLog();
	mulOperate();
    //InsteadOfHTMLComponent(); //跟日期控件有冲突-去掉by刘凯华2010-05-26
	checkboxSelector();
})

//////////////////tabs:new////////////////

function selectMenuAdd(oThis,tableID)
{
     var oTags = document.getElementById("tab1");
	 var oMenu = oTags.getElementsByTagName("li");
         for(i = 0; i < oMenu.length-1; i++)
         {
	       oMenu[i].className = "unselected";
         }
	 oThis.className = "selected";

  for(i=0; j=document.getElementById("tabTable"+i); i++)
  { 
  j.style.display = "none"; 
  } 
  document.getElementById(tableID).style.display = ""; 
}

function selectMenu(oThis,tableID)
{
     var oTags = document.getElementById("tab1");
	 var oMenu = oTags.getElementsByTagName("li");
         for(i = 0; i < oMenu.length; i++)
         {
	       oMenu[i].className = "unselected";
         }
	 oThis.className = "selected";

  for(i=0; j=document.getElementById("tabTable"+i); i++)
  { 
  j.style.display = "none"; 
  } 
  document.getElementById(tableID).style.display = ""; 
}

function selectMenu2(oThis,tableID)
{
     var oTags = document.getElementById("tab2");
	 var oMenu = oTags.getElementsByTagName("li");
         for(i = 0; i < oMenu.length; i++)
         {
	       oMenu[i].className = "unselected";
         }
	 oThis.className = "selected";

  for(i=10; j=document.getElementById("tabTable"+i); i++)
  { 
  j.style.display = "none"; 
  } 
  document.getElementById(tableID).style.display = ""; 
}

////////////////show/////////////////////////

function ShowDataList(CtrlID)
        {
			
              var ImgPlusScr  ="../images/icons/arrow_down.gif"	;      
              var ImgMinusScr ="../images/icons/arrow_right.gif";	    
              var imgCtrl = document.getElementById("img"+CtrlID);
              var showdiv = "showdiv"+ CtrlID;
    		 	    if(imgCtrl.src.indexOf("arrow_down") == -1)
    		 	    {
    		 	        document.getElementById(showdiv).style.display = "";
    		 	        imgCtrl.src = ImgPlusScr; 
    		      }
    		      else
    		      {
    				  document.getElementById(showdiv).style.display = "none";
    		          imgCtrl.src = ImgMinusScr ;		  		          
    		      } 
}


///////////////////display search///////////////

function searchresult()
{
  document.getElementById("searchresult").style.display = "";
}

/////////input,textarea选中状态///////////////
//function putFocus()
//{
//	$("input,textarea").focus(function(){
//	$(this).attr("class","focus");
//	})
//}

///////显示、隐藏查询条件///////////////
function showSearch()
 {
	$(".showtitle,.hidetitle").click(function(){
		 var t = $(this).parent().parent().next("tbody");
		 t.toggle();
         if(t.get(0).style.display == "none")
		 {
			 $(this).attr("class","showtitle");
			 $("#search_tip").text("显示查询条件");
		 }else{
			 $(this).attr("class","hidetitle");
			 $("#search_tip").text("隐藏查询条件");
		}
	})
 }
 
 
///////折叠表单///////////////
function showTable()
 {
	$(".showtit,.hidetit").click(function(){
		 var t = $(this).parent().parent().parent().next("table");
		 t.toggle();
         if(t.get(0).style.display == "none")
		 {
			 $(this).attr("class","showtit");
		 }else{
			 $(this).attr("class","hidetit");
		}
	})
 }
 
  
 ///////viewLog///////////////
function showLog()
 {
	$(".log,.log_down").hover(function(){
	   $(this).addClass("log_over");   
	 },
	 function(){
		 $(this).removeClass("log_over");  
	 });
	$(".log,.log_down").click(function(){
		 var t = $(this).next("div");
		 t.toggle();
         if(t.get(0).style.display == "none")
		 {
			 $(this).attr("class","log");
		 }
		 else
		 {
			 $(this).attr("class","log_down");
		}
	})
 }

///////datagrid选中行变色与鼠标经过行变色///////////////
function initDatagrid()
{  
    $('.tb_datalist tbody tr:odd').addClass('tr_even');
	$('.tb_datalist tbody tr').hover(
		function() {$(this).addClass('tr_hover');},
		function() {$(this).removeClass('tr_hover');}
	);
	
    // 如果单选框默认情况下是选择的，变色.
	$('.tb_datalist input[type="radio"]:checked').parents('tr').addClass('tr_selected');
	
	// 单选框
	$('.tb_datalist tbody tr').click(
		function() {
			$(this).siblings().removeClass('tr_selected');
			$(this).addClass('tr_selected');
			$(this).find('input[type="radio"]').attr('checked','checked');
		}
	);
  
}


///////////////////下拉多操作按钮///////////////
function mulOperate() 
{
$(".muloperate,.muloperate ul").hover(function(){
     $(".muloperate ul").addClass("hover");   
 },function(){
     $(".muloperate ul").removeClass("hover");  
 }); 
 $(".muloperate").click(function(){
    $(".muloperate ul").addClass("hover");   
},function(){
    $(".muloperate ul").removeClass("hover");  
}); 
}





///////打开新窗口不兼容FF///////////////
function openwinIE(toPage,inputid,width,height)
{
	input=document.getElementById(inputid);
	v=window.showModalDialog(toPage,this,"dialogWidth:"+width+"px;status:no;dialogHeight:"+height+"px"); 
	if(v!=null)
	{
		input.value=v;
	}
}

///////打开新窗口带滚动条///////////////
function openwin(url,name,iWidth,iHeight)
{
var url; //转向网页的地址;
var name; //网页名称，可为空;
var iWidth; //弹出窗口的宽度;
var iHeight; //弹出窗口的高度;
var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
window.open(url,name,'height='+iHeight+',,innerHeight='+iHeight+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+',toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
}


///////打开新窗口不带滚动条==用于部门等选择///////////////
function openwin_nobar(url,name,iWidth,iHeight)
{
var url; //转向网页的地址;
var name; //网页名称，可为空;
var iWidth; //弹出窗口的宽度;
var iHeight; //弹出窗口的高度;
var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
window.open(url,name,'height='+iHeight+',,innerHeight='+iHeight+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+',toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no');
}


/////////多选人员选择/////////////////
function All(e,itemName)   
  {   
      var aa = document.getElementsByName(itemName);   
      for (var i=0;i<aa.length;i++)   
        aa[i].checked = e.checked;   //得到那个总控的复选框的选中状态   
  }   
  function Item(e,allName)   
  {   
      var all = document.getElementsByName(allName)[0];   
      if(!e.checked) all.checked = false;   
      else   
      {   
          var aa = document.getElementsByName(e.name);   
          for (var i=0;i<aa.length;   i++)   
            if(!aa[i].checked) return;   
          all.checked = true;   
      }   
  } 
  
function moveOption(e1, e2){
 try{
  for(var i=0;i<e1.options.length;i++){
   if(e1.options[i].selected){
    var e = e1.options[i];
    e2.options.add(new Option(e.text, e.value));
    e1.remove(i);
    i=i-1
   }
  }
  document.myform.city.value=getvalue(document.myform.list2);
 }
 catch(e){}
}
function getvalue(geto){
 var allvalue = "";
 for(var i=0;i<geto.options.length;i++){
  allvalue +=geto.options[i].value + ",";
 }
 return allvalue;
}

function ShowDataList(CtrlID)
{
	var ImgPlusScr  ="../../images/icons/arrow_down2.gif";      
	var ImgMinusScr ="../../images/icons/arrow_right2.gif";	    
	var imgCtrl = document.getElementById("img"+CtrlID);
	var TableID = "table"+ CtrlID;
	if(imgCtrl.src.indexOf("arrow_down") == -1)
	{
		document.getElementById(TableID).style.display = "";
		imgCtrl.src = ImgPlusScr; 
	}
	else
	{
		document.getElementById(TableID).style.display = "none";
	  	imgCtrl.src = ImgMinusScr ;		  		          
	} 
}

//鼠标点击文本框变色
function InsteadOfHTMLComponent()
{
	var elements = document.all;
	for(var i = 0; i < elements.length; i++)
	{	 
		if( elements[i].type == "text" || elements[i].type == "password" || elements[i].type == "textarea"  )
		{
			if( !(elements[i].readOnly) ) {
				elements[i].onfocus = function () {															
									this.style.backgroundColor = "#DCF1FA";
									};
			}
		}		
		if( elements[i].type == "text" || elements[i].type == "password"|| elements[i].type == "textarea"  )
		{	
			elements[i].onblur = function () {
										
							this.style.backgroundColor = "";
					};
		}
	}
}

//datagrid数据表格复选框全选/反选
function checkboxSelector(){
	var dataGrid = ".tb_datalist";
	var tableHover = ".tb_datalist>tbody";
	$(tableHover).find("tr").hover(function(){ $(this).addClass("tr_hover")}, function(){$(this).removeClass("tr_hover") });
	$(":checkbox[@checkSelector]").click(function(){
		var p = $(this);
		$(":checkbox[@checkNode]").filter(function(){return !$(this).attr("disabled")}).each(function(){this.checked = p.attr("checked")});
	})
	$(":checkbox[@checkNode]").click(function(){
		var p = $(this);
		x = $(":checkbox[@checkNode]").filter(function(){return !$(this).attr("disabled")});
		var k = 0;
		for(var i=0;i<x.length;i++) {if(x.get(i).checked) { k++ };}
		var t = $(":checkbox").filter(function(){return $(this).attr("checkSelector") == p.attr("checkNode")});
		if(k==x.length) { 
			t.each(function(){this.checked = true}) 
		} else {
			t.each(function(){this.checked = false}) 
		}
	})
	
}


//datagrid多操作(操作列)
var  popMenu  = {
 
      showOperation:function(_this){ 	  
	  var popMenuBar = $(_this).parents("td").find("ul") ;
	   popMenuBar.show() ;
       showSelf($(_this).parents("td").find("ul"));
	   popMenu.setPostion(_this);
  },
    hidOperation:function(_this){
 	  var popMenuBar = $(_this).parents("td").find("ul") ;
	   	popMenuBar.hide() ;
        showSelf($(_this).parents("td").find("ul"));
  },
    setPostion:function(_this){
	 var popMenuBar = $(_this).parents("td").find("ul") ;
	 var pointerX = $("body").innerWidth() - $(_this).offset().left;
	 var pointerY = $("body").innerHeight() - $(_this).offset().top;
	 var x ,y;
	 
	  
     if(pointerY < popMenuBar.innerHeight()) 
	 {
	  y =  $(_this).offset().top + $("body").scrollTop() - popMenuBar.innerHeight();

	 }
	 else
	 {
		  //if($(_this).offset().top + popMenuBar.height()>  $(window).height())
		  
		  
		  if (($(_this).offset().top + popMenuBar.innerHeight()) > $(window).height() +$(window).scrollTop())
		  {
			//alert($(_this).offset().top+":"+$(document).height()+":"+popMenuBar.height()+":"+ $(window).height()+":"+document.body.clientHeight  );
		    y =  $(_this).offset().top - popMenuBar.height()-3+"px";
		  }
		  else if($(_this).offset().top > 0)
		  {
			y =  $(_this).offset().top+10+"px";//+10使弹出多操作位于与“操作”的正下方		    
		  }
		  else
		  {
			y =  $(_this).offset().top+10+"px";//+10使弹出多操作位于与“操作”的正下方		
		  }
		  
		  
		  
	 }

	//alert(popMenuBar.outerWidth()+":"+ $("body").innerWidth()+":"+$(_this).offset().left+":"+$(window).width());
	 if( popMenuBar.outerWidth() > pointerX )
	 {
	    x =  $(_this).offset().left - popMenuBar.width()+30+"px" ;//+30使弹出多操作与“操作+下拉图标”右对齐
	 }else{
 	    x =  $(_this).offset().left+"px" ;
	 }
	 popMenuBar.css({top:y,left:x});
	}
}

 function showSelf(_this)
  {
   	var popMenuBar = $(_this) ;
    popMenuBar.mouseover( function() {$(this).show() } );
	popMenuBar.mouseout( function() {$(this).hide() } );
  } 
//datagrid操作列多操作结束

//全选/反选
function CheckAll(obj)
            {
                var i = 0;
                var tmpName = obj.id.replace("ALL","")+i.toString(10);
                while(document.all[tmpName]!=null)
                {
                    document.all[tmpName].checked = obj.checked;
                    i+=1;
                    tmpName = obj.id.replace("ALL","")+i.toString(10);
                }
            }
            function CheckOne(obj)
            {
                var checkAll = true;
                var i = 0;
                var tmpName = obj.id+i.toString(10);
                while(document.all[tmpName]!=null)
                {
                    if(document.all[tmpName].checked)
                    { 
                        i+=1;
                        tmpName = obj.id.replace("ALL","")+i.toString(10);
                    }
                    else
                    {
                        checkAll = false;
                        break;
                    }
                }
                
                tmpName = obj.id+"ALL";
                if(document.all[tmpName]!=null)
                    document.all[tmpName].checked = checkAll;
                
            }

