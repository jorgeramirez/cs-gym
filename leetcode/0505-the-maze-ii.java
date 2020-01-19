class Solution {
    // up, down, left, right
    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { start[0], start[1] });
        int[][] distance = new int[maze.length][maze[0].length];

        for (int i = 0; i < distance.length; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            while (len-- > 0) {
                int[] current = q.poll();
                int ci = current[0];
                int cj = current[1];

                for (int[] dir : dirs) {
                    int[] landing = roll(maze, current, dir);
                    int i = landing[0];
                    int j = landing[1];
                    int d = landing[2];
                    if (distance[i][j] > distance[ci][cj] + d) {
                        distance[i][j] = d + distance[ci][cj];
                        q.add(new int[] { i, j });
                    }
                }
            }
        }
        int iEnd = destination[0];
        int jEnd = destination[1];
        return distance[iEnd][jEnd] != Integer.MAX_VALUE
            ? distance[iEnd][jEnd]
            : -1;
    }

    int[] roll(int[][] maze, int[] start, int[] dir) {
        int[] pos = { start[0], start[1], 0 };
        int rows = maze.length;
        int cols = maze[0].length;

        while (
            pos[0] >= 0 &&
            pos[0] < rows &&
            pos[1] >= 0 &&
            pos[1] < cols &&
            maze[pos[0]][pos[1]] == 0
        ) {
            pos[0] += dir[0];
            pos[1] += dir[1];
            ++pos[2];
        }
        pos[0] -= dir[0];
        pos[1] -= dir[1];
        --pos[2];
        return pos;
    }
}
