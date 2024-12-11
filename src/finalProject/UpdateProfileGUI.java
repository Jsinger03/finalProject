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

public class UpdateProfileGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtChangeTo;
	private Customer customer;

	/**
	 * Create the frame.
	 */
	public UpdateProfileGUI(Customer customer) {
		this.customer= customer;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnChangeUsername = new JButton("Change Username");
		btnChangeUsername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//set Customer's db to newUsername.txt
				//update Customer's username in users.txt
				AuthManager.updateUsername(customer, txtChangeTo.getText());
				customer.setUsername(txtChangeTo.getText());
				dispose();
				CustomerGUI customerGUI = new CustomerGUI(customer);
				customerGUI.setVisible(true);
			}
		});
		btnChangeUsername.setBounds(71, 163, 149, 29);
		contentPane.add(btnChangeUsername);
		
		JButton btnChangePwd = new JButton("Change Password");
		btnChangePwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//update customer's password in users.txt
				AuthManager.updatePassword(customer, txtChangeTo.getText());
				customer.setPassword(txtChangeTo.getText());
				dispose();
				CustomerGUI customerGUI = new CustomerGUI(customer);
				customerGUI.setVisible(true);
			}
		});
		btnChangePwd.setBounds(272, 163, 149, 29);
		contentPane.add(btnChangePwd);
		
		txtChangeTo = new JTextField();
		txtChangeTo.setBounds(171, 94, 130, 26);
		contentPane.add(txtChangeTo);
		txtChangeTo.setColumns(10);
		
		JLabel lblChangeTo = new JLabel("Change to: ");
		lblChangeTo.setBounds(72, 99, 99, 16);
		contentPane.add(lblChangeTo);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CustomerGUI customerGUI = new CustomerGUI(customer);
				customerGUI.setVisible(true);
			}
		});
		btnClose.setBounds(173, 220, 117, 29);
		contentPane.add(btnClose);
	}

}
