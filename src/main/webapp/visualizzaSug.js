function visualizza(obj)
{
	var id=$(obj).attr("id");
	var image=document.getElementById(id).src;
	var descrizione="#visualizzaDesc"+id;
	var contenitore="#contenitoreSugg"+id;
	var contenuto=$(descrizione).text();
	var lung= contenuto.length;
	if(image=="http://localhost:8080/wheredoieat/foto/frecceinbasso.png") {
		document.getElementById(id).src="foto/frecciainalto.png";
	    $(descrizione).css({"display":"block"});
	    if(lung<50) {
	    	$(contenitore).css({"margin-bottom":"20px"});
	    }
	    if((lung>49) && (lung<100)) {
	    	$(contenitore).css({"margin-bottom":"40px"});
	    }
	    if((lung>99)&&(lung<150)) {
	    	$(contenitore).css({"margin-bottom":"60px"});
	    }
	    if((lung>149)&&(lung<200)) {
	    	$(contenitore).css({"margin-bottom":"80px"});
	    }
	    if(lung>199)  {
	    	$(contenitore).css({"margin-bottom":"100px"});
	    }
	  	    
	} else {
		document.getElementById(id).src="foto/frecceinbasso.png";
		$(descrizione).css({"display":"none"});
		$(contenitore).css({"margin-bottom":"-15px"});
	}
	
	
}

