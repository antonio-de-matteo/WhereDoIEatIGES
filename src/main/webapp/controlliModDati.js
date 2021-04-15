function control(form)
{
	var maiusc=false
	var number=false;
	
    $("#errorTel").text('Deve contenere anche il prefisso.').css({"color":"grey"});
    $("#errorCitta").text('');
    $("#errorComune").text('');

	
	if($("#telefono").val().length>12) 
	{
		$("#errorTel").text('Il numero di telefono può avere al massimo 12 cifre.').css({"color":"red"});
		document.getElementById("telefono").focus();
		return(false);
	}
	
	var regexTel = "39{1}[0-9]{10}";
	if($("#telefono").val()!="") {
	   if(!($("#telefono").val().match(regexTel))) 
	   {
		  $("#errorTel").text('Non hai inserito un numero di telefono valido.').css({"color":"red"});
		  document.getElementById("telefono").focus();
		  return(false);
	   }
	}
	
	
	if($("#citta").val().length>30) 
	{
		$("#errorCitta").text('Il nome della citta è troppo lungo.').css({"color":"red"});
		document.getElementById("citta").focus();
		return(false);
	}
	
	var regexcitta="^[a-zA-Z]+(?:[\s'][a-zA-Z]+)*$";
	if($("#citta").val()!="") {
	  if(!($("#citta").val().match(regexcitta))) {
		  $("#errorCitta").text('Formato non corretto').css({"color":"red"});
		  document.getElementById("citta").focus();
		  return(false);
	  }
	}
	
	if($("#comune").val().length>15) 
	{
		$("#errorComune").text('Il nome del comune è troppo lungo').css({"color":"red"});
		document.getElementById("comune").focus();
		return(false);
	}
	if($("#comune").val()!="") {
	  if(!($("#comune").val().match(regexcitta))) {
		  $("#errorComune").text('Formato non corretto').css({"color":"red"});
		  document.getElementById("comune").focus();
		  return(false);
	  }
	}
}







function startTelefono() {
	$("#errorTel").text('Deve contenere anche il prefisso.').css({"color":"grey"});
}

function startCitta() {
	$("#errorCitta").text('');
}

function startComune() {
	$("#errorComune").text('');
}
