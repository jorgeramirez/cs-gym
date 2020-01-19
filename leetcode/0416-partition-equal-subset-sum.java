class Solution {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[half + 1][n + 1];

        // top row is true
        for (int i = 0; i <= n; i++) {
            dp[0][i] = true;
        }

        // first column is false (except the first cell)
        for (int i = 1; i <= half; i++) {
            dp[i][0] = false;
        }

        // we start our main loop
        for (int i = 1; i <= half; i++) {
            for (int j = 1; j <= n; j++) {
                boolean ans = false;
                if (dp[i][j - 1]) {
                    ans = true;
                } else if (i - nums[j - 1] >= 0 && dp[i - nums[j - 1]][j - 1]) {
                    ans = true;
                }
                dp[i][j] = ans;
            }
        }
        return dp[half][n];
    }
}
