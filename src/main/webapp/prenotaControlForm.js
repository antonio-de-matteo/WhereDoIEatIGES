function controlPrenota(form) {
	 $("#errorData").text('');
	 $("#errorOra").text('');
	 
	 var data=document.getElementById("dataInput").value;
	 var oggi=new Date();
	 var anno=data.slice(0,4);
	 var mese=data.slice(5,7);
	 var giorno=data.slice(8,10);
	 var ora=oggi.getHours();
	 var minuti=oggi.getMinutes();
	 var giornoNow=oggi.getDate();
	 var meseNow=oggi.getMonth();
	 var annoNow=oggi.getFullYear();
	 var nowInput=new Date(annoNow,meseNow,giornoNow,ora,minuti);
	 var dataInput=new Date(anno, mese-1, giorno,ora,minuti);
	 var diff=dataInput.getTime()- nowInput.getTime();
	 
	 var giornoChiusura1=$('#br').text();
	 var giornoChiusura=giornoChiusura1.slice(10);
     var day;
	 if(giornoChiusura=="Domenica") {
    	 day=0;
     }
	 if(giornoChiusura=="Lunedi") {
		 day=1;
	 }
	 if(giornoChiusura=="Martedi") {
		 day=2;
	 }
	 if(giornoChiusura=="Mercoledi") {
		 day=3;
	 }
	 if(giornoChiusura=="Giovedi") {
		 day=4;
	 }
	 if(giornoChiusura=="Venerdi") {
		 day=5;
	 }
	 if(giornoChiusura=="Sabato") {
		 day=6
	 }
	 if((day==dataInput.getDay())&&(diff>=0)) {
		 $("#errorData").text('Scegli un altro giorno, questo è il giorno di chiusura del locale.').css({"color":"red"});
		 return(false);
	 }
	 
	 
	 if(diff<0) {
		 $("#errorData").text('Data inserita già passata.').css({"color":"red"});
		 return(false);
	 }
	 

	 var oraSelezionata=document.querySelector('input[name="ora"]:checked').value;
	 var oraX=oraSelezionata/100;
	 if(diff==0) {
	 if(oraX<ora+1) {
		 $("#errorOra").text("Non puoi piu' prenotare a quest'orario.").css({"color":"red"});
		 return(false);
	 }
	 }
	 
	 
}

function startData() {
	$("#errorData").text('');
}

function startOra() {
	$("#errorOra").text('');
}
//function dateCompare(){     var preimpostata = new Date(2092, 3, 30);   var oggi = new Date();      var diff = preimpostata.getTime()  - oggi.getTime();    if(diff< =0){        alert("La data è già passata!");    }     else {      alert("Non è ancora passata la data!");     } };