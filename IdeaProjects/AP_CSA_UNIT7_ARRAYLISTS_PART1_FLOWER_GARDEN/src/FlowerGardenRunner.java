/*
The program below allows the user to create a flower garden
ArrayList that stores different flowers and how many of each there are.
It also allows the user to use different methods to receive information
about their flower garden such as the flower that is present in the flower
garden the most.
 */
import java.util.ArrayList;

/*
The class below is the runner class.
 */
public class FlowerGardenRunner {

    public static void main(String[] args) {
        FlowerGarden fg = new FlowerGarden();

        fg.addFlower( "daisy" );
        fg.addFlower( "rose" );
        fg.addFlower( "poppy" );
        fg.addFlower( "sunflower" );
        fg.addFlower( "daisy" );
        System.out.println( fg );
        System.out.println( fg.findFlower( "daisy" ) );
        System.out.println( fg.findFlower( "orchid" ) );
        System.out.println( fg.getCount( "daisy" ) );
        System.out.println( fg.getCount( "orchid" ) );
        System.out.println( fg.getFlowerName( 0 ) );
        System.out.println( fg.getFlowerName( 9 ) );
        System.out.println( fg.maxFlower() );
        fg.addFlower( "daisy" );
        fg.addFlower( "daisy" );
        fg.addFlower( "rose" );
        fg.addFlower( "poppy" );
        fg.addFlower( "daisy" );
        fg.addFlower( "lily" );
        fg.addFlower( "lily" );
        fg.addFlower( "gardenia" );
        fg.addFlower( "rose" );
        fg.addFlower( "poppy" );
        fg.addFlower( "gardenia" );
        fg.addFlower( "daisy" );
        fg.addFlower( "lily" );
        System.out.println( fg );
        System.out.println( fg.findFlower( "lily" ) );
        System.out.println( fg.findFlower( "orchid" ) );
        System.out.println( fg.getCount( "daisy" ) );
        System.out.println( fg.getCount( "orchid" ) );
        System.out.println( fg.getFlowerName( 3 ) );
        System.out.println( fg.getFlowerName( 15 ) );
        System.out.println( fg.maxFlower() );
    }
}

/*
The class below has all the methods for this program to work.
 */
class FlowerGarden {

    private ArrayList<String> garden;

    public FlowerGarden() {
        garden = new ArrayList<String>();
    }

    public void addFlower(String flower) {
       int position = findFlower(flower);

       if (position == -1) {
           garden.add("01 " + flower);
       }

       else {
           int count = getCount(flower);
           garden.remove(position);
           count++;

           if (count < 10) {
               garden.add("0" + count + " " + flower);
           }

           else {
               garden.add(count + " " + flower);
           }
       }
    }

    public int getCount(String flower) {
        int position = findFlower(flower);
        if (position != -1) {
            return Integer.parseInt(garden.get(position).substring(0,2));
        }
        return 0;
    }
    
    public int findFlower(String flower) {
        for (int i = 0; i < garden.size(); i++) {
            if (garden.get(i).contains(flower)) {
                return i;
            }
        }
        return -1;
    }

    public String getFlowerName(int position) {
        if (inRange(position)) {
                return garden.get(position).substring(3);
        }
        return "out of range";
    }

    public String maxFlower() {
        String max = garden.get(0);
        for (String flower: garden) {
            if (flower.compareTo(max)>0) {
                max = flower;
            }
        }
        return max;
    }

    public boolean inRange(int position) {
        return position >= 0 && position < garden.size();
    }

    public String toString() {
        return garden.toString();
    }
}
