package datastructures.tree;

public class NoSibling {

    public void printNoSibling(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right != null) {
            System.out.println(root.right.val);
            printNoSibling(root.right);
        } else if (root.left != null && root.right == null) {
            System.out.println(root.left.val);
            printNoSibling(root.left);
        } else {
            printNoSibling(root.right);
            printNoSibling(root.left);
        }
    }

    public static void main(String[] args) {
        TreeNode root = BinaryTree.makeTree();
        NoSibling ns = new NoSibling();
        root.left.left.right = new TreeNode(12);
        root.left.left.right.left = new TreeNode(13);
        ns.printNoSibling(root);
    }
}
