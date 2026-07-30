package app;

import java.util.Scanner;

import service.PrintService;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintService<Integer> pr = new PrintService<>();
        System.out.println("How many values? ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int add = sc.nextInt();
            pr.addValue(add);
        }
        pr.print();
        System.out.println("First: " + pr.first());
        sc.close();

    }
}
