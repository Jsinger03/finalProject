package finalProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.JTable;

public class TransactionsGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblTransactions;


	/**
	 * Create the frame.
	 */
	public TransactionsGUI(String[][] data) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] colNames = {"Buy/Sell", "Stock", "Quanity", "Price"};
		tblTransactions = new JTable(data, colNames);
		tblTransactions.setBounds(27, 21, 389, 218);
		contentPane.add(tblTransactions);
	}
}
