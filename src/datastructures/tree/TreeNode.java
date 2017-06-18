package datastructures.tree;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public String toString() {
        return String.valueOf(val);
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}
