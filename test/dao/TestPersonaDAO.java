package dao;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



import bean.PersonaBean;
import dao.PersonaDAO;
import junit.framework.TestCase;

public class TestPersonaDAO extends TestCase{
	class GFG {
		public byte[] getSHA(String input) throws NoSuchAlgorithmException {
			// Static getInstance method is called with hashing SHA
			MessageDigest md = MessageDigest.getInstance("SHA-256");

			// digest() method called
			// to calculate message digest of an input
			// and return array of byte
			return md.digest(input.getBytes(StandardCharsets.UTF_8));
		}

		public String toHexString(byte[] hash) {
			// Convert byte array into signum representation
			BigInteger number = new BigInteger(1, hash);

			// Convert message digest into hex value
			StringBuilder hexString = new StringBuilder(number.toString(16));

			// Pad with leading zeros
			while (hexString.length() < 32) {
				hexString.insert(0, '0');
			}

			return hexString.toString();
		}
	}
	String pass;
   private PersonaDAO tester=new PersonaDAO();
   GFG g = new GFG();
   private PersonaBean persona;
   
   @Before
   public void setUp() throws Exception {
	   super.setUp();
	   pass =  "MarcoDe";
	   persona=new PersonaBean("lapulce10","Lionel","Messi","lapulce10@gmail.com","393404181948","Barcelona",1,"barca", pass);
	   tester.doSave(persona);
   }

   @After
   public void tearDown() throws Exception {
	   super.tearDown();
	   tester.doDelete(persona.getUsername());
   }
   
   @Test
	public void testDoRetrieveByKey() {

	   try {
		   persona.setPassword(g.toHexString(g.getSHA(pass)));
	   } catch (NoSuchAlgorithmException e) {
		   e.printStackTrace();
	   }
	   assertEquals(persona, tester.doRetrieveByKey(persona.getUsername()));
	   persona.setPassword(pass);
	}
    
	@Test
	public void testDoSave() throws SQLException {
		PersonaBean inserito=new PersonaBean();
		try {
			persona.setPassword(g.toHexString(g.getSHA(pass)));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		inserito=tester.doRetrieveByKey(persona.getUsername());
		assertEquals(persona, inserito);
		persona.setPassword(pass);
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
		try {
			persona.setPassword(g.toHexString(g.getSHA(pass)));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		PersonaBean persona2=new PersonaBean("AlfredoRossi", "Alfredo", "Rossi", "a.rossi89@libero.it", "393456789000", "Salerno", 1, "Salerno", "d28d48075d9ddcdea76e791a719e099ebe667089");
		persone.add(persona2);
		persona2=new PersonaBean("amecuomo", "Amedeo", "Cuomo", "amedeo@bestemmio.com", "393452134567", "Salerno", 2, "Baronissi", "ed8905166758c7c6a1004c0088e7a3630ce9e15f");
		persone.add(persona2);
		persona2=new PersonaBean("A_DeMatteo", "Antonio", "DeMatteo", "adematteo@gmail.com", "393404621948", "Salerno", 2, "Salerno", "ed8905166758c7c6a1004c0088e7a3630ce9e15f");
		persone.add(persona2);
		persona2=new PersonaBean("elcardinero", "Cruz", "Cruz", "elcardinero@gmail.com","393404181948", "Buenos Aires", 1, "Buenos Aires", "ed8905166758c7c6a1004c0088e7a3630ce9e15f");
		persone.add(persona2);
		persona2=new PersonaBean("ElPampa", "Sosa", "Sosa", "elpampasosa@gmail.com", "393404181948", "Buenos Aires",1, "Buenos Aires", "ed8905166758c7c6a1004c0088e7a3630ce9e15f");
		persone.add(persona2);
		persona2=new PersonaBean("elpojo", "Vittorio","Scarano", "vitsca@gmail.com", "393404181948", "Salerno",2, "Baronissi", "ed8905166758c7c6a1004c0088e7a3630ce9e15f");
		persone.add(persona2);
		persona2=new PersonaBean("gerdenis", "German", "Denis", "eltanke@gmail.com", "393404181948", "Buenos Aires", 1, "Buenos Aires", "ed8905166758c7c6a1004c0088e7a3630ce9e15f");
		persone.add(persona2);
		persona2=new PersonaBean("imperatore", "Adriano", "Adriano", "imperatore10@gmail.com", "393478923456", "Rio De Janeiro", 1, "Rio", "ed8905166758c7c6a1004c0088e7a3630ce9e15f");
		persone.add(persona2);
		persone.add(persona);
		persona2=new PersonaBean("MrRubi", "Marc", "rubino", "mrrubin@libero.it", "392482145318", "retr", 1, "Salerno", "766a5f7db7147021f25455923a3fe9a83a5667b7ed522d2c2e2f0ca1d1938622");
		persone.add(persona2);
		persona2=new PersonaBean("tanucc", "Gaetano", "Mauro", "g.mauro14@studenti.unisa.it", "393404181948", "Avellino", 1, "Atripalda", "ed8905166758c7c6a1004c0088e7a3630ce9e15f");
		persone.add(persona2);
		persona2=new PersonaBean("tanucc33", "Gaetano", "De Lucia", "g.maur44o14@studenti.unisa.it", "3404181948", "Salerno", 1, "Fisciano","ed8905166758c7c6a1004c0088e7a3630ce9e15f");
		persone.add(persona2);
		persona2=new PersonaBean("toni9", "Luca", "Toni", "toniluca9@gmail.com", "393453456789", "Firenze", 2, "casigliolo", "ed8905166758c7c6a1004c0088e7a3630ce9e15f");
		persone.add(persona2);
		assertEquals(persone, tester.doRetrieveAll());
		persona.setPassword(pass);
	}

	@Test
	public void testDoRetrieveByLogin() {
		try {
			persona.setPassword(g.toHexString(g.getSHA(pass)));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		assertEquals(persona, tester.doRetrieveByLogin(persona.getUsername(),pass));
		persona.setPassword(pass);
	}

	@Test
	public void testDoRetrieveByEmail() {
		try {
			persona.setPassword(g.toHexString(g.getSHA(pass)));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
   	assertEquals(persona, tester.doRetrieveByEmail(persona.getEmail()));
   	persona.setPassword(pass);
	}

}
