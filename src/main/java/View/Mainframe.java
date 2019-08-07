
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;

public class Mainframe extends JFrame{
//	private Image img = new ImageIcon(this.getClass().getResource("/blue.jpg")).getImage();
//	private Image icon = new ImageIcon(this.getClass().getResource("/Login.jpeg")).getImage();
//	private Image soft = new ImageIcon(this.getClass().getResource("/soft.png")).getImage();
//	private Image couple = new ImageIcon(this.getClass().getResource("couple.png")).getImage();
//	private Image login = new ImageIcon(this.getClass().getResource("lock.png")).getImage();
	private JButton customer_login_btn,btnManagerLogin,create_acc_btn,back_btn,login_btn,btnCreate_init;
	private JTextField username_txt_dynamic;
	private JPasswordField passwordField_dynamic;
	private JTextField create_name;
	private JTextField create_pwd;
	private JTextField create_username;
	private JLabel lblDynamicLogin;
	private JPanel dynamic_login,create_acc_panel,main_panel,two_login_panel;
	
	public Mainframe() {
		initialize();
	}

	private void initialize() {
		this.setBounds(450, 450, 1366, 768);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		create_acc_panel = new JPanel();
		create_acc_panel.setBounds(998, 366, 293, 276);
		getContentPane().add(create_acc_panel);
		create_acc_panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(6, 59, 57, 27);
		create_acc_panel.add(lblName);
		
		JLabel lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setBounds(6, 114, 83, 33);
		create_acc_panel.add(lblPassword_1);
		
		create_name = new JTextField();
		create_name.setBounds(102, 59, 130, 26);
		create_acc_panel.add(create_name);
		create_name.setColumns(10);
		
		create_pwd = new JTextField();
		create_pwd.setBounds(101, 117, 130, 26);
		create_acc_panel.add(create_pwd);
		create_pwd.setColumns(10);
		
		JLabel lblUsername_1 = new JLabel("Username:");
		lblUsername_1.setBounds(2, 18, 87, 29);
		create_acc_panel.add(lblUsername_1);
		
		create_username = new JTextField();
		create_username.setColumns(10);
		create_username.setBounds(102, 21, 130, 26);
		create_acc_panel.add(create_username);
		
		btnCreate_init = new JButton("Create");
		btnCreate_init.setBounds(83, 205, 117, 29);
		create_acc_panel.add(btnCreate_init);
		
		main_panel = new JPanel();
		main_panel.setBounds(289, 28, 754, 614);
		main_panel.setBackground(Color.WHITE);
		main_panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(main_panel);
		main_panel.setLayout(null);
		main_panel.setOpaque(false);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(167, 21, 358, 246);
		main_panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		two_login_panel = new JPanel();
		two_login_panel.setBounds(38, 353, 616, 123);
		main_panel.add(two_login_panel);
		two_login_panel.setLayout(null);
		//		lblNewLabel_1.setIcon(new ImageIcon(soft));
				
				customer_login_btn = new JButton("Customer Login");
				customer_login_btn.setBounds(17, 6, 255, 87);
				two_login_panel.add(customer_login_btn);
				
				btnManagerLogin = new JButton("Manager Login");
				btnManagerLogin.setBounds(355, 6, 255, 87);
				two_login_panel.add(btnManagerLogin);
				
				create_acc_btn = new JButton("Create An Account");
				create_acc_btn.setBounds(246, 94, 151, 29);
				two_login_panel.add(create_acc_btn);
		
		dynamic_login = new JPanel();
		dynamic_login.setBounds(215, 295, 272, 267);
		main_panel.add(dynamic_login);
		dynamic_login.setLayout(null);
		
		lblDynamicLogin = new JLabel("Dynamic Login");
		lblDynamicLogin.setBounds(89, 5, 94, 16);
		dynamic_login.add(lblDynamicLogin);
		
		JLabel dynamic_username_txt = new JLabel("Username:");
		dynamic_username_txt.setBounds(27, 80, 61, 16);
		dynamic_login.add(dynamic_username_txt);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(27, 146, 61, 16);
		dynamic_login.add(lblPassword);
		
		username_txt_dynamic = new JTextField();
		username_txt_dynamic.setBounds(111, 75, 130, 26);
		dynamic_login.add(username_txt_dynamic);
		username_txt_dynamic.setColumns(10);
		
		login_btn = new JButton("Login");
		login_btn.setBounds(76, 199, 117, 29);
		dynamic_login.add(login_btn);
		
		passwordField_dynamic = new JPasswordField();
		passwordField_dynamic.setBounds(111, 141, 130, 26);
		dynamic_login.add(passwordField_dynamic);
		
		back_btn = new JButton("<");
		back_btn.setBounds(125, 232, 27, 29);
		dynamic_login.add(back_btn);


		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 1366, 768);
		getContentPane().add(lblNewLabel);
//		lblNewLabel.setIcon(new ImageIcon(img));
		

		

		
	}

	/**
	 * @return the customer_login_btn
	 */
	public JButton getCustomer_login_btn() {
		return customer_login_btn;
	}

	/**
	 * @return the btnManagerLogin
	 */
	public JButton getBtnManagerLogin() {
		return btnManagerLogin;
	}

	/**
	 * @return the create_acc_btn
	 */
	public JButton getCreate_acc_btn() {
		return create_acc_btn;
	}

	/**
	 * @return the back_btn
	 */
	public JButton getBack_btn() {
		return back_btn;
	}

	/**
	 * @return the login_btn
	 */
	public JButton getLogin_btn() {
		return login_btn;
	}

	/**
	 * @return the btnCreate_init
	 */
	public JButton getBtnCreate_init() {
		return btnCreate_init;
	}

	/**
	 * @return the username_txt_dynamic
	 */
	public JTextField getUsername_txt_dynamic() {
		return username_txt_dynamic;
	}

	/**
	 * @return the passwordField_dynamic
	 */
	public JPasswordField getPasswordField_dynamic() {
		return passwordField_dynamic;
	}

	/**
	 * @return the create_name
	 */
	public JTextField getCreate_name() {
		return create_name;
	}

	/**
	 * @return the create_pwd
	 */
	public JTextField getCreate_pwd() {
		return create_pwd;
	}

	/**
	 * @return the create_username
	 */
	public JTextField getCreate_username() {
		return create_username;
	}

	/**
	 * @return the lblDynamicLogin
	 */
	public JLabel getLblDynamicLogin() {
		return lblDynamicLogin;
	}

	/**
	 * @return the dynamic_login
	 */
	public JPanel getDynamic_login() {
		return dynamic_login;
	}

	/**
	 * @return the create_acc_panel
	 */
	public JPanel getCreate_acc_panel() {
		return create_acc_panel;
	}

	/**
	 * @return the main_panel
	 */
	public JPanel getMain_panel() {
		return main_panel;
	}

	/**
	 * @return the two_login_panel
	 */
	public JPanel getTwo_login_panel() {
		return two_login_panel;
	}
}
