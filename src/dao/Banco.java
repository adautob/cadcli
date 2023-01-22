package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.Cliente;
import model.Produto;

public class Banco {
	
	public static ArrayList<Cliente> clientes;
	public static ArrayList<Produto> produtos;

	public Banco() {
	}
	
	public static void inicia() throws ParseException {
		clientes = new ArrayList<Cliente>();
		produtos = new ArrayList<Produto>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Cliente c1 = new Cliente(1L, "Adauto Bueno", "adauto@email.com", "(47)99164-4475", sdf.parse("10/03/1982"));
		Cliente c2 = new Cliente(2L, "Amanda Vivien Gomes de Castro Bueno", "amanda@email.com", "(47)99113-1049", sdf.parse("31/05/1993"));
		Cliente c3 = new Cliente(3L, "Daniel de Castro Bueno", "daniel@email.com", "(47)00000-0000", sdf.parse("27/04/2012"));
		
		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);
		
		Produto p1 = new Produto(1L, "Mouse Óptico Gamer", 25.0);
		Produto p2 = new Produto(2L, "Teclado Preto", 32.9);
		Produto p3 = new Produto(3L, "Fone BT", 49.9);
		
		produtos.add(p1);
		produtos.add(p2);
		produtos.add(p3);
		
	}

}
