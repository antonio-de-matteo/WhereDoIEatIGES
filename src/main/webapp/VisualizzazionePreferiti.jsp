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
	<title>PRODOTTI PREFERITI DI<%=request.getAttribute("Utente")%></title>
</head>

<body>
<%@ include file="header.jsp"%>

<% ArrayList<AttivitaBean> products = (ArrayList<AttivitaBean>) request.getAttribute("Preferiti");
     %>
    
    <br>
    <h1 align="center">PRODOTTI PREFERITI DI <%=request.getAttribute("Utente")%></h1><br>

    
     <div class="container">
		<div class="row">	
<%	if (products != null && products.size() != 0) 
		{
			AttivitaDAO adao = new AttivitaDAO();
			ArrayList<String> yourList = new ArrayList<>();
			for(AttivitaBean a : products){
				yourList.add(a.getNome());
			}
			Set<String> set = new HashSet<>(yourList);
			yourList.clear();
			yourList.addAll(set);
			products = new ArrayList<AttivitaBean>();
			for(String s : yourList){
				products.add(adao.doRetrieveByName(s));
			}
		for(AttivitaBean u : products){
			FotoDAO fdao= new FotoDAO();
			ArrayList<FotoBean> fList=new ArrayList<FotoBean>();
			fList=fdao.doRetrieveGroupby();
			String url="";
			if(u!=null) {
				for(int i=0;i<fList.size();i++) {
					if(fList.get(i).getAttivitaIDAttivita()==u.getIdAttivita()) {
						url=fList.get(i).getFoto();
					}
				}

%>

			<div class = "col-md-4" id="cardColumn">
				<form id="ViewForm" method="get" action="###dove voglio andare">
					<div id="cardProdotti" class="card">
						<a href="ServletSingoloLocale?id=<%=u.getIdAttivita() %>">
							<div id="picc">  <!-- dove voglio anda -->
								<img id="prodottoPic" src="<%=url %>" class="card-img-top img-responsive" alt="...">
							</div>
						</a>

						<div class="card-body" id="cards">
							<h5 class="card-title"><%=u.getNome()%></h5>

							<div class="card-bottom">
								<h3><%=u.getComune() %></h3>
							</div>
						</div>
					</div>
				</form>
			</div>


			<%}%>

        

			
		<%}%>
	<%} %>	
		

 		
 	    </div>
 	    <br><br>
 	    <hr>
</div>
     

<%@ include file="footer.jsp"%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>



































