package Controller;

import Helper.Tools;
import Model.Customer;
import View.CustomerMainFrame;
import View.Mainframe;
import View.ManagerFrame;

public class LoginController {

    public static void refreshInfo(Mainframe mainframe) {
        mainframe.getUsername_txt_dynamic().setText("");
        mainframe.getPasswordField_dynamic().setText("");
    }

    public static void loginAction(Mainframe mainframe, CustomerMainFrame customerMainFrame, Customer customer, String currentDate, ManagerFrame managerFrame) {
        if (mainframe.isCustomer()) customerLogin(mainframe, customerMainFrame, customer);
        else managerLogin(mainframe, managerFrame, currentDate);
    }

    public static void back(Mainframe mainframe) {
        mainframe.getDynamic_login().setVisible(false);
        MainController.refreshAll(mainframe);
        mainframe.getTwo_login_panel().setVisible(true);
    }

    /****************************************************************************
     *                        customer longin methods
     ***************************************************************************/
    public static void customerLogin(Mainframe mainframe, CustomerMainFrame customerMainFrame, Customer customer) {
        if (mainframe.getUsername_txt_dynamic().getText().length() != 0 && mainframe.getPasswordField_dynamic().getText().length() != 0){
            Customer temp = Customer.customerLogin(mainframe.getUsername_txt_dynamic().getText(), mainframe.getPasswordField_dynamic().getText());
            if (temp == null) {
                Tools.confirmDialog("Result", "Incorrect username or password", mainframe);
            } else {
                mainframe.setVisible(false);
                customer = temp;
                CustomerMainController.showView(customerMainFrame, customer);
            }
        } else {
            Tools.confirmDialog("Result", "Empty Input is not allowed", mainframe);
        }
    }




    /****************************************************************************
     *                        manager login methods
     ***************************************************************************/
    public static void managerLogin(Mainframe mainframe, ManagerFrame managerFrame, String currentDate) {
        if (mainframe.getUsername_txt_dynamic().getText().length() != 0 && mainframe.getPasswordField_dynamic().getText().length() != 0){
            mainframe.setVisible(false);
            ManagerController.showWindow(managerFrame, currentDate);
        } else {
            Tools.confirmDialog("Result", "Empty Input is not allowed", mainframe);
        }
    }


}