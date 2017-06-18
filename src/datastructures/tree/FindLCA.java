package datastructures.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindLCA {

    public TreeNode findLca(TreeNode root, int s, int t) {

        String curPath = String.valueOf(root.val);
        String pathToSource = buildPath(root, "", s);
        String pathToSink = buildPath(root, "", t);

        System.out.println(pathToSource);
        System.out.println(pathToSink);
        return null;
    }

    private String buildPath(TreeNode root, String curPath, int val) {
        if (root == null) {
            return null;
        }

        curPath += (">" + root.val);
        if (root.val == val) {
            return curPath;
        }

        String leftPath = buildPath(root.left, curPath, val);
        String rightPath = buildPath(root.right, curPath, val);
        if (leftPath != null) {
            return leftPath;
        }
        if (rightPath != null) {
            return rightPath;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode tree = BinaryTree.makeTree();

        FindLCA fl = new FindLCA();
        fl.findLca(tree, 4, 7);
        fl.findLca(tree, 6, 7);
    }
}
