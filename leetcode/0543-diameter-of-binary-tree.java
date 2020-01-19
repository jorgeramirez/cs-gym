/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int diamWithRoot = longestPath(root.left) + longestPath(root.right);
        int diameterLeft = diameterOfBinaryTree(root.left);
        int diameterRight = diameterOfBinaryTree(root.right);
        return Math.max(diamWithRoot, Math.max(diameterLeft, diameterRight));
    }

    int longestPath(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(longestPath(node.left), longestPath(node.right)) + 1;
    }
}
