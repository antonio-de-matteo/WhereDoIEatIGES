package control;

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

import bean.AttivitaBean;
import bean.PersonaBean;
import dao.AttivitaDAO;
import dao.RecensioneDAO;
import server.RecensioneControl;
import static org.mockito.Mockito.*;

import java.io.IOException;



public class TestRecensioneControl {

	@Mock
	private HttpServletRequest req;
	@Mock
	private HttpServletResponse res;
	@Mock
	private HttpSession session;
	@Mock
	private RequestDispatcher rd;
	
	@Mock
	private RecensioneDAO rdao=new RecensioneDAO();
	@Mock
	private AttivitaDAO adao=new AttivitaDAO();
	
	private RecensioneControl servlet;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		servlet=new RecensioneControl();
		servlet.setADao(adao);
		servlet.setRDao(rdao);
		when(req.getSession()).thenReturn(session);
	}
	
	@Test
	public void recensione() throws ServletException, IOException {
		PersonaBean p=new PersonaBean("tanucc","Gaetano", "Mauro", "g.mauro14@studenti.unisa.it", "393404181948", "Avellino",1, "Atripalda", "mistersessa");
		when(session.getAttribute("cliente")).thenReturn(p);
		when(req.getParameter("c4l-rating")).thenReturn("3");
		when(req.getParameter("commento")).thenReturn("sono stato davvero bene in questo locale");
		when(req.getParameter("attivita")).thenReturn("1");
		AttivitaBean a=new AttivitaBean(1, "El pampa Sosa", "Fisciano", 13, 23, "Mercoledi", "via bomber", "39340412122", 200, "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3025.9426235718774!2d14.769572615021944!3d40.67523314780173!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x133bc239baaf7187%3A0x9cae3635339ffee0!2sSalerno%20Stazione!5e0!3m2!1sit!2sit!4v1577092641285!5m2!1sit!2sit", "amecuomo");
		when(adao.doRetrieveByKey(Mockito.anyInt())).thenReturn(a);
		when(req.getAttribute("recensioneFatta")).thenReturn(true);
		when(req.getRequestDispatcher("/attivitaSpecifica.jsp")).thenReturn(rd);
		servlet.doGet(req,res);
		verify(rd).forward(req, res);
		boolean recensioneFatta=(boolean)req.getAttribute("recensioneFatta");
		assertTrue(recensioneFatta);
	}
	

}
