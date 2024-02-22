/*
The program below prints new strings that start with the first letter of the
original second string and then the original first string without the last
letter.
 */

public class SwitchFirstRunner {
    public static void main(String[] args) {
        SwitchFirst run = new SwitchFirst();
        System.out.println(run.switchFirst("dog", "cats"));
        System.out.println(run.switchFirst("aplus", "pigs"));
        System.out.println(run.switchFirst("catgiraffe", "apluscompsci"));
        System.out.println(run.switchFirst("ap", "aplus"));
        System.out.println(run.switchFirst("pluscat", "dogsaplus"));
        System.out.println(run.switchFirst("  #", "#"));
        System.out.println(run.switchFirst("aplusdog#13337#", "pigaplusprogram"));
        System.out.println(run.switchFirst("code", "code1234"));
        System.out.println(run.switchFirst("plus", "wow"));
        System.out.println(run.switchFirst("catsand", "aplusdogsaplus"));
        System.out.println(run.switchFirst("7", "77777"));


    }
}

class SwitchFirst {
    public String switchFirst(String s1, String s2) {
        String newS1 = s2.substring(0,1);
        String newS2 = s1.substring(1);
        return newS1+newS2;
    }

}
