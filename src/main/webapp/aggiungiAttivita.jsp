<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="dao.*"  import="bean.*" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WhereDoIEat</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="STILI/attivita.css">
    <script>
   
          function validaFormatoNome(nome){
        	  var regexp =new RegExp("^[a-zA-Z0-9 '_.-]*$");
        	    return regexp.test(nome);
          }
          
          function validaFormatoComune(comune){
        	  var regexp =new RegExp("^[a-zA-Z']+(?:[\s][a-zA-Z ']+)*$");
        	    return regexp.test(comune);
          }
          
          function validaFormatoIndirizzo(indirizzo){
        	  var regexp = new RegExp("[A-Z][a-zA-Z][^#&<>\~;$^%{}@]{1,40}$");
        	    return regexp.test(indirizzo);
          }
          
          function validaFormatoTelefono(telefono){
        	  var regexp = new RegExp("39{1}[0-9]{10}");
        	    return regexp.test(telefono);
          }

      function Verifica(){

    	  var nome = document.modulo.nome.value;
    	  var indirizzo = document.modulo.indirizzo.value;
    	  var comune = document.modulo.comune.value;
    	  var telefono = document.modulo.telefono.value;
    	  var mappa = document.modulo.mappa.value;
    	 
    	  if($("#nome").val().length>20) {
    		  alert("Il campo nome non può avere lunghezza >20");
    		  return false;
    	  } 
    	  if($("#nome").val().length<1 )  {
              alert("Il campo nome non può essere vuoto");
    		  return false;
    	  }
    	  if(!(validaFormatoNome($("#nome").val())) ) {
    		  alert("Il campo nome non rispetta il formato");
    		  return false;
    	  }
    	  
    	  if($("#indirizzo").val().length<1) {
    		  alert("Il campo indirizzo non può essere vuoto");
    		  return false;
    	  }
    	  if ($("#indirizzo").val().length>40) {
    		  alert("Il campo indirizzo non può avere una lunghezza >40");
    		  return false;
    	  }
    	  if(!(validaFormatoIndirizzo($("#indirizzo").val()))){
        	  alert("Il campo indirizzo non rispetta il formato. Es. Via Antonio Rossi n°3");
        	  return false;
    	  }
    		                 
          if($("#comune").val().length<3) {
        	  alert("Il campo comune non puo' essere cosi corto.");
        	  return false;
          } if($("#comune").val().length>20) {
        	  alert("Il campo comune non puo' avere una lugnhezza >20");
        	  return false;
          }

          if($("#cat").val().length=6){
              alert("Scegliere una categoria valida");
              return false;
          }

          if(!(validaFormatoComune($("#comune").val())) ){
        	  alert("Il campo comune non rispetta il formato");
        	  return false;
    	  }

          if($("#telefono").val().length<1) {
        	  alert("Il campo telefono non pu' essere vuoto");
        	  return false;
          }
          if(!(validaFormatoTelefono($("#telefono").val()))){
        	  alert("Il campo telefono non rispetta il formato. Es. 393404181948");
        	  return false;
    	  }
           
	      if($("#mappa").val().length>400){
	        	  alert("Il path della mappa e' troppo lungo.");
	        	  return false;
	    	  }
	      if($("#numeroDiPosti").val().length<1){
	    	  alert("Il campo del numero dei posti non può essere vuoto.");
	    	  return false;
	      }
	      
	      if($("#numeroDiPosti").val().length>5){
	    	  alert("Il campo del numero dei posti non può essere >10000.");
	    	  return false;
	      }


      		return true;
          }
     
    	  
    </script>
 
</head>
<body>
 
<%@ include file="header.jsp"%>

<br><br>
<%Boolean successo = (Boolean) request.getAttribute("successo");
  if(successo!=null && successo==true){%>
  <p>Attivita aggiunta con successo nel sistema.</p>
  <%}else{ %>
<div class="container">
    <div class="card">
        <div class="card-header carta1">
            COMPILA I CAMPI E INSERISCI LA TUA NUOVA ATTIVITA'
        </div>
        <div class="card-body">
            <form action="AggiungiAttivitaControl" method="post" name="modulo" onsubmit="javascript:return Verifica()">
                <br>
                <div class="form-group">
                <% Boolean err = (Boolean) request.getAttribute("errore");
                   if(err!=null && err==true){ 
                %>
                <p id="errore">L'ora di chiusura deve essere maggiore di quella di apertura</p>
                <%} %>
                    <label for="inputMessage">Nome:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
                    <input type="text" name="nome" class="BORDONERO" id="nome">
                    <br>
                    <label for="inputMessage">Indirizzo:&nbsp&nbsp&nbsp</label>
                    <input type="text" name="indirizzo" class="BORDONERO" id="indirizzo">
                    <br>
                    <label for="inputMessage">Comune:&nbsp&nbsp&nbsp</label>
                    <input type="text" name="comune" class="BORDONERO" id="comune">
                    <br>
                    <label for="inputMessage">Telefono:&nbsp&nbsp&nbsp</label>
                    <input type="text" name="telefono" class="BORDONERO" id="telefono">
                    <br>
                    <label for="inputMessage">Giorno di chiusura:&nbsp</label>
                    <select name="giornoChiusura" class="BORDONERO" required>
                       <option value="nessuno">nessuno</option>
                       <option value="Lunedi">Lunedi</option>
                       <option value="Martedi">Martedi</option>
                       <option value="Mercoledi">Mercoledi</option>
                       <option value="Giovedi">Giovedi</option>
                       <option value="Venerdi">Venerdi</option>
                       <option value="Sabato">Sabato</option>
                       <option value="Domenica">Domenica</option>
                    </select>
                    <br>
                    <label for="inputMessage">Ora apertura:&nbsp</label>
                    <select name="oraApertura" class="BORDONERO" id="a">
                       <option value="12">12:00</option>
                       <option value="13">13:00</option>
                       <option value="14">14:00</option>
                       <option value="15">15:00</option>
                       <option value="16">16:00</option>
                       <option value="17">17:00</option>
                       <option value="18">18:00</option>
                       <option value="19">19:00</option>
                       <option value="20">20:00</option>
                    </select>
                    <br>
                    <label for="inputMessage">Ora chiusura:&nbsp</label>
                    <select name="oraChiusura" class="BORDONERO" id="c">
                       <option value="15">15:00</option>
                       <option value="16">16:00</option>
                       <option value="17">17:00</option>
                       <option value="18">18:00</option>
                       <option value="19">19:00</option>
                       <option value="20">20:00</option>
                       <option value="20">21:00</option>
                       <option value="20">22:00</option>
                       <option value="20">23:00</option>
                       <option value="20">24:00</option>
                    </select>
                    <br>
                    <label for="inputMessage">Numero posti:&nbsp</label>
                    <input type="number"  name="posti" class="BORDONERO" id="numeroDiPosti">
                    <br>
                    <label for="inputMessage">Mappa:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
                    <input type="text" name="mappa" class="BORDONERO" id="mappa">
                    <br>
                    <label for="inputMessage">Foto del profilo:&nbsp&nbsp</label>
                    <input type="text" name="foto" class="BORDONERO">
                    <br>
                    <label for="inputMessage">Categoria:&nbsp&nbsp</label>
                    <select name="cat" class="BORDONERO" id="cat" required>
                        <option value ="cvuota"> Seleziona una categoria</option>
                        <option value="Ristorante">Ristorante</option>
                        <option value="Pizzeria">Pizzeria</option>
                        <option value="Pub">Pub</option>
                        <option value="FastFood">FastFood</option>
                        <option value="Vegan">Vegan</option>
                        <option value="Rosticceria">Rosticceria</option>
                    </select>
                </div><br>
                    <button type="submit" class="btn btn-dark btn-lg float-left pren">Conferma</button>
                <br>
            </form>
        </div>
    </div>

</div>
<%} %>
<div id="spaziohome"><br><br><br><br><br></div>
</div>
         
    <%@ include file="footer.jsp"%>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>