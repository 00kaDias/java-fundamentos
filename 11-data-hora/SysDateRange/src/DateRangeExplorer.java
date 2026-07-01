import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateRangeExplorer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // in
        System.out.println("Initial date, dd/MM/yyyy : ");
        String uIntialDate = sc.nextLine();
        LocalDate dt1 = LocalDate.parse(uIntialDate, fmt);
        System.out.println("Ender date, dd/MM/yyyy: ");
        String uEndDate = sc.nextLine();
        LocalDate dt2 = LocalDate.parse(uEndDate, fmt);
        System.out.println();
        //

        long totalDays = ChronoUnit.DAYS.between(dt1, dt2);
        LocalDate current = dt1;

        System.out.println("Total days: " + totalDays);

        long count = 0;
        while (current.isBefore(dt2) || current.isEqual(dt2)) {
            System.out.println(current.format(DateTimeFormatter.ofPattern("dd/MM/yyyy (EEEE)")));
            if (current.getDayOfWeek() == DayOfWeek.SATURDAY || current.getDayOfWeek() == DayOfWeek.SUNDAY) {
                count++;
            }
            current = current.plusDays(1);

        }
        System.out.println();
        System.out.println("Total number of weekends: " + count);
        

        sc.close();
    }
}
