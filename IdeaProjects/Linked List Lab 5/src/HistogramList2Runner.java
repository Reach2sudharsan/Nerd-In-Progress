import static java.lang.System.*;

public class HistogramList2Runner
{
    public static void main(String[] args)
    {
        HistoList test = new HistoList();
        String testString = "ABCDEFABCDEFFEDCBAAAAABBBBBCCCDAAAAAAAEEFFF";
        for(char c : testString.toCharArray())
        {
            test.add(c);
        }
        System.out.println(test);


        //add more test cases
        test = new HistoList();
        testString = "11 22 33 44 55 66 33 44 22 11 11 11 11 22 11 11 11";

        String str = "";
        int count = 0;
        for (int i = 0; i < testString.length(); i++) {
            if (testString.charAt(i) != ' ') {
                str += testString.charAt(i);
                count++;
            }
            if (count == 2) {
                test.add(Integer.parseInt(str));
                count = 0;
                str = "";
            }
        }

        System.out.println(test);

        test = new HistoList();
        testString = "1.1 2.2 3.3 4.4 5.5 6.6 3.3 4.4 2.2 1.1 1.1 1.1 1.1 2.2 1.1";

        str = "";
        count = 0;
        for (int i = 0; i < testString.length(); i++) {
            if (testString.charAt(i) != ' ') {
                str += testString.charAt(i);
                count++;
            }
            if (count == 3) {
                test.add(Double.parseDouble(str));
                count = 0;
                str = "";
            }
        }

        System.out.println(test);

        //demonstrate bad data check
        test = new HistoList();
        test.add("dog");
        test.add(33);
        test.add(3.4);
        System.out.println(test);
    }
}
