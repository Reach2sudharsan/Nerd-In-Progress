/*
The program below says if a message is not liked, kind of liked, or is trending.
 */

/*
The class below is the runner class.
 */
public class TweetRunner {
    public static void main(String[] args) {
        Tweet sample = new Tweet("aplus", 0, 0);
        sample.addLikes(3);
        sample.addRetweets(28);
        System.out.println(sample.notLiked());
        System.out.println(sample.kindaLiked());
        sample.addLikes(35);
        System.out.println(sample.kindaLiked());
        System.out.println(sample.isTrending());
        sample.addLikes(13);
        sample.addRetweets(47);
        System.out.println(sample.notLiked());
        System.out.println(sample.kindaLiked());
        System.out.println(sample.isTrending());
        System.out.println(sample);
    }
}

/*
The class below is the "Tweet" class, which has all the methods to do what the program is required
to do.
 */
class Tweet {

    private String message;
    private int retweets;
    private int likes;

    public Tweet(String m, int r, int lk) {
        message = m;
        retweets = r;
        likes = lk;
    }

    public void addLikes(int n) {
        likes += n;
    }

    public void addRetweets(int n) {
        retweets += n;
    }

    public boolean notLiked() {
        if(likes < 10) {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean kindaLiked() {
        if(likes > retweets) {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isTrending() {
        if((retweets + likes) > 75) {
            return true;
        }

        else {
            return false;
        }
    }

    public String toString() {
        Integer rt = retweets;
        Integer lk = likes;
        return "msg " + message + " rt " + rt.toString() + " lk " + lk.toString();


    }


}
