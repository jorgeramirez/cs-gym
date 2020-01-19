class Solution {

    public void solve(char[][] board) {
        if (board == null || board.length < 2) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        // first row
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O' && !visited[0][j]) {
                bfs(board, 0, j, visited);
            }
        }

        // last row
        for (int j = 0; j < cols; j++) {
            if (board[rows - 1][j] == 'O' && !visited[rows - 1][j]) {
                bfs(board, rows - 1, j, visited);
            }
        }

        // first column
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                bfs(board, i, 0, visited);
            }
        }

        // last column
        for (int i = 0; i < rows; i++) {
            if (board[i][cols - 1] == 'O' && !visited[i][cols - 1]) {
                bfs(board, i, cols - 1, visited);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    void bfs(char[][] board, int rowSrc, int colSrc, boolean[][] visited) {
        int rows = board.length;
        int cols = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { rowSrc, colSrc });

        while (!q.isEmpty()) {
            int len = q.size();

            while (len-- > 0) {
                int[] node = q.poll();
                visited[node[0]][node[1]] = true;

                for (int[] dir : dirs) {
                    int[] nei = new int[2];
                    nei[0] = node[0] + dir[0];
                    nei[1] = node[1] + dir[1];
                    if (
                        nei[0] < 0 ||
                        nei[0] == rows ||
                        nei[1] < 0 ||
                        nei[1] == cols
                    ) {
                        continue;
                    }
                    if (
                        visited[nei[0]][nei[1]] || board[nei[0]][nei[1]] == 'X'
                    ) {
                        continue;
                    }
                    q.add(nei);
                    visited[nei[0]][nei[1]] = true;
                }
            }
        }
    }
}
