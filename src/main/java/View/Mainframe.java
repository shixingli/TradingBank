package View;


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
//	private Image bono = new ImageIcon(this.getClass().getResource("rect.png")).getImage();
	
	private JButton btnManagerLogin,register_btn,back_btn,login_btn,create_btn;
	private JTextField username_txt_dynamic;
	private JPasswordField passwordField_dynamic;
	private JTextField create_name;
	private JTextField create_pwd;
	private JTextField create_username;
	private JLabel lblDynamicLogin;
	private JPanel dynamic_login,create_acc_panel,main_panel,two_login_panel;
	private JButton customer_login_btn;
	private JButton back_create_panel;
	private boolean isCustomer = false;
	private JButton main_exit;
	private JLabel lblDate;

	public JTextField getTextField() {
		return textField;
	}

	private JTextField textField;
	private JButton btnEnter;

	public JButton getBtnEnter() {
		return btnEnter;
	}

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
		create_acc_panel.setOpaque(false);
		create_acc_panel.setVisible(false);

		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 20));
		lblName.setBounds(6, 59, 57, 27);
		create_acc_panel.add(lblName);
		
		JLabel lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 20));
		lblPassword_1.setBounds(6, 114, 110, 30);
		create_acc_panel.add(lblPassword_1);
		
		create_name = new JTextField();
		create_name.setBounds(128, 60, 130, 26);
		create_acc_panel.add(create_name);
		create_name.setColumns(10);
		
		create_pwd = new JTextField();
		create_pwd.setBounds(128, 118, 130, 26);
		create_acc_panel.add(create_pwd);
		create_pwd.setColumns(10);
		
		JLabel lblUsername_1 = new JLabel("Username:");
		lblUsername_1.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 20));
		lblUsername_1.setBounds(2, 18, 114, 29);
		create_acc_panel.add(lblUsername_1);
		
		create_username = new JTextField();
		create_username.setColumns(10);
		create_username.setBounds(128, 20, 130, 26);
		create_acc_panel.add(create_username);
		
		create_btn = new JButton("Create");
		create_btn.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 20));
		create_btn.setBounds(79, 167, 117, 29);
		create_acc_panel.add(create_btn);
		
		back_create_panel = new JButton("X");
		back_create_panel.setBounds(260, 6, 27, 29);
		create_acc_panel.add(back_create_panel);
		
		main_panel = new JPanel();
		main_panel.setBounds(290, 28, 752, 614);
		main_panel.setBackground(Color.WHITE);
		main_panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(main_panel);
		main_panel.setLayout(null);
		main_panel.setOpaque(false);
		
		dynamic_login = new JPanel();
		dynamic_login.setBounds(187, 288, 349, 320);
		main_panel.add(dynamic_login);
		dynamic_login.setLayout(null);
		dynamic_login.setVisible(false);
		dynamic_login.setOpaque(false);
		
		lblDynamicLogin = new JLabel("Dynamic Login");
		lblDynamicLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblDynamicLogin.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 20));
		lblDynamicLogin.setBounds(76, 6, 165, 26);
		lblDynamicLogin.setForeground(new Color(0, 104, 189));
		dynamic_login.add(lblDynamicLogin);
		
		JLabel dynamic_username_txt = new JLabel("Username:");
		dynamic_username_txt.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 20));
		dynamic_username_txt.setBounds(16, 74, 114, 26);
		dynamic_username_txt.setForeground(new Color(0, 104, 189));
		dynamic_login.add(dynamic_username_txt);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 20));
		lblPassword.setBounds(16, 140, 114, 26);
		lblPassword.setForeground(new Color(0, 104, 189));
		dynamic_login.add(lblPassword);
		
		username_txt_dynamic = new JTextField();
		username_txt_dynamic.setBounds(178, 75, 130, 26);
		dynamic_login.add(username_txt_dynamic);
		username_txt_dynamic.setColumns(10);
		
		login_btn = new JButton("Login");
		login_btn.setForeground(new Color(0, 104, 189));
		login_btn.setBounds(76, 199, 186, 74);
		dynamic_login.add(login_btn);
		
		passwordField_dynamic = new JPasswordField();
		passwordField_dynamic.setBounds(178, 141, 130, 26);
		dynamic_login.add(passwordField_dynamic);
		
		back_btn = new JButton("<");
		back_btn.setBounds(316, 0, 27, 29);
		back_btn.setForeground(new Color(0, 104, 189));
		dynamic_login.add(back_btn);
		
		two_login_panel = new JPanel();
		two_login_panel.setBounds(38, 353, 616, 123);
		main_panel.add(two_login_panel);
		two_login_panel.setLayout(null);
		two_login_panel.setOpaque(false);
		
//				lblNewLabel_1.setIcon(new ImageIcon(soft));

		customer_login_btn = new JButton("Customer Login");
		customer_login_btn.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 20));
		customer_login_btn.setBounds(0, 6, 255, 47);
		customer_login_btn.setForeground(new Color(0, 104, 189));
		two_login_panel.add(customer_login_btn);

		btnManagerLogin = new JButton("Manager Login");
		btnManagerLogin.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 20));
		btnManagerLogin.setBounds(355, 6, 255, 47);
		btnManagerLogin.setForeground(new Color(0, 104, 189));
		two_login_panel.add(btnManagerLogin);

		register_btn = new JButton("Register");
		register_btn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		register_btn.setForeground(new Color(0, 104, 189));
		register_btn.setBounds(226, 94, 151, 29);
		two_login_panel.add(register_btn);
		
		JLabel lblNewLabel_1 = new JLabel("");
//		lblNewLabel_1.setIcon(new ImageIcon(Mainframe.class.getResource("/img/soft.png")));
		lblNewLabel_1.setBounds(171, 55, 358, 246);
		main_panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel.setIcon(new ImageIcon(img));

		main_exit = new JButton("X");
		main_exit.setBounds(1333, 6, 27, 29);
		getContentPane().add(main_exit);
		
		btnEnter = new JButton("Enter");
		btnEnter.setBounds(694, 671, 117, 29);
		getContentPane().add(btnEnter);
		
		textField = new JTextField();
		textField.setBounds(552, 671, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		lblDate = new JLabel("Date:");
		lblDate.setBounds(497, 676, 61, 16);
		getContentPane().add(lblDate);
		
		
				
				JLabel lblNewLabel = new JLabel("New label");
//				lblNewLabel.setIcon(new ImageIcon(Mainframe.class.getResource("/img/blue.jpg")));
				lblNewLabel.setBounds(0, 0, 1366, 768);
				getContentPane().add(lblNewLabel);
		
		
		

		

		
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
		return register_btn;
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
		return create_btn;
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
	
	public boolean isCustomer() {
		return isCustomer;
	}

	public void setCustomer(boolean customer) {
		isCustomer = customer;
	}

	/**
	 * @return the back_create_panel
	 */
	public JButton getBack_create_panel() {
		return back_create_panel;
	}

	/**
	 * @return the main_exit
	 */
	public JButton getMain_exit() {
		return main_exit;
	}	
}
