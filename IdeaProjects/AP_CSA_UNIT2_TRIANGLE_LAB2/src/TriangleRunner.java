/*
The program below asks the user to enter the side lengths of a triangle and then outputs the area of
the triangle.
 */

import java.util.Scanner;

public class TriangleRunner {

    public static void main(String[] args) {
        Triangle findArea = new Triangle();
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the length of side 1: ");
        double side1 = obj.nextDouble();

        System.out.println("Enter the length of side 2: ");
        double side2 = obj.nextDouble();

        System.out.println("Enter the length of side 3: ");
        double side3 = obj.nextDouble();

        System.out.println("Area == " + findArea.calculateArea(side1, side2, side3));

    }

}

class Triangle {
    public String calculateArea(double S1, double S2, double S3) {

        double s = (S1 + S2 + S3)/2.0;
        double area = Math.sqrt(s*(s-S1)*(s-S2)*(s-S3));
        String roundedArea = String.format("%.5f", area);
        return roundedArea;
    };

}
