package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PesqCli extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;



	/**
	 * Create the dialog.
	 */
	public PesqCli(FrmVendas mf, String title, boolean modal) {
		super(mf, title, modal);
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
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(3, 56, 285, 75);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblPesquisarClientePor = new JLabel("Digite o nome");
		lblPesquisarClientePor.setBounds(3, 12, 100, 15);
		getContentPane().add(lblPesquisarClientePor);
		
		textField = new JTextField();
		textField.setBounds(3, 30, 285, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
	}
}
