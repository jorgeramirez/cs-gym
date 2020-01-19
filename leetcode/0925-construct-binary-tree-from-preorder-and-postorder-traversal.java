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

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n = pre.length;
        HashMap<Integer, Integer> preMap = new HashMap<>();
        HashMap<Integer, Integer> postMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>(); // values visited

        for (int i = 0; i < pre.length; i++) {
            preMap.put(pre[i], i);
            postMap.put(post[i], i);
        }
        TreeNode root = new TreeNode(pre[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        visited.add(root.val);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            int leftPos = preMap.get(cur.val) + 1;
            int rightPos = postMap.get(cur.val) - 1;
            int leftVal = leftPos < n ? pre[leftPos] : 0;
            int rightVal = rightPos >= 0 ? post[rightPos] : 0;

            if (leftVal > 0 && !visited.contains(leftVal)) {
                TreeNode left = new TreeNode(leftVal);
                cur.left = left;
                q.add(left);
                visited.add(leftVal);
            }

            if (rightVal > 0 && !visited.contains(rightVal)) {
                TreeNode right = new TreeNode(rightVal);
                cur.right = right;
                q.add(right);
                visited.add(rightVal);
            }
        }
        return root;
    }
}
