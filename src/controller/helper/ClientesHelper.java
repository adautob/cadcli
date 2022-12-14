package controller.helper;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Cliente;
import view.FrmClientes;

public class ClientesHelper {
	private final FrmClientes frmClientes;

	public ClientesHelper(FrmClientes frmClientes) {
		this.frmClientes = frmClientes;
	}

	public Cliente getCliente() {
		return new Cliente(null, frmClientes.getTextFieldNome().getText(),
				frmClientes.getTextFieldEmail().getText(),
				frmClientes.getTextFieldTelefone().getText(),
				frmClientes.getTextFieldIdade().getText());
	}

	public void limparCampos() {
		frmClientes.getTextFieldNome().setText("");
		frmClientes.getTextFieldEmail().setText("");
		frmClientes.getTextFieldTelefone().setText("");
		frmClientes.getTextFieldIdade().setText("");
		frmClientes.getTextFieldNome().requestFocus();
	}

	public void preencherTabela() {
	}

	public void preencherTabela(ArrayList<Cliente> clientes) {
		DefaultTableModel tm = (DefaultTableModel)frmClientes.getTable().getModel();
		
		tm.setNumRows(0);
		
		for (Cliente cliente : clientes) {
			tm.addRow(new Object[] {
					cliente.getNome(),
					cliente.getEmail(),
					cliente.getTelefone(),
					cliente.getIdade()					
			});
			
			
		}
	}
	
	public int getClienteSelecionado() {
		return frmClientes.getTable().getSelectedRow();
	}
	
	public boolean temClienteSelecionado() {
		return (frmClientes.getTable().getSelectedRow() > -1);
		
	}

	public void preencherCampos(Cliente cliente) {
		frmClientes.getTextFieldNome().setText(cliente.getNome());
		frmClientes.getTextFieldEmail().setText(cliente.getEmail());
		frmClientes.getTextFieldTelefone().setText(cliente.getTelefone());
		frmClientes.getTextFieldIdade().setText(cliente.getIdade());
	}
}

