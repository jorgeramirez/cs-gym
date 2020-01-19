/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {

    public Node cloneGraph(Node node) {
        HashMap<Integer, Node> map = buildMap(node);
        Set<Integer> seen = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            int len = q.size();
            while (len-- > 0) {
                Node current = q.poll();
                Node clone = map.get(current.val);
                if (current.neighbors == null) {
                    continue;
                }
                clone.neighbors = new ArrayList<>();
                seen.add(current.val);

                for (Node nei : current.neighbors) {
                    clone.neighbors.add(map.get(nei.val));

                    if (seen.contains(nei.val)) {
                        continue;
                    }
                    q.add(nei);
                }
            }
        }
        return map.get(node.val);
    }

    HashMap<Integer, Node> buildMap(Node root) {
        // BFS to populate the map
        HashMap<Integer, Node> map = new HashMap<>();
        Set<Integer> seen = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int len = q.size();
            while (len-- > 0) {
                Node current = q.poll();
                Node clone = new Node();
                clone.val = current.val;
                map.put(clone.val, clone);
                seen.add(current.val);

                if (current.neighbors == null) {
                    continue;
                }

                for (Node nei : current.neighbors) {
                    if (seen.contains(nei.val)) {
                        continue;
                    }
                    q.add(nei);
                }
            }
        }
        return map;
    }
}
