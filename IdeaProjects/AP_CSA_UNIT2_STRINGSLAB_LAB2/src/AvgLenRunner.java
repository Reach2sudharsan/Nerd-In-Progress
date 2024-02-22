/*
The program below prints the average length of two strings for the given strings in the
AverageLenRunner class.
 */

public class AvgLenRunner {

    public static void main(String[] args) {
        AvgLen run = new AvgLen();
        System.out.println(run.averageLen("dog", "cats"));
        System.out.println(run.averageLen("aplus", "pigs"));
        System.out.println(run.averageLen("vatgiragge", "apluscompsci"));
        System.out.println(run.averageLen("ap", "aplus"));
        System.out.println(run.averageLen("pluscat", "dogsaplus"));
        System.out.println(run.averageLen("#", "#"));
        System.out.println(run.averageLen("aplusdog#13337#", "pigaplusprogram"));
        System.out.println(run.averageLen("code", "code1234"));
        System.out.println(run.averageLen("wow", "plus "));
        System.out.println(run.averageLen("catsand", "aplusdogsaplus"));
        System.out.println(run.averageLen("7", "77777"));
    }
}

class AvgLen {
    public double averageLen(String s1, String s2) {
        double s1Length = s1.length();
        double s2Length = s2.length();
        double averageLength = (s1Length + s2Length)/2;
        return averageLength;
    }
}
