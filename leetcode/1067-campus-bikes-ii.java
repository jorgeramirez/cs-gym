class Solution {

    public int assignBikes(int[][] workers, int[][] bikes) {
        int n = bikes.length;
        int[] dp = new int[1 << n];
        return dfs(workers, bikes, dp, 0, 0);
    }

    int dfs(int[][] workers, int[][] bikes, int[] dp, int state, int w) {
        if (w == workers.length) {
            return 0;
        }
        if (dp[state] != 0) {
            return dp[state];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < bikes.length; i++) {
            if ((state & (1 << i)) != 0) {
                continue;
            }
            int sum =
                Math.abs(workers[w][0] - bikes[i][0]) +
                Math.abs(workers[w][1] - bikes[i][1]) +
                dfs(workers, bikes, dp, state | (1 << i), w + 1);
            min = Math.min(min, sum);
        }
        dp[state] = min;
        return min;
    }
}
