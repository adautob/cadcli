package controller;

import java.util.ArrayList;

import controller.helper.VendasHelper;
import dao.ProdutosDAO;
import model.Cliente;
import model.Produto;
import view.FrmVendas;

public class VendasController {
	private final FrmVendas frmVendas;
	private final VendasHelper vendasHelper;
	private final ProdutosDAO produtosDAO;

	public VendasController(FrmVendas frmVendas) {
		this.frmVendas = frmVendas;
		this.vendasHelper = new VendasHelper(frmVendas);
		this.produtosDAO = new ProdutosDAO();
	}

	public void fecharTela() {
		frmVendas.setVisible(false);
	}

	public void limparCampos() {
		vendasHelper.limparCampos();
	}

	public void preencherCampos() {
		//vendasHelper.preencherCampos();
	}

	public void salvarProduto() {/*
		if (!produtosHelper.temProdutoSelecionado()) {
			Produto produto = produtosHelper.getProduto();
			produtosDAO.AdicionarProduto(produto);
			this.atualizarTabela();
			produtosHelper.limparCampos();
		} else {
			try {
				Produto produto = produtosHelper.getProduto();
				produtosDAO.updateProduto(this.produtosHelper.getProdutoSelecionado(), produto);
				System.out.println("Produto " + produto.getDescricao() + " atualizado com sucesso");
				this.atualizarTabela();
			} catch (Exception e) {
				System.out.println("Erro ao atualizar produto");
			}

		}*/

	}

	public void atualizarTabela() {/*
		ProdutosDAO produtoDAO = new ProdutosDAO();
		ArrayList<Produto> produtos = produtoDAO.selectAll();
		this.produtosHelper.preencherTabela(produtos);*/
	}

	/*
	public Produto getProduto() {
		return produtosDAO.getProduto(this.produtosHelper.getProdutoSelecionado());

	}*/

	public void removerSelecionado() {/*
		System.out.println(produtosHelper.temProdutoSelecionado());

		if (produtosHelper.temProdutoSelecionado()) {
			Produto produto = this.getProduto();
			if (produtosDAO.RemoverProduto(produto)) {
				System.out.println("Produto " + produto.getDescricao() + " removido com sucesso");
				this.atualizarTabela();
			} else {
				System.out.println("Erro ao remover produto");
			}

		}*/

	}

	public void buscarCliente(Long id) {
		
		Cliente cliente = vendasHelper.getClienteById(id);
		vendasHelper.preencherCliente(cliente.getNome());
		
	}

}
