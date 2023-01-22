package controller.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Cliente;
import view.FrmClientes;

public class ClientesHelper {
	private final FrmClientes frmClientes;

	public ClientesHelper(FrmClientes frmClientes) {
		this.frmClientes = frmClientes;
	}

	public Cliente getCliente() throws ParseException {
		Long id = null;
		if (!frmClientes.getTextFieldId().getText().equals("")) {
			id = Long.parseLong(frmClientes.getTextFieldId().getText());
		}
		return new Cliente(id,
				frmClientes.getTextFieldNome().getText(),
				frmClientes.getTextFieldEmail().getText(),
				frmClientes.getTextFieldTelefone().getText(),
				new SimpleDateFormat("dd/MM/yyyy").parse(frmClientes.getTextFieldDataNasc().getText()));
	}

	public void limparCampos() {
		frmClientes.getTextFieldId().setText("");
		frmClientes.getTextFieldNome().setText("");
		frmClientes.getTextFieldEmail().setText("");
		frmClientes.getTextFieldTelefone().setText("");
		frmClientes.getTextFieldDataNasc().setText("");
		frmClientes.getTextFieldNome().requestFocus();
		frmClientes.getTable().removeRowSelectionInterval(0, frmClientes.getTable().getRowCount()-1);
	}


	public void preencherTabela(ArrayList<Cliente> clientes) {
		DefaultTableModel tm = (DefaultTableModel)frmClientes.getTable().getModel();
		
		tm.setNumRows(0);
		
		for (Cliente cliente : clientes) {
			tm.addRow(new Object[] {
					cliente.getId(),
					cliente.getNome(),
					cliente.getTelefone()
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
		frmClientes.getTextFieldId().setText(cliente.getId().toString());
		frmClientes.getTextFieldNome().setText(cliente.getNome());
		frmClientes.getTextFieldEmail().setText(cliente.getEmail());
		frmClientes.getTextFieldTelefone().setText(cliente.getTelefone());
		frmClientes.getTextFieldDataNasc().setText(cliente.getDataNasc().toString());
	}
}

