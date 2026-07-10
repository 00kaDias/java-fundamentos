package entities;

public abstract class Shape {
    Color color;

    public Shape() {

    }

    public Shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract Double area();

@Override
public String toString() {
return "Shapes Area: "
        +area()
        +" Colors: "
        +getColor();
}
}
