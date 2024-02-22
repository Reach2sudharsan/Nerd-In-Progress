import java.util.Scanner;

public class the25 {
    public static void main(String[] args) {
        System.out.println("Sudharsan Gopalakrishnan"); // Program 2

        // Programs 3 and 4
        String familyName = "Gopalakrishnan";
        int grade = 11;
        double height = 1.4;
        boolean isBoarder = true;
        String initials = "SG";

        //Program 5
        System.out.println(familyName + " " + grade + " " + height + " " + isBoarder + " " + initials);
        System.out.println(familyName);
        System.out.println(grade);
        System.out.println(height);
        System.out.println(isBoarder);
        System.out.println(initials);

        //Program 6
        System.out.println("The student's family name is " + familyName);
        System.out.println("The student's grade is " + grade);
        System.out.println("The student's height(meters) is " + height);
        System.out.println("The student's boarder status is " + isBoarder);
        System.out.println("The student's initials are " + initials);

        //Program 7
        int answer = 27 + 36;
        System.out.println("The answer is " + answer);

        //Program 8
        int firstNumber = 2;
        int secondNumber = 8;

        System.out.println("Sum: " + firstNumber + secondNumber);
        System.out.println("Difference: " + (firstNumber - secondNumber));
        System.out.println("Product: " + firstNumber * secondNumber);

        //Program 9
        int quotientInt = firstNumber/secondNumber;
        int remainder = firstNumber % secondNumber;
        double quotientDouble = (double)firstNumber/(double)secondNumber;
        System.out.println("The integer quotient is " + quotientInt);
        System.out.println("The integer remainder is " + remainder);
        System.out.println("The double quotient is " + Math.round(quotientDouble * 100)/100.0);

        //Program 10
        final double g = 9.8;
        double mass1 = 60;
        double mass2 = 70;
        double mass3 = 80;

        System.out.println("Mass1 weight: " + mass1*g);
        System.out.println("Mass2 weight: " + mass2*g);
        System.out.println("Mass3 weight: " + mass3*g);

        //Program 11
        Scanner obj = new Scanner(System.in);

        System.out.println("Input an integer: ");
        int integer = obj.nextInt();

        System.out.println("Result: " + Math.exp(integer));

        //Program 12
        //Scanner obj2 = new Scanner(System.in);

        System.out.println("Input a double: ");
        double doubleNum = obj.nextDouble();

        System.out.println("Whole number part: " + (int)doubleNum);
        System.out.println("Decimal number part: " + (doubleNum-(int)doubleNum));

        //Program 13
        System.out.println("Enter your age: ");
        int age = obj.nextInt();
        if (age >= 13) {
            System.out.println("You can watch the Fifth Wave without parental supervision.");
        }

        //Program 14
        else if (age < 13) {
            System.out.println("You must watch the Fifth Wave with parental supervision.");
        }

        //Program 15
        //Scanner obj3 = new Scanner(System.in);

        System.out.println("Do you like salad?(yes or no): ");
        String yesNo = obj.next();

        if (yesNo.equals("no")) {
            System.out.println("Join the naan queue");
        }

        else if (yesNo.equals("yes")){
            System.out.println("Join the salad queue");
        }

        //Program 16
        String[] names = new String[2];
        int[][] scores = new int[2][3];
        int[] totalScores = new int[2];

        for (int i = 0; i < 2; i++) {
            System.out.println("Enter Student" + (i+1) + "'s Name: ");
            names[i] = obj.next();

            System.out.println("Enter first score: ");
            int score1 = obj.nextInt();
            scores[i][0] = score1;
            totalScores[i] += score1;

            System.out.println("Enter second score: ");
            int score2 = obj.nextInt();
            scores[i][1] = score2;
            totalScores[i] += score2;

            System.out.println("Enter third score: ");
            int score3 = obj.nextInt();
            scores[i][2] = score3;
            totalScores[i] += score3;
        }

        System.out.println(names[0] + "'s total score: " + totalScores[0]);
        System.out.println(names[1] + "'s total score: " + totalScores[1]);

        if (totalScores[0] > totalScores[1]) {
            System.out.println(names[0] + " has a higher score than " + names[1]);
        }

        else if (totalScores[0] < totalScores[1]) {
            System.out.println(names[1] + " has a higher score than " + names[0]);
        }

        else {
            System.out.println(names[0] + " and " + names[1] + " tied");
        }

        //Program 17
        //Scanner obj4 = new Scanner(System.in);
        System.out.println("Enter the student's grade: ");
        int studentGrade = obj.nextInt();

        System.out.println("Enter the gender of the student(m or f): ");
        char gender = obj.next().charAt(0);

        if (gender == 'm') {
            System.out.print("The student should not wear a skirt");
        }

        else if (gender == 'f') {
            System.out.print("The student should not wear a skirt");
        }

        if (studentGrade < 6) {
            System.out.print("and a blue shirt.");
        }

        else {
            System.out.print("and a green shirt.");
        }

        //Program 18
        switch (studentGrade) {
            case 1, 2, 3, 4, 5 -> System.out.println("The student should wear a light blue shirt.");
            case 6, 7, 8 -> System.out.println("The student should wear a green shirt.");
        }

        // Program 19
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter a number: ");
            int number = obj.nextInt();
            System.out.println("Your number is " + number);
        }

        // Program 20
        int total = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter a number: ");
            int number = obj.nextInt();
            total += number;
        }
        System.out.println("Total: " + total);

        //Program 21
        total = 0;
        System.out.println("Enter a number: ");
        int num = obj.nextInt();
        total += num;

        System.out.println("Do you want to enter another number?(yes or no): ");
        String enterNum = obj.next();

        while (enterNum.equals("yes")) {
            System.out.println("Enter a number: ");
            num = obj.nextInt();
            total += num;
            System.out.println("Do you want to enter another number?(yes or no): ");
            enterNum = obj.next();

            if (enterNum.equals("no")) {
                break;
            }
        }
        System.out.println("Total: " + total);

        //Program 22
        total = 0;
        System.out.println("Enter a number: ");
        num = obj.nextInt();
        total += num;

        System.out.println("Do you want to enter another number?(yes or no): ");
        enterNum = obj.next();

        int count = 0;
        while (enterNum.equals("yes")) {
            System.out.println("Enter a number: ");
            num = obj.nextInt();
            total += num;
            System.out.println("Do you want to enter another number?(yes or no): ");
            enterNum = obj.next();
            count++;
            if (enterNum.equals("no")) {
                break;
            }
        }
        System.out.println("While loop iteration count: " + count);
        System.out.println("Total: " + total);

        //Program 23
        total = 0;
        System.out.println("Enter a number: ");
        num = obj.nextInt();
        total += num;


        System.out.println("Do you want to enter another number?(yes or no): ");
        enterNum = obj.next();

        count = 0;
        while (enterNum.equals("yes")) {
            System.out.println("Enter a number: ");
            num = obj.nextInt();
            total += num;
            System.out.println("Do you want to enter another number?(yes or no): ");
            enterNum = obj.next();
            count++;
            if (enterNum.equals("no")) {
                break;
            }
        }
        System.out.println("While loop iteration count: " + count);
        System.out.println("Total: " + total);
        double average;
        if (count == 0) {
            average = total;
            System.out.println("Average: " + average);
        }
        else {
            average = total/count;
            System.out.println("Average: " + average);
        }


        //Program 24
        System.out.println("Enter a number between 1 and 100: ");
        double Number = obj.nextDouble();

        while (Number < 1 || Number > 100) {
            System.out.println("Enter a number between 1 and 100: ");
            Number = obj.nextDouble();
        }
        System.out.println("Thank you");

        //Program 25
        int numBottles = 99;
        while (numBottles > 0) {
            if (numBottles > 0) {
                if (numBottles > 1) {
                    System.out.println(numBottles + " bottles of beer on the wall");
                    System.out.println(numBottles + " bottles of beer");
                }
                else if (numBottles  == 1) {
                    System.out.println(numBottles + " bottle of beer on the wall");
                    System.out.println(numBottles + " bottle of beer");
                }
                System.out.println("Take one down and pass it down");
                numBottles--;
                if (numBottles > 1) {
                    System.out.println(numBottles + " bottles of beer on the wall");
                }
                else if (numBottles  == 1) {
                    System.out.println(numBottles + " bottle of beer on the wall");
                }
                else {
                    System.out.println("No more bottles of beer on the wall");
                }
            }
        }
    }
}

