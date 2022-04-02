package dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bean.RecensioneBean;
import dao.RecensioneDAO;
import junit.framework.TestCase;

public class TestRecensioneDAO extends TestCase{

	
	private RecensioneDAO tester=new RecensioneDAO();
	private RecensioneBean r;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		r=new RecensioneBean(3, "ciao dosdfisf sdf suf suf ncsuvbsiuaisubvdhfi sdhiv sdhbvu ", "elcardinero", 1);
		tester.doSave(r);
		ArrayList<RecensioneBean>find=new ArrayList<RecensioneBean>();
		find=tester.doRetrieveAll(1);
		r.setIdRecensione(find.get(find.size()-1).getIdRecensione());
	}
	
	@After
	 public void tearDown() throws Exception {
		super.tearDown();
		   tester.doDelete(r.getIdRecensione());
	   }
	
	@Test
	public void testDoRetrieveByKey() {
		assertEquals(r, tester.doRetrieveByKey(r.getIdRecensione()));
	}
	
	@Test
	public void testDoRetrieveAll() throws SQLException {
		ArrayList<RecensioneBean> list=new ArrayList<RecensioneBean>();
		RecensioneBean r2=new RecensioneBean(5, "ciao didod idiv nsaivoans ija ", "ElPampa", 2);
		list.add(r2);
		r2=new RecensioneBean(1, "asdfsf safsd gfdsg", "gerdenis", 2);
		list.add(r2);
		assertEquals(list, tester.doRetrieveAll(2));
	}
	
	@Test
	public void testDoSave() {
		RecensioneBean r2=tester.doRetrieveByKey(r.getIdRecensione());
		assertEquals(r, r2);
	}

	@Test
	public void testDoDelete() throws SQLException {
		tester.doDelete(r.getIdRecensione());
		assertEquals(null, tester.doRetrieveByKey(r.getIdRecensione()));
	}

	@Test
	public void testDoUpdate() throws SQLException {
		r.setCommento("ooodooooooooooooooooooooooo     o o o oo  oo");
		r.setValutazione(1);
		tester.doUpdate(r);
		assertEquals(r, tester.doRetrieveByKey(r.getIdRecensione()));
	}

	@Test
	public void testDoRetriveByUser() throws SQLException {
		ArrayList<RecensioneBean> list=new ArrayList<RecensioneBean>();
		RecensioneBean r2=new RecensioneBean(1, "asdfsf safsd gfdsg", "gerdenis", 2);
		list.add(r2);
		assertEquals(list, tester.doRetriveByUser("gerdenis"));
	}

}
