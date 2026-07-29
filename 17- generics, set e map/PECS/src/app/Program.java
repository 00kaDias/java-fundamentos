package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        List<Integer> intList = Arrays.asList(1, 3, 6, 9);
        List<Double> dbList = Arrays.asList(2.0, 2.5, 3.0, 3.5);
        List<Object> objList = new ArrayList<>();

         copy(intList, objList);
          System.out.println("Myobj " + objList);
          
         copy(dbList, objList);
          System.out.println("Myobj " + objList);
    }

    public static void copy(List<? extends Number> source, List<? super Number> destiny) {
        for (Number number : source) {

            destiny.add(number);

        }

    }

}
