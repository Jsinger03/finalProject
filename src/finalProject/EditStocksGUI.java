package finalProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EditStocksGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtStockName;
	private JTextField txtStockSymbol;
	private JTextField txtStockPrice;
	private StocksManager stocksmanager = new StocksManager();


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
		
		ArrayList<Stock> stocks = stocksmanager.getStocks();
        String[] displayableStocks = new String[stocks.size()];
        for (int i = 0; i < stocks.size(); i++) {
            displayableStocks[i] = stocks.get(i).toString();
        }
        JList listStocks = new JList(displayableStocks);

        JScrollPane scrollPane = new JScrollPane(listStocks);
        scrollPane.setBounds(6, 6, 399, 137);
        contentPane.add(scrollPane);
		
		txtStockName = new JTextField();
		txtStockName.setBounds(6, 193, 130, 26);
		contentPane.add(txtStockName);
		txtStockName.setColumns(10);
		
		txtStockSymbol = new JTextField();
		txtStockSymbol.setBounds(148, 193, 130, 26);
		contentPane.add(txtStockSymbol);
		txtStockSymbol.setColumns(10);
		
		txtStockPrice = new JTextField();
		txtStockPrice.setBounds(285, 193, 130, 26);
		contentPane.add(txtStockPrice);
		txtStockPrice.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(16, 165, 61, 16);
		contentPane.add(lblName);
		
		JLabel lblSymbol = new JLabel("Symbol");
		lblSymbol.setBounds(148, 165, 61, 16);
		contentPane.add(lblSymbol);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(291, 165, 61, 16);
		contentPane.add(lblPrice);
		
		JButton btnAddStock = new JButton("Add Stock (type)");
		btnAddStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//take the info from the text fields and use it to add a Stock to the db
				//reload the data for the JList
				stocksmanager.addStock(new Stock(txtStockName.getText(), txtStockSymbol.getText(), Double.parseDouble(txtStockPrice.getText())));
				ArrayList<Stock> stocks = stocksmanager.getStocks();
				String[] displayableStocks = new String[stocks.size()];
				for (int i = 0; i < stocks.size(); i++) {
					displayableStocks[i] = stocks.get(i).toString();
				}
				listStocks.setListData(displayableStocks);
			}
		});
		btnAddStock.setBounds(159, 226, 132, 29);
		contentPane.add(btnAddStock);
		
		JButton btnDeleteStock = new JButton("Delete Stock (Select)");
		btnDeleteStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//remove the selected stock in the JList from the db
				//reload the data for the JList
				stocksmanager.deleteStock(Stock.fromString(listStocks.getSelectedValue().toString()));
				ArrayList<Stock> stocks = stocksmanager.getStocks();
				String[] displayableStocks = new String[stocks.size()];
				for (int i = 0; i < stocks.size(); i++) {
					displayableStocks[i] = stocks.get(i).toString();
				}
				listStocks.setListData(displayableStocks);
			}
		});
		btnDeleteStock.setBounds(0, 226, 162, 29);
		contentPane.add(btnDeleteStock);
		
		JButton btnChangePrice = new JButton("Change Price (type)");
		btnChangePrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//take the selected stock from the JList and change the price associated with it in the db
				//reload the JList data
				stocksmanager.changePrice(Stock.fromString(listStocks.getSelectedValue().toString()), Double.parseDouble(txtStockPrice.getText()));
				ArrayList<Stock> stocks = stocksmanager.getStocks();
				String[] displayableStocks = new String[stocks.size()];
				for (int i = 0; i < stocks.size(); i++) {
					displayableStocks[i] = stocks.get(i).toString();
				}
				listStocks.setListData(displayableStocks);
			}
		});
		btnChangePrice.setBounds(285, 226, 153, 29);
		contentPane.add(btnChangePrice);
		
		JButton btn = new JButton("Close");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminGUI adminGUI = new AdminGUI();
				adminGUI.setVisible(true);
			}
		});
		btn.setBounds(343, 154, 107, 27);
		contentPane.add(btn);
	}

}
