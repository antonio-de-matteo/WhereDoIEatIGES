<%@page import="bean.*"%>
<%@page import="dao.*"%>
<%@page import="server.*"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta charset="UTF-8">
<link rel="icon" href="foto/final.PNG" sizes="9x9">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>UserArea</title>
<style type="text/css">
    #recensione { color: #ffffff; }
    </style>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="STILI/UserArea.css">
<link rel="stylesheet" href="STILI/registrazione.css">
<script src="controlliCambioPassword.js"></script>
<script src="controlli.js"></script>
</head>
<body>

	<%
		PersonaBean utq = (PersonaBean) session.getAttribute("cliente");
		if (utq == null) {
			response.sendRedirect("./Home.jsp");
			return;
		} 
	%>
<%@ include file="header.jsp"%>
 <br>
 <br>
 <br>
 <br>
	<div class="container">
	<%
	   Boolean modOk=(Boolean) request.getAttribute("modOk");
	   if(modOk!=null) {
	%>
	<h4>Modifica effettuata con successo!</h4>
	<%} %>
		<div class="row m-y-2">
			<div class="col-lg-8 push-lg-4">
				<ul class="nav nav-tabs" id="contenitore_datatarget">
					<li class="nav-item menu">
					<a href="PrenotazioneControl?action=AllOrderFromUser&user=<%=utq.getUsername()%>"
						data-target="#ordini" data-toggle="tab"
						class="nav-link menu active">Prenotazioni Effettuate</a></li>
					<li class="nav-item menu"><a href="" data-target="#profilo"
						data-toggle="tab" class="nav-link menu">Info Personali</a></li>
					<li class="nav-item menu"><a href="" data-target="#password"
						data-toggle="tab" class="nav-link menu">Cambia Password</a></li>
						<li class="nav-item menu"><a href="" data-target="#modifica"
						data-toggle="tab" class="nav-link menu">Modifica Dati Personali</a></li>
						<li class="nav-item menu"><a href="recensioni?user=<%=utq.getUsername()%>" data-target="#recensioni"
						data-toggle="tab" class="nav-link menu">Vecchi Commenti</a></li>
					<% if(utq.getTipo()==2){
				%>
					<li class="nav-item menu"><a href="" data-target="#Myrecensioni"
												 data-toggle="tab" class="nav-link menu">Recensioni miei locali</a></li>

					<%}%>
				</ul>
				<div class="tab-content  p-b-3">
					<div class="tab-pane" id="profilo">
						<br>
						<h4 class="m-y-2 prova">Profilo Utente</h4>
						<br>
						<div class="row">
							<div class="col-md-6" id="distanziatore">
								<span class="titpar">Nome : </span><span><%=utq.getNome()%></span>
								<br> <br> <span class="titpar">Cognome : </span><span><%=utq.getCognome()%></span>
							</div>
							<div class="col-md-6">
								<span class="titpar">Username : </span><span><%=utq.getUsername()%></span>
								<br> <br> <span class="titpar">E-mail : </span><span><%=utq.getEmail()%></span>
							</div>
						</div>
						<!--/row-->
					</div>
					<div class="tab-pane" id="Myrecensioni">
						<br>
						<h4 class="m-y-2 prova"><a id="Myrecensione" href="recensioni?action=g&user=<%=utq.getUsername()%>">Recensioni dei miei ristoranti</a></h4>
						<br>
						<table id="tabl">
							<tr>
								<th>Valutazione</th>
								<th>Commento</th>
								<th>Locale</th>
								<th>Cliente</th>
							</tr>
							<%
								ArrayList<?> recensioni1 = (ArrayList<?>) request.getAttribute("recensioni");
								AttivitaDAO daor1=new AttivitaDAO();
								ArrayList<AttivitaBean> listr1=new ArrayList<AttivitaBean>();
								listr1=daor1.doRetrieveAll();
								if (recensioni1 != null && recensioni1.size() != 0) {
									Iterator<?> it = recensioni1.iterator();
									while (it.hasNext()) {
							%>
							<tr>
								<%
									RecensioneBean bean = (RecensioneBean) it.next();

								%>
								<td id="td"><%=bean.getValutazione()%></td>
								<td id="td"><%=bean.getCommento() %></td>
								<%String nome="";
									for(AttivitaBean b:listr1)
									{
										if(bean.getAttivitaIDAttivita()==b.getIdAttivita())
											nome=b.getNome();
									} %>
								<td id="td"><%=nome%></td>
								<td id="td"><%=bean.getPersonaUsername()%></td>
							</tr>
							<%
									}
								}
							%>
						</table>
					</div>
					<div class="tab-pane" id="recensioni">
						<br>
						<h4 class="m-y-2 prova"><a id="recensione" href="recensioni?user=<%=utq.getUsername()%>">Le mie Recensioni</a></h4>
						<br>
						<table id="tabl">
							<tr>
								<th>Valutazione</th>
								<th>Commento</th>
								<th>Locale</th>
								<th></th>
							</tr>
							<%
								ArrayList<?> recensioni = (ArrayList<?>) request.getAttribute("recensioni");
								AttivitaDAO daor=new AttivitaDAO();
								ArrayList<AttivitaBean> listr=new ArrayList<AttivitaBean>();
								listr=daor.doRetrieveAll();
								if (recensioni != null && recensioni.size() != 0) {
									Iterator<?> it = recensioni.iterator();
									while (it.hasNext()) {
							%>
							<tr>
								<%
									RecensioneBean bean = (RecensioneBean) it.next();
								%>
								<td id="td"><%=bean.getValutazione()%></td>
								<td id="td"><%=bean.getCommento() %></td>
								<%String nome="";
								for(AttivitaBean b:listr)
										{
										if(bean.getAttivitaIDAttivita()==b.getIdAttivita())
											nome=b.getNome();
										} %>
								<td id="td"><%=nome%></td>
							</tr>
							<%
									}
								}
							%>
						</table>
					</div>
					<div class="tab-pane" id="modifica">
						<br>
						<h4 class="m-y-2 prova">Modifica Dati Personali</h4>
						<br>
						<div class="row">
						<script src="controlliModDati.js"></script>
							<form action="ServletModifica" method="post" onsubmit="return control(this)">                                    
         
                                    <div class="form-group">
                                        <label  class="grassetto">&nbspTelefono</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDONERO" name="telefono" value="" id="telefono" onclick="startTelefono()" onkeyup="startTelefono()">
                                       <p id="errorTel" class="suggerimento">Deve contenere anche il prefisso.</p>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label  class="grassetto">&nbspCitt&agrave</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDONERO" name="citta" id="citta" value="" onclick="startCitta()" onkeyup="startCitta()">
                                         <p id="errorCitta"></p>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label  class="grassetto">&nbspComune</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDONERO" name="comune" value="" id="comune" onclick="startComune()" onkeyup="startComune()">
                                         <p id="errorComune"></p>
                                    </div>
                                    <button type="submit" class="btn btn-danger btn-lg float-right btn-mio" id="btnLogin">Conferma</button>

                                </form>
						</div>
						<!--/row-->
					</div>

					<div class="tab-pane active" id="ordini">
						<br>
							<h4 class="m-y-2 prova">Lista Prenotazioni</h4>
					 <br>
						<table id="tabl">
							<tr>
								<th>Numero di Posti</th>
								<th>Data</th>
								<th>Ora</th>
								<th>Locale<th>
								<th></th>
							</tr>
							<%
								ArrayList<?> order = (ArrayList<?>) request.getAttribute("order");
								AttivitaDAO dao=new AttivitaDAO();
								ArrayList<AttivitaBean> list=new ArrayList<AttivitaBean>();
								list=dao.doRetrieveAll();
								//Cart cart = (Cart) request.getAttribute("cart");  O CARRELL
								if (order != null && order.size() != 0) {
									Iterator<?> it = order.iterator();
									while (it.hasNext()) {
							%>
							<tr>
								<%
									PrenotazioneBean bean = (PrenotazioneBean) it.next();
								%>
								<td id="td"><%=bean.getNumPosti()%></td>
								<td id="td"><%=bean.getData() %></td>
								<td id="td"><%=bean.getOra() %></td>
								<%String nome="";
								for(AttivitaBean b:list)
										{
										if(bean.getAttivitaIDAttivita()==b.getIdAttivita())
											nome=b.getNome();
										} %>
								<td id="td"><%=nome%></td>
							</tr>
							<%
									}
								}
							%>
						</table>
						<br>
					</div>



					<div class="tab-pane" id="password">
						<br>
						<h4 class="m-y-2 prova">Cambio Password</h4>
						<br>



						<form action="servletCambioPassword" method="post"
							onsubmit="return controlCambio(this)">
							<p id="messaggio"></p>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label titpar">Vecchia
									password</label>
								<div class="col-lg-9">
									<input class="form-control" name="passwordVecchia"
										id="passwordVecchia" type="password" value=""
										onclick="start1()" onkeyup="start1()">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label titpar">Nuova
									password</label>

								<div class="col-lg-9">
									<input class="form-control" name="passwordNuova"
										id="passwordNuova" type="password" value="" onclick="start2()"
										onkeyup="start2()">
								</div>
								<p id="error">La password deve avere almeno 8 caratteri,
									massimo 16 caratteri e deve contenere un valore numerico e una
									lettera maiuscola</p>

							</div>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label"></label>
								<div class="col-lg-9">
									<input type="reset" class="btn btn-secondary" id="resetbottone"
										value="Cancel"> <input type="submit"
										class="btn btn-danger" id="inviobottone" value="Save Changes">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
 
  <br>
 <br>
 <br>
 <br>
	<%@ include file="footer.jsp"%>

	

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>