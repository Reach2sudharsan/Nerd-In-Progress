/*
The program below allows the user to enter the age and name of
as many dogs as he or she wants, and it then prints the name of
the oldest and youngest dogs.
*/
import java.util.Arrays;
import java.util.Scanner;

/*
The class below is the runner class.
*/
public class DoggiesRunner
{
    public static void main( String[] args )
    {
        Scanner keyboard = new Scanner(System.in);
        Scanner runName = new Scanner(System.in);

        System.out.print("How many Dogs are in the pack? :: ");
        int size = keyboard.nextInt();
        Doggies pack = new Doggies(size);
        System.out.println("");
        for(int i=0; i<size;i++)
        {
            //read in age and name of the dog

            //call the method to add a new dog to the pack
            System.out.print("Enter the age :: ");
            int age = keyboard.nextInt();

            System.out.print("Enter the name :: ");
            String name = runName.nextLine();

            pack.set(i, age, name);
            System.out.println("");

        }
        System.out.println("");
        System.out.println("pack :: "+pack);

        System.out.println("");
        System.out.println("NAME OF OLDEST :: "+pack.getNameOfOldest());
        System.out.println("NAME OF YOUNGEST :: "+pack.getNameOfYoungest());
    }
}

/*
The class below has some of the methods required for this program to
work.
*/
class Dog
{
    private int age;
    private String name;

    public Dog(int a, String n)
    {
        age = a;
        name = n;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public String toString()
    {
        return "" + age + " " + name;
    }
}

/*
The class below has the array to store the dogs and the other methods
for this program to work.
*/
class Doggies
{
    private Dog[] pups;

    public Doggies(int size)
    {
        //point pups at a new array of Dog
        pups = new Dog[size];

    }

    public void set(int spot, int age, String name)
    {
        //put a new Dog in the array at spot
        //make sure spot is in bounds
        if (spot >= 0 && spot <= pups.length-1) {
            pups[spot] = new Dog(age, name);
        }
    }

    public String getNameOfOldest()
    {
        int oldest = pups[0].getAge();
        String name = null;

        for (int i = 0; i < pups.length; i++) {
            if (pups[i].getAge() > oldest) {
                oldest = pups[i].getAge();
                name = pups[i].getName();
            }
        }
        return name;
    }

    public String getNameOfYoungest()
    {
        int youngest = pups[0].getAge();
        String name = null;

        for (int i = 0; i < pups.length; i++) {
            if (pups[i].getAge() < youngest) {
                youngest = pups[i].getAge();
                name = pups[i].getName();
            }
        }
        return name;
    }

    public String toString()
    {
        return ""+Arrays.toString(pups);
    }
}
