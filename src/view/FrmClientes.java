package view;


import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
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
import javax.swing.text.MaskFormatter;

import controller.ClientesController;

public class FrmClientes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldDataNasc;
	private JTable table;
	private JTextField textFieldEmail;
	private JTextField textFieldTelefone;
	private JTextField textFieldId;
	private MaskFormatter maskTel;
	private MaskFormatter maskData;



	/**
	 * Create the frame.
	 */
	public FrmClientes(){
		setResizable(false);
		ClientesController clientescontroller = new ClientesController(this);
		setTitle("Cadastro de Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 530, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeClientes = new JLabel("Cadastro de Clientes");
		lblCadastroDeClientes.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCadastroDeClientes.setBounds(139, 12, 200, 15);
		contentPane.add(lblCadastroDeClientes);
		
		JButton btnNewButton = new JButton("Sair");
		
		btnNewButton.addActionListener(e -> clientescontroller.fecharTela(this)); // actionlistener usando lambda
		btnNewButton.setBounds(349, 166, 117, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 82, 70, 15);
		contentPane.add(lblNome);
		
		JLabel lblDataNasc = new JLabel("Data Nascimento:");
		lblDataNasc.setBounds(384, 82, 131, 15);
		contentPane.add(lblDataNasc);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(12, 95, 350, 19);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		maskData = new MaskFormatter();
		try {
			maskData.setMask("##/##/####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		textFieldDataNasc = new JFormattedTextField(maskData);
		textFieldDataNasc.setBounds(384, 95, 80, 19);
		contentPane.add(textFieldDataNasc);
		textFieldDataNasc.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");

		btnSalvar.addActionListener(e -> {
			try {
				clientescontroller.salvarCliente();
			} catch (ParseException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		});
		btnSalvar.setBounds(12, 166, 117, 25);
		contentPane.add(btnSalvar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(e -> clientescontroller.limparCampos());
		btnNovo.setBounds(159, 166, 117, 25);
		contentPane.add(btnNovo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 203, 503, 145);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.getTableHeader().setReorderingAllowed(false);
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
				{null, null, null},
			},
			new String[] {
				"ID", "Nome", "Telefone"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(0).setMaxWidth(50);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(1).setMinWidth(300);
		table.getColumnModel().getColumn(1).setMaxWidth(300);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setMinWidth(150);
		table.getColumnModel().getColumn(2).setMaxWidth(150);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(e -> clientescontroller.removerSelecionado());
		btnRemover.setBounds(12, 360, 117, 25);
		contentPane.add(btnRemover);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(12, 135, 350, 19);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		maskTel = new MaskFormatter();
		
		try {
			maskTel.setMask("(##) #####-####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		textFieldTelefone = new JFormattedTextField(maskTel);
		textFieldTelefone.setBounds(384, 135, 131, 19);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(12, 119, 70, 15);
		contentPane.add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(384, 119, 70, 15);
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



	public MaskFormatter getMaskTel() {
		return maskTel;
	}



	public void setMaskTel(MaskFormatter maskTel) {
		this.maskTel = maskTel;
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

	public JTextField getTextFieldDataNasc() {
		return this.textFieldDataNasc;
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
