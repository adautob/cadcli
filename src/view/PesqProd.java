package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.VendasController;

public class PesqProd extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;
	private VendasController vendasController;



	/**
	 * Create the dialog.
	 */
	public PesqProd(FrmVendas mf, String title, boolean modal) {
		super(mf, title, modal);
		vendasController = new VendasController(mf);
		setResizable(false);
		setBounds(100, 100, 300, 200);
		setLocationRelativeTo(mf);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 131, 290, 35);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(e -> vendasController.fecharTela(this));
			}
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(3, 56, 285, 75);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"C\u00F3digo", "Descri\u00E7\u00E3o"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(0).setMinWidth(50);
		table.getColumnModel().getColumn(0).setMaxWidth(50);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setMinWidth(150);
		table.getColumnModel().getColumn(1).setMaxWidth(250);
		scrollPane.setViewportView(table);
		
		JLabel lblPesquisarClientePor = new JLabel("Digite o produto");
		lblPesquisarClientePor.setBounds(3, 12, 120, 15);
		getContentPane().add(lblPesquisarClientePor);
		
		textField = new JTextField();
		textField.setBounds(3, 30, 285, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
	}
}
