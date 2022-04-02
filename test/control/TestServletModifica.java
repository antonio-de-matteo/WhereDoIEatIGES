package control;

import static org.junit.Assert.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import bean.PersonaBean;
import dao.PersonaDAO;
import server.ServletModifica;
import static org.mockito.Mockito.*;

import java.io.IOException;


public class TestServletModifica {

	@Mock
	private HttpServletRequest req;
	@Mock
	private HttpServletResponse res;
	@Mock
	private HttpSession session;
	@Mock
	private RequestDispatcher rd;

	
	@Mock
	private PersonaDAO pdao=new PersonaDAO();
	
	private ServletModifica servlet;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		servlet=new ServletModifica();
		servlet.setPDao(pdao);
		when(req.getSession()).thenReturn(session);
	}
	
	@Test
	public void modifica() throws ServletException, IOException {
		when(req.getParameter("telefono")).thenReturn("393404123456");
		when(req.getParameter("citta")).thenReturn("Nola");
		when(req.getParameter("comune")).thenReturn("");
		PersonaBean p=new PersonaBean("tanucc","Gaetano", "Mauro", "g.mauro14@studenti.unisa.it", "393404181948", "Avellino",1, "Atripalda", "mistersessa");
		when(session.getAttribute("cliente")).thenReturn(p);
		when(req.getAttribute("modOk")).thenReturn(true);
		when(req.getRequestDispatcher("/areaPersonale.jsp")).thenReturn(rd);
		servlet.doGet(req,res);
		verify(rd).forward(req, res);
		boolean modOk=(boolean)req.getAttribute("modOk");
		assertTrue(modOk);
	}
	
	
}
