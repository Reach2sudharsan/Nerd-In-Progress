/*
The program below outputs new strings based on the original strings, where
the new strings do not include a character at the specific index given for
each string.
 */

public class LeaveOutRunner {
    public static void main(String[] args) {
        LeaveOut run = new LeaveOut();
        System.out.println(run.leaveOut("dog", 1));
        System.out.println(run.leaveOut("aplus", 2));
        System.out.println(run.leaveOut("catgiraffe", 3));
        System.out.println(run.leaveOut("ap", 1));
        System.out.println(run.leaveOut("pluscat", 4));
        System.out.println(run.leaveOut("aplusdog#13337#", 9));
        System.out.println(run.leaveOut("code", 2));
        System.out.println(run.leaveOut("wow", 1));
        System.out.println(run.leaveOut("catsand", 0));
    }
}

class LeaveOut {
    public String leaveOut(String s, int i) {
        String s1 = s.substring(0, i);
        String s2 = s.substring(i);
        String s3 = s2.substring(1);
        return s1 + s3;
    }
}
