package finalProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class TransactionsGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblTransactions;
	private Customer customer;


	/**
	 * Create the frame.
	 */
	public TransactionsGUI(Customer customer) {
		this.customer = customer;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CustomerGUI customerGUI = new CustomerGUI(customer);
				customerGUI.setVisible(true);
			}
		});
		btnClose.setBounds(161, 225, 117, 29);
		contentPane.add(btnClose);
		
		String[] colNames = {"Buy/Sell", "Stock", "Quanity", "Date"};
		String[][] data = customer.getTransactions();
		DefaultTableModel model = new DefaultTableModel(data, colNames);
        tblTransactions = new JTable(model);

		JScrollPane scrollPane = new JScrollPane(tblTransactions);
        scrollPane.setBounds(27, 21, 389, 218);
        contentPane.add(scrollPane);
	}
}
