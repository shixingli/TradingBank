package Controller;

import Helper.Tools;
import Model.Account;
import Model.Customer;
import View.CustomerMainFrame;

import javax.swing.*;

public class CustomerMainController {

    public static void showView(CustomerMainFrame customerMainFrame, Customer customer) {
        refreshView(customerMainFrame, customer);
        Tools.showWindow(customerMainFrame);
    }

    public static void refreshView(CustomerMainFrame customerMainFrame, Customer customer) {
        customerMainFrame.getComboBox().setModel(new DefaultComboBoxModel(Tools.ACCOUNT_TYPE));
        refreshLowerComboBox(customerMainFrame, customerMainFrame.getComboBox().getSelectedItem().toString());
        updateAccountInfo(customerMainFrame, customer);
        customerMainFrame.getAmount_money_txtfiled().setText("");
        customerMainFrame.getGroup().clearSelection();
    }

    public static void refreshLowerComboBox(CustomerMainFrame customerMainFrame, String currentType) {
        String[] accounts = new String[2];
        if (customerMainFrame.getComboBox().getSelectedItem().equals("Saving Account")) {
            accounts[0] = "Checking Account";
            accounts[1] = "Security Account";
        } else if (customerMainFrame.getComboBox().getSelectedItem().equals("Checking Account")) {
            accounts[0] = "Saving Account";
            accounts[1] = "Security Account";
        } else {
            accounts[0] = "Checking Account";
            accounts[1] = "Saving Account";
        }
        customerMainFrame.getBottom_combobox().setModel(new DefaultComboBoxModel(accounts));
    }

    public static void updateAccountInfo(CustomerMainFrame customerMainFrame, Customer customer) {
        if (customerMainFrame.getComboBox().getSelectedItem().equals("Saving Account")) {
            customerMainFrame.getAccount_info().setText(customer.getSavingAccount().toString());
        } else if (customerMainFrame.getComboBox().getSelectedItem().equals("Checking Account")) {
            customerMainFrame.getAccount_info().setText(customer.getCheckingAccount().toString());
        } else {
            customerMainFrame.getAccount_info().setText(customer.getSecurityAccount().toString());
        }
    }

    public static void transaction(CustomerMainFrame customerMainFrame, Customer customer) {
        if (Tools.checkValidNumber(customerMainFrame, customerMainFrame.getAmount_money_txtfiled().getText())) {
            double value = Double.parseDouble(customerMainFrame.getAmount_money_txtfiled().getText());
            Account account = getUpperAccount(customerMainFrame, customer);
            if (customerMainFrame.getDepositRadioButton().isSelected()) {
                Tools.confirmDialog("Result", account.deposit(value), customerMainFrame);
            } else if (customerMainFrame.getWithdrawRadioButton().isSelected()) {
                Tools.confirmDialog("Result", account.withDraw(value), customerMainFrame);
            } else if (customerMainFrame.getTransferRadioButton().isSelected()){
                if (customerMainFrame.getBottom_combobox().getSelectedItem().equals("Saving Account")) {
                    Tools.confirmDialog("Result", account.transferTo(customer.getSavingAccount(), value), customerMainFrame);
                } else if (customerMainFrame.getBottom_combobox().getSelectedItem().equals("Checking Account")) {
                    Tools.confirmDialog("Result", account.transferTo(customer.getCheckingAccount(), value), customerMainFrame);
                } else {
                    Tools.confirmDialog("Result", account.transferTo(customer.getSecurityAccount(), value), customerMainFrame);
                }
            } else {
                Tools.confirmDialog("Result", "Please choose a type of action", customerMainFrame);
            }
            updateAccountInfo(customerMainFrame, customer);
        }
    }


    /****************************************************************************
     *                        private methods
     ***************************************************************************/

    private static Account getUpperAccount(CustomerMainFrame customerMainFrame, Customer customer){
        if (customerMainFrame.getComboBox().getSelectedItem().equals("Saving Account")) {
            return customer.getSavingAccount();
        } else if (customerMainFrame.getComboBox().getSelectedItem().equals("Checking Account")) {
            return customer.getCheckingAccount();
        } else {
            return customer.getSecurityAccount();
        }
    }
}
