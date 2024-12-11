package finalProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class AdminViewTransactionsGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblTransactions;




	/**
	 * Create the frame.
	 */
	public AdminViewTransactionsGUI(String transactions) {
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
				AdminGUI adminGUI = new AdminGUI();
				adminGUI.setVisible(true);
			}
		});
		btnClose.setBounds(161, 225, 117, 29);
		contentPane.add(btnClose);
		
		String[] colNames = {"Buy/Sell", "Stock", "Quanity", "Date"};
		String[][] data = getTransactions(transactions);
		DefaultTableModel model = new DefaultTableModel(data, colNames);
        tblTransactions = new JTable(model);

		tblTransactions.getColumnModel().getColumn(0).setPreferredWidth(50);  //transaction type
		tblTransactions.getColumnModel().getColumn(1).setPreferredWidth(175); //Stock
		tblTransactions.getColumnModel().getColumn(2).setPreferredWidth(25);  //Quantity
		tblTransactions.getColumnModel().getColumn(3).setPreferredWidth(100); //Date

		JScrollPane scrollPane = new JScrollPane(tblTransactions);
        scrollPane.setBounds(27, 21, 389, 218);
        contentPane.add(scrollPane);
	}
	public String[][] getTransactions(String transactions) {
    if (transactions == null) {
        System.err.println("Transactions data is null.");
        return new String[0][0];
    }
    String[] entries = transactions.split(";");
    String[][] data = new String[entries.length][4];
    for (int i = 0; i < entries.length; i++) {
        if (!entries[i].trim().isEmpty()) {
            String[] fields = entries[i].split("`");
            if (fields.length >= 4) {
                data[i][0] = fields[3]; //Type (buy/sell)
                data[i][1] = fields[0]; //Stock
                data[i][2] = fields[1]; //Quantity
                data[i][3] = fields[2]; //Date
            } else {
                System.err.println("Invalid transaction format: " + entries[i]);
            }
        }
    }
    return data;
}

}
