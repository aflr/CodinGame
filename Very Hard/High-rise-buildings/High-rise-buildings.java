class Solution {

    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        int n = in.nextInt();

        // Some data structures
        int[][] grid = new int[n][n];
        int[][] clues = new int[4][n];
        boolean[][] mustStay = new boolean[n][n];

        // Read clues
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < n; j++)
                clues[i][j] = in.nextInt();

        // Read starting cells
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                grid[i][j] = in.nextInt();
                mustStay[i][j] = (grid[i][j] != 0);
            }

        // Solve and print
        solve(grid, mustStay, clues, n);
        print(grid, n);
    }

    // Very simple backtracking, same as a sudoku solver but different validation function
    private static boolean solve(int[][] grid, boolean[][] mustStay, int[][] clues, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    continue;
                } else {
                    for (int k = 1; k <= n; k++) {
                        if (valid(k, grid, clues, i, j, n)) {
                            grid[i][j] = k;
                            if (solve(grid, mustStay, clues, n)) {
                                return true;
                            } else if (!mustStay[i][j]) {
                                grid[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    // Check if a number k is possible at grid[i][j]
    private static boolean valid(int k, int[][] grid, int[][] clues, int i, int j, int n) {
        // Check row and column
        for (int z = 0; z < n; z++) {
            if (grid[z][j] == k)
                return false;
            if (grid[i][z] == k)
                return false;
        }
        // Check visibility clues
        // NORTH
        int N = clues[0][j];
        int[] arrayN = new int[n];
        boolean[] arrayMustStayN = new boolean[n];
        for (int z = 0; z < n; z++) {
            arrayN[z] = (z == i) ? k : grid[z][j];
            arrayMustStayN[z] = arrayN[z] != 0;
        }
        if (!validVis(arrayN, arrayMustStayN, N, n))
            return false;
        // SOUTH
        int S = clues[3][j];
        int[] arrayS = new int[n];
        boolean[] arrayMustStayS = new boolean[n];
        for (int z = 0; z < n; z++) {
            arrayS[z] = (z == n - 1 - i) ? k : grid[n - 1 - z][j];
            arrayMustStayS[z] = arrayS[z] != 0;
        }
        if (!validVis(arrayS, arrayMustStayS, S, n))
            return false;
        // WEST
        int W = clues[1][i];
        int[] arrayW = new int[n];
        boolean[] arrayMustStayW = new boolean[n];
        for (int z = 0; z < n; z++) {
            arrayW[z] = (z == j) ? k : grid[i][z];
            arrayMustStayW[z] = arrayW[z] != 0;
        }
        if (!validVis(arrayW, arrayMustStayW, W, n))
            return false;
        // EAST
        int E = clues[2][i];
        int[] arrayE = new int[n];
        boolean[] arrayMustStayE = new boolean[n];
        for (int z = 0; z < n; z++) {
            arrayE[z] = (n - 1 - z == j) ? k : grid[i][n - 1 - z];
            arrayMustStayE[z] = arrayE[z] != 0;
        }
        if (!validVis(arrayE, arrayMustStayE, E, n))
            return false;
        return true;
    }

    // Is there at least 1 valid way to fill the array with the given visibility clue?
    private static boolean validVis(int[] array, boolean[] arrayMustStay, int vis, int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] != 0)
                continue;
            for (int j = 1; j <= n; j++)
                if (notInArray(array, j, n)) {
                    array[i] = j;
                    if (validVis(array, arrayMustStay, vis, n))
                        return true;
                    else if (!arrayMustStay[i])
                        array[i] = 0;
                }
            return false;
        }
        return (vis == countVis(array));
    }

    private static boolean notInArray(int[] array, int num, int n) {
        for (int i = 0; i < n; i++)
            if (array[i] == num)
                return false;
        return true;
    }

    private static int countVis(int[] array) {
        int count = 0, max = -1;
        for (int i = 0; i < array.length; i++)
            if (array[i] > max) {
                count++;
                max = array[i];
            }
        return count;
    }

    private static void print(int[][] grid, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(grid[i][j] + (j != n - 1 ? " " : ""));
            System.out.println();
        }
    }
}
