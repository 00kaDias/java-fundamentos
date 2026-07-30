package model.entities;

public interface Shape {
    double area();

    default double perimeter() {
        return 0;
    }
}
