package finalProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;

public class RegisterGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;


	/**
	 * Create the frame.
	 */
	public RegisterGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(87, 53, 84, 16);
		contentPane.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(206, 48, 130, 26);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(206, 106, 130, 26);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(87, 111, 61, 16);
		contentPane.add(lblPassword);
		
		JRadioButton rdbtnIsAdmin = new JRadioButton("Admin");
		rdbtnIsAdmin.setBounds(87, 159, 141, 23);
		contentPane.add(rdbtnIsAdmin);

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AuthManager.register(txtUsername.getText(), txtPassword.getText(), rdbtnIsAdmin.isSelected() ? 1 : 0);//1 for admin, 0 for customer
				dispose();
			}
		});
		btnRegister.setBounds(157, 212, 117, 29);
		contentPane.add(btnRegister);
	}
}
