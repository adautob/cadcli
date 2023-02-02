package view;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import controller.VendasController;
import model.Cliente;

public class PesqCli extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textFieldPesqCli;
	
	private VendasController vendasController;

	/**
	 * Create the dialog.
	 */
	public PesqCli(FrmVendas mf, String title, boolean modal) {
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
				okButton.addActionListener(e -> {
					if (table.getSelectedRow()>-1) {
						DefaultTableModel tm = (DefaultTableModel) table.getModel();
						if (tm.getValueAt(table.getSelectedRow(), 0) != null) {
							mf.getTextFieldIdCliente().setText(tm.getValueAt(table.getSelectedRow(), 0).toString());
							vendasController.fecharTela(this);
							mf.getTextFieldCodigoProduto().requestFocus();
						}
					}
				});
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
				"ID", "Nome"
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

		JLabel lblPesquisarClientePor = new JLabel("Digite o nome");
		lblPesquisarClientePor.setBounds(3, 12, 100, 15);
		getContentPane().add(lblPesquisarClientePor);

		textFieldPesqCli = new JTextField();
		textFieldPesqCli.setBounds(3, 30, 285, 19);
		getContentPane().add(textFieldPesqCli);
		textFieldPesqCli.setColumns(10);
		textFieldPesqCli.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent e) {
				preencherTabelaPesq(vendasController.buscarClientesPorNome(textFieldPesqCli.getText()));
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				preencherTabelaPesq(vendasController.buscarClientesPorNome(textFieldPesqCli.getText()));
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				preencherTabelaPesq(vendasController.buscarClientesPorNome(textFieldPesqCli.getText()));
			}

		});

	}

	protected void preencherTabelaPesq(List<Cliente> clientes) {
		DefaultTableModel tm = (DefaultTableModel) table.getModel();

		tm.setNumRows(0);

		for (Cliente cliente : clientes) {
			tm.addRow(new Object[] { cliente.getId(), cliente.getNome() });
		}
	}
}
