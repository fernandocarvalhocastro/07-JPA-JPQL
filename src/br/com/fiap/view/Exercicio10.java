package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.impl.PacoteDAOImpl;

public class Exercicio10 {
	
	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		PacoteDAO dao = new PacoteDAOImpl(em);
		
		long quantidadePacotes = dao.quantidadeCadastradaPeriodo(new GregorianCalendar(2016, Calendar.JANUARY,1), 
											new GregorianCalendar(2018, Calendar.JANUARY,1));
	
		System.out.println(quantidadePacotes);
		em.close();
		System.exit(0);
	}
}
