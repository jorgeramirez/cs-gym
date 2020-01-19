class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int MAX = amount + 1;
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        for (int sum = 1; sum <= amount; sum++) {
            for (int j = 0; j < coins.length; j++) {
                if (sum - coins[j] < 0) {
                    dp[sum] = dp[sum];
                } else {
                    dp[sum] = Math.min(dp[sum], dp[sum - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == MAX ? -1 : dp[amount];
    }
}
