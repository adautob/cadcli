package controller.helper;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import dao.ClientesDAO;
import dao.ProdutosDAO;
import model.Cliente;
import model.Item;
import model.Produto;
import model.StatusVenda;
import model.Venda;
import view.FrmVendas;

public class VendasHelper {
	private final FrmVendas frmVendas;
	ClientesDAO clientesDAO;
	ProdutosDAO produtosDAO;

	public VendasHelper(FrmVendas frmVendas) {
		this.frmVendas = frmVendas;
		this.clientesDAO = new ClientesDAO();
		this.produtosDAO = new ProdutosDAO();
	}

	public Venda getVenda() {
		
		Cliente cliente = clientesDAO.getClienteById(Long.parseLong(frmVendas.getTextFieldIdCliente().getText()));
		Double total = 0d;
		
		for (Item item: frmVendas.getItensAux()) {
			total += item.getTotal();
		}
		
		
		return new Venda(cliente, new Date(), StatusVenda.ABERTA, frmVendas.getItensAux(), total);
	}

	public void limparCampos() {
		frmVendas.getTextFieldIdCliente().setText("");
		frmVendas.getTextFieldIdCliente().requestFocus();
	}

	
	public void AdicionarNaListaAuxiliar(Item item) {
		frmVendas.AddItemListaAux(item);
	}
	
	public void preencherTabela(ArrayList<Item> itens) {
		DefaultTableModel tm = (DefaultTableModel)frmVendas.getTable().getModel();
		
		tm.setNumRows(0);
		
		for (Item item : itens) {
			tm.addRow(new Object[] {
					item.getId_produto(),
					produtosDAO.getProdutoById(item.getId_produto()).getDescricao(),
					item.getQuantidade(),
					item.getPreco(),
					item.getTotal()
			});
			
			
		}
	}
	
	public int getItemSelecionado() {
		return frmVendas.getTable().getSelectedRow();
	}
	
	public boolean temItemSelecionado() {
		return (frmVendas.getTable().getSelectedRow() > -1);
		
	}

	public void preencherCampos(Item item) {
		frmVendas.getTextFieldQtde().setText(item.getQuantidade().toString());
		frmVendas.getTextFieldCodigoProduto().setText(item.getId_produto().toString());
	}

	public Cliente getClienteById(Long id) {
		return clientesDAO.getClienteById(id);
	}

	public void preencherCliente(String nome) {
		frmVendas.getTextFieldNomeCliente().setText(nome);
		
	}

	public Produto getProdutoById(long id) {
		return produtosDAO.getProdutoById(id);
	}

	public void preencherDescricaoProduto(String descricao) {
		frmVendas.getTextFieldDescricao().setText(descricao);
		
	}
}

