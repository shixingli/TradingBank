package View;

import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerBondFrame extends JFrame{
	private JPanel right_coner_panel,panel_1,panel,left_big_panel,panel_3;
	private JLabel lblInterestRate,FaceLable,
		lblOneWeek,label_01,label_02,label_03,
		label_secondbond,label_11,label_12,label_13,
		label_thirdbond,label_21,label_22,label_23;
	private JButton buy_bond_btn,btnSell_1,btnSell_2,btnSell_3;
	private JComboBox bond_comboBox;
	private JPanel bottom_panel;
	private JLabel lblBuyDate;
	private JLabel lblDueDate;
	private JLabel label_04;
	private JLabel label_14;
	private JLabel label_24;
	private JLabel label_05;
	private JLabel label_15;
	private JLabel label_25;
	private JButton btnPrevious;
	private JButton btnNext;
	private JButton back_btn;
	private JLabel page_label;
	private int pagenumber;

	public CustomerBondFrame() {
		getContentPane().setBackground(Color.WHITE);
		initialize();
	}
	
	private void initialize() {

		this.setBounds(0, 0, 1366, 768);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 1366, 60);
		getContentPane().add(panel);
		panel.setBackground(new Color(0, 104, 189));
		panel.setLayout(null);
		
		JLabel lblStocks = new JLabel("Bonds");
		lblStocks.setBounds(6, 6, 140, 48);		
		lblStocks.setForeground(Color.WHITE);
		lblStocks.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 30));
		panel.add(lblStocks);
		
		back_btn = new JButton("X");
		back_btn.setBounds(1305, 21, 33, 29);
		panel.add(back_btn);
		
		left_big_panel = new JPanel();
		left_big_panel.setBackground(Color.WHITE);
		left_big_panel.setBounds(19, 104, 1320, 467);
		getContentPane().add(left_big_panel);
		left_big_panel.setLayout(null);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(23, 127, 1291, 295);
		left_big_panel.add(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[] {0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		lblOneWeek = new JLabel("12345671234567");
		lblOneWeek.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_lblOneWeek = new GridBagConstraints();
		gbc_lblOneWeek.weightx = 0.01;
		gbc_lblOneWeek.anchor = GridBagConstraints.WEST;
		gbc_lblOneWeek.weighty = 2.0;
		gbc_lblOneWeek.insets = new Insets(0, 0, 5, 5);
		gbc_lblOneWeek.gridx = 0;
		gbc_lblOneWeek.gridy = 0;
		panel_3.add(lblOneWeek, gbc_lblOneWeek);
		
		label_01 = new JLabel("0,1");
		label_01.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_label_01 = new GridBagConstraints();
		gbc_label_01.weightx = 0.1;
		gbc_label_01.insets = new Insets(0, 0, 5, 5);
		gbc_label_01.gridx = 1;
		gbc_label_01.gridy = 0;
		panel_3.add(label_01, gbc_label_01);
		
		label_02 = new JLabel("0,2");
		label_02.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_label_02 = new GridBagConstraints();
		gbc_label_02.weightx = 0.1;
		gbc_label_02.insets = new Insets(0, 0, 5, 5);
		gbc_label_02.gridx = 2;
		gbc_label_02.gridy = 0;
		panel_3.add(label_02, gbc_label_02);
		
		label_03 = new JLabel("0,3");
		label_03.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_label_03 = new GridBagConstraints();
		gbc_label_03.weightx = 0.1;
		gbc_label_03.insets = new Insets(0, 0, 5, 5);
		gbc_label_03.gridx = 3;
		gbc_label_03.gridy = 0;
		panel_3.add(label_03, gbc_label_03);
		
		label_04 = new JLabel("0,4");
		label_04.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_label_04 = new GridBagConstraints();
		gbc_label_04.weightx = 0.1;
		gbc_label_04.insets = new Insets(0, 0, 5, 5);
		gbc_label_04.gridx = 4;
		gbc_label_04.gridy = 0;
		panel_3.add(label_04, gbc_label_04);
		
		label_05 = new JLabel("0,5");
		label_05.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_label_05 = new GridBagConstraints();
		gbc_label_05.weightx = 0.1;
		gbc_label_05.insets = new Insets(0, 0, 5, 5);
		gbc_label_05.gridx = 5;
		gbc_label_05.gridy = 0;
		panel_3.add(label_05, gbc_label_05);
		
		btnSell_1 = new JButton("Sell");
		GridBagConstraints gbc_btnSell_1 = new GridBagConstraints();
		gbc_btnSell_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnSell_1.gridx = 6;
		gbc_btnSell_1.gridy = 0;
		panel_3.add(btnSell_1, gbc_btnSell_1);
		
		label_secondbond = new JLabel("Second Bond");
		label_secondbond.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.weighty = 2.0;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 1;
		panel_3.add(label_secondbond, gbc_label_2);
		
		label_11 = new JLabel("1,1");
		label_11.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.insets = new Insets(0, 0, 5, 5);
		gbc_label_11.gridx = 1;
		gbc_label_11.gridy = 1;
		panel_3.add(label_11, gbc_label_11);
		
		label_12 = new JLabel("1,2");
		label_12.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.insets = new Insets(0, 0, 5, 5);
		gbc_label_12.gridx = 2;
		gbc_label_12.gridy = 1;
		panel_3.add(label_12, gbc_label_12);
		
		label_13 = new JLabel("1,3");
		label_13.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_label_13 = new GridBagConstraints();
		gbc_label_13.insets = new Insets(0, 0, 5, 5);
		gbc_label_13.gridx = 3;
		gbc_label_13.gridy = 1;
		panel_3.add(label_13, gbc_label_13);
		
		btnSell_2 = new JButton("Sell");
		btnSell_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		label_14 = new JLabel("1,4");
		label_14.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_label_14 = new GridBagConstraints();
		gbc_label_14.insets = new Insets(0, 0, 5, 5);
		gbc_label_14.gridx = 4;
		gbc_label_14.gridy = 1;
		panel_3.add(label_14, gbc_label_14);
		
		label_15 = new JLabel("1,5");
		label_15.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_label_15 = new GridBagConstraints();
		gbc_label_15.insets = new Insets(0, 0, 5, 5);
		gbc_label_15.gridx = 5;
		gbc_label_15.gridy = 1;
		panel_3.add(label_15, gbc_label_15);
		
		GridBagConstraints gbc_btnSell_2 = new GridBagConstraints();
		gbc_btnSell_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnSell_2.gridx = 6;
		gbc_btnSell_2.gridy = 1;
		panel_3.add(btnSell_2, gbc_btnSell_2);
		
		label_thirdbond = new JLabel("Third Bond");
		label_thirdbond.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.WEST;
		gbc_label_4.weighty = 2.0;
		gbc_label_4.insets = new Insets(0, 0, 0, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 2;
		panel_3.add(label_thirdbond, gbc_label_4);
		
		label_21 = new JLabel("2,1");
		label_21.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 0, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 2;
		panel_3.add(label_21, gbc_label_3);
		
		label_22 = new JLabel("2,2");
		label_22.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_label_22 = new GridBagConstraints();
		gbc_label_22.insets = new Insets(0, 0, 0, 5);
		gbc_label_22.gridx = 2;
		gbc_label_22.gridy = 2;
		panel_3.add(label_22, gbc_label_22);
		
		label_23 = new JLabel("2,3");
		label_23.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_label_23 = new GridBagConstraints();
		gbc_label_23.insets = new Insets(0, 0, 0, 5);
		gbc_label_23.gridx = 3;
		gbc_label_23.gridy = 2;
		panel_3.add(label_23, gbc_label_23);
		
		label_24 = new JLabel("2,4");
		label_24.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_label_24 = new GridBagConstraints();
		gbc_label_24.insets = new Insets(0, 0, 0, 5);
		gbc_label_24.gridx = 4;
		gbc_label_24.gridy = 2;
		panel_3.add(label_24, gbc_label_24);
		
		label_25 = new JLabel("2,5");
		label_25.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_label_25 = new GridBagConstraints();
		gbc_label_25.insets = new Insets(0, 0, 0, 5);
		gbc_label_25.gridx = 5;
		gbc_label_25.gridy = 2;
		panel_3.add(label_25, gbc_label_25);
		
		btnSell_3 = new JButton("Sell");
		GridBagConstraints gbc_btnSell_3 = new GridBagConstraints();
		gbc_btnSell_3.gridx = 6;
		gbc_btnSell_3.gridy = 2;
		panel_3.add(btnSell_3, gbc_btnSell_3);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(23, 6, 1291, 109);
		left_big_panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setBounds(19, 49, 147, 54);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JLabel lblFaceValue = new JLabel("Period");
		lblFaceValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblFaceValue.setBounds(435, 49, 147, 54);
		panel_1.add(lblFaceValue);
		lblFaceValue.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JLabel lblTimeOfPurchase = new JLabel("Rate");
		lblTimeOfPurchase.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimeOfPurchase.setBounds(219, 49, 180, 54);
		panel_1.add(lblTimeOfPurchase);
		lblTimeOfPurchase.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JLabel lblInterest = new JLabel("FaceValue");
		lblInterest.setHorizontalAlignment(SwingConstants.CENTER);
		lblInterest.setBounds(625, 49, 180, 54);
		panel_1.add(lblInterest);
		lblInterest.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		lblBuyDate = new JLabel("Buy Date");
		lblBuyDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuyDate.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblBuyDate.setBounds(814, 49, 180, 54);
		panel_1.add(lblBuyDate);
		
		lblDueDate = new JLabel("Due Date");
		lblDueDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDueDate.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblDueDate.setBounds(1020, 49, 180, 54);
		panel_1.add(lblDueDate);
		
		btnPrevious = new JButton("Prev");
		btnPrevious.setBounds(645, 434, 117, 29);
		left_big_panel.add(btnPrevious);
		
		btnNext = new JButton("Next");
		btnNext.setBounds(963, 434, 117, 29);
		left_big_panel.add(btnNext);
		
		page_label = new JLabel("Page Num");
		page_label.setBounds(826, 439, 92, 16);
		left_big_panel.add(page_label);
		
		bottom_panel = new JPanel();
		bottom_panel.setBackground(Color.WHITE);
		bottom_panel.setBounds(91, 583, 1248, 157);
		getContentPane().add(bottom_panel);
		bottom_panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choose a Bond:");
		lblNewLabel.setBounds(-56, 32, 333, 60);
		bottom_panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		bond_comboBox = new JComboBox();
		bond_comboBox.setBounds(198, 39, 356, 55);
		bottom_panel.add(bond_comboBox);
		
		right_coner_panel = new JPanel();
		right_coner_panel.setBounds(564, -12, 333, 187);
		bottom_panel.add(right_coner_panel);
		right_coner_panel.setBackground(Color.WHITE);
		right_coner_panel.setLayout(null);
		
		FaceLable = new JLabel("Face Value:");
		FaceLable.setHorizontalAlignment(SwingConstants.CENTER);
		FaceLable.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		FaceLable.setBounds(6, 105, 298, 56);
		right_coner_panel.add(FaceLable);
		
		lblInterestRate = new JLabel("Interest Rate:");
		lblInterestRate.setHorizontalAlignment(SwingConstants.CENTER);
		lblInterestRate.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblInterestRate.setBounds(6, 37, 298, 56);
		right_coner_panel.add(lblInterestRate);
		
		buy_bond_btn = new JButton("Buy");
		buy_bond_btn.setBounds(1153, 63, 89, 60);
		bottom_panel.add(buy_bond_btn);




	
	
	
	}

	/**
	 * @return the right_coner_panel
	 */
	public JPanel getRight_coner_panel() {
		return right_coner_panel;
	}

	/**
	 * @return the panel_1
	 */
	public JPanel getPanel_1() {
		return panel_1;
	}

	/**
	 * @return the panel
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * @return the left_big_panel
	 */
	public JPanel getLeft_big_panel() {
		return left_big_panel;
	}

	/**
	 * @return the panel_3
	 */
	public JPanel getPanel_3() {
		return panel_3;
	}

	/**
	 * @return the lblInterestRate
	 */
	public JLabel getLblInterestRate() {
		return lblInterestRate;
	}

	/**
	 * @return the faceLable
	 */
	public JLabel getFaceLable() {
		return FaceLable;
	}

	/**
	 * @return the lblOneWeek
	 */
	public JLabel getLblOneWeek() {
		return lblOneWeek;
	}

	/**
	 * @return the label_01
	 */
	public JLabel getLabel_01() {
		return label_01;
	}

	/**
	 * @return the label_02
	 */
	public JLabel getLabel_02() {
		return label_02;
	}

	/**
	 * @return the label_03
	 */
	public JLabel getLabel_03() {
		return label_03;
	}

	/**
	 * @return the label_secondbond
	 */
	public JLabel getLabel_secondbond() {
		return label_secondbond;
	}

	/**
	 * @return the label_11
	 */
	public JLabel getLabel_11() {
		return label_11;
	}

	/**
	 * @return the label_12
	 */
	public JLabel getLabel_12() {
		return label_12;
	}

	/**
	 * @return the label_13
	 */
	public JLabel getLabel_13() {
		return label_13;
	}

	/**
	 * @return the label_thirdbond
	 */
	public JLabel getLabel_thirdbond() {
		return label_thirdbond;
	}

	/**
	 * @return the label_21
	 */
	public JLabel getLabel_21() {
		return label_21;
	}

	/**
	 * @return the label_22
	 */
	public JLabel getLabel_22() {
		return label_22;
	}

	/**
	 * @return the label_23
	 */
	public JLabel getLabel_23() {
		return label_23;
	}

	/**
	 * @return the buy_bond_btn
	 */
	public JButton getBuy_bond_btn() {
		return buy_bond_btn;
	}

	/**
	 * @return the btnSell_1
	 */
	public JButton getBtnSell_1() {
		return btnSell_1;
	}

	/**
	 * @return the btnSell_2
	 */
	public JButton getBtnSell_2() {
		return btnSell_2;
	}

	/**
	 * @return the btnSell_3
	 */
	public JButton getBtnSell_3() {
		return btnSell_3;
	}

	/**
	 * @return the bond_comboBox
	 */
	public JComboBox getBond_comboBox() {
		return bond_comboBox;
	}

	/**
	 * @return the bottom_panel
	 */
	public JPanel getBottom_panel() {
		return bottom_panel;
	}

	/**
	 * @return the lblBuyDate
	 */
	public JLabel getLblBuyDate() {
		return lblBuyDate;
	}

	/**
	 * @return the lblDueDate
	 */
	public JLabel getLblDueDate() {
		return lblDueDate;
	}

	/**
	 * @return the label_04
	 */
	public JLabel getLabel_04() {
		return label_04;
	}

	/**
	 * @return the label_14
	 */
	public JLabel getLabel_14() {
		return label_14;
	}

	/**
	 * @return the label_24
	 */
	public JLabel getLabel_24() {
		return label_24;
	}

	/**
	 * @return the label_05
	 */
	public JLabel getLabel_05() {
		return label_05;
	}

	/**
	 * @return the label_15
	 */
	public JLabel getLabel_15() {
		return label_15;
	}

	/**
	 * @return the label_25
	 */
	public JLabel getLabel_25() {
		return label_25;
	}

	/**
	 * @return the btnPrevious
	 */
	public JButton getBtnPrevious() {
		return btnPrevious;
	}

	/**
	 * @return the btnNext
	 */
	public JButton getBtnNext() {
		return btnNext;
	}

	/**
	 * @return the back_btn
	 */
	public JButton getBack_btn() {
		return back_btn;
	}

	/**
	 * @return the page_label
	 */
	public JLabel getPage_label() {
		return page_label;
	}

	/**
	 * @return the pagenumber
	 */
	public int getPagenumber() {
		return pagenumber;
	}

	public void setPagenumber(int pagenumber) {this.pagenumber = pagenumber;}
}
