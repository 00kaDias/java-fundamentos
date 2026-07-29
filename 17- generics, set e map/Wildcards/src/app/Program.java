package app;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        List<Integer> intList = Arrays.asList(1, 3, 6, 9);
        List<Double> dbList = Arrays.asList(2.0, 2.5, 3.0, 3.5);
        System.out.println("Sum " + sumlist(intList));
        System.out.println("Sum " + sumlist(dbList));


    }

    public static double sumlist(List<? extends Number> list) {
        double sum = 0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }
}
