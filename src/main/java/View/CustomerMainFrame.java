package View;
import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class CustomerMainFrame extends JFrame{
	private JLabel lblStocks,SavingAcc,transfer_lbl;
	private JPanel panel;
	private JTextArea account_info;
	private JComboBox comboBox,bottom_combobox;
	private JButton btnStock,btnMybonds,OKButton;
	private JPanel bottom_panel,top_panel,bottom_inner_panel;
	private JRadioButton depositRadioButton,withdrawRadioButton,transferRadioButton;
	private JTextField amount_money_txtfiled;
	private ButtonGroup group;
	
	
	public CustomerMainFrame(){
		getContentPane().setBackground(Color.WHITE);
		initialize();
	}
	
	
	private void initialize(){
		String[] option = {"                             Savings",
				"                             Checking",
				"                             Security"};
		String[] option1 = {"Savings", "Checking","Security"};
		this.setBounds(0, 0, 1366, 768);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1366, 60);
		getContentPane().add(panel);
		panel.setBackground(new Color(0, 104, 189));
		panel.setLayout(null);
		
		lblStocks = new JLabel("WeLcome");
		lblStocks.setBounds(6, 6, 140, 48);		
		lblStocks.setForeground(Color.WHITE);
		lblStocks.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 30));
		panel.add(lblStocks);
		
		top_panel = new JPanel();
		top_panel.setBounds(160, 89, 1012, 278);
		getContentPane().add(top_panel);
		top_panel.setLayout(null);
		

		comboBox = new JComboBox(option);
		comboBox.setMaximumRowCount(3);
		comboBox.setBounds(559, 49, 322, 27);
		top_panel.add(comboBox);
		
		btnStock = new JButton("iStock");
		btnStock.setBounds(559, 183, 322, 29);
		top_panel.add(btnStock);
		
		btnMybonds = new JButton("iBond");
		btnMybonds.setBounds(559, 224, 322, 29);
		top_panel.add(btnMybonds);
		
		account_info = new JTextArea();
		account_info.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		account_info.setEnabled(false);
		account_info.setBounds(94, 53, 409, 219);
		top_panel.add(account_info);
		
		bottom_panel = new JPanel();
		bottom_panel.setBounds(400, 379, 566, 336);
		getContentPane().add(bottom_panel);
		bottom_panel.setLayout(null);
		
		
		
		group = new ButtonGroup();
		
		
		depositRadioButton = new JRadioButton("Deposit");
		depositRadioButton.setHorizontalAlignment(SwingConstants.LEFT);
		depositRadioButton.setBounds(27, 18, 141, 23);
		bottom_panel.add(depositRadioButton);
		
		withdrawRadioButton = new JRadioButton("WithDraw");
		withdrawRadioButton.setBounds(209, 18, 141, 23);
		bottom_panel.add(withdrawRadioButton);
		
		transferRadioButton = new JRadioButton("Transfer");
		transferRadioButton.setBounds(406, 18, 141, 23);
		bottom_panel.add(transferRadioButton);
		
		group.add(depositRadioButton);
		group.add(withdrawRadioButton);
		group.add(transferRadioButton);
		
		amount_money_txtfiled = new JTextField();
		amount_money_txtfiled.setBounds(220, 161, 130, 26);
		bottom_panel.add(amount_money_txtfiled);
		amount_money_txtfiled.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(147, 166, 61, 16);
		bottom_panel.add(lblAmount);
		
		OKButton = new JButton("Ok");
		OKButton.setBounds(209, 218, 117, 29);
		bottom_panel.add(OKButton);
		
		bottom_inner_panel = new JPanel();
		bottom_inner_panel.setBounds(131, 99, 239, 50);
		bottom_panel.add(bottom_inner_panel);
		bottom_inner_panel.setLayout(null);
		
		transfer_lbl = new JLabel("Transfer to:");
		transfer_lbl.setBounds(6, 17, 73, 16);
		bottom_inner_panel.add(transfer_lbl);
		
		bottom_combobox = new JComboBox(option1);
		bottom_combobox.setBounds(91, 13, 124, 27);
		bottom_inner_panel.add(bottom_combobox);
		
		
		DefaultListModel model = new DefaultListModel();
//		txtNumberOfShare.setColumns(10);
//        File text = new File("/Users/jasonlee/Desktop/Stock.txt");
//        Scanner scnr = new Scanner(text);
//        int lineNumber = 0;
//        while(scnr.hasNextLine()){
//            String line = scnr.nextLine();
//			model.add(lineNumber, line);
////            System.out.println("line " + lineNumber + " :" + line);
//            lineNumber++;
//        } 

//		
//		for (int i=0;i<stock.length; i++) {
//			model.add(i, stock[i]);
//		}




		
	}


	/**
	 * @return the lblStocks
	 */
	public JLabel getLblStocks() {
		return lblStocks;
	}


	/**
	 * @return the savingAcc
	 */
	public JLabel getSavingAcc() {
		return SavingAcc;
	}


	/**
	 * @return the panel
	 */
	public JPanel getPanel() {
		return panel;
	}


	/**
	 * @return the account_info
	 */
	public JTextArea getAccount_info() {
		return account_info;
	}


	/**
	 * @return the comboBox
	 */
	public JComboBox getComboBox() {
		return comboBox;
	}


	/**
	 * @return the bottom_combobox
	 */
	public JComboBox getBottom_combobox() {
		return bottom_combobox;
	}


	/**
	 * @return the btnStock
	 */
	public JButton getBtnStock() {
		return btnStock;
	}


	/**
	 * @return the btnMybonds
	 */
	public JButton getBtnMybonds() {
		return btnMybonds;
	}


	/**
	 * @return the oKButton
	 */
	public JButton getOKButton() {
		return OKButton;
	}


	/**
	 * @return the bottom_panel
	 */
	public JPanel getBottom_panel() {
		return bottom_panel;
	}


	/**
	 * @return the top_panel
	 */
	public JPanel getTop_panel() {
		return top_panel;
	}


	/**
	 * @return the bottom_inner_panel
	 */
	public JPanel getBottom_inner_panel() {
		return bottom_inner_panel;
	}


	/**
	 * @return the depositRadioButton
	 */
	public JRadioButton getDepositRadioButton() {
		return depositRadioButton;
	}


	/**
	 * @return the withdrawRadioButton
	 */
	public JRadioButton getWithdrawRadioButton() {
		return withdrawRadioButton;
	}


	/**
	 * @return the transferRadioButton
	 */
	public JRadioButton getTransferRadioButton() {
		return transferRadioButton;
	}


	/**
	 * @return the amount_money_txtfiled
	 */
	public JTextField getAmount_money_txtfiled() {
		return amount_money_txtfiled;
	}


	/**
	 * @return the group
	 */
	public ButtonGroup getGroup() {
		return group;
	}
}
