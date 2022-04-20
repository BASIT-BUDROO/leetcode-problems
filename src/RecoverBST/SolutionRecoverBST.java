package RecoverBST;

public class SolutionRecoverBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    private TreeNode A = null;
    private TreeNode B = null;
    private TreeNode C = null;
    private TreeNode D = null;
    private int count = 1;

    private void inOrder(TreeNode node) {

        if (node == null) {
            return;
        }
        inOrder(node.left);
        //  prev       curr
        if (prev.val < node.val) {
            prev = node;
        }
        // First Violation
        else if (prev.val > node.val && count == 1) {
            A = prev;
            B = node;
            prev = node;
            count++;
        }
        // Second Violation
        else if (prev.val > node.val && count == 2) {
            C = prev;
            D = node;
            prev = node;
            count++;
        }
        //
        inOrder(node.right);
    }

    public void recoverTree(TreeNode root) {
        inOrder(root);
        if ((C == null && D == null) && (A != null && B != null)) {
            int temp = A.val;
            A.val = B.val;
            B.val = temp;
        } else if (A != null && D != null) {
            int temp = A.val;
            A.val = D.val;
            D.val = temp;
        }
    }
}
