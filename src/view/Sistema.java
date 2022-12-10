package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.TelaController;
import dao.Banco;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sistema extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuItem mntmSair;
	public Banco banco = new Banco();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sistema frame = new Sistema();
					frame.setLocationRelativeTo(null);
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
	public Sistema() {
		Banco.inicia();
		setTitle("Sistema");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 450);
		TelaController  telacontroller = new TelaController(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		mnArquivo.setMnemonic('A');
		menuBar.add(mnArquivo);
		
		
		mntmSair = new JMenuItem("Sair");
		mntmSair.setMnemonic('r');
		mntmSair.addActionListener(e -> telacontroller.FecharSistema());
		mnArquivo.add(mntmSair);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		mnCadastro.setMnemonic('C');
		menuBar.add(mnCadastro);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.setMnemonic('C');
		mntmClientes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					telacontroller.navegarClientes();
				}
			});
		mnCadastro.add(mntmClientes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(e -> telacontroller.FecharSistema());
		btnSair.setBounds(556, 358, 117, 25);
		contentPane.add(btnSair);
	}

}
