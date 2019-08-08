package Controller;

import Helper.Tools;
import View.CustomerMainFrame;
import View.Mainframe;

public class MainController {

    public static void showMain(Mainframe mainframe) {
        refreshAll(mainframe);
        mainframe.getTwo_login_panel().setVisible(true);
        mainframe.getCreate_acc_panel().setVisible(false);
        mainframe.getDynamic_login().setVisible(false);
        Tools.showWindow(mainframe);
    }

    public static void refreshAll(Mainframe mainframe) {
        mainframe.setCustomer(true);
        LoginController.refreshInfo(mainframe);
        CreateController.refreshInfo(mainframe);
    }

    public static void openCustomer(Mainframe mainframe, CustomerMainFrame customerMainFrame) {
        mainframe.setVisible(false);
        customerMainFrame.setVisible(true);
    }

    public static void openManager(Mainframe mainframe) {

    }

    public static void showCreate(Mainframe mainframe) {
        mainframe.getMain_panel().setVisible(false);
        CreateController.refreshInfo(mainframe);
        mainframe.getCreate_acc_panel().setVisible(true);
    }

    public static void showLogin(Mainframe mainframe) {
        mainframe.getMain_panel().setVisible(false);
        LoginController.refreshInfo(mainframe);
    }

    public static void customerLogin(Mainframe mainframe) {
        mainframe.setCustomer(true);
        mainframe.getTwo_login_panel().setVisible(false);
        mainframe.getLblDynamicLogin().setText("Customer Login");
        mainframe.getDynamic_login().setVisible(true);
    }

    public static void managerLogin(Mainframe mainframe) {
        mainframe.setCustomer(false);
        mainframe.getTwo_login_panel().setVisible(false);
        mainframe.getLblDynamicLogin().setText("Manager Login");
        mainframe.getDynamic_login().setVisible(true);
    }

    public static void createCustomer(Mainframe mainframe) {
        mainframe.setCustomer(true);
        mainframe.getTwo_login_panel().setVisible(false);
        mainframe.getCreate_acc_panel().setVisible(true);
    }

}
