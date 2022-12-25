package lab3;

public class Rectangle extends Shape {
    private double a;
    private double b;

    public Rectangle(String shapeColor, double a, double b) {
        super(shapeColor);
        this.a = a;
        this.b = b;
    }

    public void draw() {
        System.out.println("Shape: " + this);
    }

    public double calcArea() {
        return a * b;
    }

    @Override
    public String toString() {
        return "Прямокутник " + "(колір: " + super.toString() + ", a = " + a + ", b = " + b + ") S = " + calcArea();
    }
}

