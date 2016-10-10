// JavaScript Document

$(document).ready(function(){
    $("#editTableTd tbody td").each(function(i){
    if(i%5 != 4){ 
	$(this).click(function(){
		var inputobj = $("<input type='text'>");
		var tdobj = $(this);
		var text = tdobj.html();
		if(tdobj.children("input").length>0){
			return false;
		}
		tdobj.html("");
		
		inputobj //.css("border","1px solid red")
				.css("font-size",tdobj.css("font-size"))
				.css("font-family",tdobj.css("font-family"))
				//.css("background-color",tdobj.css("background-color"))
				//.css("color","#C75F3E")
				.width(tdobj.width()-5)
				.val(text)
				.appendTo(tdobj);
				
		inputobj.get(0).select();
		inputobj.click(function(){
			return false;
		});
		
		inputobj.blur(function() {
           tdobj.html(inputobj.val());
        });
		
		inputobj.keyup(function(event){
			var keycode = event.which;
			if(keycode==13){
				var inputtext = $(this).val();
				tdobj.html(inputtext);
			}
			
			//esc
			if(keycode == 27){
				tdobj.html(text);
			}
		});
		
	});
	
	}
    });
    });


	
	