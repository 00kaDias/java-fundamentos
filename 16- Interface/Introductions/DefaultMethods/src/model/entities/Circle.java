package model.entities;

public class Circle implements Shape {
    private double raio;

    public Circle(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public double area() {
        return Math.PI * getRaio() * getRaio();
    }

}
