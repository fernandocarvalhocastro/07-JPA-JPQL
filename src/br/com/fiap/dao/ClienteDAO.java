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
	
<<<<<<< HEAD
	List<Cliente> buscarPorMesNascimento(Calendar dataNascimento);
	
=======
>>>>>>> 0084c84d99b1790e70134fa5404daf8c3f3d612a
	long quantidadeClientes();
}
