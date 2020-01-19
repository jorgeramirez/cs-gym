class Solution {

    public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length - 1;
        int max = 0;

        for (int i = -n; i <= n; i++) {
            for (int j = -n; j <= n; j++) {
                int count = 0;

                for (int k = 0; k <= n; k++) {
                    for (int l = 0; l <= n; l++) {
                        if (
                            (k + i) >= 0 &&
                            (k + i) <= n &&
                            (j + l) >= 0 &&
                            (j + l) <= n &&
                            (A[k + i][j + l] == B[k][l]) &&
                            (A[k + i][j + l] == 1)
                        ) count++;
                    }
                }

                if (count > max) max = count;
            }
        }
        return max;
    }
}
