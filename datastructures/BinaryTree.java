package datastructures;

public class BinaryTree {


    public TreeNode buildFromArray(int[] nodes) {
        return null;
    }


    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int[] nodes = new int[] {1, 2, 3, 4, 5, Integer.parseInt(null), 6};
        TreeNode root = bt.buildFromArray(nodes);
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