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
    public static final String[] ACCOUNT_TYPE = {"Checking Account", "Saving Acoount", "Security Account"};


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

    public static long getDateDifference(String date1, String date2){

        try {
            // ?????????????????????
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            Date startDate = simpleDateFormat.parse(date1);
            System.out.println(startDate.getTime());
            Date endDate = simpleDateFormat.parse(date2);
            System.out.println(startDate.getTime());
            System.out.println(endDate.getTime());
            return (TimeUnit.DAYS.convert(Math.abs(startDate.getTime() - endDate.getTime()), TimeUnit.MILLISECONDS));
        } catch (Exception e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(getDateDifference("20181120", "20190806"));
    }

//    public static String dateFormalize() {
//
//
//    }

    public static String generateUniqueId() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        return simpleDateFormat.format(new Date());
    }

    public static boolean checkValidNumber(JFrame frame, String input) {
        double value;
        try {
            value = Double.parseDouble(input);
        } catch (Exception e) {
            confirmDialog("Error", ERROR_NOT_NUMBER, frame);
            return false;
        }
        if (value < 0) {
            confirmDialog("Error", ERROR_NOT_CORRECT_RANGE, frame);
            return false;
        }

        return true;
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

    private static <T extends JFrame> void showWindow(T frame) {
        int windowWidth = frame.getWidth();
        int windowHeight = frame.getHeight();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
        frame.setVisible(true);
    }
}