package misc;

import java.util.Collections;
import java.util.HashMap;

/**
 * Problem definition: binary-tree-max-width.png
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaxWidthBinaryTree {

    public int maxWidth(TreeNode root) {
        // 1) initialize a hashmap to accumulate the number of nodes at a given level
        // 2) do DFS and pass the hashmap and level each node's level is current level + 1
        //    2.1) a node is responsible of updating the counter for its level.
        // 3) return the highest value in the hashmap

        // Time: O(|V| + |E|)  -> #vertices #edges
        // Space: O(h)  -> h is the height
        HashMap<Integer, Integer> widthsMap = new HashMap<>();
        dfs(root, 0, widthsMap);
        return Collections.max(widthsMap.values());
    }


    public void dfs(TreeNode node, int level, HashMap<Integer, Integer> widthsMap) {
        if(node == null) {
            return;
        }

        if(widthsMap.containsKey(level)){
            widthsMap.put(level, widthsMap.get(level) + 1);
        }else{
            widthsMap.put(level, 1);
        }
        dfs(node.left, level + 1, widthsMap);
        dfs(node.right, level + 1, widthsMap);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(6);

        MaxWidthBinaryTree mwbt = new MaxWidthBinaryTree();
        System.out.println(mwbt.maxWidth(root));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}