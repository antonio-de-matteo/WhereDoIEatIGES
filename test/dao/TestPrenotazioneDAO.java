package dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bean.PrenotazioneBean;
import dao.PrenotazioneDAO;
import junit.framework.TestCase;

public class TestPrenotazioneDAO extends TestCase{

	private PrenotazioneDAO tester=new PrenotazioneDAO();
	private PrenotazioneBean p;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		p=new PrenotazioneBean(0, "2020-03-02", 1300, 12, "tanucc", 2);
		tester.doSave(p);
		ArrayList<PrenotazioneBean> find=new ArrayList<PrenotazioneBean>();
		find=tester.doRetrieveAll();
		p.setIdPren(find.get(find.size()-1).getIdPren());
	}
	
	@After
	 public void tearDown() throws Exception {
		super.tearDown();
		   tester.doDelete(p.getIdPren());
	 }
	
	@Test
	public void testDoRetrieveByKey() {
		assertEquals(p, tester.doRetrieveByKey(p.getIdPren()));
	}
	
	@Test
	public void testDoRetrieveAll() throws SQLException {
		ArrayList<PrenotazioneBean> list=new ArrayList<PrenotazioneBean>();
		PrenotazioneBean p2=new PrenotazioneBean(1, "2020-03-02", 1300, 12, "tanucc", 1);
		list.add(p2);
		p2=new PrenotazioneBean(2, "2020-03-04", 1330, 2, "tanucc", 1);
		list.add(p2);
		p2=new PrenotazioneBean(3, "2020-03-02", 1300, 13, "tanucc", 1);
		list.add(p2);
		p2=new PrenotazioneBean(4, "2020-03-04", 2000, 20, "tanucc", 3);
		list.add(p2);
		list.add(p);
		assertEquals(list, tester.doRetrieveAll());
	}
	
	@Test
	public void testDoSave() {
		PrenotazioneBean p2=new PrenotazioneBean();
		p2=tester.doRetrieveByKey(p.getIdPren());
		assertEquals(p, p2);
	}

	

	@Test
	public void testDoDelete() throws SQLException {
		tester.doDelete(p.getIdPren());
		assertEquals(null, tester.doRetrieveByKey(p.getIdPren()));
	}

	@Test
	public void testDoUpdate() throws SQLException {
		p.setData("2021-04-01");
		p.setNumPosti(3);
		p.setOra(1400);
		tester.doUpdate(p);
		PrenotazioneBean p2=tester.doRetrieveByKey(p.getIdPren());
		assertEquals(p, p2);
		
	}

	@Test
	public void testDoRetrieveByOra() throws SQLException {
		assertEquals(25, tester.doRetrieveByOra(1300, 1, "2020-03-02"));
	}

	@Test
	public void testDoRetrieveByUser() throws SQLException {
		ArrayList<PrenotazioneBean> list=new ArrayList<PrenotazioneBean>();
		PrenotazioneBean p2=new PrenotazioneBean(1, "2020-03-02", 1300, 12, "tanucc", 1);
		list.add(p2);
		p2=new PrenotazioneBean(2, "2020-03-04", 1330, 2, "tanucc", 1);
		list.add(p2);
		p2=new PrenotazioneBean(3, "2020-03-02", 1300, 13, "tanucc", 1);
		list.add(p2);
		p2=new PrenotazioneBean(4, "2020-03-04", 2000, 20, "tanucc", 3);
		list.add(p2);
		list.add(p);
		assertEquals(list, tester.doRetrieveByUser(p.getPersonaUsername()));
	}

}
