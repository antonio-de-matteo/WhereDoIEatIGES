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
    <link rel="stylesheet" href="STILI/attivitaSpecifica.css">
    <script>
    function visualizza(foto){
	    var st = foto.src;
        $('#galleryImage').attr("src",st.replace("70x70","500x300"));
    }
    

    function Verifica(){
    	  var commento = document.modulo.commento.value;
    	    
        if(commento.length<10) { 
      	  alert("Il commento deve avere almeno 10 caratteri.");
      	  return false;
    	  }
        if(commento.length>255){
        	alert("Il commento puo' avere massimo 255 caratteri.");
        	  return false;
        }
            				
    	return true;
    }
    </script> 
</head>
<body>
 
<%@ include file="header.jsp"%>
<script src="formPrenota.js"></script>
  <script src="prenotaControlForm.js"></script>
<% AttivitaBean a=new AttivitaBean();
   a=(AttivitaBean)request.getAttribute("singolaAttivita");
   FotoDAO fdao= new FotoDAO();
   ArrayList<FotoBean> fList=new ArrayList<FotoBean>();
   fList=fdao.doRetrieveGroupby();
   String url="";
   if(a!=null) {
	   for(int i=0;i<fList.size();i++) {
	     if(fList.get(i).getAttivitaIDAttivita()==a.getIdAttivita()) {
  		    url=fList.get(i).getFoto();
  	     }
	   }
	   
%>
   
   <!--Main layout-->
    
  <main class="mt-0 pt-0">
  <%
     PersonaBean user=(PersonaBean)request.getSession().getAttribute("cliente");
     if(user!=null) {
  %>
  <button id="buttonPrenotazione" name="prenota" class="btn btn-dark btn-lg float-right pren" onClick="prenota()">prenota</button>
      <div class="card-bottom">
          <hr>
          <a href="ServletPreferiti?Codice=<%= a.getIdAttivita() %>" class="btn btn-primary mybutton btn-danger">Aggiungi ai preferiti</a>
      </div>
  <%} else { %>
  <button id="buttonPrenotazione" name="prenota" class="btn btn-dark btn-lg float-right pren" > <a href="login.jsp">prenota</a></button>
  <%} %>
    <div class="container dark-grey-text mt-5" id="attivita" onClick="chiudiDiv()">
       <%
       Boolean giornoChiusura=(Boolean)request.getAttribute("giornoChiusura");
             if(giornoChiusura!=null) {
            %>
            <p>Ci dispiace, ma il giorno selezionato è il nostro giorno di chiusura</p>
         <%} 
           Boolean postiNonDisp=(Boolean)request.getAttribute("postiNonDisp");
           if(postiNonDisp!=null) {
         %>
         <p>Nella data e nell'ora inserita non ci sono sufficienti posti a disposizione.</p>
          
         <%} 
           Boolean ok=(Boolean) request.getAttribute("ok");
           if(ok!=null) {
        	   
         %>
           <p>Prenotazione Effettuata con successo. Trovi la tua prenotazione nella tua area personale.</p>
         <%}
           Boolean ris=(Boolean)request.getAttribute("Ristoratore");
           if(ris!=null) {%>
             <p>L'utente di tipo ristoratore non puo' effettuare recensioni.</p>
           <%}
           
           %>
      <!--Grid row-->
      <div class="row wow fadeIn">

        <!--Grid column-->
        <div class="col-md-4 mb-4 div1">
          <h1 id="titl"><%=a.getNome() %></h1><br>
          <div id="muu">
          <img src="<%=url%>" class="img-fluid" alt="">
          </div>
              <br>         
              <div class="d-flex justify-content-left">
               
                 
              </div>
        </div>
        <!--Grid column-->

        <!--Grid column-->
        <div class="col-md-8 mb-4">

          <!--Content-->
          <div class="p-4">

            <div class="mb-3">
                <span class="badge badge-secondary" id="cat"><%=a.getOraApertura()%>:00-<%=a.getOraChiusura() %>:00</span>
                <p class="badge badge-secondary" id="br">Chiuso di <%=a.getGiornoChiusura() %></p>                
            </div>

			<%
  
   			PiattiDAO piattodao=new PiattiDAO();
  			 ArrayList<PiattiBean> pList=new ArrayList<PiattiBean>();
  			 pList=piattodao.doRetrieveByAttivita(a.getIdAttivita());
			%>
            

            <p class="lead">
            <span id="prezzovero">I piatti consigliati del locale</span>
            <br>
            <%
   			for(int i=0;i<pList.size();i++) {
	   		PiattiBean piatto= new PiattiBean();
	   		piatto=pList.get(i);
			%>      
              <span><%=piatto.getPiatto() %>: <%=piatto.getDescrizione() %></span>
              <br>
            <%} %>
            </p>

            <br>
            <h4 id="mappa">Come raggiungere il locale:</h4>
            <iframe id="frameMaps" src="<%=a.getMappa() %>" width="400" height="250" frameborder="0" style="border:0;"></iframe>
            <br>
          </div>
          <!--Content-->

        </div>
        <!--Grid column-->

      </div>
      <!--Grid row-->
      
  <%
    fList.clear();
    fList=fdao.doRetrieveByAttivita(a.getIdAttivita());%>


<div class="container py-3 px-0">
</div>
<div class="container bg-dark py-4 mb-4 min-vh-50 shadow shadow-lg">
    <div class="row">
        <div class="col-12 text-white gallery">
            <div class="row">
                
                <!-- timeline item 1 left dot -->
                <div class="col-auto text-center flex-column d-none ">
                    <div class="row h-50">
                        <div class="col">&nbsp;</div>
                        <div class="col">&nbsp;</div>
                    </div>
                    <h5 class="m-0">
                        <span class="badge badge-pill border border-secondary">&nbsp;</span>
                    </h5>
                    <div class="row h-50">
                        <div class="col border-right border-secondary">&nbsp;</div>
                        <div class="col">&nbsp;</div>
                    </div>
                </div>
                <!-- timeline item 1 event content -->
                <div class="col py-2">
                    <div class="card bg-transparent border-0 text-light">
                        <div class="card-body">
                            <div class="float-right text-muted"><i class="fa fa-check"></i></div>
                            <p class="card-title text-uppercase">Le foto del locale</p>
                            <div class="row no-gutters">
                            <%for(int i=0;i<fList.size();i++) {
    							FotoBean f1=new FotoBean();
    							f1=fList.get(i);
  							%>
                                <div class="col-2 col-sm-auto">
                                    <a href data-toggle="modal" data-target="#galleryModal"><img src="<%=f1.getFoto() %>"width=100px height=100px class="mb-2 mr-2 img-fluid" onclick = "javascript: visualizza(this)" /></a>
                                </div>
                            <%} }%>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="galleryModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content bg-dark">
            <div class="modal-header border-0">
                <h5 class="font-weight-light text-white mb-0" id="galleryTitle"></h5>
                <button type="button" class="close float-right text-dark" aria-label="Close" data-dismiss="modal">
                  <span aria-hidden="true">&#xD7;</span>
                </button>
            </div>
            <div class="modal-body p-0 text-center bg-alt">
                <img src="//placehold.it/1200x700/222?text=..." id="galleryImage" class="loaded-image mx-auto img-fluid">
            </div>
            <div class="modal-footer border-0">
                <button class="btn btn-outline-light" data-dismiss="modal" aria-hidden="true">OK</button>
            </div>
        </div>
    </div>
</div>

<br><br>

<% //if(p.getTipo()==1){
 %>
<% Boolean recFatta = (Boolean) request.getAttribute("recensioneFatta");
   if(recFatta!=null && recFatta){%>	
         <p>recensione effettuata con successo<p> 
 <%}
   else{%>
<div class="container">
    <div class="card">
        <div class="card-header carta1">
            LASCIA QUI LA TUA RECENSIONE...
        </div>
        <div class="card-body">
            <form action="RecensioneControl" method="post" name="modulo" onsubmit="javascript:return Verifica()">
                <div class="form-row">
                    <div class="c4l-rating">
                    <label for="inputEmail">Valutazione:</label>
                    <br>
    <input name="c4l-rating" type="radio" id="c4l-rate1" value="1" />
    <label for="c4l-rate1"></label>
 
    <input name="c4l-rating" type="radio" id="c4l-rate2" value="2" />
    <label for="c4l-rate2"></label>
 
    <input name="c4l-rating" type="radio" id="c4l-rate3" value="3" checked />
    <label for="c4l-rate3"></label>
 
    <input name="c4l-rating" type="radio" id="c4l-rate4" value="4" />
    <label for="c4l-rate4"></label>
 
    <input name="c4l-rating" type="radio" id="c4l-rate5" value="5" checked />
    <label for="c4l-rate5"></label>
                  </div>
                </div>
                <br><br>
                <div class="form-group">
                    <label for="inputMessage">Commento:</label>
                    <textarea name="commento" class="form-control BORDONERO" rows="5" id="inputMessage"></textarea>
                </div><br>
                <input type="hidden" name="attivita" value="<%=a.getIdAttivita()%>">
                <%
                PersonaBean user=(PersonaBean)request.getSession().getAttribute("cliente");
                if(user!=null){ %>
                    <button type="submit" class="btn btn-dark btn-lg float-left pren">Conferma</button>
                    <%} else {%>
                    <button type="submit" class="btn btn-dark btn-lg float-left pren"><a href="login.jsp">Conferma</a></button>
                    <%} %>
                <br>
           

            </form>
        </div>
    </div>

</div>
<%}//} %>

<%RecensioneDAO rdao= new RecensioneDAO();
ArrayList<RecensioneBean> rList=new ArrayList<RecensioneBean>();
rList=rdao.doRetrieveAll(a.getIdAttivita());%>

<br><br>
<div class="container">
    <div class="card">
        <div class="card-header carta1">
            RECENSIONI SULL'ATTIVITA'
        </div>
        <div class="card-body">
                <br><br>
                <div class="form-group">
                <%for(int i=0;i<rList.size();i++) {
    							RecensioneBean r1=new RecensioneBean();
    							r1=rList.get(i);
  							%>
                    <label for="inputMessage"><%=r1.getPersonaUsername() %> :</label>
                    <textarea class="form-control BORDOGRIGIO" rows="4" readonly><%=r1.getCommento() %></textarea>
                    <br>
                 <%} %>
                </div><br>
                <br>
        </div>
    </div>

</div>


<div id="spaziohome"><br><br><br><br><br></div>
</div>
<div id="prenotazione">
   <h4 id="titoloPren">Inserisci i dati per la prenotazione</h4>
   <img src="foto/x.png" id="chiudiDiv" onMouseOver="effettoX()" onMouseOut="effettoXEsce()" onClick="chiudiDiv()">
   <div>
      <form action="ServletPrenotazione?id=<%=a.getIdAttivita() %>" method="post" name="prenotazione" id="formPren" onsubmit="return controlPrenota(this)">
         <fieldset id="data" onMouseOver="effettoData()" onMouseOut="effettoDataEsce()">
            <legend id="legendData">Data</legend>
            <input type="date" name="data" required onclick="startData()" onkeyup="startData()" id="dataInput">
            <p id="errorData"></p>
         </fieldset>
         <fieldset id="ora" onMouseOver="effettoOra()" onMouseOut="effettoOraEsce()">
            <legend id="legendOra">Ora</legend>
            <%
             for(int x=a.getOraApertura();x<a.getOraChiusura();x++) {
            %>
            <div class="oraRadio">
               <input type="radio" name="ora" value="<%=x%>00" required><p><%=x %>:00</p>
            </div>
            <div class="oraRadio">
               <input type="radio" name="ora" value="<%=x %>30" required><p><%=x %>:30</p>
            </div>
        <%} %>  
                     <p id="errorOra"></p>
         </fieldset>

         <fieldset id="posti" onMouseOver="effettoPosti()" onMouseOut="effettoPostiEsce()">
            <legend id="legendPosti">Posti</legend>
            <input type="number" name="posti" min="1" max="<%=a.getNumPosti() %>" value="1" id="numberPosti">
         </fieldset>
         <input type="submit" name="conferma" value="Prenota" id="buttonPrenota" onMouseOver="confermaPren()" onMouseOut="confermaPrenEsce()">
      </form> 
   </div>
</div>
         
    <%@ include file="footer.jsp"%>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>