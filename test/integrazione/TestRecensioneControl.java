package integrazione;

import static org.junit.Assert.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import bean.AttivitaBean;
import bean.PersonaBean;
import bean.RecensioneBean;
import dao.AttivitaDAO;
import dao.RecensioneDAO;
import server.RecensioneControl;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;



public class TestRecensioneControl {

	@Mock
	private HttpServletRequest req;
	@Mock
	private HttpServletResponse res;
	@Mock
	private HttpSession session;
	@Mock
	private RequestDispatcher rd;
	
	private RecensioneDAO rdao=new RecensioneDAO();
	private RecensioneControl servlet;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		servlet=new RecensioneControl();
		when(req.getSession()).thenReturn(session);
	}
	
	@After
	public void tearDown() throws SQLException {
		ArrayList<RecensioneBean> list=new ArrayList<RecensioneBean>();
		list=rdao.doRetrieveAll(1);
			rdao.doDelete(list.get(list.size()-1).getIdRecensione());
	}
	
	@Test
	public void recensione() throws ServletException, IOException {
		PersonaBean p=new PersonaBean("tanucc","Gaetano", "Mauro", "g.mauro14@studenti.unisa.it", "393404181948", "Avellino",1, "Atripalda", "mistersessa");
		when(session.getAttribute("cliente")).thenReturn(p);
		when(req.getParameter("c4l-rating")).thenReturn("3");
		when(req.getParameter("commento")).thenReturn("sono stato davvero bene in questo locale");
		when(req.getParameter("attivita")).thenReturn("1");
		when(req.getAttribute("recensioneFatta")).thenReturn(true);
		when(req.getRequestDispatcher("/attivitaSpecifica.jsp")).thenReturn(rd);
		servlet.doGet(req,res);
		verify(rd).forward(req, res);
		boolean recensioneFatta=(boolean)req.getAttribute("recensioneFatta");
		assertTrue(recensioneFatta);
	}
	

}
