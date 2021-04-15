<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>
	<link rel="icon" href="foto/logoDef.png" sizes="9x9">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>WhereDoIEat</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="STILI/registrazione.css">

</head>
<body>

 <%@ include file="header.jsp"%>
   <%
                             Boolean failed=(Boolean) request.getAttribute("failed");
                             if(failed!=null) {
                            %>
                            <div id="failed">
                            <p>l'username o la tua email sono gia' registrati sul sito. </p>
                            </div>
                            <%} %> 
<script src="controlli.js"></script> 
  <!--<div id="MIODIV">-->
    <div class="container py-5">
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-6 mx-auto">
    
                          
   
                        <!-- form card login -->
                        <div class="card rounded-0 CDtot" id="contenitoreTotale">
                            <div class="card-header carta1">
                                <h3 class="mb-0">REGISTRATI</h3>
                            </div>
                            <div class="card-body">
                            <p id="error"> 
		                    </p> 
                                  <form action="ServletRegistrazione" method="post" onsubmit="return control(this)">                                    
                                  <div class="form-group">
                                        <label  class="grassetto">&nbspNome</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDONERO" name="nome" id="nome" onclick="startNome()" onkeyup="startNome()">
                                        <p id="errorNome"></p>
                                    </div>
                                    <div class="form-group">
                                        <label  class="grassetto">&nbspCognome</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDONERO" name="cognome" id="cognome" onclick="startCognome()" onkeyup="startCognome()">
                                        <p id="errorCognome"></p>
                                    </div>
                                    <div class="form-group">
                                        <label  class="grassetto"><img src="foto/ominoLogin.png" alt="">&nbspUsername</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDONERO" name="username" id="username" onclick="startUsername()" onkeyup="startUsername()">
                                        <p id="errorU" class="suggerimento">Deve contenere almeno 1 carattere e al massimo 32</p>
                                    </div>
                                    <div class="form-group">
                                        <label  class="grassetto">&nbspTelefono</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDONERO" name="telefono" id="telefono" onclick="startTelefono()" onkeyup="startTelefono()">
                                         <p id="errorTel" class="suggerimento">Deve contenere anche il prefisso.</p>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label  class="grassetto">&nbspCitt&agrave</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDONERO" name="citta" id="citta" onclick="startCitta()" onkeyup="startCitta()">
                                         <p id="errorCitta"></p>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label  class="grassetto">&nbspComune</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDONERO" name="comune" id="comune" onclick="startComune()" onkeyup="startComune()">
                                         <p id="errorComune"></p>
                                    </div>
                                    
                                     <div class="form-group">
                                        <label  class="grassetto">&nbspTipo</label>
                                        <select name="tipo" class="form-control form-control-lg rounded-0 BORDONERO">
                                            <option value="cliente">Cliente</option>
                                            <option value="ristoratore">Ristoratore</option>
                                        </select>  
                                    </div>
                                    
                                    
                                    <div class="form-group">
                                        <label  class="grassetto"><img src="foto/email.png" alt="">&nbspE-mail</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDONERO" name="email" id="email" onclick="startEmail()" onkeyup="startEmail()">
                                         <p id="errorEmail"></p>
                                    </div>
                                    
                                       <p id="errorE"></p>
                                    <div class="form-group">
                                        <label class="grassetto"><img src="foto/chiave.png" alt="">&nbspPassword</label>
                                        <input type="password" class="form-control form-control-lg rounded-0 BORDONERO" name="password" id="password" onclick="startPassword()" onkeyup="startPassword()">
                                         <p id="errorP1" class="suggerimento">La password deve avere almeno 8 caratteri, massimo 25 caratteri e deve contenere un valore numerico e una lettera maiuscola</p>
                                    </div>
                                    <div class="form-group">
                                        <label class="grassetto"><img src="foto/chiave.png" alt="">&nbspRipeti&nbspPassword</label>
                                        <input type="password" class="form-control form-control-lg rounded-0 BORDONERO" name="password2" id="password2" onclick="startPassword2()" onkeyup="startPassword2()">
                                        <p id="errorP2" class="suggerimento"><p>
                                    </div>
                                    <button type="submit" class="btn btn-danger btn-lg float-right btn-mio" id="btnLogin">Crea il tuo Account</button>
                                    <div>
                                     <p>Hai gia un account? <a id="linkReg" href="login.jsp">Accedi</a> </p> 
                                    </div>
                                </form>
                            </div>
                            <!--/card-block-->
                        </div>
                        <!-- /form card login -->
    
                    </div>
    
    
                </div>
                <!--/row-->
    
            </div>
            <!--/col-->
        </div>
        <!--/row-->
    </div>
    <!--/container-->
  <!--</div>--> 


<%@ include file="footer.jsp"%>
     
   
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="js/bootstrap.min.js"></script>
</body>

