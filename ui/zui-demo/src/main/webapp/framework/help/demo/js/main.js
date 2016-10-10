$(document).ready(function() {
 	showSearch();
	showDetail();
	showfaq();
	showTable();
	initDatagrid();
	showLog();
	mulOperate();
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


///////帮助中心显示隐藏图例代码///////////////
function showDetail()
 {
	$(".showdetail,.hidedetail").click(function(){
		 var t = $(this).parent().next();
		 t.toggle();
         if(t.get(0).style.display == "none")
		 {
			 $(this).attr("class","showdetail");
		 }else{
			 $(this).attr("class","hidedetail");
		}
	})
 }
 
 ///////帮助中心显示隐藏FAQ///////////////
function showfaq()
 {
	$(".showfaq,.hidefaq").click(function(){
		 var t = $(this).next();
		 t.toggle();
         if(t.get(0).style.display == "none")
		 {
			 $(this).attr("class","showfaq");
		 }else{
			 $(this).attr("class","hidefaq");
		}
	})
 }



