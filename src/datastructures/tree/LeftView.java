package datastructures.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeftView {

    public List<Integer> leftView(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();

        generateLeftView(map, 0, root);
        System.out.println(map);

        List<Integer> view = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            view.add(e.getValue());
        }
        return view;
    }

    private void generateLeftView(Map<Integer, Integer> map, int lvl, TreeNode root) {
        if (map.containsKey(lvl) || root == null) {
            return;
        }

        map.put(lvl, root.val);

        generateLeftView(map, lvl+1, root.left);
        generateLeftView(map, lvl+1, root.right);
    }

    public static void main(String[] args) {
        TreeNode root = BinaryTree.makeTree();
        LeftView lv = new LeftView();
        lv.leftView(root);
    }
}
