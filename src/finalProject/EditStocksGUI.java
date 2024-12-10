package finalProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditStocksGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtStockName;
	private JTextField txtStockSymbol;
	private JTextField txtStockPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditStocksGUI frame = new EditStocksGUI();
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
	public EditStocksGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList listStocks = new JList();
		listStocks.setBounds(56, 31, 311, 122);
		contentPane.add(listStocks);
		
		txtStockName = new JTextField();
		txtStockName.setBounds(28, 193, 130, 26);
		contentPane.add(txtStockName);
		txtStockName.setColumns(10);
		
		txtStockSymbol = new JTextField();
		txtStockSymbol.setBounds(170, 193, 130, 26);
		contentPane.add(txtStockSymbol);
		txtStockSymbol.setColumns(10);
		
		txtStockPrice = new JTextField();
		txtStockPrice.setBounds(314, 193, 130, 26);
		contentPane.add(txtStockPrice);
		txtStockPrice.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(66, 165, 61, 16);
		contentPane.add(lblName);
		
		JLabel lblSymbol = new JLabel("Symbol");
		lblSymbol.setBounds(196, 165, 61, 16);
		contentPane.add(lblSymbol);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(340, 165, 61, 16);
		contentPane.add(lblPrice);
		
		JButton btnAddStock = new JButton("Add Stock");
		btnAddStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//take the info from the text fields and use it to add a Stock to the db
				//reload the data for the JList
			}
		});
		btnAddStock.setBounds(180, 231, 117, 29);
		contentPane.add(btnAddStock);
		
		JButton btnDeleteStock = new JButton("Delete Stock");
		btnDeleteStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//remove the selected stock in the JList from the db
				//reload the data for the JList
			}
		});
		btnDeleteStock.setBounds(30, 226, 117, 29);
		contentPane.add(btnDeleteStock);
		
		JButton btnChangePrice = new JButton("Change Price");
		btnChangePrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//take the selected stock from the JList and change the price associated with it in the db
				//reload the JList data
			}
		});
		btnChangePrice.setBounds(324, 231, 117, 29);
		contentPane.add(btnChangePrice);
	}

}