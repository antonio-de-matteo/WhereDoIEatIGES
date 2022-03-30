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
 
</head>
<body>
 
<%@ include file="header.jsp"%>
<%String cat =(String) request.getAttribute("cat");
if(cat!=null)
	%>
<h2> <%=cat%></h2>
<%
%>
<div class="row">
<%ArrayList<AttivitaBean> l = new ArrayList<AttivitaBean>();
 l = (ArrayList<AttivitaBean>) request.getAttribute("lista");
  if(l!=null && l.size()!=0){
	  for(AttivitaBean a : l){ 
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
       
       <div class = "col-md-4" id="cardColumn">
       	<form id="ViewForm" method="get" action="###dove voglio andare">
        	<div id="cardProdotti" class="card">
          		<a href="ServletSingoloLocale?id=<%=a.getIdAttivita() %>">
          		<div id="picc">  <!-- dove voglio anda -->
          			<img id="prodottoPic" src="<%=url %>" class="card-img-top img-responsive" alt="...">
          		</div>
          		</a>
			
			<div class="card-body" id="cards">
			  <h5 class="card-title"><%=a.getNome()%></h5>
			    
			  	<div class="card-bottom">
			  		<h3><%=a.getComune() %></h3>
			  	</div>
			</div>
		    </div>
		 </form>
        </div>
       
       
<%}}} %>
</div>

<div id="spaziohome"><br><br><br><br><br></div>

         
    <%@ include file="footer.jsp"%>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>