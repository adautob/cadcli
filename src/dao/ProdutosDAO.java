package dao;


import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutosDAO {
	
	Banco banco;
	
	public ProdutosDAO() {	
	}
	
	public void AdicionarProduto(Produto produto) {
		Long max = 0L;
		for (Produto p : Banco.produtos) {
			if (p.getId()>max) max = p.getId();
		}
		produto.setId(++max);
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
	
	public Produto getProdutoById(Long id) {
		Produto produto = new Produto();
		
		for (Produto p : Banco.produtos) {
			if (p.getId() == id) produto = p; 
		}
		return produto;
	}
	
	public void updateProduto(int index, Produto produto) {
		Banco.produtos.set(index, produto);
	}

	public List<Produto> getProdutosPorDesc(String desc) {
		List<Produto> produtosAux = new ArrayList<Produto>();
		
		for (Produto pro : Banco.produtos) {
			if (pro.getDescricao().toLowerCase().contains(desc.toLowerCase())) produtosAux.add(pro);
		}
		
		return produtosAux;
	}


}
