package View;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class CustomerStockFrame extends JFrame{
	
	private String[] stock = {"AAPL193.34","GOOG","YHOO","NASDAQ","NKE"};
	private JTextField txtNumberOfShare_buy;
	private JTextField txtNumberOfShare_sell;
	private JLabel lblStocks;
	private JButton Customer_buy_botton, Customer_sell_botton;
	



	private JLabel lblNumberOfShare;
	private JPanel sell_panel,buy_panel;
	private JList customer_brought_stock_list;
	
	public CustomerStockFrame()  {
		getContentPane().setBackground(Color.WHITE);
		initialize();
	}
	
	
	private void initialize()  {
		String[] option1 = {"Savings", "Checking","Security"};

		this.setBounds(0, 0, 1366, 768);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1366, 60);
		getContentPane().add(panel);
		panel.setBackground(new Color(0, 104, 189));
		panel.setLayout(null);
		
		JLabel lblStocks = new JLabel("Stocks");
		lblStocks.setBounds(6, 6, 140, 48);		
		lblStocks.setForeground(Color.WHITE);
		lblStocks.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 30));
		panel.add(lblStocks);
		
		DefaultListModel model = new DefaultListModel();
	    JList list = new JList(model);
	    list.setForeground(Color.WHITE);
	    list.setBackground(new Color(0, 104, 189));
	    list.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 25));
		list.setBounds(841, 143, 484, 551);
		getContentPane().add(list);
		
		customer_brought_stock_list = new JList();
		customer_brought_stock_list.setBackground(new Color(0,104,189));
		customer_brought_stock_list.setBounds(105, 154, 301, 523);
		getContentPane().add(customer_brought_stock_list);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(502, 361, 220, 133);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblNumberOfShare = new JLabel("Number of Share:");
		lblNumberOfShare.setBounds(54, 21, 139, 16);
		panel_1.add(lblNumberOfShare);
		
		sell_panel = new JPanel();
		sell_panel.setBounds(32, 49, 146, 72);
		panel_1.add(sell_panel);
		sell_panel.setBackground(Color.WHITE);
		sell_panel.setLayout(null);
		
		Customer_sell_botton = new JButton("Sell");
		Customer_sell_botton.setBounds(37, 43, 57, 29);
		sell_panel.add(Customer_sell_botton);
		
		txtNumberOfShare_sell = new JTextField();
		txtNumberOfShare_sell.setBounds(37, 6, 57, 26);
		sell_panel.add(txtNumberOfShare_sell);
		txtNumberOfShare_sell.setColumns(10);
		
		buy_panel = new JPanel();
		buy_panel.setBounds(0, 0, 154, 83);
		sell_panel.add(buy_panel);
		buy_panel.setBackground(Color.WHITE);
		buy_panel.setLayout(null);
		
		txtNumberOfShare_buy = new JTextField();
		txtNumberOfShare_buy.setBounds(38, 17, 57, 26);
		buy_panel.add(txtNumberOfShare_buy);
		txtNumberOfShare_buy.setColumns(10);
		
		Customer_buy_botton = new JButton("Buy");
		Customer_buy_botton.setBounds(38, 48, 57, 29);
		buy_panel.add(Customer_buy_botton);
		
		
//        File text = new File("/Users/jasonlee/Desktop/Stock.txt");
//        Scanner scnr = new Scanner(text);
//        int lineNumber = 0;
//        while(scnr.hasNextLine()){
//            String line = scnr.nextLine();
//			model.add(lineNumber, line);
//            lineNumber++;
//        } 
		




		
	}


	/**
	 * @return the stock
	 */
	public String[] getStock() {
		return stock;
	}


	/**
	 * @return the txtNumberOfShare_buy
	 */
	public JTextField getTxtNumberOfShare_buy() {
		return txtNumberOfShare_buy;
	}


	/**
	 * @return the txtNumberOfShare_sell
	 */
	public JTextField getTxtNumberOfShare_sell() {
		return txtNumberOfShare_sell;
	}


	/**
	 * @return the lblStocks
	 */
	public JLabel getLblStocks() {
		return lblStocks;
	}


	/**
	 * @return the customer_buy_botton
	 */
	public JButton getCustomer_buy_botton() {
		return Customer_buy_botton;
	}


	/**
	 * @return the customer_sell_botton
	 */
	public JButton getCustomer_sell_botton() {
		return Customer_sell_botton;
	}


	/**
	 * @return the lblNumberOfShare
	 */
	public JLabel getLblNumberOfShare() {
		return lblNumberOfShare;
	}


	/**
	 * @return the sell_panel
	 */
	public JPanel getSell_panel() {
		return sell_panel;
	}


	/**
	 * @return the buy_panel
	 */
	public JPanel getBuy_panel() {
		return buy_panel;
	}


	/**
	 * @return the customer_brought_stock_list
	 */
	public JList getCustomer_brought_stock_list() {
		return customer_brought_stock_list;
	}


}
