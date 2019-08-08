package Controller;

import Helper.Tools;
import Model.Customer;
import View.CustomerMainFrame;
import View.Mainframe;

public class LoginController {

    public static void refreshInfo(Mainframe mainframe) {
        mainframe.getUsername_txt_dynamic().setText("");
        mainframe.getPasswordField_dynamic().setText("");
    }

    public static void loginAction(Mainframe mainframe, CustomerMainFrame customerMainFrame) {
        if (mainframe.isCustomer()) customerLogin(mainframe, customerMainFrame);
        else managerLogin(mainframe);
    }

    public static void back(Mainframe mainframe) {
        mainframe.getDynamic_login().setVisible(false);
        MainController.refreshAll(mainframe);
        mainframe.getTwo_login_panel().setVisible(true);
    }

    /****************************************************************************
     *                        customer longin methods
     ***************************************************************************/
    public static void customerLogin(Mainframe mainframe, CustomerMainFrame customerMainFrame) {
        if (mainframe.getUsername_txt_dynamic().getText().length() != 0 && mainframe.getPasswordField_dynamic().getText().length() != 0){
            mainframe.setVisible(false);
            Customer customer = new Customer("Gappery", "Li", "a1", "adf");
            CustomerMainController.showView(customerMainFrame, customer);
        } else {
            Tools.confirmDialog("Result", "Empty Input is not allowed", mainframe);
        }
    }




    /****************************************************************************
     *                        manager login methods
     ***************************************************************************/
    public static void managerLogin(Mainframe mainframe) {
        if (mainframe.getUsername_txt_dynamic().getText().length() != 0 && mainframe.getPasswordField_dynamic().getText().length() != 0){

        } else {

        }
    }


}