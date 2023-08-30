class Solution {
    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        int[][] board = new int[9][9];
        boolean[][] mustStay = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            char[] line = in.nextLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                board[i][j] = line[j] - '0';
                mustStay[i][j] = board[i][j] != 0;
            }
        }
        solve(board, mustStay);
        printBoard(board);
    }
    private static boolean solve(int[][] board, boolean[][] mustStay) {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != 0)
                    continue;
                for (int k = 1; k <= 9; k++)
                    if (valid(k, board, i, j)) {
                        board[i][j] = k;
                        if (solve(board, mustStay))
                            return true;
                        else if (!mustStay[i][j])
                            board[i][j] = 0;
                    }
                return false;
            }
        return true;
    }
    private static boolean valid(int k, int[][] board, int i, int j) {
        return validRow(k, board, i) && validCol(k, board, j) && validSquare(k, board, i, j);
    }
    private static boolean validRow(int k, int[][] board, int row) {
        for (int i = 0; i < 9; i++)
            if (board[row][i] == k)
                return false;
        return true;
    }
    private static boolean validCol(int k, int[][] board, int col) {
        for (int i = 0; i < 9; i++)
            if (board[i][col] == k)
                return false;
        return true;
    }
    private static boolean validSquare(int k, int[][] board, int row, int col) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[row / 3 * 3 + i][col / 3 * 3 + j] == k)
                    return false;
        return true;
    }
    private static void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(board[i][j]);
            System.out.println();
        }
    }
}
