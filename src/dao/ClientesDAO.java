package dao;


import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClientesDAO {
	
	
	public ClientesDAO() {	
	}
	
	public void AdicionarCliente(Cliente cliente) {
		Long max = 0L;
		for (Cliente cli: Banco.clientes) {
			if (cli.getId()>max) max = cli.getId();
		}
		cliente.setId(++max);
		Banco.clientes.add(cliente);
		
		System.out.println("Cliente adicionado: "+cliente);
		System.out.println(Banco.clientes);
		
	}
	
	public boolean RemoverCliente(Cliente cliente) {
		return Banco.clientes.remove(cliente);
	}

	public ArrayList<Cliente> selectAll() {
		return Banco.clientes;
	}
	
	public Cliente getCliente(int index) {
		return Banco.clientes.get(index);
		
	}
	
	public Cliente getClienteById(Long id) {
		Cliente c = new Cliente();
		
		for (Cliente cli : Banco.clientes) {
			if (cli.getId() == id) c = cli;
		}
		
		return c;
		
	}
	
	public void updateCliente(int index, Cliente cliente) {
		Banco.clientes.set(index, cliente);
	}

	public List<Cliente> getClientesByName(String nome) {
		List<Cliente> clientesAux = new ArrayList<Cliente>();
		
		for (Cliente cli : Banco.clientes) {
			if (cli.getNome().toLowerCase().contains(nome.toLowerCase())) clientesAux.add(cli);
		}
		
		return clientesAux;
	}


}
