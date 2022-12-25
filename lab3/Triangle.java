package lab3;

public class Triangle extends Shape {
    private double a;
    private double b;
    private double c;

    public Triangle(String shapeColor, double a, double b, double c) {
        super(shapeColor);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void draw() {
        System.out.println("Shape: " + this);
    }

    public double calcArea() {
        double p = (a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    @Override
    public String toString() {
        return "Трикутник " + "(колір: " + super.toString() + ", a = " + a + ", b = " + b + ", c = " + c + ") S = " + calcArea();
    }
}
