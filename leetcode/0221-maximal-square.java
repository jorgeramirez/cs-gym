class Solution {

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int maxLen = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[matrix.length - 1][i] == '1') {
                dp[matrix.length - 1][i] = 1;
                maxLen = 1;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix[0].length - 1] == '1') {
                dp[i][matrix[0].length - 1] = 1;
                maxLen = 1;
            }
        }

        for (int i = matrix.length - 2; i >= 0; i--) {
            for (int j = matrix[0].length - 2; j >= 0; j--) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                dp[i][j] =
                    Math.min(
                        Math.min(dp[i + 1][j], dp[i][j + 1]),
                        dp[i + 1][j + 1]
                    ) +
                    1;
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }

        return maxLen * maxLen;
    }
}
