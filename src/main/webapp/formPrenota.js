function prenota()
{
   $("#prenotazione").css({"display":"block"});	
   $("#attivita").css({"opacity":"0.3"});
}

function effettoX() {
	$("#chiudiDiv").css({"height":"7%"});
	$("#chiudiDiv").css({"width":"7%"});
	$("#chiudiDiv").css({"left":"92%"});
}

function effettoXEsce() {
	$("#chiudiDiv").css({"height":"5%"});
	$("#chiudiDiv").css({"width":"5%"});
	$("#chiudiDiv").css({"left":"94%"});
}

function chiudiDiv() {
	$("#prenotazione").css({"display":"none"});	
	$("#attivita").css({"opacity":"1"});
}

function confermaPren() {
	$("#buttonPrenota").css({"background-color":"red"});
}

function confermaPrenEsce() {
	$("#buttonPrenota").css({"background-color":"darkred"});
}

function effettoPosti() {
	$("#legendPosti").css({"background-color":"red"});
}

function effettoPostiEsce() {
	$("#legendPosti").css({"background-color":"darkred"});
}

function effettoOra() {
	$("#legendOra").css({"background-color":"red"});
}

function effettoOraEsce() {
	$("#legendOra").css({"background-color":"darkred"});
}

function effettoData() {
	$("#legendData").css({"background-color":"red"});
}

function effettoDataEsce() {
	$("#legendData").css({"background-color":"darkred"});
}
