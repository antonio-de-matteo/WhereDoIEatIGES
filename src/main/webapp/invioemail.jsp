<%--
  Created by IntelliJ IDEA.
  User: Antonio
  Date: 24/04/2021
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Invio Email</title>
    <link rel="stylesheet" href="STILI/schedaFooter.css">
    <link rel="icon" href="foto/logoDef.png" sizes="9x9">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<%@ include file="header.jsp"%>
<div class="center">

    <h1 align="center"> Contattaci</h1>

    <form action="mailto:wheredoieat@gmail.com" method="post" enctype="text/plain">
        Nome:<br>
        <input type="text" name="name" placeholder="Inserisci il tuo nome"><br>
        E-mail:<br>
        <input type="text" name="mail" placeholder="Inserisci la tua email"><br>
        Messaggio:<br>
        <textarea name="comment" rows="4" cols="50" placeholder="Inserici il tuo messaggio">  </textarea>
        <br><br>
        <input type="submit" value="Invia">
        <input type="reset" value="Ripristina">
    </form>

    </div>

<%@ include file="footer.jsp"%>
</body>
</html>
