// https://leetcode.com/problems/maximum-width-of-binary-tree/

import misc.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        // 1) use a queue to do BFS
        // 2) encode the position of each node left = 2 * pos, right = 2 * pos + 1. Position of root = 0.
        // 3) at a given depth, the first node that gets out of the queue, is the leftmost, so we store the left and compute the distance with every other node at
        //    the same level
        Queue<TreeNodeMetadata> queue = new LinkedList<>();
        TreeNodeMetadata rootMeta = new TreeNodeMetadata(root, 0, 0);
        queue.add(rootMeta);
        TreeNodeMetadata currentNode;
        int left = 0;
        int currentDepth = 0;
        int maxWidth = 0;

        while(!queue.isEmpty()) {
            currentNode = queue.poll();

            if(currentNode.node == null) {
                continue;
            }
            queue.add(new TreeNodeMetadata(currentNode.node.left, currentNode.depth + 1, currentNode.position * 2));
            queue.add(new TreeNodeMetadata(currentNode.node.right, currentNode.depth + 1, currentNode.position * 2 + 1));

            if(currentDepth != currentNode.depth) {
                currentDepth = currentNode.depth;
                left = currentNode.position;
            }
            maxWidth = Math.max(maxWidth, currentNode.position - left + 1);
        }
        return maxWidth;
    }


    public static class TreeNodeMetadata {
        TreeNode node;
        Integer position;
        Integer depth;

        public TreeNodeMetadata(TreeNode node, Integer depth, Integer position) {
            this.node = node;
            this.depth = depth;
            this.position = position;
        }
    }


    public static void main(String[] args) {
        MaxWidthBinaryTree mwbt = new MaxWidthBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        System.out.println(mwbt.widthOfBinaryTree(root));

        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(7);
        System.out.println(mwbt.widthOfBinaryTree(root));
    }
}
