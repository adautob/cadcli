package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.ProdutosController;
import util.NumberRenderer;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FrmProdutos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldDescricao;
	private JTextField textFieldPreco;
	private JTextField textFieldCodigo;

	public JTable getTable() {
		return table;
	}

	public JTextField getTextFieldDescricao() {
		return textFieldDescricao;
	}

	public JTextField getTextFieldPreco() {
		return textFieldPreco;
	}

	public JTextField getTextFieldCodigo() {
		return textFieldCodigo;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProdutos frame = new FrmProdutos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmProdutos() {
		final Integer LARGURA = 520;
		final Integer ALTURA = 345;

		ProdutosController produtosController = new ProdutosController(this);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, LARGURA, ALTURA);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadas = new JLabel("Cadastro de Produtos");
		lblCadas.setBounds(149, 10, 196, 19);
		lblCadas.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCadas.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCadas);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(2, ALTURA - 203, LARGURA - 11, ALTURA / 2);
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
					System.out.println(produtosController.getProduto());
					System.out.println(index);
					produtosController.preencherCampos();
				}

			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Descri\u00E7\u00E3o", "Pre\u00E7o"
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
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(0).setMaxWidth(50);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setMinWidth(200);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setMinWidth(50);
		table.getColumnModel().getColumn(2).setCellRenderer(NumberRenderer.getCurrencyRenderer());

		JLabel lblDescris = new JLabel("Descrição");
		lblDescris.setBounds(12, 61, 70, 15);
		contentPane.add(lblDescris);

		JLabel lblPreo = new JLabel("Preço");
		lblPreo.setBounds(27, 88, 70, 15);
		contentPane.add(lblPreo);

		textFieldDescricao = new JTextField();
		textFieldDescricao.setBounds(86, 59, 412, 19);
		contentPane.add(textFieldDescricao);
		textFieldDescricao.setColumns(10);

		textFieldPreco = new JTextField();
		textFieldPreco.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (!textFieldCodigo.getText().equals("")) {
					textFieldPreco.setText(produtosController.pegaPrecoProdutoSelecionado().toString());
				}
			}
		});
		
		textFieldPreco.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres="0987654321.";// lista de caracters que devem ser aceitos
				if(!caracteres.contains(e.getKeyChar()+"")
						||(textFieldPreco.getText().contains("."))&&(e.getKeyChar()=='.')){// se o caracter que gerou o
				//evento estiver não estiver na lista
				e.consume();//aciona esse propriedade para eliminar a ação do evento
				} 
			}
		});
		
		textFieldPreco.setBounds(86, 86, 114, 19);
		contentPane.add(textFieldPreco);
		textFieldPreco.setColumns(10);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(e -> produtosController.limparCampos());
		btnNovo.setBounds(12, 105, 117, 25);
		contentPane.add(btnNovo);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(e -> produtosController.fecharTela(this));
		btnSair.setBounds(377, 105, 117, 25);
		contentPane.add(btnSair);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(e -> produtosController.salvarProduto());
		btnSalvar.setBounds(259, 105, 117, 25);
		contentPane.add(btnSalvar);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(e -> produtosController.removerSelecionado());
		btnRemover.setBounds(130, 105, 117, 25);
		contentPane.add(btnRemover);

		JLabel lblCdigo = new JLabel("Código");
		lblCdigo.setBounds(12, 28, 70, 15);
		contentPane.add(lblCdigo);

		textFieldCodigo = new JTextField();
		textFieldCodigo.setEditable(false);
		textFieldCodigo.setBounds(86, 28, 114, 19);
		contentPane.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);

		produtosController.atualizarTabela();

	}
}
