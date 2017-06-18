package datastructures.tree;

public class SumTree {

    public boolean isSumTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean isLeftSumTree = isSumTree(root.left);
        boolean isRightSumTree = isSumTree(root.right);

        int curVal = root.val;
        int leftVal = (root.left == null) ? 0 : (root.left.val);
        int rightVal = (root.right == null) ? 0 : (root.right.val);
        boolean isRootSumTree = (curVal == (leftVal + rightVal));

        return isLeftSumTree && isRightSumTree && isRootSumTree;
    }
}
