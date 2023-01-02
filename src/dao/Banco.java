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
		
		Cliente c1 = new Cliente("Adauto", "adauto@email.com", "7384738743", "39");
		
		clientes.add(c1);
		
		Produto p1 = new Produto("Mouse", 25.0);
		Produto p2 = new Produto("Teclado", 32.9);
		Produto p3 = new Produto("Fone", 49.9);
		
		produtos.add(p1);
		produtos.add(p2);
		produtos.add(p3);
		
	}

}
