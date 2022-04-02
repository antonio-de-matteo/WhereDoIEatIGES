package dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bean.PiattiBean;
import dao.PiattiDAO;
import junit.framework.TestCase;

public class TestPiattiDAO extends TestCase{

	private PiattiDAO tester=new PiattiDAO();
	private PiattiBean p;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		p=new PiattiBean(0,"patate","patate cotte nel forno elettrico",1);
		tester.doSave(p);
		ArrayList<PiattiBean> find=new ArrayList<PiattiBean>();
		find=tester.doRetrieveAll();
		p.setIdPiatto(find.get(find.size()-1).getIdPiatto());
	}
	
	@After
	 public void tearDown() throws Exception {
		super.tearDown();
		   tester.doDelete(p.getIdPiatto());
	   }
	
	@Test
	public void testDoRetrieveByKey() {
		assertEquals(p, tester.doRetrieveByKey(p.getIdPiatto()));
	}
	
	@Test
	public void testDoRetrieveAll() throws SQLException {
		ArrayList<PiattiBean> list=new ArrayList<PiattiBean>();
		PiattiBean p2=new PiattiBean(1, "gnocchi al forno", "gnocchi cotti al forno  per 10 minuti", 1);
		list.add(p2);
		p2=new PiattiBean(2, "pizza integrale", "pizza con farina integrale", 2);
		list.add(p2);
		p2=new PiattiBean(3, "pizza", "pizza cotta nel forno a legna", 2);
		list.add(p2);
		p2=new PiattiBean(4, "pizza", "pizza cotta nel forno a legna", 1);
		list.add(p2);
		p2=new PiattiBean(5, "pizza", "pizza cotta nel forno a legna", 3);
		list.add(p2);
		p2=new PiattiBean(6, "risotto", "Risotto tipico della zona con funghi paesani", 1);
		list.add(p2);
		p2=new PiattiBean(7, "tagliata di carne", "carne servita con contorni tipici della zona", 3);
		list.add(p2);
		list.add(p);
		assertEquals(list, tester.doRetrieveAll());
	}
	
	@Test
	public void testDoSave() {
		PiattiBean p2=new PiattiBean();
		p2=tester.doRetrieveByKey(p.getIdPiatto());
		assertEquals(p, p2);
	}

	@Test
	public void testDoDelete() throws SQLException {
		tester.doDelete(p.getIdPiatto());
		assertEquals(null, tester.doRetrieveByKey(p.getIdPiatto()));
	}

	@Test
	public void testDoUpdate() throws SQLException {
		p.setPiatto("patatine fritte");
		p.setDescrizione("patatine con olio di girasoli");
		tester.doUpdate(p);
		PiattiBean p2=new PiattiBean();
		p2=tester.doRetrieveByKey(p.getIdPiatto());
		assertEquals(p, p2);
	}

	

	@Test
	public void testDoRetrieveByAttivita() {
		ArrayList<PiattiBean> list=new ArrayList<PiattiBean>();
		PiattiBean p2=new PiattiBean(1, "gnocchi al forno", "gnocchi cotti al forno  per 10 minuti", 1);
		list.add(p2);
		p2=new PiattiBean(4, "pizza", "pizza cotta nel forno a legna", 1);
		list.add(p2);
		p2=new PiattiBean(6, "risotto", "Risotto tipico della zona con funghi paesani", 1);
		list.add(p2);
		list.add(p);
		assertEquals(list, tester.doRetrieveByAttivita(p.getAttivitaIDAttivita()));
		
	}

}
