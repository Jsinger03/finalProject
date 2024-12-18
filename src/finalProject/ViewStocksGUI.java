package finalProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

public class ViewStocksGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtSymbol;
	private JTextField txtQuantity;
	private Customer customer;
	private StocksManager stocksManager;
	/**
	 * Create the frame.
	 */
	public ViewStocksGUI(Customer customer) {
		this.customer=customer;
		this.stocksManager = new StocksManager();
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
		
		
		
		
		ArrayList<Stock> stocks = stocksManager.getStocks();
		String[] displayableStocks = new String[stocks.size()];
		for (int i = 0; i < stocks.size(); i++) {
			displayableStocks[i] = stocks.get(i).toString();
		}
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(26, 75, 399, 137);
        contentPane.add(scrollPane);

        JList listStocks = new JList(displayableStocks);
        scrollPane.setViewportView(listStocks);
		
		txtQuantity = new JTextField();
		txtQuantity.setBounds(94, 225, 130, 26);
		contentPane.add(txtQuantity);
		txtQuantity.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(36, 230, 61, 16);
		contentPane.add(lblQuantity);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Search stocks db and see if a stock matches the name or symbol given in those fields
				//if so, load that data into the JList
				//if not, do not modify the list
				//this needs to take name, and if name is blank take symbol
				String name = txtName.getText().trim();
                String symbol = txtSymbol.getText().trim();
                ArrayList<Stock> searchResults;

                if (!name.isEmpty()) {
                    //search by name
                    searchResults = stocksManager.searchStocks(name);
                } else if (!symbol.isEmpty()) {
                    //search by symbol
                    searchResults = stocksManager.searchStocks(symbol);
                } else {
                    //if both are blank, return the whole db of stocks
                    searchResults = stocksManager.getStocks();
                }

                String[] displayableStocks = new String[searchResults.size()];
                for (int i = 0; i < searchResults.size(); i++) {
                    displayableStocks[i] = searchResults.get(i).toString();
                }
                listStocks.setListData(displayableStocks);
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
				customer.buyStock(Stock.fromString(listStocks.getSelectedValue().toString()), Integer.parseInt(txtQuantity.getText()));
				dispose();
				CustomerGUI customerGUI = new CustomerGUI(customer);
				customerGUI.setVisible(true);
			}
		});
		btnBuyStock.setBounds(225, 225, 117, 29);
		contentPane.add(btnBuyStock);

		JButton btnAddToWatchlist = new JButton("Add to Watchlist");
		btnAddToWatchlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//take the stock selected from the list and add it to the customer's watchlist attribute
				customer.addToWatchlist(listStocks.getSelectedValue().toString());
				dispose();
				WatchlistGUI watchlistGUI = new WatchlistGUI(customer);
				watchlistGUI.setVisible(true);
			}
		});
		btnAddToWatchlist.setBounds(271, 42, 173, 29);
		contentPane.add(btnAddToWatchlist);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CustomerGUI customerGUI = new CustomerGUI(customer);
				customerGUI.setVisible(true);
			}
		});
		btnClose.setBounds(333, 224, 117, 29);
		contentPane.add(btnClose);
	}

}
