import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/discuss/interview-question/349617
public class SubtreeWithMaximumAverage {

    public TreeNode maxSubtreeAverage(TreeNode root) {
        List<AnnotatedTreeNode> children = new ArrayList<>();
        double childMax = 0;
        TreeNode childMaxNode = null;
        int sum = root.val;
        int n = 1;

        for (TreeNode child : root.children) {
            AnnotatedTreeNode aChild = dfs(new AnnotatedTreeNode(child, 0, 0));
            double childAvg = aChild.sum / aChild.n;

            if (childAvg > childMax) {
                childMax = childAvg;
                childMaxNode = child;
            }
            n += aChild.n;
            sum += aChild.sum;
        }
        double rootAvg = sum / n;

        if (rootAvg > childMax) {
            return root;
        }
        return childMaxNode;
    }

    public AnnotatedTreeNode dfs(AnnotatedTreeNode aNode) {
        if (aNode.node.children == null) {
            aNode.sum = aNode.node.val;
            aNode.n = 1;
            return aNode;
        }

        for (TreeNode child : aNode.node.children) {
            AnnotatedTreeNode aChild = dfs(new AnnotatedTreeNode(child, 0, 0));
            aNode.sum += aChild.sum;
            aNode.n += aNode.n;
        }
        aNode.sum += aNode.node.val;
        aNode.n += 1;
        return aNode;
    }

    static class TreeNode {
        public int val;
        public List<TreeNode> children;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, List<TreeNode> children) {
            this.val = val;
            this.children = children;
        }
    }

    class AnnotatedTreeNode {
        int n;
        int sum;
        TreeNode node;

        AnnotatedTreeNode(TreeNode node, int n, int sum) {
            this.node = node;
            this.n = n;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 20;
        root.children = new ArrayList<>();
        root.children.add(new TreeNode(12));
        root.children.add(new TreeNode(18));
        root.children.get(0).children = new ArrayList<>();
        root.children.get(0).children.add(new TreeNode(11));
        root.children.get(0).children.add(new TreeNode(2));
        root.children.get(0).children.add(new TreeNode(3));
        root.children.get(1).children = new ArrayList<>();
        root.children.get(1).children.add(new TreeNode(15));
        root.children.get(1).children.add(new TreeNode(8));

        SubtreeWithMaximumAverage s = new SubtreeWithMaximumAverage();
        TreeNode maxNode = s.maxSubtreeAverage(root);
        System.out.println(maxNode.val);
    }
}
