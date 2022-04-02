package dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bean.FotoBean;
import dao.FotoDAO;
import junit.framework.TestCase;

public class TestFotoDAO extends TestCase{

	private FotoBean f;
	private FotoDAO tester=new FotoDAO();
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		f=new FotoBean("zzz.jpg",1);
		tester.doSave(f);
	}
	
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		tester.doDelete(f.getFoto());
	}
	
	@Test
	public void testDoRetrieveByKey() {
		assertEquals(f,tester.doRetrieveByKey(f.getFoto()));
	}
	
	@Test
	public void testDoSave() {
		FotoBean inserito=tester.doRetrieveByKey(f.getFoto());
		assertEquals(f, inserito);
	}


	@Test
	public void testDoDelete() throws SQLException {
		tester.doDelete(f.getFoto());
		assertEquals(null, tester.doRetrieveByKey(f.getFoto()));
	}

	@Test
	public void testDoUpdate() throws SQLException {
		String path=f.getFoto();
		f.setFoto("zzzzzzz.png");
		tester.doUpdate(f,path);
		FotoBean mod=tester.doRetrieveByKey(f.getFoto());
		assertEquals(f, mod);
	}

	@Test
	public void testDoRetrieveAll() throws SQLException {
		ArrayList<FotoBean>list=new ArrayList<FotoBean>();
		FotoBean f2=new FotoBean("fotodb/bruschetta.jpg",1);
		list.add(f2);
		f2=new FotoBean("fotodb/ristorante-da-kico.jpg", 1);
		list.add(f2);
		list.add(f);
		f2=new FotoBean("fotodb/img-ristoranti.jpg", 2);
		list.add(f2);
		f2=new FotoBean("fotodb/la-sala.jpg", 2);
		list.add(f2);
		f2=new FotoBean("fotodb/pizza.jpg", 2);
		list.add(f2);
		f2=new FotoBean("fotodb/ristorante-servizio.jpg", 2);
		list.add(f2);
		f2=new FotoBean("fotodb/testata-ristorante.jpg", 2);
		list.add(f2);
		f2=new FotoBean("fotodb/imagesILV4I6JR.jpg", 3);
		list.add(f2);
		f2=new FotoBean("fotodb/Montagna-Verde-Ristorante.jpg", 3);
		list.add(f2);
		f2=new FotoBean("fotodb/ristorante-firenze.jpg", 3);
		list.add(f2);
		f2=new FotoBean("fotodb/ristorante.jpg", 3);
		list.add(f2);
		f2=new FotoBean("fotodb/ristorante1.jpg", 3);
		list.add(f2);
		f2=new FotoBean("fotodb/ceci.jpg", 4);
		list.add(f2);
		f2=new FotoBean("fotodb/toto.jpg", 4);
		list.add(f2);
		f2=new FotoBean("fotodb/zuppa.jpg", 4);
		list.add(f2);
		f2=new FotoBean("fotodb/foodSA.jpg", 5);
		list.add(f2);
		f2=new FotoBean("fotodb/foodSA1.jpg", 5);
		list.add(f2);
		f2=new FotoBean("fotodb/foodSA2.jpg", 5);
		list.add(f2);
		f2=new FotoBean("fotodb/aperitivo.jpg", 6);
		list.add(f2);
		f2=new FotoBean("fotodb/aperitivo1.jpg", 6);
		list.add(f2);
		f2=new FotoBean("fotodb/aperitivo2.jpg", 6);
		list.add(f2);
		f2=new FotoBean("FotoADM", 99);
		list.add(f2);

		System.out.println(tester.doRetrieveByKey(f.getFoto()).getFoto());
		assertEquals(list, tester.doRetrieveAll());
	}

	@Test
	public void testDoRetrieveGroupby() throws SQLException {
		ArrayList<FotoBean> list=new ArrayList<FotoBean>();
		FotoBean f2=new FotoBean("fotodb/bruschetta.jpg", 1);
		list.add(f2);
		f2=new FotoBean("fotodb/img-ristoranti.jpg", 2);
		list.add(f2);
		f2=new FotoBean("fotodb/imagesILV4I6JR.jpg", 3);
		list.add(f2);
		f2=new FotoBean("fotodb/ceci.jpg", 4);
		list.add(f2);
		f2=new FotoBean("fotodb/foodSA.jpg", 5);
		list.add(f2);
		f2=new FotoBean("fotodb/aperitivo.jpg", 6);
		list.add(f2);
		f2=new FotoBean("FotoADM", 99);
		list.add(f2);

		assertEquals(list, tester.doRetrieveGroupby());
	}

	@Test
	public void testDoRetrieveByAttivita() {
		ArrayList <FotoBean> list=new ArrayList<FotoBean>();
		FotoBean f2=new FotoBean("fotodb/bruschetta.jpg", 1);
		list.add(f2);
		f2=new FotoBean("fotodb/ristorante-da-kico.jpg", 1);
		list.add(f2);
		list.add(f);
		assertEquals(list, tester.doRetrieveByAttivita(1));
	}

}
