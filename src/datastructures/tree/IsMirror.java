package datastructures.tree;

public class IsMirror {

    public boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null ^ b != null) {
            return false;
        }

        boolean sameValue = (a.val == b.val);
        boolean recurMirror = isMirror(a.left, b.right) && isMirror(a.right, b.left);
        return (sameValue && recurMirror);
    }

}
