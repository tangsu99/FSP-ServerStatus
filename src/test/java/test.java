import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        String a = "2023-03-05 23:02:56 +0800";
        System.out.println(expires(getExpiresOn(), getCurrentDate()));
        System.out.println(getExpiresOn().getTime() - getCurrentDate().getTime());
    }

    private static DateFormat getDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
    }

    private static Date fromDate(String expiresOn) {
        DateFormat dateFormat = getDateFormat();
        Date date = null;
        try {
            date = dateFormat.parse(expiresOn);
        } catch (ParseException parseException) {
            // empty catch block
        }
        return date;
    }

    private static Date getExpiresOn() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(2, 1);
        return calendar.getTime();
    }

    private static Date getCurrentDate() {
        return new Date();
    }

    private static boolean expires(Date expiresDate, Date currentDate) {
        return currentDate.getTime() >= expiresDate.getTime();
    }
}
