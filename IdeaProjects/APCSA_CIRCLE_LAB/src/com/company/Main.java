/*
This code takes in integer inputs for radii of 6 circles
and outputs the area of each circle.
 */

package com.company;

import java.lang.Math.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the radius: ");
        double r1 = obj.nextDouble();

        System.out.println("Enter the radius: ");
        double r2 = obj.nextDouble();

        System.out.println("Enter the radius: ");
        double r3 = obj.nextDouble();

        System.out.println("Enter the radius: ");
        double r4 = obj.nextDouble();

        System.out.println("Enter the radius: ");
        double r5 = obj.nextDouble();

        System.out.println("Enter the radius: ");
        double r6 = obj.nextDouble();

        System.out.println("Circle area is: "+Math.PI*r1*r1);
        System.out.println("Circle area is: "+Math.PI*r2*r2);
        System.out.println("Circle area is: "+Math.PI*r3*r3);
        System.out.println("Circle area is: "+Math.PI*r4*r4);
        System.out.println("Circle area is: "+Math.PI*r5*r5);
        System.out.println("Circle area is: "+Math.PI*r6*r6);




    }
}

/*

7.5
10
72.534
55
101
99.952
 */
