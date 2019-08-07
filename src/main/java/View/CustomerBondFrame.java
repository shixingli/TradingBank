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

public class CustomerBondFrame extends JFrame{
	private JPanel right_coner_panel,panel_1,panel,left_big_panel,panel_3;
	private JLabel lblInterestRate,FaceLable,
		left_arrow,right_arrow,
		lblOneWeek,label_01,label_02,label_03,
		label_secondbond,label_11,label_12,label_13,
		label_thirdbond,label_21,label_22,label_23;
	private JButton buy_bond_btn,btnSell_1,btnSell_2,btnSell_3;
	private JComboBox bond_comboBox;


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
		
		left_big_panel = new JPanel();
		left_big_panel.setBackground(Color.WHITE);
		left_big_panel.setBounds(19, 95, 761, 564);
		getContentPane().add(left_big_panel);
		left_big_panel.setLayout(null);
		
		left_arrow = new JLabel("<");
		left_arrow.setBounds(277, 528, 61, 16);
		left_big_panel.add(left_arrow);
		left_arrow.setHorizontalAlignment(SwingConstants.TRAILING);
		left_arrow.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		right_arrow = new JLabel(">");
		right_arrow.setBounds(350, 528, 61, 16);
		left_big_panel.add(right_arrow);
		right_arrow.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(23, 221, 732, 295);
		left_big_panel.add(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[] {0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		lblOneWeek = new JLabel("OneWeek Bond");
		lblOneWeek.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_lblOneWeek = new GridBagConstraints();
		gbc_lblOneWeek.weighty = 2.0;
		gbc_lblOneWeek.insets = new Insets(0, 0, 5, 5);
		gbc_lblOneWeek.gridx = 0;
		gbc_lblOneWeek.gridy = 0;
		panel_3.add(lblOneWeek, gbc_lblOneWeek);
		
		label_01 = new JLabel("0,1");
		label_01.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.weightx = 0.1;
		gbc_label_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_9.gridx = 1;
		gbc_label_9.gridy = 0;
		panel_3.add(label_01, gbc_label_9);
		
		label_02 = new JLabel("0,2");
		label_02.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.weightx = 0.1;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 2;
		gbc_label_5.gridy = 0;
		panel_3.add(label_02, gbc_label_5);
		
		label_03 = new JLabel("0,3");
		label_03.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_label_13 = new GridBagConstraints();
		gbc_label_13.weightx = 0.1;
		gbc_label_13.insets = new Insets(0, 0, 5, 5);
		gbc_label_13.gridx = 3;
		gbc_label_13.gridy = 0;
		panel_3.add(label_03, gbc_label_13);
		
		btnSell_1 = new JButton("Sell");
		GridBagConstraints gbc_btnSell_1 = new GridBagConstraints();
		gbc_btnSell_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnSell_1.gridx = 4;
		gbc_btnSell_1.gridy = 0;
		panel_3.add(btnSell_1, gbc_btnSell_1);
		
		label_secondbond = new JLabel("Second Bond");
		label_secondbond.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.weighty = 2.0;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 1;
		panel_3.add(label_secondbond, gbc_label_2);
		
		label_11 = new JLabel("1,1");
		label_11.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 1;
		panel_3.add(label_11, gbc_label_1);
		
		label_12 = new JLabel("1,2");
		label_12.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 2;
		gbc_label_6.gridy = 1;
		panel_3.add(label_12, gbc_label_6);
		
		label_13 = new JLabel("1,3");
		label_13.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_label_15 = new GridBagConstraints();
		gbc_label_15.insets = new Insets(0, 0, 5, 5);
		gbc_label_15.gridx = 3;
		gbc_label_15.gridy = 1;
		panel_3.add(label_13, gbc_label_15);
		
		btnSell_2 = new JButton("Sell");
		GridBagConstraints gbc_btnSell_2 = new GridBagConstraints();
		gbc_btnSell_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnSell_2.gridx = 4;
		gbc_btnSell_2.gridy = 1;
		panel_3.add(btnSell_2, gbc_btnSell_2);
		
		label_thirdbond = new JLabel("Third Bond");
		label_thirdbond.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
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
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.insets = new Insets(0, 0, 0, 5);
		gbc_label_12.gridx = 2;
		gbc_label_12.gridy = 2;
		panel_3.add(label_22, gbc_label_12);
		
		label_23 = new JLabel("2,3");
		label_23.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_label_17 = new GridBagConstraints();
		gbc_label_17.insets = new Insets(0, 0, 0, 5);
		gbc_label_17.gridx = 3;
		gbc_label_17.gridy = 2;
		panel_3.add(label_23, gbc_label_17);
		
		btnSell_3 = new JButton("Sell");
		GridBagConstraints gbc_btnSell_3 = new GridBagConstraints();
		gbc_btnSell_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnSell_3.gridx = 4;
		gbc_btnSell_3.gridy = 2;
		panel_3.add(btnSell_3, gbc_btnSell_3);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(23, 107, 732, 109);
		left_big_panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Bond");
		lblNewLabel_3.setBounds(19, 49, 147, 54);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JLabel lblFaceValue = new JLabel("Face Value");
		lblFaceValue.setBounds(180, 49, 147, 54);
		panel_1.add(lblFaceValue);
		lblFaceValue.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JLabel lblTimeOfPurchase = new JLabel("PurchaseDate");
		lblTimeOfPurchase.setBounds(308, 49, 180, 54);
		panel_1.add(lblTimeOfPurchase);
		lblTimeOfPurchase.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JLabel lblInterest = new JLabel("Interest");
		lblInterest.setBounds(480, 49, 180, 54);
		panel_1.add(lblInterest);
		lblInterest.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		bond_comboBox = new JComboBox();
		bond_comboBox.setBounds(817, 225, 406, 55);
		getContentPane().add(bond_comboBox);
		
		JLabel lblNewLabel = new JLabel("Choose a Bond:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(849, 153, 333, 60);
		getContentPane().add(lblNewLabel);
		
		right_coner_panel = new JPanel();
		right_coner_panel.setBackground(Color.WHITE);
		right_coner_panel.setBounds(864, 365, 333, 187);
		getContentPane().add(right_coner_panel);
		right_coner_panel.setLayout(null);
		
		FaceLable = new JLabel("Face Value:");
		FaceLable.setHorizontalAlignment(SwingConstants.CENTER);
		FaceLable.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		FaceLable.setBounds(6, 105, 298, 56);
		right_coner_panel.add(FaceLable);
		
		lblInterestRate = new JLabel("Interest Rate:");
		lblInterestRate.setHorizontalAlignment(SwingConstants.CENTER);
		lblInterestRate.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblInterestRate.setBounds(6, 36, 298, 56);
		right_coner_panel.add(lblInterestRate);
		
		buy_bond_btn = new JButton("Buy");
		buy_bond_btn.setBounds(989, 630, 117, 29);
		getContentPane().add(buy_bond_btn);




	
	
	
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
	 * @return the left_arrow
	 */
	public JLabel getLeft_arrow() {
		return left_arrow;
	}

	/**
	 * @return the right_arrow
	 */
	public JLabel getRight_arrow() {
		return right_arrow;
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
}
