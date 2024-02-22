/*
The program below prints a new string based on the original string and the
string that is to be removed.
 */

/*
The class below is the runner class.
 */
public class StringRemoverRunner {
    public static void main(String[] args) {
        StringRemover run = new StringRemover();
        System.out.println(run.stringRemover("xR-MxR-MHelloxR-M", "R-M"));
        System.out.println(run.stringRemover("sxsssxssxsxssexssxsesss", "xs"));
        System.out.println(run.stringRemover("fuxqwexqwertyxqwexqwertyrtyxqwertyrtyn", "qwerty"));
        System.out.println(run.stringRemover("dogdogcatddodogdogdoggog", "dog"));
    }
}

/*
The class below has the method needed for this program to work.
 */
class StringRemover {
    public String stringRemover(String s, String remove) {
        while (s.indexOf(remove) >= 0) {
            int i = s.indexOf(remove);
            if (i > 0) {
                int j = s.indexOf(remove) - 1;
                s = s.substring(0, j) + s.substring(j+remove.length()+1);
            }

            else {
                s = s.substring(0, i) + s.substring(i+remove.length());
            }
        }
        return s;
    }
}
