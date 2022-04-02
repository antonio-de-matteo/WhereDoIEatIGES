package control;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import bean.PersonaBean;
import dao.PersonaDAO;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import server.ServletLogin;

public class TestServletLogin {
 
	@Mock
	private HttpServletRequest req;
	
	@Mock
	private HttpServletResponse res;
	
	@Mock
	private ServletContext ctx;
	
	@Mock
	private HttpSession session;
	
	@Mock
	private PersonaDAO pdao=new PersonaDAO();
	
	@Mock
	private RequestDispatcher rd;
	
	private ServletLogin servlet;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		servlet= new ServletLogin();
		servlet.setDAO(pdao);
		when(req.getSession()).thenReturn(session);
	}
	
	@Test
	public void loginOk() throws ServletException, IOException {
		PersonaBean p=new PersonaBean("tanucc","Gaetano", "Mauro", "g.mauro14@studenti.unisa.it", "393404181948", "Avellino",1, "Atripalda", "mistersessa");
		when(pdao.doRetrieveByLogin(Mockito.anyString(), Mockito.anyString())).thenReturn(p);
		when(pdao.doRetrieveByKey(Mockito.anyString())).thenReturn(p);
		when(req.getParameter("username")).thenReturn("tanucc");
		when(req.getParameter("password")).thenReturn("mistersessa");
		when(session.getAttribute("cliente")).thenReturn(p);
		when(req.getRequestDispatcher("Home.jsp")).thenReturn(rd);
		servlet.doGet(req, res);
		verify(rd).forward(req, res);
		assertEquals(p, session.getAttribute("cliente"));
	}
	
	@Test
	public void notLogged() throws ServletException, IOException   {
		when(pdao.doRetrieveByLogin(Mockito.anyString(), Mockito.anyString())).thenReturn(null);
		when(req.getParameter("username")).thenReturn("tanucc");
		when(req.getParameter("password")).thenReturn("x");
		when(req.getRequestDispatcher("login.jsp")).thenReturn(rd);
		when(req.getAttribute("denied")).thenReturn(true);
		servlet.doGet(req, res);
		verify(rd).forward(req, res);
		boolean denied=(boolean) req.getAttribute("denied");
		assertTrue(denied);
	}
	
	

}
