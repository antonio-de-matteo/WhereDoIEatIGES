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
    <link rel="stylesheet" href="STILI/email.css">
    <link rel="icon" href="foto/logoDef.png" sizes="9x9">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<%@ include file="header.jsp"%>
<section>
    <div class="container">
        <form action="https://formspree.io/f/mqkwaovg" method="POST" id="my-form">

            <div class="form-group">
                <label for="firstName"> First Name</label>
                <input type="text" id="firstName" name="firstName">
            </div>

            <div class="form-group">
                <label for="lastName">Last Name</label>
                <input type="text" id="lastName" name="lastName">
            </div>

            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email">
            </div>

            <div class="form-group">
                <label for="massage">Massage</label>
                <textarea name="massage" id="massage" cols="30" rows="10"></textarea>
            </div>

            <button type="submit">Submit</button>
        </form>
    </div>
    <div id="status"></div>
</section>

<script src="js/bootstrap.min.js"></script>
<%@ include file="footer.jsp"%>
</body>
</html>
