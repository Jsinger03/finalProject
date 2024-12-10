package finalProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public CustomerGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setBounds(39, 203, 117, 29);
		contentPane.add(btnDeposit);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setBounds(271, 203, 117, 29);
		contentPane.add(btnWithdraw);
		
		JButton btnViewPortfolio = new JButton("View Portfolio");
		btnViewPortfolio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnViewPortfolio.setBounds(39, 129, 117, 29);
		contentPane.add(btnViewPortfolio);
		
		JButton btnViewTransactions = new JButton("View Transactions");
		btnViewTransactions.setBounds(39, 67, 178, 29);
		contentPane.add(btnViewTransactions);
		
		JButton btnUpdateProfile = new JButton("Update Profile");
		btnUpdateProfile.setBounds(271, 67, 117, 29);
		contentPane.add(btnUpdateProfile);
		
		JButton btnViewStocks = new JButton("View Stocks");
		btnViewStocks.setBounds(250, 129, 117, 29);
		contentPane.add(btnViewStocks);
	}
}
