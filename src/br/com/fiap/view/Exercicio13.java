package br.com.fiap.view;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cliente;

public class Exercicio13 {

	public static void main(String[] args) {

		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		ClienteDAO dao = new ClienteDAOImpl(em);
		
		List<Cliente> clientes = dao.buscarPorMesNascimento(new GregorianCalendar(2018,Calendar.MARCH,1));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		for(Cliente c : clientes){
			System.out.println(c.getNome() + " - " +sdf.format(c.getDataNascimento().getTime()));
		}
		em.close();
		System.exit(0);
	}
}
