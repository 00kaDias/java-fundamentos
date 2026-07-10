package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Circle;
import entities.Color;
import entities.Rectangle;
import entities.Shape;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Shape> forms = new ArrayList<>();
        System.out.println("Enter the number of shapes: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Shape #" + 1 + " data:");
            System.out.println("Rectangle or circle (r/c)? ");
            char chose = sc.next().charAt(0);
            sc.nextLine();
            System.out.println("Color (BLACK/BLUE/RED): ");
            String color = sc.nextLine();
            if (chose == 'r') {

                System.out.println("Width: ");
                double width = sc.nextDouble();
                System.out.println("Height");
                double height = sc.nextDouble();
                forms.add(new Rectangle(Color.valueOf(color.toUpperCase()), width, height));

            } else if (chose == 'c') {
                System.out.println("Radius: ");
                double radius = sc.nextDouble();
                forms.add(new Circle(Color.valueOf(color.toUpperCase()), radius));
            }
            System.out.println(forms);
        }
        sc.close();
    }
}
