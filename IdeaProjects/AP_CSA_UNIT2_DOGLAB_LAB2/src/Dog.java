public class Dog {


    private int age;
    private String name;


    public static void main(String[] args) {
        Dog d = new Dog("rover");

    }

    public Dog(String n) {
        age = 1;
        name = n;
    }

    public Dog(String n, int a) {
        age = a;
        name = n;
    }

    public void increaseAgeByOne() {
        age++;
    }

    public int getPeopleAge(int val) {
        return age * val;
    };

    public String getName() {
        return name;
    };








}



/*
Dog d = new Dog( &quot;rover&quot; );
System.out.println( d.getPeopleAge( 7 ) );
d.increaseAgeByOne();
d.increaseAgeByOne();
System.out.println( d.getPeopleAge( 11 ) );
System.out.println( d.getName() );
d.increaseAgeByOne();
d.increaseAgeByOne();
d.increaseAgeByOne();
d.increaseAgeByOne();
System.out.println( d.getPeopleAge( 8 ) );
Dog g = new Dog( &quot;bob&quot;, 3 );
System.out.println( g.getName() );
System.out.println( g.getPeopleAge( 5 ) );

Sample Output :
7
33
rover


Files Needed ::
Dog.java
DogRunner.java



56
bob
15
 */
