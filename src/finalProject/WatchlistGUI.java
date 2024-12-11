package finalProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class WatchlistGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Customer customer;



	/**
	 * Create the frame.
	 */
	public WatchlistGUI(Customer customer) {
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
		btnClose.setBounds(156, 21, 117, 29);
		contentPane.add(btnClose);
		String[] stocks = customer.getWatchlist().split(";");
        JList listWatchlist = new JList(stocks);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(33, 62, 368, 178);
        scrollPane.setViewportView(listWatchlist);
        contentPane.add(scrollPane);
		
		JLabel lblTitle = new JLabel("Watchlist");
		lblTitle.setBounds(33, 26, 87, 16);
		contentPane.add(lblTitle);
		
	}
}
