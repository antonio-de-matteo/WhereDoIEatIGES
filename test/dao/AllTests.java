package dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAttivitaDAO.class, TestFotoDAO.class, TestPersonaDAO.class, TestPiattiDAO.class,
		TestPreferitiDAO.class, TestPrenotazioneDAO.class, TestRecensioneDAO.class, TestSuggerimentiDAO.class })
public class AllTests {

}
