class Solution {

    public int minDominoRotations(int[] A, int[] B) {
        int cA = Math.min(swaps(A, B, A[0]), swaps(B, A, A[0]));
        int cB = Math.min(swaps(A, B, B[0]), swaps(B, A, B[0]));
        if (cA == cB && cA == Integer.MAX_VALUE) {
            return -1;
        }
        return Math.min(cA, cB);
    }

    // always make A all equal (if possible)
    public int swaps(int[] A, int[] B, int target) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != target && B[i] != target) {
                res = -1;
                break;
            }
            if (A[i] != target && B[i] == target) {
                ++res;
            }
        }
        return res == -1 ? Integer.MAX_VALUE : res;
    }
}
