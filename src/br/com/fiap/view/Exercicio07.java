package br.com.fiap.view;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cliente;

public class Exercicio07 {
	
	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		ClienteDAO dao = new ClienteDAOImpl(em);
		List<String> lista = new ArrayList<String>();
		lista.add("SP");
		lista.add("MG");
		lista.add("RJ");
		List<Cliente> clientes = dao.buscarPorEstados(lista);
		
		for(Cliente c: clientes){
			System.out.println(c.getNome() + "-" + c.getEndereco().getCidade().getUf());
		}
		em.close();
		System.exit(0);
	}
}
