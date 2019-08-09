package Controller;

import Helper.Tools;
import Model.Customer;
import Model.Manager;
import View.Mainframe;
import View.ManagerFrame;

import javax.swing.*;
import java.util.ArrayList;

public class ManagerController {

    public static void showWindow(ManagerFrame managerFrame, String currentDate) {
        refreshView(managerFrame, currentDate);
        Tools.showWindow(managerFrame);
    }

    public static void refreshView(ManagerFrame managerFrame, String currentDate) {
        managerFrame.getGroup_two().clearSelection();
        refreshBond(managerFrame);
        refreshStock(managerFrame, currentDate);
        managerFrame.getTextarea().setText("?????");
        managerFrame.getUpdate_txtfield().setText("");
        managerFrame.getLeft_1().setVisible(false);
        managerFrame.getBond_lst().setVisible(false);
        ArrayList<String> customers = new ArrayList<>();
        for (Customer customer : Manager.customerList) {
            customers.add(customer.getFirstName());
        }
        managerFrame.getCustomer_combo().setModel(new DefaultComboBoxModel(customers.toArray()));
        managerFrame.getAccount_combo().setModel(new DefaultComboBoxModel(Tools.ACCOUNT_TYPE));
    }

    public static void refreshBond(ManagerFrame managerFrame) {
        managerFrame.getBond_lst().setModel(new DefaultComboBoxModel(Tools.Bond_Map));
        managerFrame.getBond_lst().clearSelection();
    }

    public static void refreshStock(ManagerFrame managerFrame, String currentDate) {
        managerFrame.getLeft_1().setModel(new DefaultComboBoxModel(Manager.getStocks(currentDate).toArray()));
        managerFrame.getBond_lst().clearSelection();
    }


    public static void showStock(ManagerFrame managerFrame) {
        managerFrame.getLeft_1().setVisible(true);
        managerFrame.getBond_lst().setVisible(false);
    }

    public static void showBond(ManagerFrame managerFrame) {
        managerFrame.getLeft_1().setVisible(false);
        managerFrame.getBond_lst().setVisible(true);
    }

    public static void updateStock(ManagerFrame managerFrame, String currentDate) {
        if (managerFrame.getLeft_1().getSelectedValue() == null) {
            Tools.confirmDialog("Result", "Please choose a correct stock", managerFrame);
            return;
        }

        if (Tools.checkValidNumber(managerFrame, managerFrame.getUpdate_txtfield().getText())) {
            if (Tools.getFirstElementBeforeSpace(managerFrame.getLeft_1().getSelectedValue().toString()).equals("Ticker")) {
                Tools.confirmDialog("Result", "Choose title is not a good idea", managerFrame);
            }
            Manager.updateStock(Tools.getFirstElementBeforeSpace(managerFrame.getLeft_1().getSelectedValue().toString()), currentDate, Double.parseDouble(managerFrame.getUpdate_txtfield().getText()));
            refreshStock(managerFrame, currentDate);
        }
    }

    public static void back(ManagerFrame managerFrame, Mainframe mainframe) {
        managerFrame.setVisible(false);
        MainController.showMain(mainframe);
    }

    public static void generateReport(ManagerFrame managerFrame) {
        String name = managerFrame.getCustomer_combo().getSelectedItem().toString();
        Customer temp = new Customer("test", "test", "test", "test");
        for (Customer customer : Manager.customerList) {
            if (customer.getFirstName().equals(name)) {
                temp = customer;
                break;
            }
        }
        System.out.println(temp.getID());
        if (managerFrame.getAccount_combo().getSelectedItem().equals("Checking Account")) {
         managerFrame.getTextarea().setText(Manager.checking);
        } else if (managerFrame.getAccount_combo().getSelectedItem().equals("Saving Account")) {
            managerFrame.getTextarea().setText(Manager.saving);
        } else {
            managerFrame.getTextarea().setText(Manager.security);
        }
    }

}
