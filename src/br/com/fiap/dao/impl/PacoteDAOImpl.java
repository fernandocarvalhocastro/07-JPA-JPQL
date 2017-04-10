package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class PacoteDAOImpl extends GenericDAOImpl<Pacote,Integer> implements PacoteDAO{

	public PacoteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Pacote> listar() {
		TypedQuery<Pacote> query = 
				em.createQuery("from Pacote",Pacote.class);
		return query.getResultList();
	}

	@Override
	public List<Pacote> buscarPorPreco(float minimo, float maximo) {
		TypedQuery<Pacote> query = em.createQuery(
			"from Pacote p where p.preco between :min and :max",Pacote.class);
		query.setParameter("min", minimo);
		query.setParameter("max", maximo);
		return query.getResultList();
	}

	@Override
	public List<Pacote> buscarPorTransporte(Transporte transporte) {
		TypedQuery<Pacote> query = em.createQuery(
			"from Pacote p where p.transporte = :t",Pacote.class);
		query.setParameter("t", transporte);
		return query.getResultList();
	}

	public List<Pacote> buscarPorData(Calendar inicio, Calendar fim){
		return em.createQuery("from Pacote p where p.dataSaida between :inicio and :fim",Pacote.class)
				.setParameter("inicio", inicio)
				.setParameter("fim", fim)
				.getResultList();
	}

	@Override
	public double precoMedio() {
		return em.createQuery("select avg(p.preco) from Pacote p", Double.class).getSingleResult();
	}

	@Override
	public long quantidadeCadastradaPeriodo(Calendar inicio, Calendar fim) {
		return em.createQuery("select count(p) from Pacote p "
								+ "where p.dataSaida between :inicio and :fim",Long.class)
				.setParameter("inicio", inicio)
				.setParameter("fim", fim)
				.getSingleResult();
	}

	@Override
	public Pacote maiorPreco() {
		return em.createQuery("select p from Pacote p where p.preco = (select max(p.preco) from Pacote p)",Pacote.class).getSingleResult();
	}
}




