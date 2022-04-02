package dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



import bean.PersonaBean;
import dao.PersonaDAO;
import junit.framework.TestCase;

public class TestPersonaDAO extends TestCase{
   private PersonaDAO tester=new PersonaDAO();
   
   private PersonaBean persona;
   
   @Before
   public void setUp() throws Exception {
	   super.setUp();
	   persona=new PersonaBean("lapulce10","Lionel","Messi","lapulce10@gmail.com","393404181948","Barcelona",1,"barca","ab682163bedf8e606edc39c02f6cc8ef5a8b6959");
	   tester.doSave(persona);
   }
   
   @After
   public void tearDown() throws Exception {
	   super.tearDown();
	   tester.doDelete(persona.getUsername());
   }
   
   @Test
	public void testDoRetrieveByKey() {
		assertEquals(persona, tester.doRetrieveByKey(persona.getUsername()));
	}
    
	@Test
	public void testDoSave() throws SQLException {
		PersonaBean inserito=new PersonaBean();
		inserito=tester.doRetrieveByKey(persona.getUsername());
		assertEquals(persona, inserito);
	}

	@Test
	public void testDoUpdate() throws SQLException {
		persona.setComune("Fisciano");
		persona.setCitta("Salerno");
		persona.setCognome("Mauro");
		persona.setNome("Gaetano");
		persona.setTelefono("393404181948");
		tester.doUpdate(persona);
		PersonaBean inserito=tester.doRetrieveByKey(persona.getUsername());
		assertEquals(persona, inserito);
	}
	
	@Test
	public void testDoDelete() throws SQLException {
		tester.doDelete(persona.getUsername());
		assertEquals(null, tester.doRetrieveByKey(persona.getUsername()));
	}



	@Test
	public void testDoRetrieveAll() throws SQLException {
		ArrayList<PersonaBean> persone=new ArrayList<PersonaBean>();
		PersonaBean persona2=new PersonaBean("amecuomo", "Amedeo", "Cuomo", "amedeo@bestemmio.com", "393452134567", "Salerno", 2, "Baronissi", "Mistersessa69");
		persone.add(persona2);
		persona2=new PersonaBean("elcardinero", "Cruz", "Cruz", "elcardinero@gmail.com","393404181948", "Buenos Aires", 1, "Buenos Aires", "Mistersessa69");
		persone.add(persona2);
		persona2=new PersonaBean("ElPampa", "Sosa", "Sosa", "elpampasosa@gmail.com", "393404181948", "Buenos Aires",1, "Buenos Aires", "Mistersessa69");
		persone.add(persona2);
		persona2=new PersonaBean("elpojo", "Vittorio","Scarano", "vitsca@gmail.com", "393404181948", "Salerno",2, "Baronissi", "Vittorio9");
		persone.add(persona2);
		persona2=new PersonaBean("gerdenis", "German", "Denis", "eltanke@gmail.com", "393404181948", "Buenos Aires", 1, "Buenos Aires", "Mistersessa69");
		persone.add(persona2);
		persona2=new PersonaBean("imperatore", "Adriano", "Adriano", "imperatore10@gmail.com", "393478923456", "Rio De Janeiro", 1, "Rio", "Mistersessa69");
		persone.add(persona2);
		persone.add(persona);
		persona2=new PersonaBean("tanucc", "Gaetano", "Mauro", "g.mauro14@studenti.unisa.it", "393404181948", "Avellino", 1, "Atripalda", "mistersessa");
		persone.add(persona2);
		persona2=new PersonaBean("tanucc33", "Gaetano", "De Lucia", "g.maur44o14@studenti.unisa.it", "3404181948", "Salerno", 1, "Fisciano","mistersessa");
		persone.add(persona2);
		persona2=new PersonaBean("toni9", "Luca", "Toni", "toniluca9@gmail.com", "393453456789", "Firenze", 2, "casigliolo", "Mistersessa69");
		persone.add(persona2);
		assertEquals(persone, tester.doRetrieveAll());
	}

	@Test
	public void testDoRetrieveByLogin() {
		assertEquals(persona, tester.doRetrieveByLogin(persona.getUsername(), persona.getPassword()));
	}

	@Test
	public void testDoRetrieveByEmail() {
		assertEquals(persona, tester.doRetrieveByEmail(persona.getEmail()));
	}

}
