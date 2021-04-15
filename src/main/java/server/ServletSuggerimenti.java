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
import bean.SuggerimentiBean;
import dao.SuggerimentiDAO;

/**
 * Servlet implementation class ServletSuggerimenti
 */
@WebServlet("/ServletSuggerimenti")
public class ServletSuggerimenti extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SuggerimentiDAO sdao2;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSuggerimenti() {
        super();
        // TODO Auto-generated constructor stub 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String titolo= request.getParameter("titolo");
	     String descrizione= request.getParameter("descrizione");
	     SuggerimentiDAO sdao;
	     if(sdao2!=null) {
	    	 sdao=sdao2; 
	     } else {
	    	 sdao=new SuggerimentiDAO();
	     }
	     SuggerimentiBean s=new SuggerimentiBean();
	     PersonaBean p=(PersonaBean) request.getSession().getAttribute("cliente");
	     String personaUsername=p.getUsername();
	     s.setTesto(descrizione);
	     s.setTitolo(titolo);
	     s.setPersonaUsername(personaUsername);
	     try {
			sdao.doSave(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     request.setAttribute("done", true);
         RequestDispatcher rd=request.getRequestDispatcher("suggerimenti.jsp");
         rd.forward(request, response);
         System.out.println("ciao");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void setSDao(SuggerimentiDAO sdao2) {
		this.sdao2=sdao2;
	}

}
