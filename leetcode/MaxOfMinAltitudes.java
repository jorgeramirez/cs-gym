// https://leetcode.com/discuss/interview-question/383669/
public class MaxOfMinAltitudes {

    // I could further improve this by using an array B of size A[0].length instead of a matrix.
    public int maxOfMinAltitues(int[][] A) {
        int[][] B = new int[A.length][A[0].length];

        int min = A[1][0];
        for (int i = 1; i < A.length; i++) {
            if (A[i][0] < min) {
                min = A[i][0];
            }
        }

        for (int i = 1; i < A.length; i++) {
            B[i][0] = min;
        }

        min = A[0][1];
        for (int i = 1; i < A.length; i++) {
            if (A[0][i] < min) {
                min = A[0][i];
            }
        }
        for (int i = 1; i < A[0].length; i++) {
            B[0][i] = min;
        }

        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < A[0].length; j++) {

                if (i == A.length - 1 && j == A[0].length - 1) {
                    return Math.max(B[i][j - 1], B[i - 1][j]);
                }

                int val = Math.max(B[i - 1][j], B[i][j - 1]);
                B[i][j] = Math.min(val, A[i][j]);
            }
        }
        return B[B.length - 1][B[0].length - 1];
    }

    public static void main(String[] args) {
        MaxOfMinAltitudes s = new MaxOfMinAltitudes();
        int[][] A = new int[][]{
                new int[]{5, 1},
                new int[]{4, 5}
        };
        System.out.println(s.maxOfMinAltitues(A));

        A = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 1}
        };
        System.out.println(s.maxOfMinAltitues(A));
    }
}
