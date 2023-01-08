package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import model.Item;

public class FrmVendas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField textFieldTotal;
	private JTextField textFieldIdCliente;
	private JTextField textFieldNomeCliente;
	private JTextField textFieldCodigoProduto;
	private JTextField textFieldQtde;
	private JTextField textFieldDescricao;
	
	private List<Item> itensAux;

	public void AddItemListaAux(Item item) {
		itensAux.add(item);
	}
	
	public void RemoveItemListaAux(Item item) {
		itensAux.remove(item);
	}
	
	public List<Item> getItensAux() {
		return itensAux;
	}

	public void setItensAux(List<Item> itensAux) {
		this.itensAux = itensAux;
	}

	public JTextField getTextFieldTotal() {
		return textFieldTotal;
	}

	public JTextField getTextFieldIdCliente() {
		return textFieldIdCliente;
	}

	public JTextField getTextFieldNomeCliente() {
		return textFieldNomeCliente;
	}

	public JTextField getTextFieldCodigoProduto() {
		return textFieldCodigoProduto;
	}

	public JTextField getTextFieldQtde() {
		return textFieldQtde;
	}

	public JTable getTable() {
		return table;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmVendas frame = new FrmVendas();
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
	@SuppressWarnings("serial")
	public FrmVendas() {
		itensAux = new ArrayList<>();  // lista auxiliar
		setTitle("Venda");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 591, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(UIManager.getColor("Button.focus"));
		scrollPane.setBounds(2, 180, 580, 160);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Descri\u00E7\u00E3o", "Qtde", "Pre\u00E7o", "Total"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(0).setMinWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(1).setMinWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setMinWidth(50);
		table.getColumnModel().getColumn(3).setMinWidth(75);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setMinWidth(90);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setViewportView(table);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(437, 352, 40, 15);
		contentPane.add(lblTotal);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setBounds(485, 348, 95, 19);
		contentPane.add(textFieldTotal);
		textFieldTotal.setColumns(10);
		
		JPanel panelCliente = new JPanel();
		panelCliente.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		panelCliente.setBounds(12, 18, 557, 70);
		contentPane.add(panelCliente);
		panelCliente.setLayout(null);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(33, 18, 13, 15);
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		panelCliente.add(lblId);
		
		textFieldIdCliente = new JTextField();
		textFieldIdCliente.setBounds(33, 37, 70, 19);
		panelCliente.add(textFieldIdCliente);
		textFieldIdCliente.setColumns(10);
		
		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente");
		lblNomeDoCliente.setBounds(120, 18, 120, 15);
		panelCliente.add(lblNomeDoCliente);
		
		textFieldNomeCliente = new JTextField();
		textFieldNomeCliente.setEditable(false);
		textFieldNomeCliente.setBounds(120, 37, 430, 19);
		panelCliente.add(textFieldNomeCliente);
		textFieldNomeCliente.setColumns(10);
		
		JButton btnPesquisarCliente = new JButton("");
		btnPesquisarCliente.setBounds(5, 37, 20, 19);
		panelCliente.add(btnPesquisarCliente);
		
		JPanel panelItens = new JPanel();
		panelItens.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Adicionar \u00CDtem", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		panelItens.setBounds(12, 100, 557, 70);
		contentPane.add(panelItens);
		panelItens.setLayout(null);
		
		textFieldQtde = new JTextField();
		textFieldQtde.setBounds(5, 37, 50, 19);
		panelItens.add(textFieldQtde);
		textFieldQtde.setColumns(10);
		
		JLabel lblCdigo = new JLabel("Código");
		lblCdigo.setBounds(95, 18, 50, 15);
		panelItens.add(lblCdigo);
		
		textFieldCodigoProduto = new JTextField();
		textFieldCodigoProduto.setBounds(95, 37, 70, 19);
		panelItens.add(textFieldCodigoProduto);
		textFieldCodigoProduto.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Qtde");
		lblQuantidade.setBounds(5, 18, 40, 15);
		panelItens.add(lblQuantidade);
		
		JButton button = new JButton("");
		button.setBounds(70, 37, 20, 19);
		panelItens.add(button);
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setEditable(false);
		textFieldDescricao.setBounds(180, 37, 370, 19);
		panelItens.add(textFieldDescricao);
		textFieldDescricao.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setBounds(180, 18, 70, 15);
		panelItens.add(lblDescricao);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(247, 0, 70, 15);
		contentPane.add(lblStatus);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(437, 0, 70, 15);
		contentPane.add(lblData);
		
		JLabel lblIdVenda = new JLabel("Id Venda");
		lblIdVenda.setBounds(12, 0, 70, 15);
		contentPane.add(lblIdVenda);
	}
}
