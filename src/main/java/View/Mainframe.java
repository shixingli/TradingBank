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
	private JTextField textField;
	private JPasswordField passwordField;
	
	public Mainframe() {
		initialize();
	}

	private void initialize() {
		this.setBounds(450, 450, 1366, 768);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBounds(465, 147, 456, 486);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setOpaque(false);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(66, -16, 298, 233);
		panel.add(lblNewLabel_1);
//		lblNewLabel_1.setIcon(new ImageIcon(soft));
		
		textField = new JTextField();
		textField.setBounds(223, 240, 175, 37);
		panel.add(textField);
		textField.setColumns(10);
		 
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setForeground(new Color(0, 104, 189));
		lblNewLabel_2.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 30));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 215, 205, 74);
		panel.add(lblNewLabel_2);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(new Color(0, 104, 189));
		lblPassword.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 30));
		lblPassword.setBounds(6, 301, 205, 74);
		panel.add(lblPassword);
		
//		JButton btnNewButton = new JButton("Login");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btnNewButton.setForeground(new Color(0, 104, 189));
//		btnNewButton.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 30));
//		btnNewButton.setBounds(171, 409, 83, 37);
//		panel.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(223, 325, 175, 37);
		panel.add(passwordField);


		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 1366,768);
		getContentPane().add(lblNewLabel);
//		lblNewLabel.setIcon(new ImageIcon(img));
		

		

		
	}
}
