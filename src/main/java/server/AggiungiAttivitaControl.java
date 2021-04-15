package server;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AttivitaBean;
import bean.FotoBean;
import bean.PersonaBean;
import dao.AttivitaDAO;
import dao.FotoDAO;

/**
 * Servlet implementation class AggiungiAttivitaControl
 */
@WebServlet("/AggiungiAttivitaControl")
public class AggiungiAttivitaControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FotoDAO fdao;
	private AttivitaDAO adao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiAttivitaControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ap = request.getParameter("oraApertura");
		String ch = request.getParameter("oraChiusura");
		int a = Integer.parseInt(ap);
		int c = Integer.parseInt(ch);
		if(c<=a) {
			request.setAttribute("errore", true);
			request.getRequestDispatcher("/aggiungiAttivita.jsp").forward(request,response);
			return;
		}
		else {	
			String nome = request.getParameter("nome");
			String indirizzo = request.getParameter("indirizzo");
			String comune = request.getParameter("comune");
			String telefono = request.getParameter("telefono");
			String giornoChiusura = request.getParameter("giornoChiusura");
			
			String p = request.getParameter("posti");
			int posti = Integer.parseInt(p);
			
			String mappa = request.getParameter("mappa");
			PersonaBean ristoratore = (PersonaBean) request.getSession().getAttribute("cliente");
			String id = ristoratore.getUsername();
			
			AttivitaBean att = new AttivitaBean(0,nome, comune,a,c,
					giornoChiusura,indirizzo,telefono, posti, mappa,
					id);
			AttivitaDAO d;
			if(adao!=null) {
				d=adao;
			} else {
				d=new AttivitaDAO();
			}
			try {
				d.doSave(att);
				ArrayList<AttivitaBean> l = new ArrayList<AttivitaBean>();
				l = d.doRetrieveAll();
				int idGenerato = l.get(l.size()-1).getIdAttivita();
				String f = request.getParameter("foto");
				FotoBean foto = new FotoBean(f,idGenerato);
				FotoDAO daof;
				if(fdao!=null) {
					daof=fdao;
				} else {
					daof= new FotoDAO();
				}
				daof.doSave(foto);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("successo", true);
		request.getRequestDispatcher("/aggiungiAttivita.jsp").forward(request,response);
	}
	
	public void setFDao(FotoDAO fdao) {
		this.fdao=fdao;
	}
	public void setADao(AttivitaDAO adao) {
		this.adao=adao;
	}

}
