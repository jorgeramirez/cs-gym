class Solution {

    public int maxProfit(int[] prices) {
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
