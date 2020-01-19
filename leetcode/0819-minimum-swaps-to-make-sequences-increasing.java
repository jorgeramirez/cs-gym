class Solution {

    public int minSwap(int[] A, int[] B) {
        int[] swaps = new int[A.length];
        int[] keep = new int[A.length];
        swaps[0] = 1;

        for (int i = 1; i < A.length; i++) {
            swaps[i] = Integer.MAX_VALUE;
            keep[i] = Integer.MAX_VALUE;

            // the sequence is strictly increasing
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                // we swap i too to make the rule intact (since we swapped i-1)
                swaps[i] = swaps[i - 1] + 1;

                // we just copy since we don't need a swap
                keep[i] = keep[i - 1];
            }

            // the sequence is not strictly increasing (or it is
            // and we need to "floor" the counts on i), but we can
            // swap i  meet the condition.
            if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                // we do a swap on i but we use the original i-1
                // ordered if possible (i-1 is striclty
                // increasing without a swap)
                swaps[i] = Math.min(swaps[i], keep[i - 1] + 1);

                // we need to swap on i
                keep[i] = Math.min(keep[i], swaps[i - 1]);
            }
        }
        return Math.min(swaps[A.length - 1], keep[A.length - 1]);
    }
}
