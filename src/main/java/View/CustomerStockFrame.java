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
	private JTextField txtNumberOfShare_sell;
	private JLabel lblStocks;
	private JButton Customer_dynamic_botton;
	



	private JLabel lblNumberOfShare;
	private JPanel sell_panel;
	private JList customer_brought_stock_list,market_stock_lst;
	
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
	    market_stock_lst = new JList(model);
	    market_stock_lst.setVisibleRowCount(10);
	    market_stock_lst.setForeground(Color.WHITE);
	    market_stock_lst.setBackground(new Color(0, 104, 189));
	    market_stock_lst.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 25));
		market_stock_lst.setBounds(841, 143, 484, 551);
		getContentPane().add(market_stock_lst);
		
		customer_brought_stock_list = new JList();
		customer_brought_stock_list.setBackground(new Color(0,104,189));
		customer_brought_stock_list.setBounds(105, 154, 301, 523);
		getContentPane().add(customer_brought_stock_list);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(550, 345, 220, 133);
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
		
		Customer_dynamic_botton = new JButton("Dynamic");
		Customer_dynamic_botton.setBounds(37, 43, 67, 29);
		sell_panel.add(Customer_dynamic_botton);
		
		txtNumberOfShare_sell = new JTextField();
		txtNumberOfShare_sell.setBounds(37, 6, 67, 26);
		sell_panel.add(txtNumberOfShare_sell);
		txtNumberOfShare_sell.setColumns(10);
		
		
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


//	/**
//	 * @return the txtNumberOfShare_buy
//	 */
//	public JTextField getTxtNumberOfShare_buy() {
//		return txtNumberOfShare_buy;
//	}


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


//	/**
//	 * @return the customer_buy_botton
//	 */
//	public JButton getCustomer_buy_botton() {
//		return Customer_buy_botton;
//	}


	/**
	 * @return the customer_sell_botton
	 */
	public JButton getCustomer_sell_botton() {
		return Customer_dynamic_botton;
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
//	public JPanel getBuy_panel() {
//		return buy_panel;
//	}


	/**
	 * @return the customer_brought_stock_list
	 */
	public JList getCustomer_brought_stock_list() {
		return customer_brought_stock_list;
	}

	public JButton getCustomer_dynamic_botton() {
		return Customer_dynamic_botton;
	}

	public JList getMarket_stock_lst() {
		return market_stock_lst;
	}
}
