package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{

	List<Cliente> buscarPorEstado(String estado);
	
	List<Cliente> buscarPorDiaReserva(int reserva);
	
	List<Cliente> buscar(String nome, String cidade);
	
	List<Cliente> buscarPorEstados(List<String> estados);
	
	Cliente buscarPorCpf(String cpf);
	
	List<Cliente> buscarPorMesNascimento(Calendar dataNascimento);
	
	long quantidadeClientes();
}
