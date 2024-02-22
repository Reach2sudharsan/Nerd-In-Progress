import static java.lang.System.*;

public class HistoTreeRunner
{
    public static void main(String[] args)
    {
        HistoTree test = new HistoTree();
        test.addData('A');
        test.addData('A');
        test.addData('A');
        test.addData('A');
        test.addData('B');
        test.addData('V');
        test.addData('S');
        test.addData('E');
        test.addData('A');
        test.addData('S');
        test.addData('A');
        test.addData('A');
        test.addData('V');
        test.addData('S');
        test.addData('E');
        test.addData('A');
        System.out.println(test);

        test = new HistoTree();
        test.addData(1);
        test.addData(2);
        test.addData(3);
        test.addData(11);
        test.addData(22);
        test.addData(32);
        test.addData(1);
        test.addData(22);
        test.addData(13);
        System.out.println(test);

        test = new HistoTree();
        test.addData("abc");
        test.addData("ead");
        test.addData("xyz");
        test.addData("xyz");
        test.addData("abc");
        test.addData("ead");
        test.addData("abc");
        test.addData("2342");
        test.addData("x2y2z");
        System.out.println(test);
    }
}

class HistoTree
{
    private HistoNode root;

    public HistoTree( )
    {
        root = null;
    }

    public void addData(Comparable data)
    {
        HistoNode tree = search(data);
        if (tree != null) {
            tree.setDataCount(tree.getDataCount()+1);
        }
        else {
            root = add(data, root);
        }
    }

    private HistoNode add(Comparable data, HistoNode tree)
    {
        if(tree == null)
            tree = new HistoNode(data, 1, null, null);

        Comparable treeValue = tree.getData();
        int dirTest = data.compareTo(treeValue);

        if(dirTest < 0)
            tree.setLeft(add(data, tree.getLeft()));
        else if(dirTest > 0)
            tree.setRight(add(data, tree.getRight()));

        return tree;
    }

    public HistoNode search(Comparable data)
    {
        return search(data, root);
    }

    private HistoNode search(Comparable data, HistoNode tree)
    {
        if (tree == null || data.compareTo(tree.getData()) == 0)
            return tree;
        return search(data, data.compareTo(tree.getData()) > 0 ? tree.getRight() : tree.getLeft());
    }

    public String toString()
    {
        return toString(root);
    }

    private String toString(HistoNode tree)
    {
        if (tree != null) {
            out.print(tree.getData() + " - " + tree.getDataCount() + "  ");
            toString(tree.getLeft());
            toString(tree.getRight());
        }
        return "";
    }
}

class HistoNode
{
    private Comparable data;
    private int dataCount;
    private HistoNode left;
    private HistoNode right;

    public HistoNode(Comparable d, int cnt, HistoNode lft, HistoNode rt)
    {
        data=d;
        dataCount=cnt;
        left=lft;
        right=rt;
    }

    public Comparable getData()
    {
        return data;
    }

    public int getDataCount()
    {
        return dataCount;
    }

    public HistoNode getLeft()
    {
        return left;
    }

    public HistoNode getRight()
    {
        return right;
    }

    public void setData(Comparable d)
    {
        data=d;
    }

    public void setDataCount(int cnt)
    {
        dataCount=cnt;
    }

    public void setLeft(HistoNode lft)
    {
        left=lft;
    }

    public void setRight(HistoNode rt)
    {
        right=rt;
    }
}
