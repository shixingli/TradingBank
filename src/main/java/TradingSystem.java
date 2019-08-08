import Model.Customer;
import View.CustomerMainFrame;

public class TradingSystem {

    private CustomerMainFrame customerMainFrame;

    // User
    private Customer customer;


    public TradingSystem() {
        // cutomerMainFrame
        customerMainFrame = new CustomerMainFrame();
        customerMainFrame.setVisible(true);
    }


    public static void main(String[] args) {

    }

}
