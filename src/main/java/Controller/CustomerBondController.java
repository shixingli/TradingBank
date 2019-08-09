package Controller;

import Helper.Tools;
import Model.Bond;
import Model.Customer;
import Model.Manager;
import View.CustomerBondFrame;
import View.CustomerMainFrame;

import javax.swing.*;

public class CustomerBondController {

    public static Bond[] tempBonds = new Bond[3];
    public static int calc = 0;

    public static void showView(CustomerBondFrame customerBondFrame, Customer customer) {
        refreshView(customerBondFrame, customer);
        Tools.showWindow(customerBondFrame);
    }

    public static void refreshView(CustomerBondFrame customerBondFrame, Customer customer) {
        customerBondFrame.setPagenumber(1);
        updateBondTable(customerBondFrame, customer);
        customerBondFrame.getBond_comboBox().setModel(new DefaultComboBoxModel(Tools.Bond_TYPE));
        updateBondInfo(customerBondFrame);
        updatePageInfo(customerBondFrame, customer);
        updateBalance(customerBondFrame, customer);
    }

    public static void updateBalance(CustomerBondFrame customerBondFrame, Customer customer) {
        customerBondFrame.getBalance_txt().setText(customer.getSecurityAccount().toString());
    }


    public static void updateBondTable(CustomerBondFrame customerBondFrame, Customer customer) {

        tempBonds = new Bond[3];
        int tempPage = customerBondFrame.getPagenumber();
        int i = 1;
        calc = 0;

        for (Bond bond : customer.getSecurityAccount().getOwnedBonds().keySet()) {
            if (i == (tempPage * 3 - 2)) {
                tempBonds[0] = bond;
                calc++;
            } else if (i == (tempPage * 3 - 1)) {
                tempBonds[1] = bond;
                calc++;
            } else if (i == (tempPage * 3)){
                tempBonds[2] = bond;
                calc++;
            }
            i++;
        }

        if (calc == 0) {
            customerBondFrame.getBtnSell_1().setVisible(false);
            customerBondFrame.getBtnSell_2().setVisible(false);
            customerBondFrame.getBtnSell_3().setVisible(false);
            customerBondFrame.getLblOneWeek().setText("");
            customerBondFrame.getLabel_01().setText("");
            customerBondFrame.getLabel_02().setText("");
            customerBondFrame.getLabel_03().setText("");
            customerBondFrame.getLabel_04().setText("");
            customerBondFrame.getLabel_05().setText("");

            customerBondFrame.getLabel_secondbond().setText("");
            customerBondFrame.getLabel_11().setText("");
            customerBondFrame.getLabel_12().setText("");
            customerBondFrame.getLabel_13().setText("");
            customerBondFrame.getLabel_14().setText("");
            customerBondFrame.getLabel_15().setText("");

            customerBondFrame.getLabel_thirdbond().setText("");
            customerBondFrame.getLabel_21().setText("");
            customerBondFrame.getLabel_22().setText("");
            customerBondFrame.getLabel_23().setText("");
            customerBondFrame.getLabel_24().setText("");
            customerBondFrame.getLabel_25().setText("");
        }

        if (calc == 1) {
            customerBondFrame.getBtnSell_1().setVisible(true);
            customerBondFrame.getBtnSell_2().setVisible(false);
            customerBondFrame.getBtnSell_3().setVisible(false);
            customerBondFrame.getLblOneWeek().setText(tempBonds[0].getID());
            customerBondFrame.getLabel_01().setText(tempBonds[0].getValue() + "");
            customerBondFrame.getLabel_02().setText(tempBonds[0].getPeriod() + "days");
            customerBondFrame.getLabel_03().setText(tempBonds[0].getValue() + "");
            customerBondFrame.getLabel_04().setText(tempBonds[0].getBuyDate());
            customerBondFrame.getLabel_05().setText(Tools.dueDateCalculate(tempBonds[0].getBuyDate(), tempBonds[0].getPeriod()));
            System.out.println(Tools.dueDateCalculate(tempBonds[0].getBuyDate(), tempBonds[0].getPeriod()));
            System.out.println("???????");

            customerBondFrame.getLabel_secondbond().setText("");
            customerBondFrame.getLabel_11().setText("");
            customerBondFrame.getLabel_12().setText("");
            customerBondFrame.getLabel_13().setText("");
            customerBondFrame.getLabel_14().setText("");
            customerBondFrame.getLabel_15().setText("");

            customerBondFrame.getLabel_thirdbond().setText("");
            customerBondFrame.getLabel_21().setText("");
            customerBondFrame.getLabel_22().setText("");
            customerBondFrame.getLabel_23().setText("");
            customerBondFrame.getLabel_24().setText("");
            customerBondFrame.getLabel_25().setText("");
        }

        if (calc == 2) {
            customerBondFrame.getBtnSell_1().setVisible(true);
            customerBondFrame.getBtnSell_2().setVisible(true);
            customerBondFrame.getBtnSell_3().setVisible(false);
            customerBondFrame.getLblOneWeek().setText(tempBonds[0].getID());
            customerBondFrame.getLabel_01().setText(tempBonds[0].getValue() + "");
            customerBondFrame.getLabel_02().setText(tempBonds[0].getPeriod() + "days");
            customerBondFrame.getLabel_03().setText(tempBonds[0].getValue() + "");
            customerBondFrame.getLabel_04().setText(tempBonds[0].getBuyDate());
            customerBondFrame.getLabel_05().setText(Tools.dueDateCalculate(tempBonds[0].getBuyDate(), tempBonds[0].getPeriod()));

            customerBondFrame.getLabel_secondbond().setText(tempBonds[1].getID());
            customerBondFrame.getLabel_11().setText(tempBonds[1].getValue() + "");
            customerBondFrame.getLabel_12().setText(tempBonds[1].getPeriod() + "days");
            customerBondFrame.getLabel_13().setText(tempBonds[1].getValue() + "");
            customerBondFrame.getLabel_14().setText(tempBonds[1].getBuyDate());
            customerBondFrame.getLabel_15().setText(Tools.dueDateCalculate(tempBonds[1].getBuyDate(), tempBonds[1].getPeriod()));

            customerBondFrame.getLabel_thirdbond().setText("");
            customerBondFrame.getLabel_21().setText("");
            customerBondFrame.getLabel_22().setText("");
            customerBondFrame.getLabel_23().setText("");
            customerBondFrame.getLabel_24().setText("");
            customerBondFrame.getLabel_25().setText("");
        }

        if (calc > 2) {
            customerBondFrame.getBtnSell_1().setVisible(true);
            customerBondFrame.getBtnSell_2().setVisible(true);
            customerBondFrame.getBtnSell_3().setVisible(true);
            customerBondFrame.getLblOneWeek().setText(tempBonds[0].getID());
            customerBondFrame.getLabel_01().setText(tempBonds[0].getValue() + "");
            customerBondFrame.getLabel_02().setText(tempBonds[0].getPeriod() + "days");
            customerBondFrame.getLabel_03().setText(tempBonds[0].getValue() + "");
            customerBondFrame.getLabel_04().setText(tempBonds[0].getBuyDate());
            customerBondFrame.getLabel_05().setText(Tools.dueDateCalculate(tempBonds[0].getBuyDate(), tempBonds[0].getPeriod()));

            customerBondFrame.getLabel_secondbond().setText(tempBonds[1].getID());
            customerBondFrame.getLabel_11().setText(tempBonds[1].getValue() + "");
            customerBondFrame.getLabel_12().setText(tempBonds[1].getPeriod() + "days");
            customerBondFrame.getLabel_13().setText(tempBonds[1].getValue() + "");
            customerBondFrame.getLabel_14().setText(tempBonds[1].getBuyDate());
            customerBondFrame.getLabel_15().setText(Tools.dueDateCalculate(tempBonds[1].getBuyDate(), tempBonds[1].getPeriod()));

            customerBondFrame.getLabel_thirdbond().setText(tempBonds[2].getID());
            customerBondFrame.getLabel_21().setText(tempBonds[2].getValue() + "");
            customerBondFrame.getLabel_22().setText(tempBonds[2].getPeriod() + "days");
            customerBondFrame.getLabel_23().setText(tempBonds[2].getValue() + "");
            customerBondFrame.getLabel_24().setText(tempBonds[2].getBuyDate());
            customerBondFrame.getLabel_25().setText(Tools.dueDateCalculate(tempBonds[2].getBuyDate(), tempBonds[2].getPeriod()));
        }
    }

    public static void nextPage(CustomerBondFrame customerBondFrame, Customer customer) {
        if (customerBondFrame.getPagenumber() < getTotalPageNumber(customer)) {
            customerBondFrame.setPagenumber(customerBondFrame.getPagenumber()+1);
            updateBondTable(customerBondFrame, customer);
        }
    }

    public static void prevPage(CustomerBondFrame customerBondFrame, Customer customer) {
        if (customerBondFrame.getPagenumber() > 1) {
            customerBondFrame.setPagenumber(customerBondFrame.getPagenumber()-1);
            updateBondTable(customerBondFrame, customer);
        }
    }

    public static void buyBond(CustomerBondFrame customerBondFrame, Customer customer, String currentDate) {
        if (customerBondFrame.getBond_comboBox().getSelectedItem().equals("7 Days")) {
            Tools.confirmDialog("Result", customer.getSecurityAccount().buyBond(7, Tools.generateUniqueId(), currentDate), customerBondFrame);
        } else if (customerBondFrame.getBond_comboBox().getSelectedItem().equals("1 Month")) {
            Tools.confirmDialog("Result", customer.getSecurityAccount().buyBond(30, Tools.generateUniqueId(), currentDate), customerBondFrame);
        } else {
            Tools.confirmDialog("Result", customer.getSecurityAccount().buyBond(90, Tools.generateUniqueId(), currentDate), customerBondFrame);
        }
        updateBalance(customerBondFrame, customer);
        refreshView(customerBondFrame, customer);
    }

    public static void sellBond(CustomerBondFrame customerBondFrame, Customer customer, String currentDate, int num) {
        if (num > calc) {
            return;
        }
        Tools.confirmDialog("Result", customer.getSecurityAccount().sellBond(tempBonds[num-1].getID(), currentDate), customerBondFrame);
        refreshView(customerBondFrame, customer);
        updateBalance(customerBondFrame, customer);
    }

    public static void back(CustomerBondFrame customerBondFrame, CustomerMainFrame customerMainFrame, Customer customer) {
        customerBondFrame.setVisible(false);
        CustomerMainController.showView(customerMainFrame, customer);
    }

    public static void updateBondInfo(CustomerBondFrame customerBondFrame) {
        if (customerBondFrame.getBond_comboBox().getSelectedItem().equals("7 Days")) {
            customerBondFrame.getFaceLable().setText("Face Value:   " + 1000);
            customerBondFrame.getLblInterestRate().setText("Interest Rate:   " + Manager.bondMap.get(7));
        } else if (customerBondFrame.getBond_comboBox().getSelectedItem().equals("1 Month")) {
            customerBondFrame.getFaceLable().setText("Face Value:   " + 1500);
            customerBondFrame.getLblInterestRate().setText("Interest Rate:   " + Manager.bondMap.get(30));
        } else {
            customerBondFrame.getFaceLable().setText("Face Value:   " + 3000);
            customerBondFrame.getLblInterestRate().setText("Interest Rate:   " + Manager.bondMap.get(90));
        }
    }

    public static void updatePageInfo(CustomerBondFrame customerBondFrame, Customer customer) {
        customerBondFrame.getPage_label().setText("Page " + customerBondFrame.getPagenumber() + "/" + (getTotalPageNumber(customer) == 0 ? 1 : getTotalPageNumber(customer)));
    }
    /****************************************************************************
     *                        private methods
     ***************************************************************************/
    private static int getTotalPageNumber(Customer customer) {
        return (int)(Math.ceil(customer.getSecurityAccount().getOwnedBonds().size() / 3.0));
    }





}
