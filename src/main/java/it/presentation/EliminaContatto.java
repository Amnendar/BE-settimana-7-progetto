package it.presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import it.business.GestioneContattiEJB;


@WebServlet("/eliminacontatto")
public class EliminaContatto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EliminaContatto() {
        super();
        
    }

    @EJB 
    GestioneContattiEJB gcejb;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("numero");
		gcejb.rimuoviContatto(id);
		
		
		response.getWriter().append("Contatto Eliminato! ");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
