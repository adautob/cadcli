package controller.helper;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import dao.ClientesDAO;
import dao.ProdutosDAO;
import model.Cliente;
import model.Item;
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

	public Venda getVenda() { // implementar instancia Venda pegando dados da tela
		
		Cliente cliente = clientesDAO.getCliente(Integer.parseInt(frmVendas.getTextFieldIdCliente().getText()));
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
		
		for (Item item : itens) { // implementar codigo para preencher JTable com Itens da venda
			tm.addRow(new Object[] {
					item.getId_produto(),
					produtosDAO.getProduto(item.getId_produto()),
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
}

