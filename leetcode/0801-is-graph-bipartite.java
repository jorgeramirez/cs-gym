class Solution {

    public boolean isBipartite(int[][] graph) {
        if (graph.length == 1) {
            return true;
        }
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);

        for (int node = 0; node < graph.length; node++) {
            if (colors[node] != -1) {
                continue;
            }
            colors[node] = 1; // colors 1 or 2
            Queue<Integer> q = new LinkedList<>();
            q.add(node);
            while (!q.isEmpty()) {
                int len = q.size();
                while (len-- > 0) {
                    int parent = q.poll();
                    int neiColor = colors[parent] == 1 ? 2 : 1;

                    for (int nei : graph[parent]) {
                        if (colors[nei] != -1 && colors[nei] != neiColor) {
                            return false;
                        }
                        if (colors[nei] == -1) {
                            colors[nei] = neiColor;
                            q.add(nei);
                        }
                    }
                }
            }
        }
        return true;
    }
}
