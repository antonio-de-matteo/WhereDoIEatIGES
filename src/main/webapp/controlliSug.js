function control(form)
{
	
    $("#errorTitolo").text('');
    $("#errorDescrizione").text('');


	

	if ($("#titolo").val()=="")
	{
    $("#errorTitolo").text('Non hai inserito il titolo').css({"color":"red"});
	 document.getElementById("titolo").focus();
	 return(false);
	}
	
	if($("#titolo").val().length>50) {
		$("#errorTitolo").text('Il titolo deve essere più corto').css({"color":"red"});
		document.getElementById("titolo").focus();
		return(false);
	}

	 
	if ($("#descrizione").val()=="")
	{
	 $("#errorDescrizione").text('Non hai inserito una descrizione').css({"color":"red"});
	 document.getElementById("descrizione").focus();
	 return(false);
	}

	if($("#descrizione").val().length>255) {
		$("#errorDescrizione").text('La descrizione deve essere più corta').css({"color":"red"});
		document.getElementById("descrizione").focus();
		return(false);
	
}


}






function startTitolo() {
	$("#errorTitolo").text('');
}

function startDescrizione() {
	$("#errorDescrizione").text('');
}

