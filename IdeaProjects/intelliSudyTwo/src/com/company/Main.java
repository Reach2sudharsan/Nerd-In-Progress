package com.company;
import java.util.Scanner;
import java.lang.Math.*;



public class Main {


    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);

        System.out.println("Enter the radius of a cone: ");
        double r1 = obj.nextDouble();

        System.out.println("Enter the radius of another cone: ");
        double r2 = obj.nextDouble();

        double v1 = (((double)1)/3)*Math.PI*r1;
        double v2 = (((double)1)/3)*Math.PI*r2;

        System.out.println("The volume of the first cone is " + v1);
        System.out.println("The volume of the second cone is " + v2);

        



	// write your code here
    }
}
