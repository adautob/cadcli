package controller;

import java.util.ArrayList;

import controller.helper.ClientesHelper;
import dao.ClientesDAO;
import model.Cliente;
import view.FrmClientes;

public class ClientesController {
	private final FrmClientes frmClientes;
	private final ClientesHelper clientesHelper;
	private final ClientesDAO clientesDAO;

	public ClientesController(FrmClientes frmclientes) {
		this.frmClientes = frmclientes;
		this.clientesHelper = new ClientesHelper(frmClientes);
		this.clientesDAO = new ClientesDAO();
	}

	public void fecharTela() {
		frmClientes.setVisible(false);
	}

	public void limparCampos() {
		clientesHelper.limparCampos();
	}

	public void preencherCampos() {
		clientesHelper.preencherCampos(this.getCliente());
	}

	public void salvarCliente() {
		if (!clientesHelper.temClienteSelecionado()) {
			Cliente cliente = clientesHelper.getCliente();
			clientesDAO.AdicionarCliente(cliente);
			this.atualizarTabela();
			clientesHelper.limparCampos();
		} else {
			try {
				Cliente cliente = clientesHelper.getCliente();
				clientesDAO.updateCliente(this.clientesHelper.getClienteSelecionado(), cliente);
				System.out.println("Cliente " + cliente.getNome() + " atualizado com sucesso");
				this.atualizarTabela();
			} catch (Exception e) {
				System.out.println("Erro ao atualizar cliente");
			}

		}

	}

	public void atualizarTabela() {
		ClientesDAO clienteDAO = new ClientesDAO();
		ArrayList<Cliente> clientes = clienteDAO.selectAll();
		this.clientesHelper.preencherTabela(clientes);
	}

	public Cliente getCliente() {
		return clientesDAO.getCliente(this.clientesHelper.getClienteSelecionado());

	}

	public void removerSelecionado() {
		System.out.println(clientesHelper.temClienteSelecionado());

		if (clientesHelper.temClienteSelecionado()) {
			Cliente cliente = this.getCliente();
			if (clientesDAO.RemoverCliente(cliente)) {
				System.out.println("Cliente " + cliente.getNome() + " removido com sucesso");
				this.atualizarTabela();
			} else {
				System.out.println("Erro ao remover cliente");
			}

		}

	}

}
