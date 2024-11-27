import java.util.Scanner;

abstract class Shape {
    int dim1, dim2;

    abstract void printArea();
}

class Rectangle extends Shape {
    Rectangle(int length, int breadth) {
        this.dim1 = length;
        this.dim2 = breadth;
    }

    void printArea() {
        System.out.println("Area of Rectangle: " + (dim1 * dim2));
    }
}

class Triangle extends Shape {
    Triangle(int base, int height) {
        this.dim1 = base;
        this.dim2 = height;
    }

    void printArea() {
        System.out.println("Area of Triangle: " + (0.5 * dim1 * dim2));
    }
}

class Circle extends Shape {
    Circle(int radius) {
        this.dim1 = radius;
        this.dim2 = 0;
    }

    void printArea() {
        System.out.println("Area of Circle: " + (Math.PI * dim1 * dim1));
    }
}

public class javalab4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length and breadth of rectangle: ");
        int length = scanner.nextInt();
        int breadth = scanner.nextInt();
        Rectangle rectangle = new Rectangle(length, breadth);

        System.out.print("Enter base and height of triangle: ");
        int base = scanner.nextInt();
        int height = scanner.nextInt();
        Triangle triangle = new Triangle(base, height);

        System.out.print("Enter radius of circle: ");
        int radius = scanner.nextInt();
        Circle circle = new Circle(radius);

        rectangle.printArea();
        triangle.printArea();
        circle.printArea();
    }
}
