package datastructures.tree;

import java.util.*;

public class BoundaryView {

    public List<Integer> boundaryByLevel(TreeNode root) {
        Map<Integer, List<Integer>> levelValues = new HashMap<>();
        buildLevels(levelValues, 0, root);

        List<Integer> view = new ArrayList<>();
        int levels = levelValues.keySet().size();
        for (int i = 0; i < levels; i++) {
            List<Integer> curLevel = levelValues.get(i);
            view.add(curLevel.get(0));
        }

        List<Integer> bottomView = levelValues.get(levels-1);
        for (int i = 1; i < bottomView.size(); i++) {
            int leafValue = bottomView.get(i);
            view.add(leafValue);
        }

        for (int i = levels-2; i >= 1; i--) {
            List<Integer> curLevel = levelValues.get(i);
            view.add(curLevel.get(curLevel.size()-1));
        }

        return view;
    }

    private void buildLevels(Map<Integer, List<Integer>> levelValues, int lvl, TreeNode root) {
        if (root == null) {
            return;
        }

        List<Integer> curValues = levelValues.getOrDefault(lvl, new ArrayList<>());
        curValues.add(root.val);
        levelValues.put(lvl, curValues);

        buildLevels(levelValues, lvl+1, root.left);
        buildLevels(levelValues, lvl+1, root.right);
    }

    public static void main(String[] args) {
        BoundaryView bv = new BoundaryView();
        TreeNode root = BinaryTree.makeTree();

        List<Integer> view = bv.boundaryByLevel(root);
        BinaryTree.print(root);
        System.out.println(Arrays.toString(view.toArray()));
    }
}
