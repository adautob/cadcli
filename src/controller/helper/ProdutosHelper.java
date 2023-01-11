package controller.helper;

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
		return new Produto(null, frmProdutos.getTextFieldDescricao().getText(),
				Double.parseDouble(frmProdutos.getTextFieldPreco().getText()));
	}

	public void limparCampos() {
		frmProdutos.getTextFieldDescricao().setText("");
		frmProdutos.getTextFieldPreco().setText("");
		frmProdutos.getTextFieldDescricao().requestFocus();
	}


	public void preencherTabela(ArrayList<Produto> produtos) {
		DefaultTableModel tm = (DefaultTableModel)frmProdutos.getTable().getModel();
		
		tm.setNumRows(0);
		
		for (Produto produto : produtos) {
			tm.addRow(new Object[] {
					produto.getDescricao(),
					produto.getPreco()					
			});
			
			
		}
	}
	
	public int getProdutoSelecionado() {
		return frmProdutos.getTable().getSelectedRow();
	}
	
	public boolean temProdutoSelecionado() {
		return (frmProdutos.getTable().getSelectedRow() > -1);
		
	}

	public void preencherCampos(Produto produto) {
		frmProdutos.getTextFieldDescricao().setText(produto.getDescricao());
		frmProdutos.getTextFieldPreco().setText(String.valueOf(produto.getPreco()));
	}
}

