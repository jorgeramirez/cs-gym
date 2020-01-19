class Solution {
    // all directions
    int[][] dirs = new int[][] {
        // left, up, right, down
        { 0, -1 },
        { -1, 0 },
        { 0, 1 },
        { 1, 0 },
        // top left, top right, bottom left, bottom right
        { -1, -1 },
        { -1, 1 },
        { 1, -1 },
        { 1, 1 }
    };

    public char[][] updateBoard(char[][] board, int[] click) {
        int rows = board.length;
        int cols = board[0].length;

        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(click);

        while (!q.isEmpty()) {
            int len = q.size();
            while (len-- > 0) {
                int[] current = q.poll();
                List<int[]> neis = new ArrayList<>();
                int adjMines = 0;

                for (int[] dir : dirs) {
                    int neiR = current[0] + dir[0];
                    int neiC = current[1] + dir[1];

                    if (neiR < 0 || neiR == rows || neiC < 0 || neiC == cols) {
                        continue;
                    }

                    if (board[neiR][neiC] == 'M') {
                        ++adjMines;
                    } else if (board[neiR][neiC] == 'E') {
                        neis.add(new int[] { neiR, neiC });
                    }
                }

                if (adjMines > 0) {
                    board[current[0]][current[1]] = (char) (adjMines + '0');
                    continue;
                }
                board[current[0]][current[1]] = 'B';

                for (int[] nei : neis) {
                    q.add(nei);

                    // we mark the neighboard as visited using 'V';
                    board[nei[0]][nei[1]] = 'V';
                }
            }
        }
        return board;
    }
}
