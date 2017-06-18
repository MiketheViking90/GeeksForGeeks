package datastructures.tree;

public class RootToLeftPathSum {

    public boolean hasSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.isLeaf()) {
            return root.val == sum;
        }

        return hasSum(root.left, sum - root.val) || hasSum(root.right, sum - root.val);
    }

}
