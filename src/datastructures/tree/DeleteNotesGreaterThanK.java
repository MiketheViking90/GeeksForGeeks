package datastructures.tree;

public class DeleteNotesGreaterThanK {

    public void pruneTree(TreeNode root, int k) {
        pruneTreeR(root, k);
    }

    public TreeNode pruneTreeR(TreeNode root, int k) {
        if (root == null) {
            return null;
        }

        if (root.val < k) {
            root.left = pruneTreeR(root.left, k);
            root.right = pruneTreeR(root.right, k);
        } else {
            root.right = pruneTreeR(root.right, k);
            root = pruneTreeR(root.left, k);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = BinaryTree.makeTree();
        DeleteNotesGreaterThanK dn = new DeleteNotesGreaterThanK();
        BinaryTree.print(root);
        dn.pruneTree(root, 6);
        BinaryTree.print(root);
    }
}
