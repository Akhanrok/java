package lab3;

import java.util.ArrayList;
import java.util.Arrays;

public class ShapeRunner {
    public static void main(String[] args) {
        ShapeComparator ShapeComparator = new ShapeComparator(newShapes());
        System.out.println("Фігури:");
        ShapeComparator.printShapes(newShapes());

        System.out.println("\nСумарна площа всіх фігур: " + ShapeComparator.areaSum());
        System.out.println("Сумарна площа (круг): " + ShapeComparator.areaSumByType("circle"));
        System.out.println("Сумарна площа (прямокутник): " + ShapeComparator.areaSumByType("rectangle"));
        System.out.println("Сумарна площа (трикутник): " + ShapeComparator.areaSumByType("triangle"));

        System.out.println("\nСортування за зростанням площі: ");
        ShapeComparator.sortByArea();
        System.out.println("\nСортування за кольором: ");
        ShapeComparator.sortByColor();
    }

    public static ArrayList<Shape> newShapes() {
        Shape[] shapes = {
                new Circle("red", 5),
                new Rectangle("blue", 1, 2),
                new Triangle("green", 13,14,15),
                new Circle("yellow", 3),
                new Circle("purple", 16),
                new Triangle("red", 2,3,4),
                new Rectangle("blue", 7, 3),
                new Circle("green", 2),
                new Triangle("gold", 3, 4,5),
                new Circle("purple", 11)
        };
        return new ArrayList<>(Arrays.asList(shapes));
    }
}
