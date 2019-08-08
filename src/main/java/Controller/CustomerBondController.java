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

    public static void showView(CustomerBondFrame customerBondFrame, Customer customer) {
        refreshView(customerBondFrame, customer);
        Tools.showWindow(customerBondFrame);
    }

    public static void refreshView(CustomerBondFrame customerBondFrame, Customer customer) {
        customerBondFrame.setPagenumber(1);
        updateBondTable(customerBondFrame, customer);
        customerBondFrame.getBond_comboBox().setModel(new DefaultComboBoxModel(Tools.Bond_TYPE));
    }

    public static void updateBondTable(CustomerBondFrame customerBondFrame, Customer customer) {

        tempBonds = new Bond[3];
        int tempPage = customerBondFrame.getPagenumber();
        int i = 1;
        for (Bond bond : customer.getSecurityAccount().getOwnedBonds().keySet()) {
            if (i == (tempPage * 3 - 2)) {
                tempBonds[0] = bond;
            } else if (i == (tempPage * 3 - 1)) {
                tempBonds[1] = bond;
            } else if (i == (tempPage * 3)){
                tempBonds[2] = bond;
            }
            i++;
        }

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
        refreshView(customerBondFrame, customer);
    }

    public static void sellBond(CustomerBondFrame customerBondFrame, Customer customer, String currentDate, int num) {
        Tools.confirmDialog("Result", customer.getSecurityAccount().sellBond(tempBonds[num].getID(), currentDate), customerBondFrame);
        refreshView(customerBondFrame, customer);
    }

    public static void back(CustomerBondFrame customerBondFrame, CustomerMainFrame customerMainFrame, Customer customer) {
        customerBondFrame.setVisible(false);
        CustomerMainController.showView(customerMainFrame, customer);
    }

    public static void updateBondInfo(CustomerBondFrame customerBondFrame) {
        if (customerBondFrame.getBond_comboBox().getSelectedItem().equals("7 Days")) {
            customerBondFrame.getFaceLable().setText("Face Value:   " + 1369.23);
            customerBondFrame.getLblInterestRate().setText("Interest Rate:   " + Manager.bondMap.get(7));
        } else if (customerBondFrame.getBond_comboBox().getSelectedItem().equals("1 Month")) {
            customerBondFrame.getFaceLable().setText("Face Value:   " + 2862.74);
            customerBondFrame.getLblInterestRate().setText("Interest Rate:   " + Manager.bondMap.get(30));
        } else {
            customerBondFrame.getFaceLable().setText("Face Value:   " + 3362.08);
            customerBondFrame.getLblInterestRate().setText("Interest Rate:   " + Manager.bondMap.get(90));
        }
    }

    /****************************************************************************
     *                        private methods
     ***************************************************************************/
    private static double getTotalPageNumber(Customer customer) {
        return (int)(Math.ceil(customer.getSecurityAccount().getOwnedBonds().size() / 3.0));
    }





}
