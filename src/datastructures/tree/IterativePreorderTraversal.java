package datastructures.tree;

import java.util.*;

public class IterativePreorderTraversal {

    public List<Integer> traverse(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        List<Integer> traversal = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode visit = stack.pop();
            traversal.add(visit.val);

            if (visit.left != null) {
                stack.push(visit.left);
            }

            if (visit.right != null) {
                stack.push(visit.right);
            }
        }
        return traversal;
    }

    public static void main(String[] args) {
        IterativePreorderTraversal ipt = new IterativePreorderTraversal();

        TreeNode root = BinaryTree.makeTree();
        List<Integer> traversal = ipt.traverse(root);
        System.out.println(Arrays.toString(traversal.toArray()));
    }
}
