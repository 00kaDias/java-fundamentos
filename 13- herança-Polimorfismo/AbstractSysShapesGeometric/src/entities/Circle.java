package entities;

public class Circle extends Shape {
    public double radius;

    public Circle(Color color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public Double area() {
        return radius * radius * 3.14;
    }
}
