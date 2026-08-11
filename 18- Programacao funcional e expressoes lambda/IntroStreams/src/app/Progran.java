package app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Progran {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 4, 5, 6, 7, 8);

        Stream<Integer> st1 = list.stream().map(x -> x * 10);

        System.out.println("St1: " + Arrays.toString(st1.toArray()));

        Stream<String> st2 = Stream.of("Maria", "Helenna", "Bob");
        System.out.println("st2: " + Arrays.toString(st2.toArray()));
        Stream<Integer> st3 = Stream.iterate(0, x -> x + 2);
        System.out.println("st3: " + Arrays.toString(st3.limit(10).toArray()));
        Stream.iterate(new int[] { 0, 1 }, x -> new int[] { x[1], x[0] + x[1] })
                .limit(10)
                .mapToInt(p -> p[0])
                .forEach(System.out::println);
       

    }
}
