package dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bean.PreferitiBean;
import dao.PreferitiDAO;
import junit.framework.TestCase;

public class TestPreferitiDAO extends TestCase{

	private PreferitiDAO tester=new PreferitiDAO();
	private PreferitiBean p;
	
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		p=new PreferitiBean("tanucc",2);
		tester.doSave(p);
		ArrayList<PreferitiBean> find=new ArrayList<PreferitiBean>();
		find=tester.doRetrieveAll();
		p.setIdPref(find.get(find.size()-1).getIdPref());
	}
	
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		   tester.doDelete(p.getIdPref());
	   }
	
	@Test
	public void testDoRetrieveByKey() {
		assertEquals(p, tester.doRetrieveByKey(p.getIdPref()));
	}
	
	@Test
	public void testDoRetrieveAll() throws SQLException {
		ArrayList<PreferitiBean> list=new ArrayList<PreferitiBean>();
		list.add(p);
		assertEquals(list, tester.doRetrieveAll());
	}
	
	@Test
	public void testDoSave() {
		PreferitiBean p2=new PreferitiBean();
		p2=tester.doRetrieveByKey(p.getIdPref());
		assertEquals(p, p2);
	}
	
	

	@Test
	public void testDoDelete() throws SQLException {
		tester.doDelete(p.getIdPref());
		assertEquals(null, tester.doRetrieveByKey(p.getIdPref()));
	}

	@Test 
	public void testDoUpdate() throws SQLException {
		p.setAttivitaIDAttivita(2);
		p.setPersonaUsername("toni9");
		tester.doUpdate(p);
		PreferitiBean p2=new PreferitiBean();
		p2=tester.doRetrieveByKey(p.getIdPref());
		assertEquals(p, p2);
	}

	

}
