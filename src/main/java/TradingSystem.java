import Controller.*;
import Helper.Tools;
import Model.Company;
import Model.Customer;
import Model.Manager;
import Model.Stock;
import View.CustomerBondFrame;
import View.CustomerMainFrame;
import View.CustomerStockFrame;
import View.Mainframe;

public class TradingSystem {

    private CustomerMainFrame customerMainFrame;
    private CustomerStockFrame customerStockFrame;
    private CustomerBondFrame customerBondFrame;
    private Mainframe mainframe;

    // User
    private Customer customer;
    private Manager manager;

    private String currentDate;

    public TradingSystem() {
        frameInit();
        dataInit();

    }

    public void frameInit() {
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
        customerMainFrame.getBtnMybonds().addActionListener(e -> CustomerMainController.openBond(customerMainFrame, customerBondFrame, customer));
        customerMainFrame.getBtnStock().addActionListener(e -> CustomerMainController.openStock(customerMainFrame, customerStockFrame, customer, currentDate));


        // customerStockFrame
        customerStockFrame = new CustomerStockFrame();
        customerStockFrame.getCustomer_brought_stock_list().addListSelectionListener(e -> CustomerStockController.setSell(customerStockFrame));
        customerStockFrame.getMarket_stock_lst().addListSelectionListener(e -> CustomerStockController.setBuy(customerStockFrame));
        customerStockFrame.getCustomer_sell_botton().addActionListener(e -> CustomerStockController.transaction(customerStockFrame, customer, currentDate));

        //customerBondFrame
        customerBondFrame = new CustomerBondFrame();
        customerBondFrame.getBack_btn().addActionListener(e -> CustomerBondController.back(customerBondFrame, customerMainFrame, customer));
        customerBondFrame.getBond_comboBox().addActionListener(e -> CustomerBondController.updateBondInfo(customerBondFrame));
        customerBondFrame.getBuy_bond_btn().addActionListener(e -> CustomerBondController.buyBond(customerBondFrame, customer, currentDate));
        customerBondFrame.getBtnSell_1().addActionListener(e -> CustomerBondController.sellBond(customerBondFrame, customer, currentDate, 1));
        customerBondFrame.getBtnSell_2().addActionListener(e -> CustomerBondController.sellBond(customerBondFrame, customer, currentDate, 2));
        customerBondFrame.getBtnSell_3().addActionListener(e -> CustomerBondController.sellBond(customerBondFrame, customer, currentDate, 3));
        customerBondFrame.getBtnNext().addActionListener(e -> CustomerBondController.nextPage(customerBondFrame, customer));
        customerBondFrame.getBtnPrevious().addActionListener(e -> CustomerBondController.prevPage(customerBondFrame, customer));

        //MainFrame
        mainframe = new Mainframe();
        mainframe.getBtnCreate_init().addActionListener(e -> MainController.createCustomer(mainframe));
        mainframe.getBtnManagerLogin().addActionListener(e -> MainController.managerLogin(mainframe));
        mainframe.getCustomer_login_btn().addActionListener(e -> MainController.customerLogin(mainframe));
        mainframe.getLogin_btn().addActionListener(e -> LoginController.loginAction(mainframe, customerMainFrame));
        mainframe.getCreate_acc_btn().addActionListener(e -> MainController.createCustomer(mainframe));
        mainframe.getBtnCreate_init().addActionListener(e -> CreateController.createAccount(mainframe));
        mainframe.getBack_create_panel().addActionListener(e -> CreateController.back(mainframe));
        mainframe.getBack_btn().addActionListener(e -> LoginController.back(mainframe));
    }

    public void dataInit() {

        currentDate = Tools.generateCurrentDate();
        Manager manager = new Manager("Bruce", "Zhang", "U45687bedf", "123");

        Customer c1 = new Customer("asd", "hjk", "Usdjhfsid123", "123");
        Customer c2 = new Customer("qwe", ".o.,.m", "dfydt678", "456");
        Customer c3 = new Customer("zxc", "Zhen", "aaaa123", "789");
        Customer c4 = new Customer("ghj", "uiyu", "nfgnf567", "000");
        Customer c5 = new Customer("iuhkbk", "iopiop", "gfhfg777", "111");

        manager.addCustomer(customer);

        Company company = new Company("Apple", "LASD123");
        Company c = new Company("Google", "HJAK567");


        Stock stock = new Stock(company);
        manager.addStock(stock);
        System.out.println(manager.updateStock("LASD123", currentDate, 10));
        Stock sa = new Stock(c);
        manager.addStock(sa);
        manager.updateStock("HJAK567", currentDate, 50);
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

    public CustomerBondFrame getCustomerBondFrame() {
        return customerBondFrame;
    }

    public Mainframe getMainframe() {
        return mainframe;
    }

    public Manager getManager() {
        return manager;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public static void main(String[] args) {
        TradingSystem tradingSystem = new TradingSystem();
        tradingSystem.customer = new Customer("Gappery", "Li", "asdf", "asdf");
        tradingSystem.manager = new Manager("Gappery", "li", "asdf", "asdf");
        CustomerBondController.showView(tradingSystem.getCustomerBondFrame(), tradingSystem.getCustomer());
    }

}
