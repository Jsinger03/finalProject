package finalProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewStocksGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtSymbol;
	private JTextField txtQuantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStocksGUI frame = new ViewStocksGUI();
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
	public ViewStocksGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(144, 14, 130, 26);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblSearchForName = new JLabel("Stock Name");
		lblSearchForName.setBounds(26, 19, 96, 16);
		contentPane.add(lblSearchForName);
		
		JLabel lblSymbol = new JLabel("Stock Symbol");
		lblSymbol.setBounds(26, 47, 117, 16);
		contentPane.add(lblSymbol);
		
		txtSymbol = new JTextField();
		txtSymbol.setBounds(144, 42, 130, 26);
		contentPane.add(txtSymbol);
		txtSymbol.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Search stocks db and see if a stock matches the name or symbol given in those fields
				//if so, load that data into the JList
				//if not, do not modify the list
			}
		});
		btnSearch.setBounds(293, 14, 117, 29);
		contentPane.add(btnSearch);
		
		JButton btnBuyStock = new JButton("Buy Stock");
		btnBuyStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//take selected stock from list, and quantity from text field
				//have customer buy the stock, using its own function to check if it has enough balance
				//return to the CustomerGUI
			}
		});
		btnBuyStock.setBounds(308, 225, 117, 29);
		contentPane.add(btnBuyStock);
		
		JList listStocks = new JList();
		listStocks.setBounds(26, 75, 399, 137);
		contentPane.add(listStocks);
		
		JButton btnAddToWatchlist = new JButton("Add to Watchlist");
		btnAddToWatchlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//take the stock selected from the list and add it to the customer's watchlist attribute
			}
		});
		btnAddToWatchlist.setBounds(271, 42, 173, 29);
		contentPane.add(btnAddToWatchlist);
		
		txtQuantity = new JTextField();
		txtQuantity.setBounds(144, 225, 130, 26);
		contentPane.add(txtQuantity);
		txtQuantity.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(36, 230, 61, 16);
		contentPane.add(lblQuantity);
	}

}
