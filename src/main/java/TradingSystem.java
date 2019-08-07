import Controller.CustomerMainController;
import Controller.CustomerStockController;
import Helper.Tools;
import Model.Customer;
import View.CustomerMainFrame;
import View.CustomerStockFrame;

public class TradingSystem {

    private CustomerMainFrame customerMainFrame;
    private CustomerStockFrame customerStockFrame;

    // User
    private Customer customer;

    private String currentDate;


    public TradingSystem() {
        // customerMainFrame
        customerMainFrame = new CustomerMainFrame();
        customerMainFrame.getOKButton().addActionListener(e -> CustomerMainController.transaction(customerMainFrame, customer));
        customerMainFrame.getComboBox().addActionListener(e -> {
            CustomerMainController.updateAccountInfo(customerMainFrame, customer);
            CustomerMainController.refreshLowerComboBox(customerMainFrame, customerMainFrame.getComboBox().getSelectedItem().toString());
        });
        customerMainFrame.getDepositRadioButton().addActionListener(e -> CustomerMainController.hideComboBox(customerMainFrame));
        customerMainFrame.getWithdrawRadioButton().addActionListener(e -> CustomerMainController.hideComboBox(customerMainFrame));
        customerMainFrame.getTransferRadioButton().addActionListener(e -> CustomerMainController.showComboBox(customerMainFrame));

        // customerStockFrame
        customerStockFrame = new CustomerStockFrame();
        customerStockFrame.getCustomer_brought_stock_list().addListSelectionListener(e -> CustomerStockController.setSell(customerStockFrame));
        customerStockFrame.getMarket_stock_lst().addListSelectionListener(e -> CustomerStockController.setBuy(customerStockFrame));
    }

    public CustomerMainFrame getCustomerMainFrame() {
        return customerMainFrame;
    }

    public CustomerStockFrame getCustomerStockFrame() {
        return customerStockFrame;
    }

    public Customer getCustomer() {
        return customer;
    }

    public static void main(String[] args) {
        TradingSystem tradingSystem = new TradingSystem();
        tradingSystem.customer = new Customer("Gappery", "Li", "asdf", "asdf");
        CustomerStockController.showView(tradingSystem.getCustomerStockFrame());
    }

}
