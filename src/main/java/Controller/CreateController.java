package Controller;

import Helper.Tools;
import Model.Customer;
import Model.Manager;
import View.Mainframe;

public class CreateController {

    public static void back (Mainframe mainframe) {
        mainframe.getCreate_acc_panel().setVisible(false);
        MainController.refreshAll(mainframe);
        mainframe.getTwo_login_panel().setVisible(true);
    }

    public static void refreshInfo (Mainframe mainframe) {
        mainframe.getCreate_name().setText("");
        mainframe.getCreate_username().setText("");
        mainframe.getPasswordField_dynamic().setText("");
    }

    public static void createAccount (Mainframe mainframe, Customer customer) {
        if (mainframe.getCreate_username().getText().length() != 0 && mainframe.getCreate_name().getText().length() != 0 && mainframe.getCreate_pwd().getText().length() != 0){
//            Manager.readCustomerList();

            Customer temp = Customer.customerRegister(mainframe.getCreate_name().getText(), " ", mainframe.getCreate_username().getText(), mainframe.getCreate_pwd().getText());
            if (temp == null) {
                Tools.confirmDialog("result", "Duplicated id!", mainframe);
            } else {
                Manager.writeCustomerList();
                Tools.confirmDialog("result", "Account created!", mainframe);
                customer = temp;
                mainframe.getCreate_acc_panel().setVisible(false);
                mainframe.getTwo_login_panel().setVisible(true);
            }
        } else {
            Tools.confirmDialog("Result", "Empty Input is not allowed", mainframe);
        }
    }
}
