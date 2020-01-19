class Solution {

    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxGold = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                int max = dfs(grid, new boolean[m][n], i, j);
                maxGold = Math.max(maxGold, max);
            }
        }
        return maxGold;
    }

    int dfs(int[][] grid, boolean[][] visited, int i, int j) {
        int sum = 0;
        visited[i][j] = true;
        List<int[]> moves = getMoves(grid, visited, i, j);
        for (int[] next : moves) {
            sum = Math.max(sum, dfs(grid, visited, next[0], next[1]));
        }
        visited[i][j] = false;
        return grid[i][j] + sum;
    }

    int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    // return the possible moves
    List<int[]> getMoves(int[][] grid, boolean[][] visited, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        List<int[]> moves = new ArrayList<>();
        for (int[] dir : dirs) {
            int iNext = i + dir[0];
            int jNext = j + dir[1];
            if (
                iNext >= 0 &&
                iNext < m &&
                jNext >= 0 &&
                jNext < n &&
                grid[iNext][jNext] > 0 &&
                !visited[iNext][jNext]
            ) {
                moves.add(new int[] { iNext, jNext });
            }
        }
        return moves;
    }
}
