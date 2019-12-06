package datastructures;


import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {


    public TreeNode buildFromArray(int[] nodes) {
        return null;
    }

    public void printInOrder(TreeNode node) {
        // In order: left, root, right
        // if the tree is a BST then these print elements in ascending order
        // Time O(n) Space O(n)
        if(node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }

    public void printPreOrder(TreeNode node) {
        // Pre order: root, left, right
        // useful to create a copy of a Tree (because we need to create the parent first, then the children)
        // Time O(n) Space O(n)
        if(node == null) {
            return;
        }
        System.out.print(node.val + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public void printPostOrder(TreeNode node) {
        // Post Order: Left, Right, Root
        // use full to delete a Tree (because we remove the children first and then the parent)
        // Time O(n) Space O(n)
        if(node == null) {
            return;
        }
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.val + " ");
    }

    public void printLevelOrder(TreeNode root) {
        // Breadth-first printing
        // Time O(n) Space O(n)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode current;
        while(!queue.isEmpty()) {
            current = queue.poll();
            System.out.print(current.val + " ");

            if(current.left != null) {
                queue.add(current.left);
            }

            if(current.right != null) {
                queue.add(current.right);
            }
        }
    }


    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        //int[] nodes = new int[] {1, 2, 3, 4, 5, Integer.parseInt(null), 6};
        //TreeNode root = bt.buildFromArray(nodes);

// Input tree
//                 1
//                / \
//               3   2
//              /     \
//             5       9
//            /         \
//           6           7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(7);


        System.out.println("In order");
        bt.printInOrder(root);
        System.out.println("\nPre order");
        bt.printPreOrder(root);
        System.out.println("\nPost order");
        bt.printPostOrder(root);
        System.out.println("\nLevel ordering");
        bt.printLevelOrder(root);
    }

    public static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        private int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}