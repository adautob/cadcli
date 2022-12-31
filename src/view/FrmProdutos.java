package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class FrmProdutos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

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
		scrollPane.setBounds(2, ALTURA-203, LARGURA-11, ALTURA/2);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
			},
			new String[] {
				"Descri\u00E7\u00E3o", "Pre\u00E7o"
			}
		));
		
		JLabel lblDescris = new JLabel("Descrição");
		lblDescris.setBounds(12, 49, 70, 15);
		contentPane.add(lblDescris);
		
		JLabel lblPreo = new JLabel("Preço");
		lblPreo.setBounds(27, 88, 70, 15);
		contentPane.add(lblPreo);
		
		textField = new JTextField();
		textField.setBounds(86, 47, 412, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(86, 86, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(0).setMinWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setMinWidth(50);
		
	
	}
}
