package lab3;

public class Circle extends Shape {
    private double r;

    public Circle(String shapeColor, double radius) {
        super(shapeColor);
        this.r = radius;
    }

    public void draw() {
        System.out.println("Shape: " + this);
    }

    public double calcArea() {
        return Math.PI * Math.pow(r, 2);
    }

    @Override
    public String toString() {
        return "Круг " + "(колір: " + super.toString() + ", r = " + r + ") S = " + calcArea();
    }
}
