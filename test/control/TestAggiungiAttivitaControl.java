package control;

import static org.junit.Assert.*;
import static org.mockito .Mockito.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith; 
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;

import bean.AttivitaBean;
import bean.PersonaBean;
import dao.AttivitaDAO;  
import dao.FotoDAO;
import org.powermock.modules.junit4.PowerMockRunner;
import server.AggiungiAttivitaControl;

@RunWith(PowerMockRunner.class)
@PrepareForTest(AttivitaDAO.class)
public class TestAggiungiAttivitaControl {
	@Mock
	HttpServletRequest req;
	
	@Mock
	HttpServletResponse res;
	
	@Mock
	HttpSession session;
	
	@Mock
	AttivitaDAO adao=new AttivitaDAO();
	@Mock
	FotoDAO fdao=new FotoDAO();
	
	@Mock
	RequestDispatcher rd;
	
	AggiungiAttivitaControl servlet;
	
	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);
		servlet=new AggiungiAttivitaControl();
		when(req.getSession()).thenReturn(session);
		servlet.setADao(adao);
		servlet.setFDao(fdao);
	}
	
	@Test
	public void oraErrata() throws ServletException, IOException {
		when(req.getParameter("oraApertura")).thenReturn("18");
		when(req.getParameter("oraChiusura")).thenReturn("16");
		when(req.getAttribute("errore")).thenReturn(true);
		when(req.getRequestDispatcher("/aggiungiAttivita.jsp")).thenReturn(rd);
		servlet.doPost(req,res);
		verify(rd).forward(req, res);
		boolean errore=(boolean) req.getAttribute("errore");
		assertTrue(errore);
	}

	@Test
	public void aggiuntaAttOk() throws SQLException, ServletException, IOException  {
		
		when(req.getParameter("oraApertura")).thenReturn("15");
		when(req.getParameter("oraChiusura")).thenReturn("22");
		when(req.getParameter("nome")).thenReturn("King kebab");
		when(req.getParameter("indirizzo")).thenReturn("via sopra, 5");
		when(req.getParameter("comune")).thenReturn("Fisciano");
		when(req.getParameter("telefono")).thenReturn("393404181948");
		when(req.getParameter("giornoChiusura")).thenReturn("Lunedi");
		when(req.getParameter("posti")).thenReturn("100");
		when(req.getParameter("mappa")).thenReturn("sofhsviusb/OihnuiB/OBNouI/OuHBNOU/OB/O");
		PersonaBean p=new PersonaBean("toni9", "Luca", "Toni", "toniluca9@gmail.com", "393453456789", "Firenze", 2, "casigliolo", "Mistersessa69");
		when(req.getSession().getAttribute("cliente")).thenReturn(p);
		ArrayList<AttivitaBean> list=new ArrayList<>();
		AttivitaBean a=new AttivitaBean();
		a.setComune(req.getParameter("comune"));
		a.setNome(req.getParameter("nome"));
		a.setGiornoChiusura(req.getParameter("giornoChiusura"));
		a.setIndirizzo(req.getParameter("indirizzo"));
		a.setMappa(req.getParameter("mappa"));
		a.setNome(req.getParameter("nome"));
		a.setNumPosti(100);
		a.setOraApertura(15);
		a.setOraChiusura(22);
		a.setPersonaUsername("toni9");
		a.setTelefono(req.getParameter("telefono"));
		a.setIdAttivita(1);
		list.add(a);
		when(AttivitaDAO.doRetrieveAll()).thenReturn(list);
		when(req.getParameter("foto")).thenReturn("fotodb/ciao.jpg");
		when(req.getAttribute("successo")).thenReturn(true);
		when(req.getRequestDispatcher("/aggiungiAttivita.jsp")).thenReturn(rd);
		servlet.doPost(req, res);
		verify(rd).forward(req, res);
		boolean successo=(boolean) req.getAttribute("successo");
		assertTrue(successo);
	}
	
}
