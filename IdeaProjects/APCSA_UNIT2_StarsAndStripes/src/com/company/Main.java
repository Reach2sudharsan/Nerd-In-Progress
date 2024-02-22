/*
The program below prints lines of stars and dashes using the methods and constructors below.
 */
package com.company;

import static java.lang.System.*;

public class Main
{
    public static void main(String args[])
    {
        StarsAndStripes test = new StarsAndStripes();
        test.printASmallBox();
        test.printTwoBlankLines();
        test.printABigBox();
        test.printTwoBlankLines();
    }
}

class StarsAndStripes
{
    public StarsAndStripes()
    {
        out.println("StarsAndStripes");
        printTwoBlankLines();

    }

    public void printTwentyStars()
    {
        out.println("********************");
    }

    public void printTwentyDashes()
    {
        out.println("--------------------");
    }

    public void printTwoBlankLines()
    {
        out.println("\n");
    }

    public void printASmallBox()
    {
        printTwentyDashes();
        printTwentyStars();
        printTwentyDashes();
        printTwentyStars();
        printTwentyDashes();
        printTwentyStars();
        printTwentyDashes();
    }

    public void printABigBox()
    {
        printASmallBox();
        printASmallBox();
    }
}



//import static java.lang.System.out;
//
//public class Main {
//
//
//    public static void main(String[] args) {
//        Main test = new Main();
//        test.printABigBox();
//
//    }
//    public Main() {
//        out.println("StarsAndStripes");
//        printTwoBlankLines();
//    }
//
//    public void printTwentyStars() {
//        out.println("********************");
//
//    }
//
//    public void printTwentyDashes() {
//        out.println("--------------------");
//
//
//    }
//    public void printTwoBlankLines() {
//        out.println("\n");
//
//
//    }
//    public void printASmallBox() {
//        printTwentyDashes();
//        printTwentyStars();
//        printTwentyDashes();
//        printTwentyStars();
//        printTwentyDashes();
//        printTwentyStars();
//        printTwentyDashes();
//
//
//
//    }
//    public void printABigBox() {
//        printASmallBox();
//        printASmallBox();
//
//    }
//}



