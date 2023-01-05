package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Rectangle;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class FrmVendas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField textFieldTotal;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textFieldCodigoProduto;
	private JTextField textFieldQtde;

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
		
		textField = new JTextField();
		textField.setBounds(33, 37, 70, 19);
		panelCliente.add(textField);
		textField.setColumns(10);
		
		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente");
		lblNomeDoCliente.setBounds(120, 18, 120, 15);
		panelCliente.add(lblNomeDoCliente);
		
		textField_1 = new JTextField();
		textField_1.setBounds(120, 37, 430, 19);
		panelCliente.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnPesquisarCliente = new JButton("");
		btnPesquisarCliente.setBounds(5, 37, 20, 19);
		panelCliente.add(btnPesquisarCliente);
		
		JPanel panelItens = new JPanel();
		panelItens.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Adicionar \u00CDtem", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		panelItens.setBounds(12, 100, 557, 70);
		contentPane.add(panelItens);
		panelItens.setLayout(null);
		
		textFieldQtde = new JTextField();
		textFieldQtde.setBounds(33, 37, 50, 19);
		panelItens.add(textFieldQtde);
		textFieldQtde.setColumns(10);
		
		JLabel lblCdigo = new JLabel("Código");
		lblCdigo.setBounds(120, 18, 50, 15);
		panelItens.add(lblCdigo);
		
		textFieldCodigoProduto = new JTextField();
		textFieldCodigoProduto.setBounds(120, 37, 70, 19);
		panelItens.add(textFieldCodigoProduto);
		textFieldCodigoProduto.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Qtde");
		lblQuantidade.setBounds(33, 18, 90, 15);
		panelItens.add(lblQuantidade);
		
		JButton button = new JButton("");
		button.setBounds(5, 37, 20, 19);
		panelItens.add(button);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(247, 0, 70, 15);
		contentPane.add(lblStatus);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(437, 0, 70, 15);
		contentPane.add(lblData);
		
		JLabel lblVendaNmero = new JLabel("Id Venda");
		lblVendaNmero.setBounds(12, 0, 70, 15);
		contentPane.add(lblVendaNmero);
	}
}
