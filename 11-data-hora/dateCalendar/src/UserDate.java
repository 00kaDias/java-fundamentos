import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class UserDate {
public static void main(String[] args) throws ParseException {
     Scanner sc = new Scanner(System.in);
    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat fmt1 = new SimpleDateFormat("EEEE", Locale.of("en" , "US"));
    
     
     System.out.println("Date: ");
     String userInDate = sc.next();
     Date dateIn = fmt.parse(userInDate);
     Calendar calen = Calendar.getInstance();
     calen.setTime(dateIn);
     int day = calen.get(Calendar.DAY_OF_MONTH);
     int month = 1 + calen.get(Calendar.MONTH);
     int year = calen.get(Calendar.YEAR);
     System.out.println("Day:" + day + ", Month: "+month + ", Year: " +year + " | "+ fmt1.format(dateIn));
     sc.close();
}
}
