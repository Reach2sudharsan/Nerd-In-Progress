import static java.lang.System.*;
import java.util.Queue;
import java.util.LinkedList;

public class BSTreeRunner
{
    public static void main( String args[] )
    {
        //add in test code
        BinarySearchTree test = new BinarySearchTree();

        test.add(14);
        test.add(2);
        test.add(12);
        test.add(16);
        test.add(19);
        test.add(1);
        test.add(15);

        out.println(test);
        test.inOrder();
        test.preOrder();
        test.postOrder();
        test.revOrder();
        out.println(test.getNumLevels());
        out.println(test.numLeaves());
        out.println(test.width());
        out.println(test.height());
        out.println(test.numNodes());
        out.println(test.ifFull());
        test.makeEmpty();
        out.println(test);
    }
}

class TreeNode<T extends Comparable<T>> implements Treeable<T>
{
    private T treeNodeValue;
    private TreeNode<T> leftTreeNode;
    private TreeNode<T> rightTreeNode;

    public TreeNode( )
    {
        treeNodeValue = null;
        leftTreeNode = null;
        rightTreeNode = null;
    }

    public TreeNode(T value)
    {
        treeNodeValue = value;
        leftTreeNode = null;
        rightTreeNode = null;
    }

    public TreeNode(T value, TreeNode<T> left, TreeNode<T> right)
    {
        treeNodeValue = value;
        leftTreeNode = left;
        rightTreeNode = right;
    }

    public T getValue()
    {
        return treeNodeValue;
    }

    public TreeNode<T> getLeft()
    {
        return leftTreeNode;
    }

    public TreeNode<T> getRight()
    {
        return rightTreeNode;
    }

    public void setValue(T value)
    {
        treeNodeValue = value;
    }

    public void setLeft(Treeable<T> left)
    {
        leftTreeNode = (TreeNode<T>)left;
    }

    public void setRight(Treeable<T> right)
    {
        rightTreeNode = (TreeNode<T>)right;
    }
}

class BinarySearchTree<T extends Comparable<T>>
{
    private TreeNode<T> root;

    public BinarySearchTree()
    {
        root = null;
    }

    public void makeEmpty(){
        root = null;
    }

    public void add(T val)
    {
        root = add(val, root);
    }

    private TreeNode<T> add(T val, TreeNode<T> tree)
    {
        if(tree == null)
            tree = new TreeNode<T>(val);

        T treeValue = tree.getValue();
        int dirTest = val.compareTo(treeValue);

        if(dirTest < 0)
            tree.setLeft(add(val, tree.getLeft()));
        else if(dirTest > 0)
            tree.setRight(add(val, tree.getRight()));

        return tree;
    }

    public void inOrder()
    {
        inOrder(root);
        System.out.println("\n\n");
    }

    private void inOrder(TreeNode tree)
    {
        if (tree != null){
            inOrder(tree.getLeft());
            System.out.print(tree.getValue() + " ");
            inOrder(tree.getRight());
        }
    }

    //add in pre, post, level, and rev order traversals

    public void preOrder() {
        preOrder(root);
        out.println();
    }

    private void preOrder(TreeNode<T> tree) {
        if (tree != null) {
            out.print(tree.getValue() + " ");
            preOrder(tree.getLeft());
            preOrder(tree.getRight());
        }
    }

    public void postOrder() {
        postOrder(root);
        out.println();
    }

    private void postOrder(TreeNode<T> tree) {
        if (tree != null) {
            preOrder(tree.getLeft());
            preOrder(tree.getRight());
            out.print(tree.getValue() + " ");
        }
    }

    public void revOrder()
    {
        revOrder(root);
        System.out.println("\n\n");
    }

    private void revOrder(TreeNode tree)
    {
        if (tree != null){
            revOrder(tree.getRight());
            System.out.print(tree.getValue() + " ");
            revOrder(tree.getLeft());
        }
    }

    public int getNumLevels()
    {
        return getNumLevels(root);
    }

    private int getNumLevels(TreeNode tree)
    {
        if(tree==null)
            return 0;
        else if(getNumLevels(tree.getLeft())>getNumLevels(tree.getRight()))
            return 1+getNumLevels(tree.getLeft());
        else
            return 1+getNumLevels(tree.getRight());
    }

    //add in numLeaves, width, height, numNodes, ifFull etc
    public int numLeaves() {
        return numLeaves(root);
    }

    private int numLeaves(TreeNode<T> tree) {
        if (tree != null) {
            if (tree.getLeft() != null){
                return numLeaves(tree.getLeft()) + numLeaves(tree.getRight());
            }

            else if (tree.getRight() != null) {
                return numLeaves(tree.getRight()) + numLeaves(tree.getLeft());
            }

            else if (tree.getLeft() == null && tree.getRight() == null) {
                return 1 + numLeaves(tree.getLeft()) + numLeaves(tree.getRight());
            }
        }
        return 0;
    }

    public int width() {
        return width(root);
    }

    private int width(TreeNode<T> tree) {
        if (tree != null) {
            if (tree.getLeft() == null && tree.getRight() == null) {
                return 1 + width(tree.getLeft()) + width(tree.getRight());
            }

            if (tree.getLeft() == null || tree.getRight() == null) {
                return 2 + width(tree.getLeft()) + width(tree.getRight());
            }

            else if (tree.getLeft() != null && tree.getRight() != null) {
                return width(tree.getLeft()) + width(tree.getRight());
            }
        }
        return 0;
    }

    public int height() {
        return height(root);
    }

    private int height(TreeNode tree) {
        if(tree==null) {
            return 0;
        }
        else if(getNumLevels(tree.getLeft())>getNumLevels(tree.getRight())) {
            return 1 + getNumLevels(tree.getLeft()) - 1;
        }
        else {
            return 1 + getNumLevels(tree.getRight()) - 1;
        }
    }

    public int numNodes() {
        return numNodes(root);
    }

    private int numNodes(TreeNode<T> tree) {
        if (tree != null) {
            return 1 + numNodes(tree.getLeft()) + numNodes(tree.getRight());
        }
        return 0;
    }

    public boolean ifFull() {
        return ifFull(root);
    }

    private boolean ifFull(TreeNode<T> tree) {
        if (tree != null) {
            if (tree.getLeft() != null && tree.getRight() != null) {
                return ifFull(tree.getLeft()) && ifFull(tree.getRight());
            }
            else if (tree.getLeft() == null && tree.getRight() == null){
                return true;
            }
        }
        return false;
    }

    public String toString()
    {
        return toString(root);
    }

    private String toString(TreeNode tree)
    {
        if(tree==null)
            return "";
        else return "" + toString(tree.getLeft())+ " " + tree.getValue() + " "  + toString(tree.getRight());
    }
}

interface Treeable<T extends Comparable<T>>
{
    public Object getValue();
    public Treeable<T> getLeft();
    public Treeable<T> getRight();
    public void setValue(T value);
    public void setLeft(Treeable<T> left);
    public void setRight(Treeable<T> right);
}