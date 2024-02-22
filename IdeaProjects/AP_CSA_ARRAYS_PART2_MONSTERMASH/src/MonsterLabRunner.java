/*
The program below allows the user to create and store any number
of monsters.
*/
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

/*
The class below is the runner class.
*/
public class MonsterLabRunner
{
    public static void main( String args[] )
    {
        Scanner keyboard = new Scanner(in);

        out.print("How many monsters are in the herd? :: ");
        int size = keyboard.nextInt();
        Monsters herd = new Monsters(size);

        for(int i=0; i<size;i++)
        {
            out.print("\nEnter the ht :: ");
            int ht = keyboard.nextInt();
            out.print("Enter the wt :: ");
            int wt = keyboard.nextInt();
            out.print("Enter the age :: ");
            int age = keyboard.nextInt();
            herd.add(i,new Monster(ht,wt,age));
            out.print("\n");
        }
        System.out.println("HERD :: "+herd);
        System.out.println("SMALLEST :: "+herd.getSmallest());
        System.out.println("LARGEST :: "+herd.getLargest());
    }
}

/*
The class below has the properties of a monster and some of the
methods required for the program to work.
*/
class Monster {
    private int weight;
    private int height;
    private int age;

    public Monster( int h, int w, int a )
    {
        height = h;
        weight = w;
        age = a;
    }

    //height is 1st, weight is 2nd, and age is 3rd
    public boolean isBigger( Monster other )
    {
        if( height > other.height )
            return true;
        if( height < other.height )
            return false;
        if( weight > other.weight )
            return true;
        if( weight < other.weight )
            return false;
        if( age > other.age )
            return true;
        return false;
    }

    public String toString()
    {
        return ""+ height + " " + weight + " " + age;
    }
}

/*
The class below has an array based on the previous class for
storing the data of individual monsters and other methods
required for this program to work.
*/
class Monsters
{
    private Monster[] myMonsters;

    public Monsters()
    {
        setMonsters(0);
    }

    public Monsters(int size)
    {
        setMonsters(size);
    }

    public void setMonsters(int size)
    {
        myMonsters = new Monster[size];
    }

    public void add(int spot, Monster m)
    {
        if(spot<myMonsters.length)
            myMonsters[spot]=m;
    }

    public Monster get(int spot)
    {
        return myMonsters[spot];
    }

    public Monster getLargest( )
    {
        Monster big = myMonsters[0];
        for( int i = 1; i < myMonsters.length; i++)
        {
            if( !big.isBigger( myMonsters[i] ) )
                big = myMonsters[i];
        }
        return big;
    }

    public Monster getSmallest( )
    {
        Monster small = myMonsters[0];
        for( int i = 1; i < myMonsters.length; i++)
        {
            if( small.isBigger( myMonsters[i] ) )
                small = myMonsters[i];
        }
        return small;
    }

    public String toString()
    {
        return ""+Arrays.toString(myMonsters);
    }
}


