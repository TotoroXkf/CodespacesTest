class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode leftResult = lowestCommonAncestor(root.left, p, q);
        TreeNode rightResult = lowestCommonAncestor(root.right, p, q);
        if (leftResult != null && rightResult != null) {
            return root;
        } else if (leftResult != null) {
            return leftResult;
        } else if (rightResult != null) {
            return rightResult;
        } else {
            return null;
        }
    }
}