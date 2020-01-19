class Solution {

    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;

        if (k > n) {
            return maxProfitGreedy(prices);
        }
        int[][] profit = new int[k + 1][n];

        for (int t = 1; t <= k; t++) {
            int maxPrevProfit = Integer.MIN_VALUE;

            for (int currentDay = 1; currentDay < n; currentDay++) {
                maxPrevProfit =
                    Math.max(
                        maxPrevProfit,
                        -prices[currentDay - 1] + profit[t - 1][currentDay - 1]
                    );
                profit[t][currentDay] =
                    Math.max(
                        profit[t][currentDay - 1],
                        prices[currentDay] + maxPrevProfit
                    );
            }
        }

        return profit[k][n - 1];
    }

    public int maxProfitGreedy(int prices[]) {
        if (prices.length == 0) {
            return 0;
        }
        int totalProfit = 0;
        int maxAvail = prices[prices.length - 1];
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] < maxAvail) {
                totalProfit += maxAvail - prices[i];
            }
            maxAvail = prices[i];
        }
        return totalProfit;
    }
}
