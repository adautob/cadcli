package view;


import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controller.ClientesController;
import javax.swing.JScrollPane;

public class FrmClientes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldIdade;
	private JTable table;



	/**
	 * Create the frame.
	 */
	public FrmClientes() {
		setResizable(false);
		ClientesController clientescontroller = new ClientesController(this);
		setTitle("Cadastro de Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 488, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeClientes = new JLabel("Cadastro de Clientes");
		lblCadastroDeClientes.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCadastroDeClientes.setBounds(119, 12, 200, 15);
		contentPane.add(lblCadastroDeClientes);
		
		JButton btnNewButton = new JButton("Sair");
		
		btnNewButton.addActionListener(e -> clientescontroller.fecharTela()); // actionlistener usando lambda
		btnNewButton.setBounds(337, 79, 117, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(40, 39, 70, 15);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(337, 39, 70, 15);
		contentPane.add(lblIdade);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(40, 52, 248, 19);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldIdade = new JTextField();
		textFieldIdade.setBounds(337, 52, 117, 19);
		contentPane.add(textFieldIdade);
		textFieldIdade.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");

		btnSalvar.addActionListener(e -> clientescontroller.salvarCliente());
		btnSalvar.setBounds(40, 79, 117, 25);
		contentPane.add(btnSalvar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(e -> clientescontroller.limparCampos());
		btnNovo.setBounds(182, 79, 117, 25);
		contentPane.add(btnNovo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 132, 414, 185);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setShowHorizontalLines(false);
		table.setName("");
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel selectionModel = table.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int index = table.getSelectedRow();
				if ((!e.getValueIsAdjusting()) && (index > -1)) {
					System.out.println(clientescontroller.getCliente());
					System.out.println(index);
					clientescontroller.preencherCampos();
				}
				
			}
		});
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Idade"
			}
		));
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(e -> clientescontroller.removerSelecionado());
		btnRemover.setBounds(40, 329, 117, 25);
		contentPane.add(btnRemover);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(330);
		table.getColumnModel().getColumn(0).setMaxWidth(330);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setMaxWidth(80);
		
		clientescontroller.atualizarTabela();
	}



	public JTextField getTextFieldNome() {
		return this.textFieldNome;
	}

	public JTextField getTextFieldIdade() {
		return this.textFieldIdade;
	}


	public JTable getTable() {
		return table;
	}



	public void setTable(JTable jtable) {
		this.table = jtable;
	}
}
