package server;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AttivitaBean;
import bean.PersonaBean;
import dao.AttivitaDAO;


/**
 * Servlet implementation class RicercaControl
 */
@WebServlet("/RicercaControl")
public class RicercaControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RicercaControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

			if(action!=null) {
				if(action.equalsIgnoreCase("SearchComune")) {
					try {
					String comune = request.getParameter("comune");
					ArrayList<AttivitaBean> list=AttivitaDAO.doRetrieveByComune(comune);
					request.setAttribute("lista",list) ;
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListaAttivita.jsp");
					dispatcher.forward(request, response);
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
				else if(action.equalsIgnoreCase("SearchCat")) {
					try {
						String categoria = request.getParameter("cat");
						ArrayList<AttivitaBean> list=AttivitaDAO.doRetrieveByCategoria(categoria);
						request.setAttribute("lista",list) ;
						request.setAttribute("cat",categoria);
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListaAttivita.jsp");
						dispatcher.forward(request, response);
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
				else if(action.equalsIgnoreCase("SearchNome")) {
					ArrayList<AttivitaBean> list=new ArrayList<AttivitaBean>();
					try{
						list = AttivitaDAO.doRetrieveAll();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					String daCercare=(String) request.getParameter("daCercare");
					System.out.println(daCercare);
					ArrayList<AttivitaBean> l=new ArrayList<AttivitaBean>();
					if(daCercare!=null && !(daCercare.equalsIgnoreCase(""))) {
						for(AttivitaBean p : list) {
							if(containsIgnoreCase(p.getNome(),daCercare)) {
							//if(p.getNome().contains(daCercare)  ||   p.getNome().contains(daCercare.toUpperCase())   ) {
				                  l.add(p);
				             }
				        }
				    }
					request.setAttribute("lista",l) ;
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListaAttivita.jsp");
					dispatcher.forward(request, response);
                }
				else if(action.equalsIgnoreCase("mie")) {
					try{
					PersonaBean ut = (PersonaBean) request.getSession().getAttribute("cliente");
					String s = ut.getUsername();
					ArrayList<AttivitaBean> list=AttivitaDAO.doRetrieveByUtente(s);
					request.setAttribute("lista",list) ;
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListaAttivita.jsp");
					dispatcher.forward(request, response);
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
		  }
	}

	private boolean containsIgnoreCase(String str, String searchStr) {
		if(str == null || searchStr == null) return false;

	    final int length = searchStr.length();
	    if (length == 0)
	        return true;

	    for (int i = str.length() - length; i >= 0; i--) {
	        if (str.regionMatches(true, i, searchStr, 0, length))
	            return true;
	    }
	    return false;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
