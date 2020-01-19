class Solution {

    public int shipWithinDays(int[] weights, int D) {
        int total = 0;
        int max = 0;
        for (int i = 0; i < weights.length; i++) {
            total += weights[i];
            max = Math.max(max, weights[i]);
        }
        int start = max;
        int end = total;
        while (start <= end) {
            int guess = (start + end) / 2;
            int days = getDays(weights, guess);
            if (days > D) {
                start = guess + 1;
            } else {
                end = guess - 1;
            }
        }
        return start;
    }

    int getDays(int[] weights, int capacity) {
        int days = 1;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            if (sum + weights[i] > capacity) {
                sum = weights[i];
                ++days;
            } else {
                sum += weights[i];
            }
        }
        return days;
    }
}
