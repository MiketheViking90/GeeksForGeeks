package datastructures.tree;

public class CheckBST {

    public boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        boolean isLeftBST = isBST(root.left);
        boolean isRightBST = isBST(root.right);
        boolean isBST = false;
        if (root.left != null) {
            isBST &= (root.left.val < root.val);
        }
        if (root.right != null) {
            isBST &= (root.right.val >= root.val);
        }

        return isLeftBST & isRightBST & isBST;
    }
}
