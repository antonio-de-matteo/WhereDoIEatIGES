package integrazione;

import static org.junit.Assert.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import bean.PersonaBean;

import static org.mockito.Mockito.*;

import java.io.IOException;

import server.ServletLogin;

public class TestServletLogin {
    @Mock
	HttpServletRequest req;
	@Mock
    HttpServletResponse res;
	@Mock
	HttpSession session;
	@Mock
	RequestDispatcher rd;
	
	ServletLogin servlet;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		servlet=new ServletLogin();
		when(req.getSession()).thenReturn(session);
	}
	
	@Test
	public void loginOk() throws ServletException, IOException {
		PersonaBean p=new PersonaBean("tanucc","Gaetano", "Mauro", "g.mauro14@studenti.unisa.it", "393404181948", "Avellino",1, "Atripalda", "mistersessa");
		when(req.getParameter("username")).thenReturn("tanucc");
		when(req.getParameter("password")).thenReturn("mistersessa");
		when(session.getAttribute("cliente")).thenReturn(p);
		when(req.getRequestDispatcher("Home.jsp")).thenReturn(rd);
		servlet.doGet(req, res);
		verify(rd, times(1)).forward(req, res);
		assertEquals(p, session.getAttribute("cliente"));
	}
	
	@Test
	public void notLogged() throws ServletException, IOException   {
		when(req.getParameter("username")).thenReturn("tanucc");
		when(req.getParameter("password")).thenReturn("x");
		when(req.getRequestDispatcher("login.jsp")).thenReturn(rd);
		when(req.getAttribute("denied")).thenReturn(true);
		servlet.doGet(req, res);
		verify(rd, times(1)).forward(req, res);
		boolean denied=(boolean) req.getAttribute("denied");
		assertTrue(denied);
	}
	
	
	

}
