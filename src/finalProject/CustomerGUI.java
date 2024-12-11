package finalProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class CustomerGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDepositAmount;
	private JTextField txtWithdrawAmount;
	private Customer customer;


	/**
	 * Create the frame.
	 */
	public CustomerGUI(User user) {
		customer = Customer.fromString(user.getId(), user.getUsername(), user.getPassword());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//take the quantity in txtDepositAmount and add it to Customer's balance
				double amt = Double.parseDouble(txtDepositAmount.getText());
				customer.deposit(amt);
			}
		});
		btnDeposit.setBounds(281, 178, 117, 29);
		contentPane.add(btnDeposit);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//take quantity in txtWithdrawAmount and remove it from Customer's balance
				double amt = Double.parseDouble(txtWithdrawAmount.getText());
				customer.withdraw(amt);
			}
		});
		btnWithdraw.setBounds(281, 219, 117, 29);
		contentPane.add(btnWithdraw);
		
		JButton btnViewPortfolio = new JButton("View Portfolio");
		btnViewPortfolio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//render PortfolioGUI
				PortfolioGUI portfolioGUI = new PortfolioGUI(customer);
				portfolioGUI.setVisible(true);
				dispose();
			}
		});
		btnViewPortfolio.setBounds(34, 70, 117, 29);
		contentPane.add(btnViewPortfolio);
		
		JButton btnViewTransactions = new JButton("View Transactions");
		btnViewTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//render TransactionsGUI
			}
		});
		btnViewTransactions.setBounds(24, 29, 178, 29);
		contentPane.add(btnViewTransactions);
		
		JButton btnUpdateProfile = new JButton("Update Profile");
		btnUpdateProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//render UpdateProfileGUI
			}
		});
		btnUpdateProfile.setBounds(300, 29, 117, 29);
		contentPane.add(btnUpdateProfile);
		
		JButton btnViewStocks = new JButton("View Stocks");
		btnViewStocks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//render ViewStocksGUI
				ViewStocksGUI viewStocksGUI = new ViewStocksGUI(customer);
				viewStocksGUI.setVisible(true);
				dispose();
			}
		});
		btnViewStocks.setBounds(281, 70, 117, 29);
		contentPane.add(btnViewStocks);
		
		txtDepositAmount = new JTextField();
		txtDepositAmount.setBounds(125, 178, 130, 26);
		contentPane.add(txtDepositAmount);
		txtDepositAmount.setColumns(10);
		
		txtWithdrawAmount = new JTextField();
		txtWithdrawAmount.setBounds(125, 219, 130, 26);
		contentPane.add(txtWithdrawAmount);
		txtWithdrawAmount.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(156, 154, 61, 16);
		contentPane.add(lblAmount);
	}
}
