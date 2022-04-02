package control;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAggiungiAttivitaControl.class, TestRecensioneControl.class, TestServletLogin.class,
		TestServletModifica.class, TestServletPrenotazione.class, TestServletRegistrazione.class,
		TestServletSuggerimenti.class })
public class AllTests {

}
