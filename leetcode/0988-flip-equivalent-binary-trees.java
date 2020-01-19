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

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(root1);
        Queue<TreeNode> q2 = new LinkedList<>();
        q2.add(root2);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int len1 = q1.size();
            int len2 = q2.size();
            if (len1 != len2) {
                return false;
            }
            while (len1-- > 0) {
                TreeNode n1 = q1.poll();
                TreeNode n2 = q2.poll();
                Integer n1Val = n1 != null ? n1.val : null;
                Integer n2Val = n2 != null ? n2.val : null;

                if (n1Val != n2Val) {
                    return false;
                }
                if (n1Val == null) {
                    continue;
                }

                Integer n1Left = n1.left != null ? n1.left.val : null;
                Integer n1Right = n1.right != null ? n1.right.val : null;

                Integer n2Left = n2.left != null ? n2.left.val : null;
                Integer n2Right = n2.right != null ? n2.right.val : null;

                if (n1Left == n2Left && n1Right == n2Right) {
                    q1.add(n1.left);
                    q1.add(n1.right);
                    q2.add(n2.left);
                    q2.add(n2.right);
                } else if (n1Left == n2Right && n1Right == n2Left) {
                    q1.add(n1.left);
                    q1.add(n1.right);
                    q2.add(n2.right);
                    q2.add(n2.left);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
