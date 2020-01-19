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

    public TreeNode lowestCommonAncestor(
        TreeNode root,
        TreeNode p,
        TreeNode q
    ) {
        Deque<TreeNode> pPath = dfs(root, p);
        Deque<TreeNode> qPath = dfs(root, q);

        boolean stop = false;
        TreeNode lca = null;

        while (!stop) {
            TreeNode pNode = pPath.pollFirst();
            TreeNode qNode = qPath.pollFirst();
            if (pNode != null && qNode != null && pNode.val == qNode.val) {
                lca = pNode;
            } else {
                stop = true;
            }
        }
        return lca;
    }

    Deque<TreeNode> dfs(TreeNode root, TreeNode target) {
        Deque<TreeNode> stack = new LinkedList<>();
        HashMap<Integer, TreeNode> parents = new HashMap<>();
        stack.push(root);
        parents.put(root.val, null);
        TreeNode node = null;

        while (!stack.isEmpty()) {
            node = stack.pop();

            if (node.val == target.val) {
                break;
            }

            if (node.left != null) {
                stack.push(node.left);
                parents.put(node.left.val, node);
            }

            if (node.right != null) {
                stack.push(node.right);
                parents.put(node.right.val, node);
            }
        }
        Deque<TreeNode> path = new LinkedList<>();
        path.add(node);
        TreeNode parent = parents.get(node.val);

        while (parent != null) {
            path.addFirst(parent);
            parent = parents.get(parent.val);
        }
        return path;
    }
}
