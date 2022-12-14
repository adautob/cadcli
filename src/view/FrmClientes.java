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
	private JTextField textFieldEmail;
	private JTextField textFieldTelefone;



	/**
	 * Create the frame.
	 */
	public FrmClientes() {
		setResizable(false);
		ClientesController clientescontroller = new ClientesController(this);
		setTitle("Cadastro de Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeClientes = new JLabel("Cadastro de Clientes");
		lblCadastroDeClientes.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCadastroDeClientes.setBounds(139, 12, 200, 15);
		contentPane.add(lblCadastroDeClientes);
		
		JButton btnNewButton = new JButton("Sair");
		
		btnNewButton.addActionListener(e -> clientescontroller.fecharTela()); // actionlistener usando lambda
		btnNewButton.setBounds(349, 135, 117, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 39, 70, 15);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(349, 39, 70, 15);
		contentPane.add(lblIdade);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(12, 52, 285, 19);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldIdade = new JTextField();
		textFieldIdade.setBounds(349, 52, 117, 19);
		contentPane.add(textFieldIdade);
		textFieldIdade.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");

		btnSalvar.addActionListener(e -> clientescontroller.salvarCliente());
		btnSalvar.setBounds(12, 135, 117, 25);
		contentPane.add(btnSalvar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(e -> clientescontroller.limparCampos());
		btnNovo.setBounds(159, 135, 117, 25);
		contentPane.add(btnNovo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 172, 651, 145);
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
				"Nome", "Email", "Telefone", "Idade"
			}
		));
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(e -> clientescontroller.removerSelecionado());
		btnRemover.setBounds(12, 329, 117, 25);
		contentPane.add(btnRemover);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(12, 92, 285, 19);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(302, 92, 164, 19);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(12, 76, 70, 15);
		contentPane.add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(304, 76, 70, 15);
		contentPane.add(lblTelefone);
		table.getColumnModel().getColumn(0).setResizable(true);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(0).setMaxWidth(150);
		table.getColumnModel().getColumn(1).setResizable(true);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setMaxWidth(150);
		table.getColumnModel().getColumn(2).setResizable(true);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setMaxWidth(100);
		table.getColumnModel().getColumn(3).setResizable(true);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setMaxWidth(50);
		
		clientescontroller.atualizarTabela();
	}



	public JTextField getTextFieldNome() {
		return this.textFieldNome;
	}

	public JTextField getTextFieldIdade() {
		return this.textFieldIdade;
	}
	

	public JTextField getTextFieldEmail() {
		return this.textFieldEmail;
	}


	public JTextField getTextFieldTelefone() {
		return this.textFieldTelefone;
	}


	public JTable getTable() {
		return table;
	}



	public void setTable(JTable jtable) {
		this.table = jtable;
	}
}
