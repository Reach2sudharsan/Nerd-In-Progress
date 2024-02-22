package com.company;
import static java.lang.System.*;

public class StarsAndStripes {

    public static void main(String[] args) {
        out.println("I will use a constructor.");
        StarsAndStripes test = new StarsAndStripes();
        test.printABigBox();

    }
    public StarsAndStripes() {
        out.println("StarsAndStripes");
        printTwoBlankLines();
    }

    public void printTwentyStars() {
        out.println("********************");

    }

    public void printTwentyDashes() {
        out.println("--------------------");


    }
    public void printTwoBlankLines() {
        out.println("\n");


    }
    public void printASmallBox() {
        printTwentyDashes();
        printTwentyStars();
        printTwentyDashes();
        printTwentyStars();
        printTwentyDashes();
        printTwentyStars();
        printTwentyDashes();



    }
    public void printABigBox() {
        printASmallBox();
        printASmallBox();

    }
}

/*
      test.printASmallBox();
      test.printTwoBlankLines();
      test.printABigBox();
      test.printTwoBlankLines();


StarsAndStripes
--------------------
********************
--------------------
********************
--------------------
********************
--------------------
--------------------
********************
--------------------
********************
--------------------
********************
--------------------
--------------------
********************
--------------------
********************
--------------------

 */