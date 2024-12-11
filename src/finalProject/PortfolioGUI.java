package finalProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PortfolioGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtQuantity;
	private Customer customer;


	/**
	 * Create the frame.
	 */
	public PortfolioGUI(Customer customer) {
		this.customer = customer;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBalance = new JLabel(String.format("Balance: %.2f", customer.getBalance()));
		lblBalance.setBounds(103, 174, 130, 16);
		contentPane.add(lblBalance);
		
		JLabel lblPL = new JLabel("Profit/Loss");
		lblPL.setBounds(103, 202, 81, 16);
		contentPane.add(lblPL);
		
		String[] portfolio = customer.getPortfolio().toString().split(";");
		JList listPortfolio = new JList(portfolio);
		listPortfolio.setBounds(103, 36, 241, 126);
		contentPane.add(listPortfolio);
		//need to pull the Portfolio from Customer, and for each stock in it search the database for that stock and get its current price
		//if stock is not present, remove it from portfolio
		
		JButton btnSellStock = new JButton("Sell Stock");
		btnSellStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//take the selected stock, and have the Customer call the method it has for selling stocks
				//call updateList
			}
		});
		btnSellStock.setBounds(307, 225, 117, 29);
		contentPane.add(btnSellStock);
		
		txtQuantity = new JTextField();
		txtQuantity.setBounds(148, 225, 130, 26);
		contentPane.add(txtQuantity);
		txtQuantity.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(55, 230, 61, 16);
		contentPane.add(lblQuantity);
	}
}
