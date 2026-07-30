package app;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        List<Double> doubleList = Arrays.asList(3.2, 2.4, 1.5, 4.9);
        System.out.println("Min: " + min(doubleList));

    }

    public static <T extends Comparable<T>> T min(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Is empty");
        }
        T min = list.get(0);
        for (T item : list) {
            if (item.compareTo(min) < 0) {
                min = item;
            }

        }
        return min;
    }
}