function control(form)
{
	var maiusc=false
	var number=false;
	
    $("#errorNome").text('');
    $("#errorCognome").text('');
    $("#errorU").text('Deve contenere almeno 1 carattere e non piu di 32').css({"color":"grey"});
    $("#errorEmail").text('');
    $("#errorTel").text('Deve contenere anche il prefisso.').css({"color":"grey"});
    $("errorCitta").text('');
    $("#errorP1").text('La password deve avere almeno 8 caratteri, massimo 25 caratteri e deve contenere un valore numerico e una lettera maiuscola').css({"color":"grey"});
    $("#errorP2").text('');
    $("#error").text('');


	

	if ($("#nome").val()=="")
	{
    $("#errorNome").text('Non hai inserito il tuo nome').css({"color":"red"});
	 document.getElementById("nome").focus();
	 return(false);
	}
	
	if ($("#nome").val().length>20)
	{
    $("#errorNome").text('Il nome non può superare i 20 caratteri').css({"color":"red"});
	 document.getElementById("nome").focus();
	 return(false);
	}
	
	var regexnome="^[a-zA-Z]+(?:[\s'][a-zA-Z]+)*$";
	if(!($("#nome").val().match(regexnome))) {
		$("#errorNome").text('Formato nome non corretto').css({"color":"red"});
		 document.getElementById("nome").focus();
		 return(false);
	}

	 
	if ($("#cognome").val()=="")
	{
	 $("#errorCognome").text('Non hai inserito il tuo cognome').css({"color":"red"});
	 document.getElementById("cognome").focus();
	 return(false);
	}
	
	if ($("#cognome").val().length>20)
	{
    $("#errorCognome").text('Il cognome non può superare i 20 caratteri').css({"color":"red"});
	 document.getElementById("cognome").focus();
	 return(false);
	}
	
	if(!($("#cognome").val().match(regexnome))) {
		$("#errorCognome").text('Formato cognome non corretto').css({"color":"red"});
		 document.getElementById("cognome").focus();
		 return(false);
	}
	
	

	if ($("#username").val()=="")
	{
     $("#errorU").text('Non hai inserito il tuo username').css({"color":"red"});
	 document.getElementById("username").focus();
	 return(false);
	}	
	
	if ($("#username").val().length<1)
	{
		$("#errorU").text('Inserire una username con almeno 1 carattere.').css({"color":"red"});
	 document.getElementById("username").focus();
	 return(false);
	}

	if ($("#username").val().length>32)
	{
		$("#errorU").text('Inserire una username con massimo 32 caratteri.').css({"color":"red"});
	 document.getElementById("password").focus();
	 return(false);
	}
	
	var regexuser="^[A-Za-z0-9]+(?:[ _-][A-Za-z0-9]+)*$";
	if(!($("#username").val().match(regexuser))) {
		$("#errorU").text('Formato username non corretto').css({"color":"red"});
		 document.getElementById("password").focus();
		 return(false);
	}
	
	if($("#telefono").val()=="")
		{
		$("#errorTel").text('Non hai inserito il tuo numero di telefono.').css({"color":"red"});
		document.getElementById("telefono").focus();
		return(false);
		}
	

	if($("#telefono").val().length<8) 
	{
		$("#errorTel").text('Il numero di telefono ha almeno 8 cifre.').css({"color":"red"});
		document.getElementById("telefono").focus();
		return(false);
	}
	
	if($("#telefono").val().length>20) 
	{
		$("#errorTel").text('Il numero di telefono può avere al massimo 20 cifre.').css({"color":"red"});
		document.getElementById("telefono").focus();
		return(false);
	}
	
	var regexTel = "39{1}[0-9]{10}";
	if(!($("#telefono").val().match(regexTel))) 
	{
		$("#errorTel").text('Non hai inserito un numero di telefono valido.').css({"color":"red"});
		document.getElementById("telefono").focus();
		return(false);
	}
	
	if($("#citta").val()=="") 
	{
		$("#errorCitta").text('Non hai inserito la tua citta.').css({"color":"red"});
		document.getElementById("citta").focus();
		return(false);
	}
	
	if($("#citta").val().length>30) 
	{
		$("#errorCitta").text('Il nome della citta è troppo lungo.').css({"color":"red"});
		document.getElementById("citta").focus();
		return(false);
	}
	
	var regexcitta="^[a-zA-Z]+(?:[\s'][a-zA-Z]+)*$";
	if(!($("#citta").val().match(regexcitta))) {
		$("#errorCitta").text('Formato non corretto').css({"color":"red"});
		document.getElementById("citta").focus();
		return(false);
	}
	
	if($("#comune").val()=="") 
	{
		$("#errorComune").text('Non hai inserito il tuo comune').css({"color":"red"});
		document.getElementById("comune").focus();
		return(false);
	}
	
	if($("#comune").val().length>15) 
	{
		$("#errorComune").text('Il nome del comune è troppo lungo').css({"color":"red"});
		document.getElementById("comune").focus();
		return(false);
	}
	
	if(!($("#comune").val().match(regexcitta))) {
		$("#errorComune").text('Formato non corretto').css({"color":"red"});
		document.getElementById("comune").focus();
		return(false);
	}
	
	 
	if ($("#email").val()=="")
	{
     $("#errorEmail").text('Non hai inserito la tua e-mail').css({"color":"red"});
	 document.getElementById("email").focus();
	 return(false);
	}
	
	if($("#email").val().length>100) {
		$("#errorEmail").text('email troppo lunga').css({"color":"red"});
		 document.getElementById("email").focus();
		 return(false);
	} 
	
	var regexEmail = "^\\w+([\\.-]?\\w+)@\\w+([\\.-]?\\w+)(\\.\\w{2,3})+$";
	if(!($("#email").val().match(regexEmail))) {
		$("#errorEmail").text('Non hai inserito una e-mail valida').css({"color":"red"});
		 document.getElementById("email").focus();
		 return(false);
	}

	
if ($("#password").val()=="")
{
	$("#errorP1").text('Inserire una password valida.').css({"color":"red"});
	document.getElementById("password").focus();
 return(false);
}

if ($("#password").val().length<8)
{
	$("#errorP1").text('Inserire una password con almeno 8 caratteri.').css({"color":"red"});
 document.getElementById("password").focus();
 return(false);
}

if ($("#password").val().length>25)
{
	$("#errorP1").text('Inserire una password con massimo 25 caratteri.').css({"color":"red"});
 document.getElementById("password").focus();
 return(false);
}

	for(var i=0; i<$("#password").val().length;i++)
	{
		var c=$("#password").val().charAt(i);
		 if(c.toUpperCase()==c)
		 {
			 maiusc=true;
		 }
	}

	if(maiusc==false) 
		{
		$("#errorP1").text('La password deve avere almeno un carattere maiuscolo.').css({"color":"red"});
		 document.getElementById("password").focus();
		 return(false);
		}
	
	for(var i=0; i<$("#password").val().length;i++)
	{
		
	var c=$("#password").val().charAt(i);
	if((c=='0') || (c=='1') || (c=='2') || (c=='3') || (c=='4') || (c=='5') || (c=='6') || (c=='7') || (c=='8') || (c=='9'))
	 {
		 number=true;
	 }
	}
		if(number==false) 
			{
			$("#errorP1").text('La password deve avere almeno un numero.').css({"color":"red"});
				 document.getElementById("password").focus();
				 return(false);
			}
		
		if ($("#password2").val()=="")
		{
	    $("#errorP2").text('Devi confermare la tua password').css({"color":"red"});
		document.getElementById("password2").focus();
		 return(false);
		}

		var p = $("#password").val();
		var p2= $("#password2").val();

		if(!(p==p2))
		{
	     $("#errorP2").text('Le due password non corrispondono').css({"color":"red"});
		 document.getElementById("password2").focus();
		 return(false);
		}		
}













function startNome(){
	    $("#errorNome").text('');
}

function startCognome(){
    $("#errorCognome").text('');
}

function startUsername(){
    $("#errorU").text('Deve contenere almeno 1 carattere e non piu di 32').css({"color":"grey"});
}

function startEmail(){
    $("#errorEmail").text('');
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

function startPassword(){
    $("#errorP1").text('La password deve avere almeno 8 caratteri, massimo 25 caratteri e deve contenere un valore numerico e una lettera maiuscola').css({"color":"grey"});
}

function startPassword2(){
    $("#errorP2").text('');
}

