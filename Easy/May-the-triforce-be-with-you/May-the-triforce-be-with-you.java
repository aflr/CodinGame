class Solution {

    public static void main(String args[]) {
        // Read size
        int N = new java.util.Scanner(System.in).nextInt();
        // Create grid of characters
        char[][] grid = new char[N * 2][(N * 2 - 1) * 2 + 1];
        // Initialize grid to spaces
        for (int i = 0; i < grid.length; i++)
            java.util.Arrays.fill(grid[i], ' ');
        // Add dot to top-left to avoid automatic trimming
        grid[0][0] = '.';
        // Fill triangles
        for (int i = 0; i < N; i++)
            for (int j = N - i - 1; j < N + i; j++)
                grid[i][j + N] = grid[i + N][j] = grid[i + N][j + 2 * N] = '*';
        // Print result
        printGrid(grid, System.out);
    }

    private static void printGrid(char[][] grid, java.io.PrintStream ps) {
        StringBuilder sb;
        for (int i = 0; i < grid.length; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < grid[i].length; j++)
                sb.append(grid[i][j]);
            ps.println(sb.toString().replaceAll(" +$", ""));
        }
    }
}
