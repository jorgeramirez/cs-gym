class Solution {

    public int splitArray(int[] nums, int m) {
        // we use dp[i][j] which hold the minimum largest subarray
        // for splitting 0..i numbers into j parts
        // our answer will be dp[nums.length-1][m];
        // dp[0][0] is 0 the rest is INF
        // to update j we can form it by splitting from k to i
        int n = nums.length;
        int[][] dp = new int[n + 1][m + 1];
        int[] sums = new int[n + 1];

        // preffix sum
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < i; k++) {
                    // sums[i] - sums[k] gives the sum of the range k..i
                    // this saves us one for loop
                    dp[i][j] =
                        Math.min(
                            dp[i][j],
                            Math.max(dp[k][j - 1], sums[i] - sums[k])
                        );
                }
            }
        }
        return dp[n][m];
    }
}
