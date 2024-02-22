import static java.lang.System.out;

public class HistoTreeRunner2
{
    public static void main(String[] args)
    {
        //A A A A B V S E A S A A V S E A
        HistoTree2 test = new HistoTree2();
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



        test = new HistoTree2();
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


        test = new HistoTree2();
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

class HistoTree2
{
    private TreeNode2 root;

    public HistoTree2( )
    {
        root = null;
    }

    public void addData(Comparable data)
    {
        TreeNode2 tree = search(data);
        if (tree != null) {
            ((ThingCount)tree.getValue()).setCount(((ThingCount)tree.getValue()).getCount()+1);
        }
        else {
            root = add(new ThingCount(data, 1), root);
        }
    }

    private TreeNode2 add(Comparable data, TreeNode2 tree)
    {
        if(tree == null)
            tree = new TreeNode2(data, null, null);

        ThingCount treeValue = (ThingCount)tree.getValue();
        ThingCount dt = (ThingCount)data;

        int dirTest = ((Comparable)dt.getThing()).compareTo((Comparable)treeValue.getThing());

        if(dirTest < 0)
            tree.setLeft(add(data, tree.getLeft()));
        else if(dirTest > 0)
            tree.setRight(add(data, tree.getRight()));

        return tree;
    }

    private TreeNode2 search(Comparable data)
    {
        return search(data, root);
    }

    private TreeNode2 search(Comparable data, TreeNode2 tree)
    {
        if (tree == null || data.compareTo(((ThingCount)tree.getValue()).getThing()) == 0)
            return tree;
        return search(data, data.compareTo(((ThingCount)tree.getValue()).getThing()) > 0 ? tree.getRight() : tree.getLeft());
    }

    public String toString()
    {
        return toString(root);
    }

    private String toString(TreeNode2 tree)
    {
        if (tree != null) {
            toString(tree.getLeft());
            out.print(tree.getValue() + "  ");
            toString(tree.getRight());
        }
        return "";    }
}

class TreeNode2 implements Treeable2
{
    private Comparable treeNodeValue;
    private TreeNode2 leftTreeNode;
    private TreeNode2 rightTreeNode;

    public TreeNode2( )
    {
        treeNodeValue = null;
        leftTreeNode = null;
        rightTreeNode = null;
    }

    public TreeNode2(Comparable value)
    {
        treeNodeValue = value;
        leftTreeNode = null;
        rightTreeNode = null;
    }

    public TreeNode2(Comparable value, TreeNode2 left, TreeNode2 right)
    {
        treeNodeValue = value;
        leftTreeNode = left;
        rightTreeNode = right;
    }

    public Comparable getValue()
    {
        return treeNodeValue;
    }

    public TreeNode2 getLeft()
    {
        return leftTreeNode;
    }

    public TreeNode2 getRight()
    {
        return rightTreeNode;
    }

    public void setValue(Comparable value)
    {
        treeNodeValue = value;
    }

    public void setLeft(Treeable2 left)
    {
        leftTreeNode = (TreeNode2)left;
    }

    public void setRight(Treeable2 right)
    {
        rightTreeNode = (TreeNode2)right;
    }
}

interface Treeable2
{
    public Object getValue();
    public Treeable2 getLeft();
    public Treeable2 getRight();
    public void setValue(Comparable value);
    public void setLeft(Treeable2 left);
    public void setRight(Treeable2 right);
}
