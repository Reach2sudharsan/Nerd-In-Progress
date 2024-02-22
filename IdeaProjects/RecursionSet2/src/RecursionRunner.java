import static java.lang.System.*;

public class RecursionRunner
{
    public static void main(String args[])
    {
        //add more test cases
        // Lab 1
        System.out.println(RecursionFunOne.countEvenDigits(4532));
        System.out.println(RecursionFunOne.countEvenDigits(11145322));
        System.out.println(RecursionFunOne.countEvenDigits(224532714));
        System.out.println(RecursionFunOne.countEvenDigits(2468));
        System.out.println(RecursionFunOne.countEvenDigits(13579));

        // Lab 2
        out.println();

        System.out.println(RecursionFunTwo.countChickens("itatfun"));
        System.out.println(RecursionFunTwo.countChickens("itatchickenfun"));
        System.out.println(RecursionFunTwo.countChickens("chchickchickenenicken"));
        System.out.println(RecursionFunTwo.countChickens("chickchickfun"));
        System.out.println(RecursionFunTwo.countChickens("chickenbouncetheballchicken"));

        // Lab 3
        out.println();

        System.out.println(RecursionFunThree.luckyThrees(3));
        System.out.println(RecursionFunThree.luckyThrees(31332));
        System.out.println(RecursionFunThree.luckyThrees(134523));
        System.out.println(RecursionFunThree.luckyThrees(3113));
        System.out.println(RecursionFunThree.luckyThrees(13331));
        System.out.println(RecursionFunThree.luckyThrees(777337777));

        // Lab 4
        out.println();

        System.out.println(RecursionFunFour.sumOddDigits(3212123));
        System.out.println(RecursionFunFour.sumOddDigits(12345));
        System.out.println(RecursionFunFour.sumOddDigits(777));
        System.out.println(RecursionFunFour.sumOddDigits(33));
        System.out.println(RecursionFunFour.sumOddDigits(0));
        System.out.println(RecursionFunFour.sumOddDigits(222));
    }
}

class RecursionFunOne
{
    public static int countEvenDigits(int num)
    {
        if (num > 0) {
            int digit = num % 10;
            if (digit % 2 == 0) {
                return 1 + countEvenDigits(num/10);
            }
            else {
                return countEvenDigits(num/10);
            }
        }
        return 0;
    }
}

class RecursionFunTwo
{
    public static int countChickens(String word)
    {
        int i = word.indexOf("chicken");
        if (word.contains("chicken")) {
            return 1 + countChickens(word.substring(0, i) + word.substring(i+7));
        }
        return 0;
    }
}

class RecursionFunThree
{
    /* luckyThrees will return the count of 3s in the number
     * unless the 3 is at the front and then it does not count
     * 3 would return 0
     * 31332  would return 2
     * 134523 would return 2
     * 3113  would return 1
     * 13331 would return 3
     * 777337777  would return 2
     * the solution to this problem must use recursion
     */
    public static int luckyThrees( long number )
    {
        if (number > 10) {
            long digit = number % 10;
            if (digit == 3) {
                return 1 + luckyThrees(number/10);
            }
            else {
                return luckyThrees(number/10);
            }
        }
        return 0;
    }
}

class RecursionFunFour
{
    //sum all odd digits
    public static int sumOddDigits(int num)
    {
        if (num > 0) {
            int digit = num % 10;
            if (digit % 2 == 1) {
                return digit + sumOddDigits(num/10);
            }
            else {
                return sumOddDigits(num/10);
            }
        }
        return num;
    }
}
