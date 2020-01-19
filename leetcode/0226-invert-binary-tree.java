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

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int len = q.size();
            while (len-- > 0) {
                TreeNode node = q.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;
                node.left = right;
                node.right = left;

                if (left != null) {
                    q.add(left);
                }

                if (right != null) {
                    q.add(right);
                }
            }
        }
        return root;
    }
}
