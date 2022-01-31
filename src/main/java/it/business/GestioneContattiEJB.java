package it.business;

//aggiunto commento chiarificatore
//ciao mauro

import java.util.List;

import it.data.Contatto;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;





@Stateless
@LocalBean
public class GestioneContattiEJB implements GestioneContattiEJBLocal {
	
	private static final String COGNOME ="SELECT c.nome, c.cognome, c.email, n.numero FROM public.contatti as c join public.num_telefono as n on c.id = n.id where c.cognome LIKE ";
	private static final String NUMERO = "SELECT c.nome, c.cognome, c.email, n.numero FROM public.contatti as c join public.num_telefono as n on c.id = n.id where numero = ";
	private static final String ELIMINA ="DELETE FROM public.contatti WHERE id = ";
	

	@PersistenceContext(unitName = "rubricaPS")
	EntityManager em;
    
	
	public GestioneContattiEJB() {
    
    
		
    
    }

	@SuppressWarnings ("unchecked")
	public List<Contatto>getAllContatti() {
		
		Query q =em.createNamedQuery("contatti.getAllContatti");
   	  return q.getResultList();

	}

	
	public void aggiungiContatto(Contatto c) {
		em.persist(c);
		em.flush();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Contatto> getContattoCognome(String cognome) {
		Query q = em.createNamedQuery(COGNOME + "'"+"%"+ cognome+"%"+"'");
		return q.getResultList();
		
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Contatto> getContattoNumero(String numero){
		Query q = em.createNamedQuery(NUMERO + "'" + numero+ "'");
		return q.getResultList();
		
	}
	
	public void rimuoviContatto(String id) {
		Query q = em.createNamedQuery(ELIMINA + "'" + id +"'");
		q.executeUpdate();
		
	}
	
	
}
