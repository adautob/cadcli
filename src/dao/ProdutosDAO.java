package dao;


import java.util.ArrayList;

import model.Produto;

public class ProdutosDAO {
	
	Banco banco;
	
	public ProdutosDAO() {	
	}
	
	public void AdicionarProduto(Produto produto) {
		Banco.produtos.add(produto);
		System.out.println("Produto adicionado: "+produto);
		System.out.println(Banco.produtos);
		
	}
	
	public boolean RemoverProduto(Produto produto) {
		return Banco.produtos.remove(produto);
	}

	public ArrayList<Produto> selectAll() {
		return Banco.produtos;
	}
	
	public Produto getProduto(int index) {
		return Banco.produtos.get(index);
		
	}
	
	public void updateProduto(int index, Produto produto) {
		Banco.produtos.set(index, produto);
	}


}
