package app;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> mapWords = new TreeMap<>();

        System.out.println("How many words are you going to write? ");
        String frase = sc.nextLine();
        String[] wordWrite = frase.split(" ");
        for (String w : wordWrite) {
            if (mapWords.containsKey(w)) {
                mapWords.put(w, mapWords.get(w) + 1);
            } else {
                mapWords.put(w, 1);
            }
        }
        for (String m : mapWords.keySet()) {
            System.out.println(m + ": " + mapWords.get(m));
        }

        sc.close();

    }
}
