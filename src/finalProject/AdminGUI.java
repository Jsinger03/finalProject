package finalProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	/**
	 * Create the frame.
	 */
	public AdminGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEditStocks = new JButton("Edit Stocks");
		btnEditStocks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//render EditStocksGUI
				EditStocksGUI EditStocksGUI = new EditStocksGUI();
				EditStocksGUI.setVisible(true);
				dispose();
			}
		});
		btnEditStocks.setBounds(171, 46, 117, 29);
		contentPane.add(btnEditStocks);
		
		JButton btnGenerateUserTransactionReport = new JButton("Generate Transaction Report");
		btnGenerateUserTransactionReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String transactions = AuthManager.getUserTransactions(txtUsername.getText());
				AdminViewTransactionsGUI adminViewTransactionsGUI = new AdminViewTransactionsGUI(transactions);
				adminViewTransactionsGUI.setVisible(true);
				dispose();
			}
		});
		btnGenerateUserTransactionReport.setBounds(76, 207, 304, 29);
		contentPane.add(btnGenerateUserTransactionReport);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(171, 169, 130, 26);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(76, 174, 83, 16);
		contentPane.add(lblUsername);
	}

}
