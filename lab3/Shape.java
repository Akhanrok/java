package lab3;

public abstract class Shape implements Drawable {
    private String color;

    public Shape (String shapeColor) {
        this.color = shapeColor;
    }

    public abstract double calcArea();

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return this.color;
    }
}
