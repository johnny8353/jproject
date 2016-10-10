////////////////////////////////////////////////////////
// ƣcreateCurrentPosition
// ˵ǰλÿؼ
// ˵addtitle--׷ӵԶ
// Աtu.zhengjun
// ڣ2008-1-28
///////////////////////////////////////////////////////
function createCurrentPosition(addtitle)
{
		if(addtitle==null || addtitle=="undefined")
		{
			addtitle = "";
		}
		
		var firsttitle = top.topframe.frametopmenu.document.getElementById(top.topframe.frametopmenu.PrevSelectedNavItemID).childNodes(0).childNodes(0).nodeValue + " &gt; ";    //һ˵ı
		var midtitle = "";
		
		if (top.topframe.frametopmenu.mode == "Outlook")    //Outlook˵ı
		{
			midtitle += top.leftup.document.getElementById(top.leftup.PrevSelectedMenuItemID).parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.previousSibling.childNodes(1).childNodes(0).innerText + " &gt; ";
			midtitle += top.leftup.document.getElementById(top.leftup.PrevSelectedMenuItemID).childNodes(1).childNodes(0).innerText;
		}
		else    //Tree˵ı
		{	
			var strID = top.leftup.objPrevSelectedTreeItem.id.split("_");
			var appendID = strID[0] + "_0";
			for (var i=2; i < strID.length; i++ )
			{
				appendID += "_" + strID[i];
				midtitle += top.leftup.document.getElementById(appendID).innerText;
				if (i != (strID.length-1))
				{
					midtitle += " &gt; ";	
				}
			}
		}
		
		var strHeader = "";
		strHeader += "<table width='100%'><tr><td nowrap><div class='div_subtitle'><span class='arrow_subtitle'>";
		strHeader += "ǰλã" + firsttitle + midtitle + addtitle;
		strHeader += "</span></div></td></tr></table>";
		document.write(strHeader);
}

////////////////////////////////////////////////////////
// ƣopenwin
// ˵,λĻ
// ˵url--ڵĵַ
//					width--ڵĿ
//					height--ڵĸ߶
///////////////////////////////////////////////////////
function openwin(url, width, height)
{
	window.open(url,"newwin","resizable=yes,scrollbars=yes,status=yes,toolbar=no,menubar=no,location=no,dependent,width="+width+",height="+height+",left=" +(screen.availWidth-width)/2+",top=0" +(screen.availHeight-height)/2);
}


////////////////////////////////////////////////////////
// ƣswitchTabs
// ˵лTabsҳ
// ˵objTab--Դ
// ڣ2008-1-31
///////////////////////////////////////////////////////
function switchTabs(objTab)
{
	var tabs = objTab.parentNode.childNodes;

	for(i in tabs)
	{  
		if(tabs[i] == objTab)
		{
			tabs[i].className= 'selected';
		}
		else
		{
			tabs[i].className= 'unselected';
		} 
	}
}


////////////////////////////////////////////////////////
// ƣshowFloatHint
// ˵ʾʾ
// ˵txt--ʾݣHtml
//					width--ʾĿ
//					height--ʾĸ߶
// ڣ2008-1-31
///////////////////////////////////////////////////////
function showFloatHint(txt, width, height)
{
	var objHint = document.getElementById("floatHint");
	if (objHint == null)
	{
		objHint = document.createElement("<div id=floatHint style='POSITION:absolute; left:50; height=50; width:"+ width +"; height:"+ height +"; Z-INDEX: 100; border:1px #9999FF solid; padding:4px 4px 2px 4px; background-color:#C6D5F5;'></div>");
		objHint.innerHTML = txt;
		document.body.insertBefore(objHint);
	}
	else
	{
		with(objHint)
		{
			style.width  = width;
			style.height = height;
			innerHTML = txt;
			style.display = "";	
		}
	}

	var x = event.x+document.body.scrollLeft +10; 
	var y = event.y+document.body.scrollTop +10;
	objHint.style.left = x;
	objHint.style.top = y;
	
	document.onmousemove = function ()
	{
		var x = event.x+document.body.scrollLeft +10; 
		var y = event.y+document.body.scrollTop +10;
		objHint.style.left = x;
		objHint.style.top = y;
	};

}

////////////////////////////////////////////////////////
// ƣhideFloatHint
// ˵رոʾshowFloatHintһʹ
// ڣ2008-1-31
///////////////////////////////////////////////////////
function hideFloatHint()
{
	document.getElementById("floatHint").style.display = "none";
}


////////////////////////////////////////////////////////
// ƣinsertRow
// ˵
// ˵tableID--ĿtableID
// ڣ2008-1-31
///////////////////////////////////////////////////////
function insertRow(tableID)
{
	var objTrSur = document.getElementById(tableID).childNodes[1].childNodes[0];
	var objTrDest = document.createElement("TR");
	for(var i =0; i < objTrSur.childNodes.length; i++)
	{
		var objTdDest = document.createElement("TD");
		objTdDest.innerHTML = objTrSur.childNodes[i].innerHTML;
		objTrDest.appendChild(objTdDest);
	}

	document.getElementById(tableID).childNodes[1].appendChild(objTrDest);
}
////////////////////////////////////////////////////////
// ƣdeleteRow
// ˵ɾУinsertRowһʹ
// ˵objTd--td
// ڣ2008-1-31
///////////////////////////////////////////////////////
function deleteRow(objTd)
{
	objTd.parentNode.parentNode.style.display = "none";
}


////////////////////////////////////////////////////////
// ƣShowDate
// ˵ڣ磺xxxxxxxx
///////////////////////////////////////////////////////
function ShowDate()
{
	todayDate = new Date();
	date = todayDate.getDate();
	month= todayDate.getMonth() +1;
	year= todayDate.getYear();
	if(navigator.appName == "Netscape")
	{
		document.write(1900+year);
		document.write("");
		document.write(month);
		document.write("");
		document.write(date);
		document.write("");
	}
	if(navigator.appVersion.indexOf("MSIE") != -1)
	{
		document.write(year);
		document.write("");
		document.write(month);
		document.write("");
		document.write(date);
		document.write("");
	}
}
    	

	

/////////////////////TopMenu /////////////////////////
var ii = 0;
var movx = 0;
// a>0
function movstar(a,time)
{
	// ʱ
	if(a>0)
	{// һ
	if(ii>0)
	return;
	
	}else{// ʱ
	if(ii<0) // һ
	return;
	
	}
	  if(a>0)
		 ii = 1;
		else
		 ii = -1;
	   onmouseout=movover();
	movx=setInterval("mov("+a+")",time) 
	
}
function movover(){ 
	clearInterval(movx)
}
function mov(a)
{ 
	scrollx=top.topframe.frametopmenu.document.body.scrollLeft 
	scrolly=top.topframe.frametopmenu.document.body.scrollTop 
	scrollx=scrollx+a 
	top.topframe.frametopmenu.window.scroll(scrollx,scrolly) 
} 
		
		
		
////////////////////LeftMenu //////////////////////////
function ScrollWindow(id)
{
	if (event.wheelDelta >= 120)
		mscroll(-30,id);
	else if (event.wheelDelta <= -120)
		mscroll(30,id);
}

function mscroll(iScrollNumber,OBJdivObject)
{
		var iTemp = 1;
		iTemp          = iScrollNumber;											//˵
		var OBJTemp    = parent.leftup.document.getElementById(OBJdivObject);	//˵иֵĶ
		var iScrollTop = OBJTemp.scrollTop										//ò

		if (iTemp==0)
		{
			return;                                                             //Ϊ0ͷ  
		}
		OBJTemp.scrollTop=OBJTemp.scrollTop + iTemp;							//˵Ļ
	if (iScrollTop==OBJTemp.scrollTop)
	{
		//˵ٹ ôֹͣ
		return;
	}
	//setTimeout("mscroll(iTemp,'" + OBJdivObject + "')",80);						//һֱťͶʱͬȵĻ
}
	


var goSelectTag = new Array();
var previousObject = null;

// ժҪѡCheckBoxList
// ߣԪ 
// ڣ2005-05-11
// ʾؼIdؿؼIdCheckBoxListIdCheckBoxList Id
function SetCheckBoxList(strTextId, strHideId, strDivId, strChkId, strPostBackId)
{
	var px = 0;
	var py = 0;
	var txt = document.getElementById(strTextId);
	var hid = document.getElementById(strHideId);
	var lay = document.getElementById(strDivId);
	var chkHeader = strChkId;
	var temp = null;
	var hidArr = hid.value.split(";");
	var strText = "";
	// gujiaye add begin
	if (goSelectTag.length > 0)
	{
		if (txt == previousObject){
		  if (lay.style.visibility == "visible"){
	  		DisableDiv(lay);
				for (var i = 0; i < hidArr.length; i++)
				{
					if (document.getElementById(chkHeader + "_" + i).checked)
					{
						strText += hidArr[i] + ";";
					}
				}
				strText = strText.substring(0, strText.length - 1);
				txt.value = strText;
				if (strPostBackId != "" && document.getElementById(strPostBackId) != null)
				{
                    document.getElementById(strPostBackId).click();				
				}
	  		return;
	  	}
	  }
	}
	previousObject = txt;
	// gujiaye add end
	temp = txt;
	do 
	{
			px += temp.offsetLeft;
			py += temp.offsetTop;
			temp = temp.offsetParent;
	}
	while(temp.tagName != "BODY");
	
	//alert(hidArr[0]);
	
	with(lay.style)
	{
		left = px;
		top = py  + txt.offsetHeight;
		width = txt.offsetWidth;
		//height = hidArr.length * 20;
		// gujiaye add begin
		toggleTags(lay); 
		// gujiaye add end
		border = "1px solid #999999";
		OVERFLOW = "auto";
		//Z-index = 101;
		//background-color = "#FFFFFF";
	}

	if (lay.style.visibility == 'visible')
	{
		lay.style.visibility = 'hidden';
	}
	else
	{
		lay.style.visibility = 'visible';
	}
	
	try
	{
		if (lay.style.visibility == 'hidden')
		{
			for (var i = 0; i < hidArr.length; i++)
			{
				if (document.getElementById(chkHeader + "_" + i).checked)
				{
					strText += hidArr[i] + ";";
				}
			}
			
			strText = strText.substring(0, strText.length - 1);
			
			txt.value = strText;
		}
	}
	catch(e)
	{
		//alert(e.message);
	}
}

// gujiaye add begin
function DisableDiv(aEle)
{
	var i;
  for (i in goSelectTag)
  {
  	aEle.style.visibility = "hidden";
  	goSelectTag[i].style.visibility = "visible";
  }
  goSelectTag.length = 0;

}

function Point(iX, iY){
	this.x = iX;
	this.y = iY;
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

function toggleTags(aEle)
{
	with (document.all.tags("SELECT"))
	{
		for (i=0; i<length; i++)
		{
			if ((item(i).Victor!="Won")&&tagInBound(item(i), aEle))
			{
				item(i).style.visibility = "hidden";
				goSelectTag[goSelectTag.length] = item(i);
			}
		}
	}
}

function tagInBound(aTag, aEle)
{
	with (aEle.style)
	{
			var l = parseInt(left);
			var t = parseInt(top);
			var r = l+parseInt(width);
			var b = t+parseInt(height);
			var ptLT = fGetXY(aTag);
			return !((ptLT.x>r)||(ptLT.x+aTag.offsetWidth<l)||(ptLT.y>b)||(ptLT.y+aTag.offsetHeight<t));
	}
}

function trim(strSource)
{
	strSource = LTrim(strSource);
	return RTrim(strSource);
}

// gujiaye add end

