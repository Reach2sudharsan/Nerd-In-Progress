/*

This code will first create an instance of the scanner object. It will then
initialize the variables "num1" and "num2" and then asks for integer inputs
for both of those variables and print the values of those variables based on
what was inputted in the integer inputs.

*/


package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int num1, num2;
        System.out.print("Enter an integer: ");
        num1 = obj.nextInt();
        System.out.print("Enter an integer: ");
        num2 = obj.nextInt();
        System.out.println("Number 1 = " + num1);
        System.out.println("Number 2 = " + num2);



    }
}
