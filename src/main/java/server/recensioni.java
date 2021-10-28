package server;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.*;
import dao.RecensioneDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class recensioni
 */
@WebServlet("/recensioni")
public class recensioni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public recensioni() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("user");
		RecensioneDAO dao= new RecensioneDAO();
		try {
			if(request.getParameter("action")!=null && request.getParameter("action").equals("g")){
				ArrayList<RecensioneBean> ret= dao.doRetriveByOwner(user);
				request.setAttribute("recensioni",ret);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/areaPersonale.jsp");
				dispatcher.forward(request, response);
			}
			else {
				ArrayList<RecensioneBean> ret = dao.doRetriveByUser(user);
				request.setAttribute("recensioni", ret);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/areaPersonale.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
