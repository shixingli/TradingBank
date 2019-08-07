package Controller;

import View.Mainframe;

public class CreateController {

    public static void back (Mainframe mainframe) {
        mainframe.getCreate_acc_panel().setVisible(false);
        MainController.refreshAll(mainframe);
        mainframe.getMain_panel().setVisible(true);
    }

    public static void refreshInfo (Mainframe mainframe) {
        mainframe.getCreate_name().setText("");
        mainframe.getCreate_username().setText("");
        mainframe.getPasswordField_dynamic().setText("");
    }

    public static void createAccount (Mainframe mainframe) {

    }
}
