import java.util.HashSet;
import java.util.Set;

class Solution {

    public int numIslands(char[][] grid) {
        Set<String> visited = new HashSet<>();
        int nIslands = 0;
        Point p;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                p = new Point(i, j);

                if (grid[i][j] == '0' || visited.contains(p.getKey())) {
                    continue;
                }
                ++nIslands;
                dfs(grid, visited, p);
            }
        }
        return nIslands;
    }

    public void dfs(char[][] grid, Set<String> visited, Point p) {
        if (p.i < 0 || p.i == grid.length || p.j < 0 || p.j == grid[0].length) {
            return;
        }

        if (grid[p.i][p.j] == '0' || visited.contains(p.getKey())) {
            return;
        }
        visited.add(p.getKey());
        dfs(grid, visited, p.left());
        dfs(grid, visited, p.right());
        dfs(grid, visited, p.top());
        dfs(grid, visited, p.down());
    }

    class Point {
        int i, j;

        Point(int _i, int _j) {
            i = _i;
            j = _j;
        }

        Point top() {
            return new Point(i - 1, j);
        }

        Point down() {
            return new Point(i + 1, j);
        }

        Point right() {
            return new Point(i, j + 1);
        }

        Point left() {
            return new Point(i, j - 1);
        }

        String getKey() {
            return i + "-" + j;
        }
    }
}
