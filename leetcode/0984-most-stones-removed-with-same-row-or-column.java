class Solution {

    public int removeStones(int[][] stones) {
        int n = stones.length;
        Set<Integer> visited = new HashSet<>();
        int c = 0;
        while (visited.size() < n) {
            for (int i = 0; i < stones.length; i++) {
                if (visited.contains(i)) {
                    continue;
                }
                findConnected(i, stones, visited);
                ++c;
            }
        }
        return stones.length - c;
    }

    void findConnected(int index, int[][] stones, Set<Integer> visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        while (!q.isEmpty()) {
            int cur = q.poll();
            visited.add(cur);
            for (int i = 0; i < stones.length; i++) {
                if (visited.contains(i)) {
                    continue;
                }
                if (
                    stones[cur][0] == stones[i][0] ||
                    stones[cur][1] == stones[i][1]
                ) {
                    q.add(i);
                }
            }
        }
    }
}
