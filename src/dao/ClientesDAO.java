package dao;


import java.util.ArrayList;

import model.Cliente;

public class ClientesDAO {
	
	Banco banco;
	
	public ClientesDAO() {	
	}
	
	public void AdicionarCliente(Cliente cliente) {
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
	
	public void updateCliente(int index, Cliente cliente) {
		Banco.clientes.set(index, cliente);
	}


}
