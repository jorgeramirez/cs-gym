package misc;

import java.util.*;

/**
 * Problem definition: binary-tree-vertical-sum.png
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class VerticalSumBinaryTree {

    public int verticalSum(TreeNode root, int line) {
        // 1) determine root line
        // 2) run dfs and pass the root line information
        // Time: O(n)
        // Space O(1)
        int rootLine = getRootLine(root);
        return dfs(root, rootLine, line);
    }

    private int getRootLine(TreeNode root) {
        // This one should build an array representation of the tree (per levels, putting null for missing nodes)
        int numNodes = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            ++numNodes;
            TreeNode currentNode = queue.poll();

            if(currentNode.left != null) {
                queue.add(currentNode.left);
            }

            if(currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return (int)Math.floor((numNodes -  1) / 2);
    }

    private int dfs(TreeNode node, int nodeLine, int targetLine) {
        if(node == null) {
            return 0;
        }

        int sumLeft = dfs(node.left, nodeLine - 1, targetLine);
        int sumRight = dfs(node.right, nodeLine + 1, targetLine);

        if(nodeLine == targetLine) {
            return sumLeft + sumRight + node.val;
        }
        return sumLeft + sumRight;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(6);

        VerticalSumBinaryTree vsbt = new VerticalSumBinaryTree();
        System.out.println(vsbt.verticalSum(root, 3));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}