
//var txtValue=document.all.dateStart.value;
var gdCtrl = new Object();
var goSelectTag = new Array();
var gcGray   = "#808080";
var gcToggle = "#FB8664";
var gcEmpty = '';
var gcBG = "#e5e6ec";
var previousObject = null;
var gdCurDate = new Date();
var giYear = gdCurDate.getFullYear();
var giMonth = gdCurDate.getMonth()+1;
var giDay = gdCurDate.getDate();
var curYear = gdCurDate.getFullYear();
var curMonth = gdCurDate.getMonth()+1;
var curDay = gdCurDate.getDate();
curMonth= (curMonth.toString().length==1)?'0'+curMonth.toString():curMonth.toString();
curDay= (curDay.toString().length==1)?'0'+curDay.toString():curDay.toString();
var giHh = gdCurDate.getHours();
var giMm = gdCurDate.getMinutes();
var giSs = gdCurDate.getSeconds();
var giTime = giHh+':'+giMm+':'+giSs;
var Hid = true;
function fCheckIsNumber(num)
{
	var i,j,strTemp;
	strTemp="010023456789";
	if (num.length==0)
	{
		return false;
	}
	for (i=0;i<num.length;i++)
	{
		j=strTemp.indexOf(num.charAt(i)); 
		if (j==-1)
		{
			return false;
		}
	}
	return true;
}
function LTrim(str)
{
	var whitespace = new String(" \t\n\r");
	var s = new String(str);
	if (whitespace.indexOf(s.charAt(0)) != -1)
	{
		 var j=0, i = s.length;
		while (j < i && whitespace.indexOf(s.charAt(j)) != -1)
		{
			j++;
		}
		s = s.substring(j, i);
	}
	return s;
}
function RTrim(str)
{
	var whitespace = new String(" \t\n\r");
	var s = new String(str);
	 if (whitespace.indexOf(s.charAt(s.length-1)) != -1)
	{
		var i = s.length - 1;
		while (i >= 0 && whitespace.indexOf(s.charAt(i)) != -1)
		{
			 i--;
		}
		s = s.substring(0, i+1);
	}
	return s;
}
function Trim(str) 
{
	return RTrim(LTrim(str));
}
function fCheckDateTime(datename)
{
	var inputValue=document.all[datename].value;
	inputValue=Trim(inputValue);
	var len=inputValue.length;
	if (len!=10 && len!=16 && len!=19 && len!=0)
	{
		
				
				alert('请按yyyy-mm-dd格式输入!');
				return;
		
	}
	var iDate= inputValue.substring(0,10);
	var iTime= inputValue.substring(10,len);
	//if (fCheckDate(iDate)== false)
//	{
//		alert('请按yyyy-mm-dd格式输入!');
//		return;
//	}
	if (len!=10 && len!=0)
	{
		if (fCheckTime(iTime)== false)
		{
			alert('请按yyyy-mm-dd格式输入!');
			return;
		}
	}
}
function fCheckDate(inputdate)
{
	inputdate=inputdate.split('-');
	var year=inputdate[0];
	var month=inputdate[1];
	var day=inputdate[2];
	var Date1 = new Date(year,month-1,day); 
	if (Date1.getMonth()+1!=month||Date1.getDate()!=day||Date1.getFullYear()!=year||year.length!=4)
	{
		return false;
	}
	else
	{
		if (month.indexOf('0')==0) 
		{
			month=month.substr(1,month.length); 
		}
		if (day.indexOf('0')==0) 
		{
			day=day.substr(1,day.length); 
		}
		if ((month==4 || month==6 || month==9 || month==11) && (day>30))
		{
			return false; 
		}
		if (month==2) 
		{
			if (LeapYear(year)) 
			{
				if (day>29 || day<1)
				{
					return false;
				}
			}
			else
			{
				if (day>28 || day<1)
				{
					return false; 
				}
			}
		}
	}
	return true;
}
function fCheckTime(inputTime)
{
	inputTime=inputTime.split(':')
	if(inputTime.length!=2)
	{
		if(inputTime.length!=3)
		{
			return false;
		}
	}
	var hh=Trim(inputTime[0])
	if (isNaN(hh))
	{
		return false;
	}
	if (hh.indexOf('0')==0) 
	{
		hh=hh.substr(1,hh.length); 
	}
	if ((hh<0) || (hh>23)) 
	{
		return false;
	}
	var mi=Trim(inputTime[1]);
	if (isNaN(mi))
	{
		return false;
	}
	if (mi.indexOf('0')==0) 
	{
		mi=mi.substr(1,mi.length); 
	}
	if((mi<0) || (mi>59)) 
	{
		return false;
	}
	if(inputTime.length==3)
	{
		var ss=Trim(inputTime[2]);
		if (isNaN(ss))
		{
			return false;
		}
		if (ss.indexOf('0')==0) 
		{
			ss=ss.substr(1,ss.length); 
		}
		if ((ss<0) || (ss>59)) 
		{
			return false;
		}
	}
	return true
}
function LeapYear(intYear)
{
	if (intYear % 100 == 0)
	{
		if (intYear % 400 == 0)
		{
			return true;
		}
	}
	else
	{
		if ((intYear % 4) == 0) 
		{
			return true; 
		}
	}
	return false;
}
function fSetDateTime(iYear,iMonth,iDay)
{
	giHh=document.all.dpHour.value;
	giMm=document.all.dpMinute.value;
	giSs=document.all.dpSecon.value;
	giHh=(giHh.length==1)?'0'+giHh:giHh;
	giMm=(giMm.length==1)?'0'+giMm:giMm;
	giSs=(giSs.length==1)?'0'+giSs:giSs;
	giTime=giHh+':'+giMm+':'+giSs;
	VicPopCal.style.visibility = "hidden";
	if ((iYear == 0) && (iMonth == 0) && (iDay == 0))
	{
		gdCtrl.value = "";
		var curDate = new Date();
		giYear = curDate.getFullYear();
		giMonth = curDate.getMonth()+1;
		giDay = curDate.getDate();
	}
	else
	{
		iMonth=(iMonth.toString().length==1)?'0'+iMonth.toString():iMonth;
		iDay=(iDay.toString().length==1)?'0'+iDay.toString():iDay;
		if(gdCtrl.tagName == "INPUT")
		{
			gdCtrl.value = iYear+"-"+iMonth+"-"+iDay + " " + giTime;
		}
		else
		{
			gdCtrl.innerText = iYear+"-"+iMonth+"-"+iDay + " " + giTime;
		}
	}
	for (i in goSelectTag)
	{
		goSelectTag[i].style.visibility = "visible";
	}
	goSelectTag.length = 0;
	window.returnValue=gdCtrl.value;
}
function getNowDate()
{
	var nn = new Date();
	year1=nn.getYear();
	mon1=nn.getMonth()+1;
	date1=nn.getDate();
	var monstr1;
	var datestr1
	if(mon1<10)
	{
		monstr1="0"+mon1;
	}
	else
	{
		monstr1=""+mon1;
	}
	if(date1<10)
	{
		datestr1="0"+date1;
	}
	else
	{
		datestr1=""+date1;
	}
	year1+"-"+monstr1+"-"+datestr1;
}
function getlastweekDate()
{
	var nn=new Date();
	year1=nn.getYear();
	mon1=nn.getMonth()+1;
	date1=nn.getDate();
	var mm=new Date(year1,mon1-1,date1);
	var tmp1=new Date(2000,1,1);
	var tmp2=new Date(2000,1,15);
	var ne=tmp2-tmp1;
	var mm2=new Date();
	mm2.setTime(mm.getTime()-ne);
	year2=mm2.getYear();
	mon2=mm2.getMonth()+1;
	date2=mm2.getDate();
	if(mon2<10)
	{
		monstr2="0"+mon2;
	}
	else
	{
		monstr2=""+mon2;
	}
	if(date2<10) 
	{
		datestr2="0"+date2;
	}
	else
	{
		datestr2=""+date2;
	}
	return year2+"-"+monstr2+"-"+datestr2;
}
function fSetDate(iYear, iMonth, iDay)
{
	VicPopCal.style.visibility = "hidden";
	if ((iYear == 0) && (iMonth == 0) && (iDay == 0))
	{
		gdCtrl.value = "";
		var curDate = new Date();
		giYear = curDate.getFullYear();
		giMonth = curDate.getMonth()+1;
		giDay = curDate.getDate();
	}
	else
	{
		iMonth=(iMonth.toString().length==1)?'0'+iMonth.toString():iMonth;
		iDay=(iDay.toString().length==1)?'0'+iDay.toString():iDay;
		if(gdCtrl.tagName == "INPUT")
		{
			gdCtrl.value = iYear+"-"+iMonth+"-"+iDay;
		}
		else
		{
			gdCtrl.innerText = iYear+"-"+iMonth+"-"+iDay;
		}
	}
	for (i in goSelectTag)
	{
		//goSelectTag[i].style.visibility = "visible";
	}
	goSelectTag.length = 0;
	window.returnValue=gdCtrl.value;
}
function HiddenDiv()
{
	var i;
	document.all.VicPopCal.style.visibility = "hidden";
	for (i in goSelectTag)
	{
		goSelectTag[i].style.visibility = "visible";
	}
	goSelectTag.length = 0;
}
function fSetSelected(aCell)
{
	Hid = true;
	var iOffset = 0;
	giYear = parseInt(document.all.tbSelYear.value);
	giMonth = parseInt(document.all.tbSelMonth.value);
	var iYear = giYear;
	var iMonth = giMonth;
	aCell.bgColor = gcBG;
	with (aCell.children["cellText"])
	{
		var iDay = parseInt(innerText);
		if (color==gcGray)
		{
			iOffset = (Victor<10)?-1:1;
		}
		iMonth += iOffset;
		if (iMonth<1)
		{
			iYear--;
			iMonth = 12;
		}
		else if (iMonth>12)
		{
			iYear++;
			iMonth = 1;
		}
	}
	fSetDate(iYear, iMonth, iDay);
}
function Point(iX, iY)
{
	this.x = iX;
	this.y = iY;
}
function fBuildCal(iYear, iMonth)
{
	var aMonth=new Array();
	for(i=1;i<7;i++)
	{
		aMonth[i]=new Array(i);
	}
	var dCalDate=new Date(iYear, iMonth-1, 1);
	var iDayOfFirst=dCalDate.getDay();
	var iDaysInMonth=new Date(iYear, iMonth, 0).getDate();
	var iOffsetLast=new Date(iYear, iMonth-1, 0).getDate()-iDayOfFirst+1;
	var iDate = 1;
	var iNext = 1;
	for (d = 0; d < 7; d++)
	{
		aMonth[1][d] = (d<iDayOfFirst)?-(iOffsetLast+d):iDate++;
	}
	for (w = 2; w < 7; w++)
	{
		for (d = 0; d < 7; d++)
		{
			aMonth[w][d] = (iDate<=iDaysInMonth)?iDate++:-(iNext++);
		}
	}
	return aMonth;
}
function fDrawCal(iYear, iMonth, iCellHeight, sDateTextSize)
{
	var divHtml = '';
	var WeekDay = new Array("日","一","二","三","四","五","六");
	var styleTD = " bgcolor='"+gcBG+"' bordercolor='"+gcBG+"' valign='middle' align='center' height='"+iCellHeight+"' style='font:bold arial "+sDateTextSize+";"; 
	var hmsStyleTD = " bgcolor='white' bordercolor='"+gcBG+"' valign='middle' align='center' height='"+iCellHeight+"' style='font:bold arial "+sDateTextSize+";"; 
	var txtHmsStyle="style=WIDTH:15px;COLOR:black;BORDER-TOP-STYLE:none;BORDER-RIGHT-STYLE:none;BORDER-LEFT-STYLE:none;HEIGHT:100%;BACKGROUND-COLOR:white;BORDER-BOTTOM-STYLE:none;background-color:Transparent;"; 
	divHtml = divHtml + "<tr>";
	for(i=0; i<7; i++)
	{
		divHtml = divHtml + "<td "+styleTD+"color:#990099' >"+ WeekDay[i] + "</td>";
	}
	divHtml = divHtml + "<tr>";
	for (w = 0; w < 6; w++)
	{
		divHtml = divHtml +  "<tr>";
		for (d = 0; d < 7; d++)
		{
			divHtml = divHtml + "<td id=calCell "+styleTD+"cursor:hand;' onMouseOver='this.bgColor=gcToggle' onMouseOut='this.bgColor=gcBG' onclick='fSetSelected(this)'>";
			divHtml = divHtml + "<font id=cellText Victor='Liming Weng'> </font>";
			divHtml = divHtml + "</td>";
		}
	}
	return divHtml;
}
var onfocusobj =null;
function selectHour(obj)
{
	onfocusobj =obj;
	obj.select();
}
function addTime()
{
	if(onfocusobj==undefined)
	{
		 onfocusobj =document.all('dpHour');
	}
	intTe=parseInt(onfocusobj.value);
	if(onfocusobj.id == 'dpHour') 
	{
		 if(intTe==23) 
		{
			intTe=0;   
		}
		else
		{
			intTe = intTe +1;   
		}
	}
	else
	{
		if(intTe==59)
		{
			intTe=0;
		}
		else
		{
			intTe = intTe +1;
		}
	}
	onfocusobj.value =intTe ;
}
function jianTime()
{
	 if(onfocusobj==null)
	{
		onfocusobj =document.all('dpHour');   
	}
	intTe=parseInt(onfocusobj.value);  
	 if(intTe>1)
	{
		 intTe =intTe- 1;
	}
	else
	{
		 if(onfocusobj.id == 'dpHour')
		{
			intTe = 23;
		}
		else
		{
			intTe = 59; 
		}
	}
	onfocusobj.value = intTe;
}
function NotHid()
{
	Hid = false;
}
function fUpdateCal(iYear, iMonth)
{
	Hid = false
	myMonth = fBuildCal(iYear, iMonth);
	 var i = 0;
	 var nn = new Date();
	 var cYear = nn.getYear();
	 var cDay = nn.getDate();
	 var cMonth = nn.getMonth()+1;
	 var Marked = false;
	 var Started = false;
	for (w = 0; w < 6; w++)
	{
		for (d = 0; d < 7; d++)
		{
			with (cellText[(7*w)+d])
			{
				Victor = i++;
				if (myMonth[w+1][d]<0) 
				{
					color = gcGray;
					innerText = -myMonth[w+1][d];
				}
				else
				{
					color = ((d==0)||(d==6))?"blue":"black";
					innerText = myMonth[w+1][d];
				}
				if (innerText == 1) {Started = true;}
				giDay=(giDay.toString().indexOf('0')==0)?giDay.toString().substring(1,2):giDay;
				giMonth=(giMonth.toString().indexOf('0')==0)?giMonth.toString().substring(1,2):giMonth;
				if (cDay != giDay && parseInt(giDay) == innerText && parseInt(giMonth) == iMonth &&  giYear == iYear && !Marked && Started) {Marked = true; color = "red"; cellText[(7*w)+d].innerHTML = "<div style='WIDTH: 100%; HEIGHT: 100%; BACKGROUND-COLOR: buttonface'>" + innerText + "</div>";}
				else if (cYear ==iYear  && parseInt(cMonth) ==parseInt(iMonth)  && myMonth[w+1][d] == parseInt(cDay)  && Started) {color = "red"; cellText[(7*w)+d].innerHTML = "<div style='WIDTH: 100%; HEIGHT: 100%; BACKGROUND-COLOR: yellow'>" + innerText + "</div>";}
			}
		}
	}
}
function fSetYearMon(iYear, iMon)
{
	document.all.tbSelMonth.options[iMon-1].selected = true;
	for (i = 0; i < document.all.tbSelYear.length; i++)
	{
		if (document.all.tbSelYear.options[i].value == iYear)
		{
			document.all.tbSelYear.options[i].selected = true;
		}
	}
	fUpdateCal(iYear, iMon);
}
function fPrevMonth()
{
	Hid = false;
	var iMon = document.all.tbSelMonth.value;
	var iYear = document.all.tbSelYear.value;
	if (--iMon<1) 
	{
			iMon = 12;
			iYear--;
	}
	fSetYearMon(iYear, iMon);
}
function fNextMonth()
{
	Hid = false;
	var iMon = document.all.tbSelMonth.value;
	var iYear = document.all.tbSelYear.value;
	if (++iMon>12) 
	{
			iMon = 1;
			iYear++;
	}
	fSetYearMon(iYear, iMon);
}
function fToggleTags()
{
	with (document.all.tags("SELECT"))
	{
			for (i=0; i<length; i++)
		{
					if ((item(i).Victor!="Won")&&fTagInBound(item(i)))
			{
							item(i).style.visibility = "hidden";
							goSelectTag[goSelectTag.length] = item(i);
			}
		}
	}
}
function fTagInBound(aTag)
{
	with (VicPopCal.style)
	{
			var l = parseInt(left);
			var t = parseInt(top);
			var r = l+parseInt(width);
			var b = t+parseInt(height);
			var ptLT = fGetXY(aTag);
			return !((ptLT.x>r)||(ptLT.x+aTag.offsetWidth<l)||(ptLT.y>b)||(ptLT.y+aTag.offsetHeight<t));
	}
}
function fGetXY(aTag)
{
	var oTmp = aTag;
	var pt = new Point(0,0);
	do 
	{
			pt.x += oTmp.offsetLeft;
			pt.y += oTmp.offsetTop;
			oTmp = oTmp.offsetParent;
	}
	while(oTmp.tagName!="BODY");
	return pt;
}
divHtml = '';
function HidChange(boVis)
{
	Hid = boVis;
}
function fPopCalendar(popCtrl, dateCtrl,strDate)
{
	strDate=Trim(strDate)
	if(strDate.length>10)
	{
		giYear = strDate.substring(0,4);
		giMonth = strDate.substring(5,7);
		giDay= strDate.substring(8,10);
		var iTime=strDate.substring(10,strDate.Length) ;
		iTime=Trim(iTime).split(':');
		giHh=iTime[0];
		giMm=iTime[1];
		giSs=iTime[2];
	}
	else
	{
		var curDate = new Date();
		giHh = curDate.getHours();
		giMm = curDate.getMinutes();
		giSs = curDate.getSeconds();
	}
	var c = document.getElementsByName('VicPopCal');
	if(c.length < 1)
	{
		var divHtml = '';
		var divCal = document.createElement("<Div ALIGN=CENTER id='VicPopCal'onmouseover='HidChange(false)' onmouseout='HidChange(true)' style='OVERFLOW:visibile;POSITION:absolute;VISIBILITY:hidden;z-index:100;'></Div>");
		document.body.insertBefore(divCal);
		divHtml = divHtml + "<table width=100% bgcolor='#cccccc' style='border:1px solid #716F64;'>";
		divHtml = divHtml + "<TR>";
		divHtml = divHtml + "<td valign='middle' align='center'><input type='button' css='button' name='PrevMonth' value='<' style='height:20;width:20;FONT:bold' onClick='fPrevMonth()'>";
		divHtml = divHtml + "&nbsp;<SELECT name='tbSelYear' onChange='fUpdateCal(tbSelYear.value, tbSelMonth.value)' Victor='Won' size='1' multiple='multiple'>";
		for(i=2050;i>=1900;i--)
		{
				divHtml = divHtml + "<OPTION value='"+i+"'>"+i+" 年</OPTION>";
		}
		divHtml = divHtml + "</SELECT>";
		divHtml = divHtml + "&nbsp;<select name='tbSelMonth' onChange='fUpdateCal(tbSelYear.value, tbSelMonth.value)' onClick='fUpdateCal(tbSelYear.value, tbSelMonth.value)' Victor='Won'>";
		for (i=0; i<12; i++)
		{
				divHtml = divHtml + "<option value='"+(i+1)+"'>"+gMonths[i]+"</option>";
		}
		divHtml = divHtml + "</SELECT>";
		divHtml = divHtml + "&nbsp;<input type='button' css='button' name='PrevMonth' value='>' style='height:20;width:20;FONT:bold' onclick='fNextMonth()'>";
		divHtml = divHtml + "</td>";
		divHtml = divHtml + "</TR><TR>";
		divHtml = divHtml + "<td align='center'>";
		divHtml = divHtml + "<DIV style='background-color:#3366CC'><table width='100%' border='0'>";
		divHtml = divHtml + fDrawCal(giYear, giMonth, 20, '12');
		divHtml = divHtml + "</table></DIV>";
		divHtml = divHtml + "</td>";
		divHtml = divHtml + "</TR><TR><TD align='center'>";
		divHtml = divHtml + "<TABLE width='100%'><TR><TD align='center'>";
		divHtml = divHtml + "<B style='cursor:hand' onclick='fSetDate(0,0,0)' onMouseOver='this.style.color=gcEmpty' onMouseOut='this.style.color=0'>清空</B>";
		divHtml = divHtml + "</td><td algin='center'>";
		divHtml = divHtml + "<B style='cursor:hand' onclick='fSetDate(curYear,curMonth,curDay)' onMouseOver='this.style.color=gcToggle' onMouseOut='this.style.color=0'>今天: "+curYear+"-"+curMonth+"-"+curDay+"</B>";
		divHtml = divHtml + "</td></tr></table>";
		divHtml = divHtml + "</TD></TR>";
		divHtml = divHtml + "</TABLE>";
		document.getElementById('VicPopCal').innerHTML = divHtml;
	}
	if (popCtrl == previousObject)
	{
		var VicPopCal = document.getElementById('VicPopCal');
			if (VicPopCal.style.visibility == "visible")
		{
					HiddenDiv();
					return true;
		}
	}
	previousObject = popCtrl;
	gdCtrl = dateCtrl;
	fInitialDate(strDate);
	fSetYearMon(giYear, giMonth); 
	var point = fGetXY(popCtrl);
	var VicPopCal = document.getElementById('VicPopCal');
	
	with (VicPopCal.style) 
	{
			left = point.x+popCtrl.offsetWidth-190;
			top  = point.y+popCtrl.offsetHeight;
			width = VicPopCal.offsetWidth;
			width = 190;
			height = VicPopCal.offsetHeight;
			fToggleTags(point); 	
			visibility = 'visible';
	}
	
}
function fSetHhMmSs()
{
	document.all.dpHour.value=giHh;
	document.all.dpMinute.value=giMm;
	if (giSs!=null && giSs!='')
	{
		document.all.dpSecon.value=giSs;
	}
	else
	{
		document.all.dpSecon.value='0';
	}
}
function fInitialDate(strDate)
{
	if( strDate == null || strDate.length != 10 )
	{
		return false;
	}
	var sYear  = strDate.substring(0,4);
	var sMonth = strDate.substring(5,7);
	var sDay   = strDate.substring(8,10);
	if( sMonth.charAt(0) == '0' ) { sMonth = sMonth.substring(1,2); }
	if( sDay.charAt(0)   == '0' ) { sDay   = sDay.substring(1,2);   }
	var nYear  = parseInt(sYear );
	var nMonth = parseInt(sMonth);
	var nDay   = parseInt(sDay  );
	if ( isNaN(nYear ) )	return false;
	if ( isNaN(nMonth) )	return false;
	if ( isNaN(nDay  ) )	return false;
	var arrMon = new Array(12);
	arrMon[ 0] = 31;	arrMon[ 1] = nYear % 4 == 0 ? 29:28;
	arrMon[ 2] = 31;	arrMon[ 3] = 30;
	arrMon[ 4] = 31;	arrMon[ 5] = 30;
	arrMon[ 6] = 31;	arrMon[ 7] = 31;
	arrMon[ 8] = 30;	arrMon[ 9] = 31;
	arrMon[10] = 30;	arrMon[11] = 31;
	if ( nYear  < 1900 || nYear > 2050 )	return false;
	if ( nMonth < 1 || nMonth > 12 )				return false;
	if ( nDay < 1 || nDay > arrMon[nMonth - 1] )	return false;
	giYear  = nYear;
	giMonth = nMonth;
	giDay   = nDay;
	return true;
}
var gMonths = new Array("一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月");
function maskN()
{
	var masKey = 78;
	if(event.keyCode==masKey&&event.ctrlKey)
	{
		 event.returnValue=0;
		 window.event.returnValue=0;
	}
}
function isIE()
{
	browser_name = navigator.appName;
	if (browser_name == "Microsoft Internet Explorer") 
	{
			return true;
	}
	return false;
}
function isIE2()
{
	if(document.all)
	{
			return true;
	}
	return false;
}
function isNC()
{
	browser_name = navigator.appName;
	if(browser_name == "Netscape")
	{
			return true;
	}
	return false;
}
function isNC2()
{
	if(document.layers)
	{
			return true;
	}
	return false;
}
function version()
{
	 return parseFloat(navigator.appVersion);
}
var LastTabObjectName="";
var FirstTabObjectName="";
function handleEnter()
{
}
function myKeyEvent(e)
{
	var hotkey=13;
	var rightKey = 39;
	var leftKey = 41;
	if (isNC())
	{
			if(e.which==hotkey)
		{
					e.which=9;
					return true;
		}
	}
	else if (isIE())
	{
		if (event.keyCode==hotkey)
		{
				if(LastTabObjectName.length>0 && !event.shiftKey && event.srcElement.name==LastTabObjectName)
			{
						event.keyCode=0;
						eval("document.all."+FirstTabObjectName+".focus()");
						return false;
			}
				else if(FirstTabObjectName.length>0 && event.shiftKey && event.srcElement.name==FirstTabObjectName)
			{
						event.keyCode=0;
						eval("document.all."+LastTabObjectName+".focus()");
						return false;
			}
				else
			{
						if(event.srcElement.type!="textarea")
				{
								event.keyCode=9;
				}
						return true;
			}
		}
		if (event.keyCode==rightKey)
		{
				if(LastTabObjectName.length>0 && !event.shiftKey && event.srcElement.name==LastTabObjectName)
			{
						event.keyCode=0;
						eval("document.all."+FirstTabObjectName+".focus()");
						return false;
			}
				else if(FirstTabObjectName.length>0 && event.shiftKey && event.srcElement.name==FirstTabObjectName)
			{
						event.keyCode=0;
						eval("document.all."+LastTabObjectName+".focus()");
						return false;
			}
				else
			{
						event.keyCode=9;
						return true;
			}
		}
	}
}
handleEnter();
function closeCalendarWin()
{
	try
	{
		var closeSelectDateWindow= Hid;
		if(previousObject == null)
		{
				return;
		}
		if(closeSelectDateWindow == true)
		{
				HiddenDiv();
		}
		
	}
	catch(e)
	{
			return;
	}
}
function dateCompare(fromDate,toDate,promptInfo)
{
	var calendar1Value = fromDate.value;
	var calendar2Value = toDate.value;
	if(calendar1Value!="" && calendar2Value!="")
	{
			if(calendar1Value > calendar2Value)
		{
					alert(promptInfo);
					return false;
		}
	}
	return true;			
}
document.onclick = closeCalendarWin;