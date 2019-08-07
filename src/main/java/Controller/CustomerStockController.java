package Controller;

import Helper.Tools;
import Model.Customer;
import Model.Manager;
import Model.Stock;
import View.CustomerStockFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerStockController {

    public static void showView(CustomerStockFrame customerStockFrame) {
        Tools.showWindow(customerStockFrame);
    }

    public static void refreshView(CustomerStockFrame customerStockFrame, Customer customer, String currentDate) {
        flushMarketStocks(customerStockFrame, currentDate);
        flushCustomerStocks(customerStockFrame, customer);
        customerStockFrame.getTxtNumberOfShare_sell().setText("");
    }

    public static void flushMarketStocks(CustomerStockFrame customerStockFrame, String currentDate) {
        List<String> marketInfo = new ArrayList();
        for (Stock stock : Manager.stocks) {
            marketInfo.add(stock.getCompany().getName() + " " + stock.getValue(currentDate));
        }
        customerStockFrame.getCustomer_brought_stock_list().setModel(new DefaultComboBoxModel(marketInfo.toArray()));
    }

    public static void flushCustomerStocks(CustomerStockFrame customerStockFrame, Customer customer) {
        List<String> selfInfo = new ArrayList();
        for (Stock stock : customer.getSecurityAccount().getBalance()) {
            marketInfo.add(stock.getCompany().getName() + " " + stock.getValue(currentDate));
        }
        customerStockFrame.getCustomer_brought_stock_list().setModel(new DefaultComboBoxModel(marketInfo.toArray()));
    }

    public static void setBuy(CustomerStockFrame customerStockFrame) {
        customerStockFrame.getCustomer_sell_botton().setText("Buy");
    }

    public static void setSell(CustomerStockFrame customerStockFrame) {
        customerStockFrame.getCustomer_sell_botton().setText("Sell");
    }

    public static void buyStock(CustomerStockFrame customerStockFrame, Customer customer, int shareNum, String buyDate) {
        String stockName = Tools.getFirstElementBeforeSpace(customerStockFrame.getCustomer_brought_stock_list().getSelectedValue().toString());
        Tools.confirmDialog("Result", customer.getSecurityAccount().buyStock(stockName, shareNum, buyDate), customerStockFrame);
    }

    public static void sellStock(CustomerStockFrame customerStockFrame, Customer customer) {
        String stockName = Tools.getFirstElementBeforeSpace(customerStockFrame.getCustomer_brought_stock_list().getSelectedValue().toString());
        Tools.confirmDialog("Result", customer.getSecurityAccount().buyStock(stockName, shareNum, buyDate), customerStockFrame);
    }

    /****************************************************************************
     *                        private methods
     ***************************************************************************/

}
