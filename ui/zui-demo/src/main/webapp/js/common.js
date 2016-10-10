
function SetCheckBoxListForCheck(strTextId, strHideId, strDivId, strChkId, strPostBackId)
{        
	var hid = document.getElementById(strHideId);
	if (hid != null && hid.value != "")
	{
		SetCheckBoxList(strTextId, strHideId, strDivId, strChkId, strPostBackId);
	}        
}


var goSelectTag = new Array();
var previousObject = null;

// ժҪѡCheckBoxList
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
	
		toggleTags(lay); 
	
		border = "1px solid #999999";
		OVERFLOW = "auto";
		//Z-index = 101;
		//background-color = "#FFFFFF";
	}

	if (lay.style.display == '')
	{
		lay.style.display = 'none';
	}
	else
	{
		lay.style.display = '';
	}
	
	try
	{
		if (lay.style.display == 'none')
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
	with (document.getElementsByTagName("SELECT"))
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
//end
