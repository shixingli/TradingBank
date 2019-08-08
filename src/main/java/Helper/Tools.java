package Helper;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Tools {

    public static final String ERROR_NOT_NUMBER = "Only number is accepted Here";
    public static final String ERROR_NOT_CORRECT_RANGE = "Invalid number";
    public static final String ERROR_EMPTY_STRING = "Empty id is not accepted";
    public static final String ERROR_DUPLICATE_STRING = "Id you enter is already used by other customer";
    public static final String[] ACCOUNT_TYPE = {"Checking Account", "Saving Account", "Security Account"};
    public static final String[] Bond_TYPE = {"7 days Bond", "1 Month Bond", "3 Months Bond"};


    /************************************************************************
     *                           public methods
     ************************************************************************/


    public static double doubleFormalize(double value, int decimalPlaces) {
        BigDecimal bigDecimal = new BigDecimal(value);
        return bigDecimal.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    public static boolean checkDateInput(String input) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm/dd/yyyy");
        try {
            simpleDateFormat.setLenient(false);
            Date date = simpleDateFormat.parse(input);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static int getDateDifference(String date1, String date2) {

        try {
            // get how many days between date 1 and date 2
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            Date startDate = simpleDateFormat.parse(date1);
            Date endDate = simpleDateFormat.parse(date2);
            return (int) (TimeUnit.DAYS.convert(Math.abs(startDate.getTime() - endDate.getTime()), TimeUnit.MILLISECONDS));
        } catch (Exception e) {
            return -1;
        }
    }

    public static String generateUniqueId() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        return simpleDateFormat.format(new Date());
    }

    public static boolean checkValidNumber(JFrame frame, String input) {
        double value;
        try {
            value = Double.parseDouble(input);
        } catch (Exception e) {
            System.out.println(input);
            confirmDialog("Error", ERROR_NOT_NUMBER, frame);
            return false;
        }
        if (value < 0) {
            confirmDialog("Error", ERROR_NOT_CORRECT_RANGE, frame);
            return false;
        }

        return true;
    }

    public static boolean checkValidInteger(JFrame frame, String input) {
        double value;
        try {
            value = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println(input);
            confirmDialog("Error", ERROR_NOT_NUMBER, frame);
            return false;
        }
        if (value < 0) {
            confirmDialog("Error", ERROR_NOT_CORRECT_RANGE, frame);
            return false;
        }

        return true;
    }

    public static String getFirstElementBeforeSpace(String input) {
        return input.trim().split(" ")[0];
    }

    public static <T extends JFrame> void showWindow(T frame) {
        int windowWidth = frame.getWidth();
        int windowHeight = frame.getHeight();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        frame.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);
        frame.setVisible(true);
    }


    /************************************************************************
     *                           private methods
     ***********************************************************************/

    /**
     * Input checking
     */
    private static boolean checkNotEmptyString(String input) {
        return input.length() == 0;
    }

    // error remind
    public static void confirmDialog(String title, String content, JFrame parent) {
        JOptionPane.showConfirmDialog(parent, content, title, JOptionPane.DEFAULT_OPTION);
    }

    public static void main(String[] args) {
        System.out.println(generateUniqueId());
    }

}


