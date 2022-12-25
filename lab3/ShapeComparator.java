package lab3;

import java.util.ArrayList;
import java.util.Comparator;

public class ShapeComparator {
    private ArrayList<Shape> shapes;

    public ShapeComparator(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    public double areaSum() {
        double sum = 0;
        for (Shape shape : shapes) {
            sum += shape.calcArea();
        }
        return sum;
    }

    public double areaSumByType(String type) {
        double sum = 0;
        for (Shape shape : shapes) {
            if (type.equalsIgnoreCase("Rectangle")) {
                if (shape.getClass() == Rectangle.class) {
                    sum += shape.calcArea();
                }
            } else if (type.equalsIgnoreCase("Triangle")) {
                if (shape.getClass() == Triangle.class) {
                    sum += shape.calcArea();
                }
            } else if (type.equalsIgnoreCase("Circle")) {
                if (shape.getClass() == Circle.class) {
                    sum += shape.calcArea();
                }
            } else {
                System.out.println("Помилка");
            }
        }
        return sum;
    }

    public void sortByArea() {
        shapes.sort(Comparator.comparing(Shape::calcArea));
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }

    public void sortByColor() {
        shapes.sort(Comparator.comparing(Shape::getColor));
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }

    public void printShapes(ArrayList<Shape> shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}

