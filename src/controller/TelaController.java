package controller;

import dao.Banco;
import view.FrmClientes;
import view.Sistema;

public class TelaController {
	
	Sistema tela;

	public TelaController(Sistema tela){
		this.tela = tela;
		
	}
	
	public void FecharSistema(){
		System.exit(0);
	}
	
	public void navegarClientes(){
		FrmClientes frmClientes = new FrmClientes();
		frmClientes.setLocationRelativeTo(null);
		frmClientes.setVisible(true);
	}
	
	public Banco getBanco() {
		return tela.banco;
	}
	
}
