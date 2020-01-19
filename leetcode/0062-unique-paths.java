class Solution {

    // top-down solution 5ms
    public int uniquePaths(int m, int n) {
        HashMap<String, Integer> dp = new HashMap<>();
        return dfs(n, m, new Point(0, 0), new Point(n - 1, m - 1), dp);
    }

    int dfs(int rows, int cols, Point s, Point e, HashMap<String, Integer> dp) {
        if (s.i == rows || s.j == cols) {
            return -1;
        }
        if (s.equals(e)) {
            return 1;
        }
        if (dp.containsKey(s.getKey())) {
            return dp.get(s.getKey());
        }
        int uniquePaths = 0;
        int paths = dfs(rows, cols, s.down(), e, dp);
        if (paths > 0) {
            uniquePaths += paths;
            dp.put(s.down().getKey(), paths);
        }
        paths = dfs(rows, cols, s.right(), e, dp);
        if (paths > 0) {
            uniquePaths += paths;
            dp.put(s.right().getKey(), paths);
        }
        dp.put(s.getKey(), uniquePaths);
        return uniquePaths;
    }

    static class Point {
        int i;
        int j;

        public Point(int _i, int _j) {
            i = _i;
            j = _j;
        }

        Point right() {
            return new Point(i, j + 1);
        }

        Point down() {
            return new Point(i + 1, j);
        }

        String getKey() {
            return i + "-" + j;
        }

        @Override
        public boolean equals(Object o) {
            Point p = (Point) o;
            return i == p.i && j == p.j;
        }
    }
// bottom-up solution 0 ms 5.10% memory
// public int uniquePaths(int m, int n) {
//   int rows = n; int cols = m;
//   int[][] dp = new int[rows][cols];
//   // we can form one unique path from every cell in the first row/col
//   for(int i = 0; i < cols; i++) {
//     dp[0][i] = 1;
//   }
//   for(int i = 0; i < rows; i++) {
//     dp[i][0] = 1;
//   }
//   for(int i = 1; i < rows; i++) {
//     for(int j = 1; j < cols; j++) {
//       dp[i][j] = dp[i-1][j] + dp[i][j-1];
//     }
//   }
//   return dp[rows-1][cols-1];
// }
}
