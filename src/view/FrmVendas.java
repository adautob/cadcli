package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.VendasController;
import model.Item;
import util.NumberRenderer;
import util.TableCellListener;
import javax.swing.ImageIcon;

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

	private VendasController vendasController;

	private List<Item> itensAux;

	public void AddItemListaAux(Item item) {

		// código para incrementar o ID, pois este não será fornecido pelo usuário
		Long idMaior = 0L;
		for (Item i : getItensAux()) {
			if (i.getId() > idMaior)
				idMaior = i.getId();
		}

		item.setId(++idMaior);

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

	public JTextField getTextFieldDescricao() {
		return textFieldDescricao;
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
		vendasController = new VendasController(this);
		itensAux = new ArrayList<Item>();  // lista auxiliar
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
		scrollPane.setBounds(2, 180, 580, 155);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Descri\u00E7\u00E3o", "Qtde", "Pre\u00E7o", "Total"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Double.class, Double.class
			};
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		table.getTableHeader().setReorderingAllowed(false);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(0).setMinWidth(60);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(1).setMinWidth(250);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setMinWidth(50);
		table.getColumnModel().getColumn(2).setCellRenderer(NumberRenderer.getIntegerRenderer());
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setMinWidth(75);
		table.getColumnModel().getColumn(3).setCellRenderer(NumberRenderer.getCurrencyRenderer());
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setMinWidth(90);
		table.getColumnModel().getColumn(4).setCellRenderer(NumberRenderer.getCurrencyRenderer());


		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		Action action = new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
		        TableCellListener tcl = (TableCellListener)e.getSource();
		        System.out.println("Row   : " + tcl.getRow());
		        System.out.println("Column: " + tcl.getColumn());
		        System.out.println("Old   : " + tcl.getOldValue());
		        System.out.println("New   : " + tcl.getNewValue());
				vendasController.atualizarQtdePreco(tcl.getRow(), tcl.getColumn(), tcl.getNewValue());
			}
		};

		new TableCellListener(table, action);
		
		scrollPane.setViewportView(table);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(437, 352, 40, 15);
		contentPane.add(lblTotal);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setHorizontalAlignment(SwingConstants.RIGHT);
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
		textFieldIdCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres="0987654321";// lista de caracters que não devem ser aceitos
				if(!caracteres.contains(e.getKeyChar()+"")){// se o caracter que gerou o
				//evento estiver não estiver na lista
				e.consume();//aciona esse propriedade para eliminar a ação do evento
				} 
			}
		});
		
		textFieldIdCliente.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent e) {
				if (!getTextFieldIdCliente().getText().equals(""))
					vendasController.buscarCliente(Long.parseLong(getTextFieldIdCliente().getText()));
					else getTextFieldNomeCliente().setText("");	
				
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				if (!getTextFieldIdCliente().getText().equals(""))
					vendasController.buscarCliente(Long.parseLong(getTextFieldIdCliente().getText()));
					else getTextFieldNomeCliente().setText("");	
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (!getTextFieldIdCliente().getText().equals(""))
					vendasController.buscarCliente(Long.parseLong(getTextFieldIdCliente().getText()));
					else getTextFieldNomeCliente().setText("");	
				
			}
			
			
		});
		
		textFieldIdCliente.setBounds(30, 37, 70, 19);
			
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
		
		JButton btnPesqCli = new JButton("");
		btnPesqCli.setIcon(new ImageIcon(FrmVendas.class.getResource("/view/lupa.png")));
		btnPesqCli.addActionListener(e -> vendasController.abrirPesquisarCliente());
		btnPesqCli.setBounds(5, 37, 20, 19);
		panelCliente.add(btnPesqCli);
		
		JPanel panelItens = new JPanel();
		panelItens.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Adicionar \u00CDtem", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		panelItens.setBounds(12, 100, 557, 70);
		contentPane.add(panelItens);
		panelItens.setLayout(null);
		
		textFieldQtde = new JTextField();
		textFieldQtde.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldQtde.setText("1");
				textFieldQtde.selectAll();
			}
		});
		textFieldQtde.setText("1");
		textFieldQtde.setBounds(130, 37, 35, 19);
		panelItens.add(textFieldQtde);
		textFieldQtde.setColumns(10);
		
		JLabel lblCdigo = new JLabel("Código");
		lblCdigo.setBounds(30, 18, 50, 15);
		panelItens.add(lblCdigo);
		
		textFieldCodigoProduto = new JTextField();
		
		textFieldCodigoProduto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres="0987654321";// lista de caracters que devem ser aceitos
				if(!caracteres.contains(e.getKeyChar()+"")){// se o caracter que gerou o
				//evento estiver não estiver na lista
				e.consume();//aciona esse propriedade para eliminar a ação do evento
				} 
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					System.out.println("KeyPressed Enter");
					int qtde = 0;
					
					if (!getTextFieldQtde().getText().equals(""))
						qtde = Integer.parseInt(getTextFieldQtde().getText());
					else qtde = 1;
					
					if (!getTextFieldDescricao().getText().equals(""))
							vendasController.adicionarItem(Long.parseLong(getTextFieldCodigoProduto().getText()), qtde);
				}
			}
				
		});
		
		textFieldCodigoProduto.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent e) {
				if (!getTextFieldCodigoProduto().getText().equals(""))
					vendasController.buscarProduto(Long.parseLong(getTextFieldCodigoProduto().getText()));
					else getTextFieldDescricao().setText("");	
				
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				if (!getTextFieldCodigoProduto().getText().equals(""))
					vendasController.buscarProduto(Long.parseLong(getTextFieldCodigoProduto().getText()));
					else getTextFieldDescricao().setText("");	
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (!getTextFieldCodigoProduto().getText().equals(""))
					vendasController.buscarProduto(Long.parseLong(getTextFieldCodigoProduto().getText()));
					else getTextFieldDescricao().setText("");	
				
			}
			
			
		});
		
		textFieldQtde.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres="0987654321";// lista de caracters que devem ser aceitos
				if(!caracteres.contains(e.getKeyChar()+"")){// se o caracter que gerou o
				//evento estiver não estiver na lista
				e.consume();//aciona esse propriedade para eliminar a ação do evento
				} 
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					System.out.println("KeyPressed Enter");
					int qtde = 0;
					
					if (!getTextFieldQtde().getText().equals(""))
						qtde = Integer.parseInt(getTextFieldQtde().getText());
					else qtde = 1;
					
					if (!getTextFieldDescricao().getText().equals(""))
							vendasController.adicionarItem(Long.parseLong(getTextFieldCodigoProduto().getText()), qtde);
				}
			}
				
		});
		
		textFieldCodigoProduto.setBounds(30, 37, 70, 19);
		panelItens.add(textFieldCodigoProduto);
		textFieldCodigoProduto.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Qtde");
		lblQuantidade.setBounds(130, 18, 35, 15);
		panelItens.add(lblQuantidade);
		
		JButton btnPesqProd = new JButton("");
		btnPesqProd.setIcon(new ImageIcon(FrmVendas.class.getResource("/view/lupa.png")));
		btnPesqProd.addActionListener(e -> vendasController.abrirPesquisarProduto());
		
		btnPesqProd.setBounds(5, 37, 20, 19);
		panelItens.add(btnPesqProd);
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setEditable(false);
		textFieldDescricao.setBounds(180, 37, 370, 19);
		panelItens.add(textFieldDescricao);
		textFieldDescricao.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setBounds(180, 18, 70, 15);
		panelItens.add(lblDescricao);
		
		JLabel lblX = new JLabel("X");
		lblX.setBounds(110, 39, 10, 15);
		panelItens.add(lblX);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(247, 0, 70, 15);
		contentPane.add(lblStatus);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(437, 0, 70, 15);
		contentPane.add(lblData);
		
		JLabel lblIdVenda = new JLabel("Id Venda");
		lblIdVenda.setBounds(12, 0, 70, 15);
		contentPane.add(lblIdVenda);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(12, 340, 117, 25);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(139, 340, 117, 25);
		contentPane.add(btnCancelar);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(265, 340, 117, 25);
		contentPane.add(btnFinalizar);
	}
}
