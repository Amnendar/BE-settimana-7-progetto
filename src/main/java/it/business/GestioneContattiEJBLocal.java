package it.business;

import java.util.List;

import it.data.Contatto;
import jakarta.ejb.Local;

@Local
public interface GestioneContattiEJBLocal {

	public List<Contatto> getAllContatti();
	
	public void aggiungiContatto(Contatto c);
	
	public List<Contatto> getContattoCognome(String cognome);
	
	public void rimuoviContatto(String id);
}
