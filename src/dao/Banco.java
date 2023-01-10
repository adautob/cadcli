package dao;

import java.util.ArrayList;

import model.Cliente;
import model.Produto;

public class Banco {
	
	public static ArrayList<Cliente> clientes;
	public static ArrayList<Produto> produtos;

	public Banco() {
	}
	
	public static void inicia() {
		clientes = new ArrayList<Cliente>();
		produtos = new ArrayList<Produto>();
		
		Cliente c1 = new Cliente(1L, "Adauto Bueno", "adauto@email.com", "7384738743", "39");
		Cliente c2 = new Cliente(2L, "Amanda Vivien Gomes de Castro Bueno", "amanda@email.com", "7384738743", "29");
		Cliente c3 = new Cliente(3L, "Daniel de Castro Bueno", "daniel@email.com", "7384738743", "10");
		
		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);
		
		Produto p1 = new Produto(1L, "Mouse", 25.0);
		Produto p2 = new Produto(2L, "Teclado", 32.9);
		Produto p3 = new Produto(3L, "Fone", 49.9);
		
		produtos.add(p1);
		produtos.add(p2);
		produtos.add(p3);
		
	}

}
