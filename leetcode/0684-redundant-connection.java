class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return new int[] { -1, -1 };
        }
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= edges.length; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);

            if (cycleDetected(graph, u, -1, new boolean[edges.length + 1])) {
                return edge;
            }
        }
        return new int[] { -1, -1 };
    }

    boolean cycleDetected(
        List<List<Integer>> graph,
        int u,
        int parent,
        boolean[] visited
    ) {
        if (visited[u]) {
            return true;
        }
        visited[u] = true;
        for (int v : graph.get(u)) {
            if (v != parent && cycleDetected(graph, v, u, visited)) {
                return true;
            }
        }
        return false;
    }
}
