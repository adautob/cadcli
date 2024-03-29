package controller.helper;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Produto;
import view.FrmProdutos;

public class ProdutosHelper {
	private final FrmProdutos frmProdutos;

	public ProdutosHelper(FrmProdutos frmProdutos) {
		this.frmProdutos = frmProdutos;
	}

	public Produto getProduto() {
		Long id = null;
		Double preco = null;
		if (!frmProdutos.getTextFieldCodigo().getText().equals("")) {
			id = Long.parseLong(frmProdutos.getTextFieldCodigo().getText());
		}
		if (!frmProdutos.getTextFieldPreco().getText().contains("R"))
			preco = Double.parseDouble(frmProdutos.getTextFieldPreco().getText());
		
		return new Produto(id, frmProdutos.getTextFieldDescricao().getText(), preco);
	}

	public void limparCampos() {
		frmProdutos.getTextFieldCodigo().setText("");
		frmProdutos.getTextFieldDescricao().setText("");
		frmProdutos.getTextFieldPreco().setText("");
		frmProdutos.getTextFieldDescricao().requestFocus();
		frmProdutos.getTable().removeRowSelectionInterval(0, frmProdutos.getTable().getRowCount() - 1);
	}

	public void preencherTabela(ArrayList<Produto> produtos) {
		DefaultTableModel tm = (DefaultTableModel) frmProdutos.getTable().getModel();

		tm.setNumRows(0);

		for (Produto produto : produtos) {
			tm.addRow(new Object[] { produto.getId(), produto.getDescricao(), produto.getPreco() });

		}
	}

	public int getProdutoSelecionado() {
		return frmProdutos.getTable().getSelectedRow();
	}

	public boolean temProdutoSelecionado() {
		return (frmProdutos.getTable().getSelectedRow() > -1);

	}

	public void preencherCampos(Produto produto) {
		frmProdutos.getTextFieldCodigo().setText(produto.getId().toString());
		frmProdutos.getTextFieldDescricao().setText(produto.getDescricao());

		String valorFormatado = new DecimalFormat(" R$ #,##0.00").format(produto.getPreco());

		frmProdutos.getTextFieldPreco().setText(valorFormatado);
	}
}
