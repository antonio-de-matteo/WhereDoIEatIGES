<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="bean.*" import="dao.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>WhereDoIEat</title>
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="STILI/suggerimenti.css">

</head>
<body>
<%@ include file="header.jsp"%>

<div id="suggerimenti">
<h4 id="helpUs">Aiutaci a migliorare il nostro sito!</h4>
<%
   Boolean done=(Boolean) request.getAttribute("done");
   if(done!=null) {
%>
   <h5 id="done">Suggerimento effettuato con successo</h5>	   
<%
   }
%>
<div id="effettuaSug" >  
<script src="controlliSug.js"></script> 
   <form action="ServletSuggerimenti" method="post" name="suggerimenti" id="formSug" onsubmit="return control(this)">
       <input type="text" placeholder="Titolo" name="titolo" size="30" id="titolo" onclick="startTitolo()" onkeyup="startTitolo()">
       <p id="errorTitolo"></p>
       <textarea placeholder="Descrizione del problema"  cols="60" rows="10" name="descrizione" id="descrizione" onclick="startDescrizione()" onkeyup="startDescrizione()"></textarea>
       <p id="errorDescrizione"></p>
       <button type="submit" id="buttonSug">Invia</button>
   </form>
   


</div>
<script src="visualizzaSug.js"></script>
<div id="visualizzaSug">
   <div id="coglione"></div>
   <h4 id="titoloSuggFatti">Suggerimenti che hai gia' effettuato:</h4>
   <% 
      ArrayList<SuggerimentiBean> sList=new ArrayList<SuggerimentiBean> ();
      SuggerimentiDAO sdao=new SuggerimentiDAO();
      sList=sdao.doRetrieveAll();
      if(sList.size()>0) {
    	  for(int i=0; i<sList.size();i++) {
    		  SuggerimentiBean s=new SuggerimentiBean();
        	  s=sList.get(i);
    	  %><div id="contenitoreSugg<%=s.getId()%>" class="contenitoreSugg">
    	    <div id="titoloEfoto">
    	    <h6 class="visualizzazione" id="visualizzaTitolo"><%=s.getTitolo() %></h6>
    	    <img class="frecce" src="foto/frecceinbasso.png" width="20px" height="20px" id="<%=s.getId()%>" onclick="visualizza(this)">
    	    </div>
    	    <div id="descrizioneDiv">
    	    <p class="visualizzaDesc" id="visualizzaDesc<%=s.getId()%>" style="display:none"><%=s.getTesto() %></p>
    	    </div>
    	    </div>
    	  <%
    	  }
      } else {
    	  %>
    	  <h4>Non hai effettuato ancora nessun suggerimento</h4>
    	  
    	  <%
      }
    	  
   %>

</div>


</div>



 <div id="spaziohome"> <br><br><br> <br><br> </div>
         

<%@ include file="footer.jsp"%>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>