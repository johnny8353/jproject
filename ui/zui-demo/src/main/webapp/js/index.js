$(document).ready(function() {
 	sysMenu();
})



/////////////////////////////////////
// 函数名称：ShowDate
// 功能说明：返回日期，如：xxxx年xx月xx日
////////////////////////////////////

function ShowDate()
{
	todayDate = new Date();
	date = todayDate.getDate();
	month= todayDate.getMonth() +1;
	year= todayDate.getYear();
	if(navigator.appName == "Netscape")
	{
		document.write(1900+year);
		document.write("年");
		document.write(month);
		document.write("月");
		document.write(date);
		document.write("日");
	}
	if(navigator.appVersion.indexOf("MSIE") != -1)
	{
		document.write(year);
		document.write("年");
		document.write(month);
		document.write("月");
		document.write(date);
		document.write("日");
	}
}

function selectMenu(oThis,lturl,lurl,conurl)
{
    // var oTags = document.getElementById("topmenu");
//	 var oMenu = oTags.getElementsByTagName("li");
//	 var strValue = 1;
//	 for(i = 0; i < oMenu.length; i++)
//	 {
//	      oMenu[i].className = "menu_nosel";
//	 }
//	 oThis.className = "menu_sel";
	 top.leftmenu.location.href=lurl;
	 top.lefttop.location.href=lturl;
	 top.right.location.href=conurl;
}

function sysMenu()
{
	$(".menu_nosel, menu_sel").hover(function(){
		$(this).addClass("menu_hover");},
		function(){
		$(this).removeClass("menu_hover"); 
	});

	$(".menu_sel").prev(".line").css("visibility","hidden");
	$(".menu_sel").next(".line").css("visibility","hidden");
	$(".menu_nosel").click(function(){	
		$(".menu_sel").prev(".line").css("visibility","visible");
		$(".menu_sel").next(".line").css("visibility","visible");
		$(".menu_sel").removeClass("menu_sel");	
		
		$(this).addClass("menu_sel");
		$(this).prev(".line").css("visibility","hidden");
		$(this).next(".line").css("visibility","hidden");
	
	});
}


function mscroll(iScrollNumber,OBJdivObject)
	{
			iTemp          = iScrollNumber;                                        //菜单滚动长度
			var OBJTemp    = parent.leftmenu.document.getElementById(OBJdivObject);  //查找左侧菜单框架中该名字的对象
			var iScrollTop = OBJTemp.scrollTop																     //获得层的最高数据
			
			if (iTemp==0)
			{
				return;                                                              //如果滚动长度为0就返回  
			}
			OBJTemp.scrollTop=OBJTemp.scrollTop + iTemp;                           //滚动菜单屏幕
		if (iScrollTop==OBJTemp.scrollTop)
		{
    		//如果菜单不再滚动 那么就停止
		return;
		}
			setTimeout("mscroll(iTemp,'" + OBJdivObject + "')",80);	   //如果一直按滚动按钮，就定时滚动相同长度的屏幕
} 