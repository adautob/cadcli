package controller;

import java.util.ArrayList;

import javax.swing.JFrame;

import controller.helper.ProdutosHelper;
import dao.ProdutosDAO;
import model.Produto;
import view.FrmProdutos;

public class ProdutosController {
	private final ProdutosHelper produtosHelper;
	private final ProdutosDAO produtosDAO;

	public ProdutosController(FrmProdutos frmProdutos) {
		this.produtosHelper = new ProdutosHelper(frmProdutos);
		this.produtosDAO = new ProdutosDAO();
	}

	public void fecharTela(JFrame jFrame) {
		jFrame.dispose();
	}

	public void limparCampos() {
		produtosHelper.limparCampos();
	}

	public void preencherCampos() {
		produtosHelper.preencherCampos(this.getProduto());
	}

	public void salvarProduto() {
		if (!produtosHelper.temProdutoSelecionado()) {
			Produto produto = produtosHelper.getProduto();
			produtosDAO.AdicionarProduto(produto);
			this.atualizarTabela();
			this.limparCampos();
		} else {
			try {
				Produto produto = produtosHelper.getProduto();
				if (produto.getPreco()==null) {
					Produto p = this.getProduto();
					produto.setPreco(p.getPreco());
				}
				produtosDAO.updateProduto(this.produtosHelper.getProdutoSelecionado(), produto);
				System.out.println("Produto " + produto.getDescricao() + " atualizado com sucesso");
				this.atualizarTabela();
				this.limparCampos();
			} catch (Exception e) {
				System.out.println("Erro ao atualizar produto");
			}

		}

	}

	public void atualizarTabela() {
		ProdutosDAO produtoDAO = new ProdutosDAO();
		ArrayList<Produto> produtos = produtoDAO.selectAll();
		this.produtosHelper.preencherTabela(produtos);
	}

	public Produto getProduto() {
		return produtosDAO.getProduto(this.produtosHelper.getProdutoSelecionado());

	}

	public void removerSelecionado() {
		System.out.println(produtosHelper.temProdutoSelecionado());

		if (produtosHelper.temProdutoSelecionado()) {
			Produto produto = this.getProduto();
			if (produtosDAO.RemoverProduto(produto)) {
				System.out.println("Produto " + produto.getDescricao() + " removido com sucesso");
				this.atualizarTabela();
				this.limparCampos();
			} else {
				System.out.println("Erro ao remover produto");
			}

		}

	}

	public Double pegaPrecoProdutoSelecionado() {
		return getProduto().getPreco();
	}

}
