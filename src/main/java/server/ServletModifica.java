package server;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PersonaBean;
import dao.PersonaDAO;

/**
 * Servlet implementation class ServletModifica
 */
@WebServlet("/ServletModifica")
public class ServletModifica extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PersonaDAO pdao; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModifica() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String telefono= request.getParameter("telefono");
		String citta= request.getParameter("citta");
		String comune= request.getParameter("comune");
		PersonaDAO dao;
		if(pdao!=null)   {
			dao=pdao;
		} else {
			dao=new PersonaDAO();
		}
		PersonaBean vecchia=new PersonaBean();
		vecchia= (PersonaBean) request.getSession().getAttribute("cliente");
		if(telefono!="")
			vecchia.setTelefono(telefono);
		if(citta!="")
			vecchia.setCitta(citta);
		if(comune!="")
			vecchia.setComune(comune);
		try {
			dao.doUpdate(vecchia);
		} catch (SQLException e) {
			// TODO Auto-generated catch block **abbiamo deciso di modificare così pochi campi per scelta progettuale**
			e.printStackTrace();
		}
		request.setAttribute("modOk", true);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/areaPersonale.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void setPDao(PersonaDAO pdao) {
		this.pdao=pdao;
	}
	
}
