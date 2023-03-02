package controller;

import java.util.Date;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.helper.VendasHelper;
import dao.ClientesDAO;
import dao.ProdutosDAO;
import dao.VendasDAO;
import model.Cliente;
import model.Item;
import model.Produto;
import model.StatusVenda;
import model.Venda;
import view.FrmVendas;
import view.PesqCli;
import view.PesqProd;

public class VendasController {
	private final FrmVendas frmVendas;
	private final VendasHelper vendasHelper;
	private final ProdutosDAO produtosDAO;
	private final ClientesDAO clientesDAO;
	private final VendasDAO vendasDAO;

	public VendasController(FrmVendas frmVendas) {
		this.frmVendas = frmVendas;
		this.vendasHelper = new VendasHelper(frmVendas);
		this.produtosDAO = new ProdutosDAO();
		this.clientesDAO = new ClientesDAO();
		this.vendasDAO = new VendasDAO();
	}

	public void fecharTela(JFrame jFrame) {
		jFrame.dispose();
	}

	public void preencherCampos() {
		// vendasHelper.preencherCampos();
	}

	public void salvarProduto() {/*
									 * if (!produtosHelper.temProdutoSelecionado()) { Produto produto =
									 * produtosHelper.getProduto(); produtosDAO.AdicionarProduto(produto);
									 * this.atualizarTabela(); produtosHelper.limparCampos(); } else { try { Produto
									 * produto = produtosHelper.getProduto();
									 * produtosDAO.updateProduto(this.produtosHelper.getProdutoSelecionado(),
									 * produto); System.out.println("Produto " + produto.getDescricao() +
									 * " atualizado com sucesso"); this.atualizarTabela(); } catch (Exception e) {
									 * System.out.println("Erro ao atualizar produto"); }
									 * 
									 * }
									 */

	}

	public void atualizarTabela() {/*
									 * ProdutosDAO produtoDAO = new ProdutosDAO(); ArrayList<Produto> produtos =
									 * produtoDAO.selectAll(); this.produtosHelper.preencherTabela(produtos);
									 */
	}

	/*
	 * public Produto getProduto() { return
	 * produtosDAO.getProduto(this.produtosHelper.getProdutoSelecionado());
	 * 
	 * }
	 */

	public void removerSelecionado() {/*
										 * System.out.println(produtosHelper.temProdutoSelecionado());
										 * 
										 * if (produtosHelper.temProdutoSelecionado()) { Produto produto =
										 * this.getProduto(); if (produtosDAO.RemoverProduto(produto)) {
										 * System.out.println("Produto " + produto.getDescricao() +
										 * " removido com sucesso"); this.atualizarTabela(); } else {
										 * System.out.println("Erro ao remover produto"); }
										 * 
										 * }
										 */

	}

	public void buscarCliente(Long id) {

		Cliente cliente = vendasHelper.getClienteById(id);
		vendasHelper.preencherCliente(cliente.getNome());

	}
	
	public Cliente getClienteById(Long id) {

		return vendasHelper.getClienteById(id);

	}

	public void buscarProduto(long id) {
		Produto produto = vendasHelper.getProdutoById(id);
		vendasHelper.preencherDescricaoProduto(produto.getDescricao());

	}

	public void adicionarItem(long id, Integer qtde) {
		Produto produto = produtosDAO.getProdutoById(id);
		Double total = produto.getPreco() * qtde;
		Item item = new Item(null, produto.getId(), qtde, produto.getPreco(), total);
		vendasHelper.AdicionarNaListaAuxiliar(item);
		vendasHelper.preencherTabela(frmVendas.getItensAux());
		vendasHelper.limparCamposItens();
		vendasHelper.atualizarTotalItens();
	}

	public void atualizarQtdePreco(int row, int column, Object newValue) {
		vendasHelper.atualizarQtdePreco(row, column, newValue);

	}

	public void abrirPesquisarProduto() {
		try {
			PesqProd dialog = new PesqProd(frmVendas, "Pesquisar Produto", true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void abrirPesquisarCliente() {
		try {
			PesqCli dialog = new PesqCli(frmVendas, "Pesquisar Cliente", true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Cliente> buscarClientesPorNome(String nome) {
		return clientesDAO.getClientesByName(nome);
	}

	public void fecharTela(JDialog jDialog) {
		jDialog.dispose();
	}

	public List<Produto> buscarProdutosPorDesc(String desc) {
		return produtosDAO.getProdutosPorDesc(desc);
	}

	public void salvarVenda() {
		// verificar se dados da tela são válidos
		if (!frmVendas.getTextFieldNomeCliente().getText().equals("")
				&& !frmVendas.getItensAux().isEmpty()) {
			Long id = Long.parseLong(frmVendas.getTextFieldIdCliente().getText());
			
			Double total = 0D;
			for (Item i : frmVendas.getItensAux()) {
				total += i.getTotal();
			}
			
			// montar venda com os dados da tela
			Venda venda  = new Venda(getClienteById(id),
					new Date(),
					StatusVenda.ABERTA,
					frmVendas.getItensAux(),
					total);

			// chamar DAO para salvar a venda
			Venda vendaSalva = vendasDAO.salvarVenda(venda);

			// atualizar Id venda, status e data na tela

			frmVendas.getLabelIdVenda().setText("Id Venda: " + vendaSalva.getId());
			frmVendas.getLabelStatus().setText("Status: " + vendaSalva.getStatusVenda());
			frmVendas.getLabelData().setText("Data: " + vendaSalva.getDataVenda());
			
		} else {
			JOptionPane.showMessageDialog(frmVendas, "Dados incompletos!");
		}

	}

	public void cancelarVenda() {
		// verificar se venda ja está salva
		// se estiver, alterar status para cancelada
		// se nao estiver salva, limpar dados da tela

	}

	public void finalizarVenda() {
		// mudar status para finalizada
		// apos finalizar venda, bloquear tela para edição

	}

}
