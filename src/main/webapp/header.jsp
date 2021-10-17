<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="bean.*"  import="dao.*" import="java.util.*" import="server.CalcoloMedia" %>

<!DOCTYPE html> 
<html lang="it">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>WhereDoIEat</title>
  <link rel="stylesheet" href="STILI/header.css">
</head>
<body>
    
    <!-- example 7 - center on mobile 2-->
<nav id="navbar1" class="navbar navbar-expand-lg">
  <div class="d-flex flex-grow-1">
      <span class="w-100 d-lg-none d-block"><!-- hidden spacer to center brand on mobile --></span>
      <a class="navbar-brand" href="Home.jsp">
         <img src="foto/final.PNG" alt="WhereDoIEat" id="logo">
      </a>
  </div>
              
              <%
                 PersonaBean p= new PersonaBean();
                 p=(PersonaBean) request.getSession().getAttribute("cliente");
                 if (p!=null) {  
              %>
              <a id="collegamento2" href="suggerimenti.jsp" class="nav-link">Suggerimenti</a>
              <a id="collegamento" href="ServletLogout" class="nav-link">Logout</a>
              <a id="collegamento" href="ServletPreferiti?action=pref" class="nav-link">I miei preferiti</a>

             <a id="collegamento" href="PrenotazioneControl?action=AllOrderFromUser&user=<%=p.getUsername() %>" class="nav-link">Area Personale</a>
                  <%if(p.getTipo()==2){ %>
                          <a id="collegamento" href="RicercaControl?action=mie" class="nav-link">Le mie attivita</a>
                          <a id="collegamento" href="aggiungiAttivita.jsp" class="nav-link">Aggiungi attivita</a>
                  <%} %>
              <% } else { %>
              <a id="collegamento" href="login.jsp" class="nav-link">Accedi</a>
     
              <a id="collegamento" href="registrazione.jsp" class="nav-link">Registrati ora</a>  
          <%} %>    
          
</nav>

     

<!-- example 8 - center logo on mobile, search right -->
<nav id="navbar2" class="navbar navbar-expand-lg">
  <div class="collapse navbar-collapse flex-grow-1 text-right" id="myNavbar8">

  <div class="input-group-append">
      <button class="btn btn-outline-secondary dropdown-toggle" id="locali" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">Cosa vuoi mangiare?</button>
      <div class="dropdown-menu">
        <a class="dropdown-item tipi" href="RicercaControl?action=SearchCat&cat=Ristorante">Ristorante</a>
        <div role="separator" class="dropdown-divider"></div>
        <a class="dropdown-item tipi" href="RicercaControl?action=SearchCat&cat=Pizzeria">Pizzeria</a>
        <div role="separator" class="dropdown-divider"></div>
        <a class="dropdown-item tipi" href="RicercaControl?action=SearchCat&cat=Rosticceria">Rosticceria</a>
        <div role="separator" class="dropdown-divider"></div>
        <a class="dropdown-item tipi" href="RicercaControl?action=SearchCat&cat=Pub">Pub</a>
        <div role="separator" class="dropdown-divider"></div>
        <a class="dropdown-item tipi" href="RicercaControl?action=SearchCat&cat=FastFood">FastFood</a>
        <div role="separator" class="dropdown-divider"></div>
        <a class="dropdown-item tipi" href="RicercaControl?action=SearchCat&cat=Vegan">Vegan</a>
      </div>
      </ul>
  </div>

  <div class="input-group-append">
    <button class="btn btn-outline-secondary dropdown-toggle" id="comuni" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">Dove vuoi mangiare?</button>
    <div class="dropdown-menu">
      <a class="dropdown-item tipi" href="RicercaControl?action=SearchComune&comune=Baronissi">Baronissi</a>
      <div role="separator" class="dropdown-divider"></div>
      <a class="dropdown-item tipi" href="RicercaControl?action=SearchComune&comune=Salerno">Salerno</a>
      <div role="separator" class="dropdown-divider"></div>
      <a class="dropdown-item tipi" href="RicercaControl?action=SearchComune&comune=Agropoli">Agropoli</a>
      <div role="separator" class="dropdown-divider"></div>
      <a class="dropdown-item tipi" href="RicercaControl?action=SearchComune&comune=SanCiprianoPicentino">San Cipriano Picentino</a>
      <div role="separator" class="dropdown-divider"></div>
      <a class="dropdown-item tipi" href="RicercaControl?action=SearchComune&comune=Roccadaspide">Roccadaspide</a>
    </div>
    
</div>
 
      <div class="d-flex w-100 justify-content-end order-3">
          <form class="d-flex flex-nowrap align-items-center" method="post" action="RicercaControl">
              <input type="hidden" name="action" value="SearchNome">
              <input class="form-control border-right-0 mr-n1" name="daCercare" type="search" size="50" placeholder="Cerca" aria-label="Search">
              <button id="cerca" class="btn btn-outline-secondary" type="submit"><i class="fa fa-search">Search</i></button>
            </form>
      </div>
  </div>
</nav>


    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>



