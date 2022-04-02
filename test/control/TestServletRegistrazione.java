package control;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import bean.PersonaBean;
import dao.PersonaDAO;
import server.ServletRegistrazione;

import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServletRegistrazione {

	private ServletRegistrazione servlet;
	
	@Mock
	HttpServletRequest req;
	
	@Mock
	HttpServletResponse res;
	
	@Mock
	RequestDispatcher rd;
	
	@Mock
	PersonaDAO pdao=new PersonaDAO();
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		servlet=new ServletRegistrazione();
		servlet.setDAO(pdao);
	}
	
	@Test
	public void registraOk() throws ServletException, IOException {
		when(pdao.doRetrieveByKey(Mockito.anyString())).thenReturn(null);
		when(req.getParameter("nome")).thenReturn("Gaetano");
		when(req.getParameter("cognome")).thenReturn("Mauro");
		when(req.getParameter("username")).thenReturn("tano");
		when(req.getParameter("telefono")).thenReturn("393404181948");
		when(req.getParameter("citta")).thenReturn("Salerno");
		when(req.getParameter("comune")).thenReturn("Fisciano");
		when(req.getParameter("email")).thenReturn("ciao@gmail.com");
		when(req.getParameter("password")).thenReturn("Ciao199999996");
		when(req.getParameter("tipo")).thenReturn("cliente");
		
		when(req.getAttribute("regOk")).thenReturn(true);
		when(req.getRequestDispatcher("login.jsp")).thenReturn(rd);
		servlet.doGet(req,res);
		verify(rd).forward(req, res);
		boolean regOk=(boolean) req.getAttribute("regOk");
		assertTrue(regOk);
		
	}
	
	@Test
	public void emailExist() throws ServletException, IOException {
		String email="g.mauro14@studenti.unisa.it";
		PersonaBean p=new PersonaBean("tanucc","Gaetano", "Mauro", "g.mauro14@studenti.unisa.it", "393404181948", "Avellino",1, "Atripalda", "mistersessa");
		when(pdao.doRetrieveByEmail(email)).thenReturn(p);
		when(req.getParameter("nome")).thenReturn("Gaetano");
		when(req.getParameter("cognome")).thenReturn("Mauro");
		when(req.getParameter("username")).thenReturn("tano");
		when(req.getParameter("telefono")).thenReturn("393404181948");
		when(req.getParameter("citta")).thenReturn("Salerno");
		when(req.getParameter("comune")).thenReturn("Fisciano");
		when(req.getParameter("email")).thenReturn(email);
		when(req.getParameter("password")).thenReturn("Ciao199999996");
		when(req.getParameter("tipo")).thenReturn("cliente");
		when(req.getAttribute("failed")).thenReturn(true);
		when(req.getRequestDispatcher("registrazione.jsp")).thenReturn(rd);
		servlet.doGet(req,res);
		verify(rd).forward(req, res);
		boolean failed=(boolean) req.getAttribute("failed");
		assertTrue(failed);
	}
	
	@Test
	public void userExist() throws ServletException, IOException {
		String user="tanucc";
		PersonaBean p=new PersonaBean("tanucc","Gaetano", "Mauro", "g.mauro14@studenti.unisa.it", "393404181948", "Avellino",1, "Atripalda", "mistersessa");
		when(pdao.doRetrieveByKey(user)).thenReturn(p);
		when(req.getParameter("nome")).thenReturn("Gaetano");
		when(req.getParameter("cognome")).thenReturn("Mauro");
		when(req.getParameter("username")).thenReturn(user);
		when(req.getParameter("telefono")).thenReturn("393404181948");
		when(req.getParameter("citta")).thenReturn("Salerno");
		when(req.getParameter("comune")).thenReturn("Fisciano");
		when(req.getParameter("email")).thenReturn("ciao@gmai.com");
		when(req.getParameter("password")).thenReturn("Ciao199999996");
		when(req.getParameter("tipo")).thenReturn("cliente");
		when(req.getAttribute("failed")).thenReturn(true);
		when(req.getRequestDispatcher("registrazione.jsp")).thenReturn(rd);
		servlet.doGet(req,res);
		verify(rd).forward(req, res);
		boolean failed=(boolean) req.getAttribute("failed");
		assertTrue(failed);
	}
	
	
}
