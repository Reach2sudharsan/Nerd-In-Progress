public class ThingTester
{
    public static void main(String[] args)
    {
        ThingCount one = new ThingCount();
        ThingCount two = new ThingCount('A',5);

        System.out.println(one);
        System.out.println(two);

        ThingCount three = new ThingCount("hello", 7);
        System.out.println(three);

        System.out.println(three.getCount());
        three.setCount(22);
        three.setThing(54.12);
        System.out.println(three);

        System.out.println(three.equals(two));
        two.setCount(22);
        two.setThing(54.12);
        System.out.println(two.equals(three));

        System.out.println(three.compareTo(two));
        two.setCount(11);
        two.setThing(14.12);
        System.out.println(two.compareTo(three));
        System.out.println(three.compareTo(two));
    }
}

class ThingCount implements Comparable
{
    private int count;
    private Object thing;

    public ThingCount()
    {
        count = 0;
        thing = null;
    }

    public ThingCount(Object thang, int cnt)
    {
        thing = thang;
        count = cnt;
    }

    public void setThing(Object obj)
    {
        thing = obj;
    }

    public void setCount(int cnt)
    {
        count = cnt;
    }

    public Object getThing()
    {
        return thing;
    }

    public int getCount()
    {
        return count;
    }

    public boolean equals(Object obj)
    {
        ThingCount other = (ThingCount)obj;
        return thing.equals(other.thing);
    }

    public int compareTo(Object obj)
    {
        ThingCount other = (ThingCount)obj;
//        return ((ThingCount)obj).compareTo(other);
        if ((new ThingCount(thing, count)).equals(other)) {
            return 0;
        }
        else if (toString().compareTo(other.toString()) > 0) {
            return 1;
        }
        else {
            return -1;
        }
    }

    public String toString()
    {
        return ""+thing + " - " + count;
    }
}
