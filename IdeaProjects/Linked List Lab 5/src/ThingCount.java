public class ThingCount implements Comparable
{
    private int count;
    private Object thing;

    public ThingCount()
    {
        this.thing = null;
        this.count = 0;
    }

    public ThingCount(Object thang, int cnt)
    {
        this.thing = thang;
        this.count = cnt;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int cnt)
    {
        this.count = cnt;
    }

    public void setThing(Object obj)
    {
        this.thing = obj;
    }

    public Object getThing()
    {
        return thing;
    }

    public boolean equals(Object obj)
    {
        ThingCount other = (ThingCount)obj;
        return this.thing.equals(other.thing);
    }

    public int compareTo(Object obj)
    {
        ThingCount other = (ThingCount)obj;
        return ((ThingCount) obj).compareTo(other);
    }

    public String toString()
    {
        return ""+ getThing() + " - " + getCount();
    }
}
