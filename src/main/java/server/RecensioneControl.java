package server;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AttivitaBean;
import bean.PersonaBean;
import bean.RecensioneBean;
import dao.AttivitaDAO;
import dao.RecensioneDAO;

/**
 * Servlet implementation class RecensioneControl
 */
@WebServlet("/RecensioneControl")
public class RecensioneControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AttivitaDAO adao2;
    private RecensioneDAO rdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecensioneControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PersonaBean p = (PersonaBean) request.getSession().getAttribute("cliente");
		if(p==null)
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		else 
		{
		String vals = request.getParameter("c4l-rating");
		int val = Integer.parseInt(vals);
		
		String commento = (String) request.getParameter("commento");
		String idAtts = request.getParameter("attivita");
		
		int idAtt = Integer.parseInt(idAtts);
		String idP = p.getUsername();
		
		RecensioneDAO rd;
		if(rdao!=null) {
			rd=rdao;
		} else {
			rd=new RecensioneDAO();
		}
		if(p.getTipo()==1) {
        RecensioneBean recensione = new RecensioneBean(val,commento,idP,idAtt);
        try {
			rd.doSave(recensione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        AttivitaDAO adao;
        if(adao2!=null) {
        	adao=adao2;
        } else {
        	adao=new AttivitaDAO();
        }
        AttivitaBean a =new AttivitaBean();
		a=adao.doRetrieveByKey(idAtt);
		request.setAttribute("singolaAttivita", a);
		request.setAttribute("recensioneFatta", true);
        request.getRequestDispatcher("/attivitaSpecifica.jsp").forward(request,response);
		} else {
			AttivitaDAO adao=new AttivitaDAO();
	    	 AttivitaBean a =new AttivitaBean();
			a=adao.doRetrieveByKey(idAtt);
			request.setAttribute("singolaAttivita", a);
			request.setAttribute("Ristoratore", true);
	        request.getRequestDispatcher("/attivitaSpecifica.jsp").forward(request,response);
		}
		}
        
	}
	
	public void setADao(AttivitaDAO adao) {
		this.adao2=adao;
	}
	public void setRDao(RecensioneDAO rdao) {
		this.rdao=rdao;
	}

}
