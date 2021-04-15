package server;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.media.sound.SimpleSoundbank;

import bean.AttivitaBean;
import dao.AttivitaDAO;

/**
 * Servlet implementation class ServletSingoloLocale
 */
@WebServlet("/ServletSingoloLocale")
public class ServletSingoloLocale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSingoloLocale() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idString=request.getParameter("id");
		int id=Integer.parseInt(idString);
		AttivitaDAO adao=new AttivitaDAO();
		AttivitaBean a =new AttivitaBean();
		a=adao.doRetrieveByKey(id);
		request.setAttribute("singolaAttivita", a);
		RequestDispatcher rd=request.getRequestDispatcher("attivitaSpecifica.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
