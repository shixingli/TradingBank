package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.Reader;
import javax.swing.JTextArea;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ManagerFrame extends JFrame{
	
	private JLabel lblStocks;
	private JPanel panel;
	private ButtonGroup group_two;
	private JRadioButton stock_radio_btn,Bond_radio_btn;
	private JPanel panel_2;
	private JButton back_botton,info_Generate;
	private JList bond_lst,left_1;
	private JComboBox customer_combo,account_combo;
	private JTextArea textarea;
	private JButton btnUpdate;
	private JTextField update_txtfield;
	private JLabel lblNewLabel;
	
	public ManagerFrame() {
		getContentPane().setBackground(Color.WHITE);
		initialize();
	}
	
	private void initialize() {
//		Reader myreader = new Reader();
//		String[][] grid = myreader.readDataFromCustomSeperator();
		
		this.setBounds(0, 0, 1366, 768);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1366, 60);
		getContentPane().add(panel);
		panel.setBackground(new Color(0, 104, 189));
		panel.setLayout(null);
		
		lblStocks = new JLabel("Manager");
		lblStocks.setBounds(6, 6, 140, 48);		
		lblStocks.setForeground(Color.WHITE);
		lblStocks.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 30));
		panel.add(lblStocks);
		
		back_botton = new JButton("X");
		back_botton.setBackground(Color.RED);
		back_botton.setForeground(Color.WHITE);
		back_botton.setBounds(1315, 21, 33, 29);
		panel.add(back_botton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(148, 170, 482, 543);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		DefaultListModel model2 = new DefaultListModel();
		model2.addElement("07 Day Bond  FV:6500  IR:1%");
		model2.addElement("30 Day Bond  FV:8500  IR:7%");
		model2.addElement("90 Day Bond  FV:16500 IR:10%");


		bond_lst = new JList(model2);
		bond_lst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bond_lst.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 30));
		bond_lst.setForeground(new Color(0, 104, 189));
		bond_lst.setVisibleRowCount(3);
		bond_lst.setBounds(17, 20, 459, 235);
		bond_lst.setVisible(false);

		panel_1.add(bond_lst);
		

		
		DefaultListModel model = new DefaultListModel();
		
//		for (int i=0; i<10; i++) {
//			model.addElement(grid[i][0]);
//		}
		
		left_1 = new JList();
		left_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		left_1.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 30));
		left_1.setForeground(new Color(0, 104, 189));
		left_1.setVisibleRowCount(11);
		left_1.setBounds(17, 20, 234, 464);
		left_1.setVisible(false);
		panel_1.add(left_1);
		
		DefaultListModel model1 = new DefaultListModel();
		
//		for (int i=0; i<10; i++) {
//			model1.addElement(grid[i][1]);
//		}
		DefaultListModel model4 = new DefaultListModel();
		
//		for (int i=0; i<10; i++) {
//			model4.addElement(grid[i][2]);
//		}

		group_two = new ButtonGroup();
		
		stock_radio_btn = new JRadioButton("Stock");
		stock_radio_btn.setForeground(new Color(0, 104, 189));
		stock_radio_btn.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 30));
//		stock_radio_btn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("stock selected!");
//				bond_lst.setVisible(false);
//
//				left_2.setVisible(true);left_1.setVisible(true);
//			}
//		});
		stock_radio_btn.setBounds(257, 116, 141, 41);
		getContentPane().add(stock_radio_btn);
		
		Bond_radio_btn = new JRadioButton("Bond");
		Bond_radio_btn.setForeground(new Color(0, 104, 189));
		Bond_radio_btn.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 30));
//		Bond_radio_btn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				left_2.setVisible(false);left_1.setVisible(false);
//				bond_lst.setVisible(true);
//			}
//		});
		Bond_radio_btn.setBounds(419, 116, 141, 42);
		getContentPane().add(Bond_radio_btn);
		
		group_two.add(Bond_radio_btn);group_two.add(stock_radio_btn);
		
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setForeground(Color.BLACK);
		panel_2.setBounds(736, 170, 513, 543);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		customer_combo = new JComboBox();
		customer_combo.setBounds(23, 27, 211, 34);
		panel_2.add(customer_combo);
		
		account_combo = new JComboBox();
		account_combo.setBounds(23, 217, 211, 34);
		panel_2.add(account_combo);
		
		info_Generate = new JButton("Generate");
		info_Generate.setForeground(new Color(0, 104, 189));
		info_Generate.setBounds(35, 408, 199, 29);
		panel_2.add(info_Generate);
		
		textarea = new JTextArea();
		textarea.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 20));
		textarea.setBounds(253, 116, 242, 302);
		panel_2.add(textarea);

		btnUpdate = new JButton("Update");

		btnUpdate.setForeground(new Color(0, 104, 189));
		btnUpdate.setBounds(265, 508, 142, 29);
		panel_1.add(btnUpdate);
		
		update_txtfield = new JTextField();
		update_txtfield.setBounds(83, 508, 130, 26);
		panel_1.add(update_txtfield);
		update_txtfield.setColumns(10);
		
		lblNewLabel = new JLabel("Report");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNewLabel.setBounds(900, 119, 177, 33);
		getContentPane().add(lblNewLabel);
		
	}

	/**
	 * @return the lblStocks
	 */
	public JLabel getLblStocks() {
		return lblStocks;
	}

	/**
	 * @return the panel
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * @return the group_two
	 */
	public ButtonGroup getGroup_two() {
		return group_two;
	}

	/**
	 * @return the stock_radio_btn
	 */
	public JRadioButton getStock_radio_btn() {
		return stock_radio_btn;
	}

	/**
	 * @return the bond_radio_btn
	 */
	public JRadioButton getBond_radio_btn() {
		return Bond_radio_btn;
	}

	/**
	 * @return the panel_2
	 */
	public JPanel getPanel_2() {
		return panel_2;
	}

	/**
	 * @return the back_botton
	 */
	public JButton getBack_botton() {
		return back_botton;
	}

	/**
	 * @return the info_Generate
	 */
	public JButton getInfo_Generate() {
		return info_Generate;
	}

	/**
	 * @return the bond_lst
	 */
	public JList getBond_lst() {
		return bond_lst;
	}

//	/**
//	 * @return the left_2
//	 */
//	public JList getLeft_2() {
//		return left_2;
//	}

	/**
	 * @return the left_1
	 */
	public JList getLeft_1() {
		return left_1;
	}

	/**
	 * @return the customer_combo
	 */
	public JComboBox getCustomer_combo() {
		return customer_combo;
	}

	/**
	 * @return the account_combo
	 */
	public JComboBox getAccount_combo() {
		return account_combo;
	}

	/**
	 * @return the textarea
	 */
	public JTextArea getTextarea() {
		return textarea;
	}

	/**
	 * @return the btnUpdate
	 */
	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	/**
	 * @return the update_txtfield
	 */
	public JTextField getUpdate_txtfield() {
		return update_txtfield;
	}

	/**
	 * @return the lblNewLabel
	 */
	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}
}
