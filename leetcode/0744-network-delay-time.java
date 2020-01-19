class Solution {

    public int networkDelayTime(int[][] times, int N, int K) {
        int[] delays = new int[N + 1];
        Arrays.fill(delays, -1);

        // u,v => w
        int[][] graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(graph[i], -1);
        }

        for (int i = 0; i < times.length; i++) {
            int[] node = times[i];
            graph[node[0]][node[1]] = node[2];
        }
        delays[K] = 0;
        dfs(graph, delays, K);
        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (delays[i] == -1) {
                return -1;
            }
            max = Math.max(max, delays[i]);
        }
        return max;
    }

    void dfs(int[][] graph, int[] delays, int u) {
        for (int v = 1; v < graph.length; v++) {
            if (graph[u][v] < 0) {
                continue;
            }
            int newDelay = graph[u][v] + delays[u];
            if (delays[v] == -1 || newDelay < delays[v]) {
                delays[v] = newDelay;
                dfs(graph, delays, v);
            }
        }
    }
}
