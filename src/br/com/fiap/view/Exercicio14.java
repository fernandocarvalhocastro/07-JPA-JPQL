package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.entity.Cidade;

public class Exercicio14 {
	
	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		CidadeDAO dao = new CidadeDAOImpl(em);
		List<Cidade> cidades = dao.buscarPorCidade("SP");
		
		for(Cidade c: cidades){
			System.out.println(c.getNome() + "-" + c.getUf());
		}
		em.close();
		System.exit(0);
	}
}
