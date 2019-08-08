package Controller;

import Helper.Tools;
import Model.Customer;
import Model.Manager;
import Model.Stock;
import View.CustomerMainFrame;
import View.CustomerStockFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerStockController {

    public static void showView(CustomerStockFrame customerStockFrame, Customer customer, String currentDate) {
        refreshView(customerStockFrame, customer, currentDate);
        Tools.showWindow(customerStockFrame);
    }

    public static void refreshView(CustomerStockFrame customerStockFrame, Customer customer, String currentDate) {
        customerStockFrame.getCustomer_sell_botton().setText("XX");
        flushMarketStocks(customerStockFrame, currentDate, customer);
        flushCustomerStocks(customerStockFrame, customer);
        customerStockFrame.getTxtNumberOfShare_sell().setText("");
    }

    public static void flushMarketStocks(CustomerStockFrame customerStockFrame, String currentDate, Customer customer) {
        customerStockFrame.getMarket_stock_lst().setModel(new DefaultComboBoxModel(Manager.getStocks(currentDate).toArray()));
    }

    public static void flushCustomerStocks(CustomerStockFrame customerStockFrame, Customer customer) {
        customerStockFrame.getCustomer_brought_stock_list().setModel(new DefaultComboBoxModel(customer.getSecurityAccount().showOwnedStocks().toArray()));
    }

    public static void setBuy(CustomerStockFrame customerStockFrame) {
        customerStockFrame.getCustomer_sell_botton().setText("Buy");
    }

    public static void setSell(CustomerStockFrame customerStockFrame) {
        customerStockFrame.getCustomer_sell_botton().setText("Sell");
    }

    public static void transaction(CustomerStockFrame customerStockFrame, Customer customer, String currentDate) {
        if (Tools.checkValidNumber(customerStockFrame, customerStockFrame.getTxtNumberOfShare_sell().getText())) {
            if (customerStockFrame.getCustomer_sell_botton().getText().equals("Buy")) {
                buyStock(customerStockFrame, customer, Integer.parseInt(customerStockFrame.getTxtNumberOfShare_sell().getText()), currentDate);
            } else {
                sellStock(customerStockFrame, customer, Integer.parseInt(customerStockFrame.getTxtNumberOfShare_sell().getText()), currentDate);
            }
        }
    }

    public static void back(CustomerStockFrame customerStockFrame, CustomerMainFrame customerMainFrame, Customer customer) {
        customerStockFrame.setVisible(false);
        CustomerMainController.showView(customerMainFrame, customer);
    }

    /****************************************************************************
     *                        private methods
     ***************************************************************************/
    private static void buyStock(CustomerStockFrame customerStockFrame, Customer customer, int shareNum, String buyDate) {
        String stockName = Tools.getFirstElementBeforeSpace(customerStockFrame.getMarket_stock_lst().getSelectedValue().toString());
        System.out.println(stockName);
        System.out.println(Manager.stockMap.get(stockName).getValue(buyDate));
        Tools.confirmDialog("Result", customer.getSecurityAccount().buyStock(stockName, shareNum, buyDate), customerStockFrame);
        flushCustomerStocks(customerStockFrame, customer);
    }

    private static void sellStock(CustomerStockFrame customerStockFrame, Customer customer, int shareNum, String currentDate) {
        String stockName = Tools.getFirstElementBeforeSpace(customerStockFrame.getCustomer_brought_stock_list().getSelectedValue().toString());
        Tools.confirmDialog("Result", customer.getSecurityAccount().sellStock(stockName, shareNum, currentDate), customerStockFrame);
        flushCustomerStocks(customerStockFrame, customer);
    }
}