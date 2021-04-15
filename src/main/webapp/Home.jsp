<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      
<%@ page import="bean.*"  import="dao.*" import="java.util.*" import="server.CalcoloMedia" %>

<!DOCTYPE html>    
<html lang="it"> 
<link rel="stylesheet" href="css/bootstrap.min.css">

<head>  
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>WhereDoIEat</title>
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="STILI/centroHome.css">

</head> 
<body>
    <%@ include file="header.jsp"%>  
 

<%   PersonaBean z= new PersonaBean();
     z=(PersonaBean) request.getSession().getAttribute("cliente");
     Boolean mess=(Boolean) request.getAttribute("welcome"); 
     if(mess!=null) {
 %>
 <div>
      <h5 class="welcome">Benvenuto, <%=z.getNome() %>! </h5>
 </div>
 <%} %>


<div class="container">
  <!--Carosello--> 
  <br>
  <div class="bd-example">
      <div id="carousel" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carousel" data-slide-to="0" class="active"></li>
          <li data-target="#carousel" data-slide-to="1"></li>
          <li data-target="#carousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active"> 
            <img src="foto/pizza.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block" id="prova">
              <a href="AltreRicerche?action=SearchNostalgia"><h5><button id="bottoneNost" class="btn btn-warning">Visita i migliori locali</button></h5></a>
              <p id="paragrafo">Scopri i migliori locali secondo la nostra clientela, ovvero quelli con le miglior valutazioni in questo momento.</p>
            </div>
          </div>
          <div class="carousel-item">
            <img src="foto/pasta.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
              <a href="AltreRicerche?action=SearchNostalgia"><h5><button id="bottoneNost" class="btn btn-warning">Visita i migliori locali</button></h5></a>
              <p id="paragrafo">Scopri i migliori locali secondo la nostra clientela, ovvero quelli con le miglior valutazioni in questo momento.</p>
            </div>
          </div>
          <div class="carousel-item">
            <img src="foto/burger.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
              <a href="AltreRicerche?action=SearchNostalgia"><h5><button id="bottoneNost" class="btn btn-warning">Visita i migliori locali</button></h5></a>
              <p id="paragrafo">Scopri i migliori locali secondo la nostra clientela, ovvero quelli con le miglior valutazioni in questo momento.</p>
            </div>
          </div>
        </div>
        <a class="carousel-control-prev" href="#carousel" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carousel" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
    </div>
  </div> 
<% 
     AttivitaDAO adao=new AttivitaDAO();
     ArrayList<AttivitaBean> attList=new ArrayList<AttivitaBean>();
     AttivitaBean a=new AttivitaBean();
     attList=adao.doRetrieveAll();
    
     float res;
     ArrayList<CalcoloMedia> cmList=new ArrayList<CalcoloMedia>();
     for(int x=0; x<attList.size();x++) {
    	 a=attList.get(x);
    	 res=adao.doRetrieveByMediaVal(a.getIdAttivita());
    	 CalcoloMedia cm=new CalcoloMedia();
    	 cm.setId(a.getIdAttivita());
    	 cm.setMedia(res);
    	 cmList.add(cm);
     }
     float x1,y1;
     ArrayList<CalcoloMedia> tempList=new ArrayList<CalcoloMedia>();
     for(int y=0;y<cmList.size();y++) {
    	 y1=cmList.get(y).getMedia();
    	for(int x=y+1;x<cmList.size();x++) {
    		x1=cmList.get(x).getMedia();
    		if(y1<x1) {
    			tempList.add(cmList.get(y));
    			cmList.add(y, cmList.get(x));
    			cmList.remove(y+1);
    			cmList.remove(x);
    			cmList.add(x, tempList.get(0));
    			tempList.clear();
    		} 
    	}
     }
     CalcoloMedia cm=new CalcoloMedia();
     FotoDAO fdao= new FotoDAO();
     ArrayList<FotoBean> fList=new ArrayList<FotoBean>();
     fList=fdao.doRetrieveGroupby();
     String url="";
     %>
     <br>
     <div id="consigliatiDiv">
     <h3 id="consigliati">Consigliati per te!</h3>
     <%
     for(int x=0; x<10 && x<cmList.size(); x++) {
    	 cm.setId(cmList.get(x).getId());
    	 cm.setMedia(cmList.get(x).getMedia());   
    	 a=adao.doRetrieveByKey(cm.getId());
         for(int i=0;i<fList.size();i++) {
        	 if(fList.get(i).getAttivitaIDAttivita()==a.getIdAttivita()) {
        		 url=fList.get(i).getFoto();
        	 }
         }
    	 %>
     <a href="ServletSingoloLocale?id=<%=a.getIdAttivita() %>" id="singoloConsigliato">
     <div  >
     
     <h5 ><%=a.getNome() %></h5>
     <img id="fotoCons" src="<%=url%>" height=100px width=100px>
     <h6>Valutazione:  <%= cm.getMedia() %>/5</h6>
         
        
     
   </div></a>
<%url=""; 
} %>
 </div>
   <div id="spaziohome"> <br><br><br> <br><br> </div>
   
   
   <%@ include file="footer.jsp"%>
        
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>



