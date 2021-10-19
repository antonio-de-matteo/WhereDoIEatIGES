package server;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
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
 * Servlet implementation class ServletRegistrazione
 */
@WebServlet("/ServletRegistrazione")
public class ServletRegistrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonaDAO dao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistrazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome=request.getParameter("nome");
		String cognome=request.getParameter("cognome");
		String username=request.getParameter("username");
		String telefono=request.getParameter("telefono");
		String citta=request.getParameter("citta");
		String comune=request.getParameter("comune");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String t=request.getParameter("tipo");
		int tipo=0;
		if(t.equals("cliente")) {
			tipo=1;
		}
		if(t.equals("ristoratore")) {
			tipo=2;
		}
		PersonaBean p=new PersonaBean();
		p.setUsername(username);
		p.setNome(nome);
		p.setCognome(cognome);
		p.setTelefono(telefono);
		p.setCitta(citta);
		p.setComune(comune);
		p.setEmail(email);
		p.setPassword(password);
		p.setTipo(tipo);
		PersonaDAO pdao;
		if(dao!=null) {
		  pdao=dao;
		} else {
		      pdao=new PersonaDAO();
		}
		try {
			PersonaBean p2=new PersonaBean();
			PersonaBean p3=new PersonaBean();
			p2=pdao.doRetrieveByKey(username);
			p3=pdao.doRetrieveByEmail(email);
			if(p3!=null) {
				request.setAttribute("failed", true);
				RequestDispatcher rd=request.getRequestDispatcher("registrazione.jsp");
				rd.forward(request, response);
				return;
			}
			if(p2!=null) {
				request.setAttribute("failed", true);
				RequestDispatcher rd=request.getRequestDispatcher("registrazione.jsp");
				rd.forward(request, response);
			} else {
			      pdao.doSave(p);
			      request.setAttribute("regOk", true);
			      RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			      rd.forward(request, response);
			   }
		} catch (SQLException | NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	 
	 public void setDAO(PersonaDAO personaDAO) {
		 this.dao=personaDAO;
	 }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
