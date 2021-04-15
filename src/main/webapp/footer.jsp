<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="bean.*"  import="dao.*" import="java.util.*" import="server.CalcoloMedia" %>

<!DOCTYPE html> 
<html lang="it">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>WhereDoIEat</title>

  <link rel="stylesheet" href="STILI/footer.css">

  <script src="footer.js"></script> 
</head>
<body>
         
         <!-- Footer -->
  <footer id="abbassa" class="page-footer font-small unique-color-dark">
      <div style="background-color: #000000;">
        <div class="container">
  
          <!-- Grid row-->
          <div class="row py-4 d-flex align-items-center">
  
            <!-- Grid column -->
            <div class="col-md-6 col-lg-5 text-center text-md-left mb-4 mb-md-0">
              <h6 id="headfoot" class="mb-0">Resta connesso con noi sui social</h6>
            </div>
            <!-- Grid column -->
  
            <!-- Grid column -->
            <div class="col-md-6 col-lg-7 text-center text-md-right">
  
              <!-- Facebook -->
                <a href="https://www.facebook.com/ElDiezShop/?ref=bookmarks" id="img" onMouseOver="cambiaFacebook()" onMouseOut="ricambiaFacebook()"><img id="facebook" src="foto/facebook2.png" class="fb-ic">
                <i class="fab fa-facebook-f white-text mr-4"> </i>
              </a>
              <!--Youtube -->
                  <a href="https://www.youtube.com/watch?v=lH1m5zOImJU" id="img" onMouseOver="cambiaYouTube()" onMouseOut="ricambiaYouTube()"><img id="youtube" src="foto/youtube2.png"  class="fb-ic">
               <i class="fab fa-linkedin-in white-text mr-4"> </i>
               </a>
              <!--Instagram-->
                  <a href="https://www.instagram.com/eldiezshop2019" id="img" onMouseOver="cambiaInstagram()" onMouseOut="ricambiaInstagram()"><img id="instagram" src="foto/Instagram2.png"  class="fb-ic" >
            <i class="fab fa-instagram white-text"> </i>
          </a>
          <!-- Grid column -->
      </div>
          </div>
  
          <!-- Grid row-->
  
        </div>
      </div>
  
      <!-- Footer Links -->
      <div class="container text-center text-md-left mt-5">
  
        <!-- Grid row -->
        <div class="row mt-3">
  
          <!-- Grid column -->
          <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4"> 
  
            <!-- Content -->
            <h6 class="text-uppercase font-weight-bold">CHI SIAMO</h6>
            <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
            <p>Salve,siamo quattro ragazzi appassionati di Informatica e studenti del Dipartimento di Informatica di UNISA. Abbiamo sviluppato questo sito con lo scopo di fornire ai nostri clienti un modo comodo di conoscere attività e gustare i loro cibi in base ad un sistema di recensioni e valutazioni su queste ultime.</p>
  
          </div>
          <!-- Grid column -->
  
          <!-- Grid column -->
          <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
  
            <!-- Links -->
            <h6 class="text-uppercase font-weight-bold">AIUTO</h6>
            <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
            <p>
              <a class="linkfoot" href="terminiecondizioni.html">Termini & Condizioni</a>
            </p>
            <p>
              <a class="linkfoot" href="policy.html">Privacy Policy</a>
            </p>
            <p>
              <a class="linkfoot" href="recesso.html">Diritto di Recesso</a>
            </p>
            <p>
              <a class="linkfoot" href="faq.html">FAQ</a>
            </p>
  
          </div>
          <!-- Grid column -->
  
          <!-- Grid column -->
          <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
  
            <!-- Links -->
            <h6 class="text-uppercase font-weight-bold">LINK UTILI</h6>
            <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
            <p>
              <a class="linkfoot" href="#!">Area Personale</a>
            </p>
            <p>
              <a class="linkfoot" href="registrazione.jsp">Registrati</a>
            </p>
            <p>
              <a class="linkfoot" href="taglia home.html">Tabella delle Taglie</a>
              
            </p>
  
          </div>
          <!-- Grid column -->
  
          <!-- Grid column -->
          <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
  
            <!-- Links -->
            <h6 class="text-uppercase font-weight-bold">Contatti</h6>
            <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
            <p>
              <img src="foto/luogo.png" alt="volevi">
            <i class="fas fa-home mr-3"></i> <a class="linkfoot" href="https://www.google.it/maps/place/Via+Roma,+Salerno+SA/@40.6783183,14.756089,17z/data=!3m1!4b1!4m5!3m4!1s0x133bc22609d11f13:0x7a65ed64b91a7408!8m2!3d40.6783183!4d14.758283">Salerno,Via Roma,156</a></p>
          <p>
            <img src="foto/email.png" alt="volevi">
            <i class="fas fa-envelope mr-3"></i><a class="linkfoot" href="https://accounts.google.com/signin/v2/sl/pwd?hl=it&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin">wheredoieat_shop@gmail.com</a> </p>
          <p>
            <img src="foto/phone.png" alt="volevi">
            <i class="fas fa-phone mr-3"></i> +39 348 32 09 519 </p>
          <p>
            <img src="foto/fisso.png" alt="volevi">
            <i class="fas fa-print mr-3"></i> + 089 89 32 63</p>
  
          </div>
          <!-- Grid column -->
  
        </div>
        <!-- Grid row -->
  
      </div>
      <!-- Footer Links -->
  
      <!-- Copyright -->
      <div class="footer-copyright text-center py-3">© 2020 Copyright:
        <a class="linkfoot" href="index.jsp">WhereDoIEat </a>
      </div>
      <!-- Copyright -->
  
    </footer>
    <!-- Footer -->
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>



