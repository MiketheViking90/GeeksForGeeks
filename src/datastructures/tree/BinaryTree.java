package datastructures.tree;

import java.util.*;

public class BinaryTree {

    public static TreeNode makeTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right= new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        return root;
    }

    public static void print(TreeNode root) {
        Map<Integer, List<String>> map = new HashMap<>();

        buildLevelMap(map, 0, root);

        for (int lvl : map.keySet()) {
            List<String> vals = map.get(lvl);
            System.out.println(Arrays.toString(vals.toArray()));
        }
    }

    private static void buildLevelMap(Map<Integer, List<String>> map, int level, TreeNode root) {
        List<String> curLevel = map.getOrDefault(level, new ArrayList<>());

        if (root == null) {
            curLevel.add("/");
            map.put(level, curLevel);
            return;
        }
        curLevel.add(String.valueOf(root.val));
        map.put(level, curLevel);

        buildLevelMap(map, level + 1, root.left);
        buildLevelMap(map, level + 1, root.right);
    }

    public static void main(String[] args) {
        TreeNode root = BinaryTree.makeTree();
        BinaryTree.print(root);
    }

}
