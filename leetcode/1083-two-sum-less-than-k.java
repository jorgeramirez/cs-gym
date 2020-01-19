class Solution {

    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int i = 0;
        int j = A.length - 1;
        int max = 0;
        while (i < j) {
            if (A[i] + A[j] < K) {
                max = Math.max(max, A[i] + A[j]);
                ++i;
            } else {
                --j;
            }
        }
        return max != 0 ? max : -1;
    }
}
