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
    List<TreeNode> candidates = new ArrayList<>();

    public boolean isSubtree(TreeNode s, TreeNode t) {
        traverse(s, t);
        for (TreeNode root : candidates) {
            if (equals(root, t)) {
                return true;
            }
        }
        return false;
    }

    void traverse(TreeNode source, TreeNode target) {
        if (source == null) {
            return;
        }
        if (source.val == target.val) {
            candidates.add(source);
        }
        traverse(source.left, target);
        traverse(source.right, target);
    }

    boolean equals(TreeNode nodeInS, TreeNode nodeInT) {
        if (nodeInS == null && nodeInT == null) {
            return true;
        }
        if (nodeInS == null && nodeInT != null) {
            return false;
        }
        if (nodeInS != null && nodeInT == null) {
            return false;
        }

        if (nodeInS.val != nodeInT.val) {
            return false;
        }

        boolean isSubTree = equals(nodeInS.left, nodeInT.left);

        if (!isSubTree) {
            return false;
        }

        return equals(nodeInS.right, nodeInT.right);
    }
}
