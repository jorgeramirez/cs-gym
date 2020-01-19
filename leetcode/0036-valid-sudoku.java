class Solution {

    public boolean isValidSudoku(char[][] board) {
        int n = board.length;

        // row-wise checks
        for (int r = 0; r < n; r++) {
            Set<Character> digits = new HashSet<>();

            for (int c = 0; c < n; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                if (digits.contains(board[r][c])) {
                    return false;
                }
                digits.add(board[r][c]);
            }
        }

        // col-wise checks
        for (int c = 0; c < n; c++) {
            Set<Character> digits = new HashSet<>();

            for (int r = 0; r < n; r++) {
                if (board[r][c] == '.') {
                    continue;
                }
                if (digits.contains(board[r][c])) {
                    return false;
                }
                digits.add(board[r][c]);
            }
        }

        // sub-squares checks
        int step = 3;

        for (int r = 0; r < n; r += step) {
            for (int c = 0; c < n; c += step) {
                boolean isValid = checkSquare(board, r, c, step);
                if (!isValid) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean checkSquare(char[][] board, int rowStart, int colStart, int limit) {
        Set<Character> digits = new HashSet<>();

        for (int r = rowStart; r < rowStart + limit; r++) {
            for (int c = colStart; c < colStart + limit; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                if (digits.contains(board[r][c])) {
                    return false;
                }
                digits.add(board[r][c]);
            }
        }
        return true;
    }
}
