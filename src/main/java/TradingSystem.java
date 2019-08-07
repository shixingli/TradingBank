import Controller.CustomerMainController;
import Helper.Tools;
import Model.Customer;
import View.CustomerMainFrame;

public class TradingSystem {

    private CustomerMainFrame customerMainFrame;

    public CustomerMainFrame getCustomerMainFrame() {
        return customerMainFrame;
    }

    // User
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public TradingSystem() {
        // cutomerMainFrame
        customerMainFrame = new CustomerMainFrame();
        customerMainFrame.getOKButton().addActionListener(e -> CustomerMainController.transaction(customerMainFrame, customer));
        customerMainFrame.getComboBox().addActionListener(e -> {
            CustomerMainController.updateAccountInfo(customerMainFrame, customer);
            CustomerMainController.refreshLowerComboBox(customerMainFrame, customerMainFrame.getComboBox().getSelectedItem().toString());
        });
    }




    public static void main(String[] args) {
        TradingSystem tradingSystem = new TradingSystem();
        tradingSystem.customer = new Customer("Gappery", "Li", "asdf", "asdf");
        CustomerMainController.showView(tradingSystem.getCustomerMainFrame(), tradingSystem.customer);
    }

}
