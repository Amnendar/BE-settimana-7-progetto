package it.presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import it.business.GestioneContattiEJB;
import it.data.Contatto;
import it.data.NumTelefono;


@WebServlet("/inserisci")
public class Inserisci extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Inserisci() {
        super();
       
    }
    
    @EJB 
    GestioneContattiEJB gcejb;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome=request.getParameter("nome");
		String cognome=request.getParameter("cognome");
		String email=request.getParameter("email");
		String numero1=request.getParameter("numero1");
		String numero2=request.getParameter("numero2");
		
		Contatto c = new Contatto();
		
		NumTelefono num1 = new NumTelefono();
		NumTelefono num2 = new NumTelefono();
		num1.setNumero(numero1);
		num2.setNumero(numero2);
		
		num1.setContatto(c);
		num2.setContatto(c);
		
		c.setNome(nome);
		c.setCognome(cognome);
		c.setEmail(email);
		c.aggiungiNumeri(num1);
		c.aggiungiNumeri(num2);
		
		
		gcejb.aggiungiContatto(c);
		
		
		
		
		
		
		response.getWriter().append("Contatto Inserito Correttamente! ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
