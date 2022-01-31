package it.presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import it.business.GestioneContattiEJB;
import it.data.Contatto;


@WebServlet("\ricercacognome")
public class RicercaCognome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RicercaCognome() {
        super();
        
    }

    @EJB 
    GestioneContattiEJB gcejb;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cognome = request.getParameter("cognome");
		
		
		List<Contatto> risultati = gcejb.getContattoCognome(cognome);
		
		for(Contatto c: risultati) {

            response.getWriter()
            .append("<div>")
            .append(" nome: ").append(c.getNome())
            .append(" cognome: ").append(c.getCognome())
            .append(" email: ").append(c.getEmail())
            .append(" numeri: ").append(c.stampaNumeri())       
            .append("</div>");
            
		
		
		
		
		}
	}	

	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
