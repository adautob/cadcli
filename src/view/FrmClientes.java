package view;


import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controller.ClientesController;

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
	private JTextField textFieldId;



	/**
	 * Create the frame.
	 */
	public FrmClientes() {
		setResizable(false);
		ClientesController clientescontroller = new ClientesController(this);
		setTitle("Cadastro de Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 565, 425);
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
		btnNewButton.setBounds(349, 166, 117, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 82, 70, 15);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(349, 82, 70, 15);
		contentPane.add(lblIdade);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(12, 95, 285, 19);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldIdade = new JTextField();
		textFieldIdade.setBounds(349, 95, 117, 19);
		contentPane.add(textFieldIdade);
		textFieldIdade.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");

		btnSalvar.addActionListener(e -> clientescontroller.salvarCliente());
		btnSalvar.setBounds(12, 166, 117, 25);
		contentPane.add(btnSalvar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(e -> clientescontroller.limparCampos());
		btnNovo.setBounds(159, 166, 117, 25);
		contentPane.add(btnNovo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 203, 536, 145);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.getTableHeader().setReorderingAllowed(false);
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
				"ID", "Nome", "Email", "Telefone", "Idade"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Object.class, Object.class, Object.class
			};
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setMaxWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setMaxWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setMaxWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setMaxWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setMaxWidth(50);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(e -> clientescontroller.removerSelecionado());
		btnRemover.setBounds(12, 360, 117, 25);
		contentPane.add(btnRemover);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(12, 135, 285, 19);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(302, 135, 164, 19);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(12, 119, 70, 15);
		contentPane.add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(304, 119, 70, 15);
		contentPane.add(lblTelefone);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(12, 54, 70, 15);
		contentPane.add(lblId);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(241, 54, 70, 15);
		contentPane.add(lblStatus);
		
		textFieldId = new JTextField();
		textFieldId.setEditable(false);
		textFieldId.setBounds(32, 51, 80, 19);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
		clientescontroller.atualizarTabela();
	}



	public JTextField getTextFieldId() {
		return textFieldId;
	}



	public void setTextFieldId(JTextField textFieldId) {
		this.textFieldId = textFieldId;
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
