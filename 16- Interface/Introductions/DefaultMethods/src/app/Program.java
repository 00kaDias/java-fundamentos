package app;

import model.entities.Circle;
import model.entities.Shape;

public class Program {
    public static void main(String[] args) {
        Shape sh = new Circle(5.0);
        System.out.println("Area: " + sh.area());
        System.out.println("Perimeter: " + sh.perimeter());

    }
}