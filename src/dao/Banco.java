package dao;

import java.util.ArrayList;

import model.Cliente;

public class Banco {
	
	public static ArrayList<Cliente> clientes;

	public Banco() {
	}
	
	public static void inicia() {
		clientes = new ArrayList<Cliente>();
		
		Cliente c1 = new Cliente("Adauto", "39");
		
		clientes.add(c1);
		
	}

}
