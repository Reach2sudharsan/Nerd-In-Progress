/*
The program below asks the user to enter 5 temperatures in degrees fahrenheit, and then
outputs all of those temperatures in degrees celcius.
 */
package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner( System.in );
        System.out.print( "Enter a fahrenheit value: " );
        double f1 = kb.nextDouble();

        System.out.print( "Enter a fahrenheit value: " );
        double f2 = kb.nextDouble();

        System.out.print( "Enter a fahrenheit value: " );
        double f3 = kb.nextDouble();

        System.out.print( "Enter a fahrenheit value: " );
        double f4 = kb.nextDouble();

        System.out.print( "Enter a fahrenheit value: " );
        double f5 = kb.nextDouble();

        double c1 = (5.0/9)*(f1-32);
        double c2 = (5.0/9)*(f2-32);
        double c3 = (5.0/9)*(f3-32);
        double c4 = (5.0/9)*(f4-32);
        double c5 = (5.0/9)*(f5-32);

        System.out.println(c1 + " degrees Celsius");
        System.out.println(c2 + " degrees Celsius");
        System.out.println(c3 + " degrees Celsius");
        System.out.println(c4 + " degrees Celsius");
        System.out.println(c5 + " degrees Celsius");
    }
}
