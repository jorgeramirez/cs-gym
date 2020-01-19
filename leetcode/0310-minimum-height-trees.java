class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> roots = new ArrayList<>();
        if (n == 0) {
            return roots;
        }
        if (n == 1) {
            roots.add(0);
            return roots;
        }

        List<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[] degrees = new int[n];
        Queue<Integer> leaves = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            degrees[i] = graph[i].size();
            if (degrees[i] == 1) {
                leaves.add(i);
            }
        }

        int count = n;
        while (count > 2) {
            count -= leaves.size();
            int len = leaves.size();
            while (len-- > 0) {
                int node = leaves.poll();
                for (int nei : graph[node]) {
                    --degrees[nei];
                    if (degrees[nei] == 1) {
                        leaves.add(nei);
                    }
                }
            }
        }
        roots.addAll(leaves);
        return roots;
    }
}
