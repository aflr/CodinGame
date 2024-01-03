import java.util.*;

class Solution {

    private static final char DEAD = '.', ALIVE = 'O';
    private static int H, W;
    private static boolean[] alive = new boolean[9], dead = new boolean[9];

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        H = in.nextInt(); W = in.nextInt();
        int N = in.nextInt(); in.nextLine();

        // Read rules
        char[] _alive = in.nextLine().toCharArray();
        char[] _dead = in.nextLine().toCharArray();
        for (int i = 0; i < 9; i++) {
            alive[i] = _alive[i] == '1';
            dead[i] = _dead[i] == '1';
        }

        // Read initial grid
        char[][] grid = new char[H][W];
        for (int i = 0; i < H; i++) {
            char[] line = in.nextLine().toCharArray();
            for (int j = 0; j < W; j++)
                grid[i][j] = line[j];
        }

        // Simulate N turns
        for (int i = 0; i < N; i++)
            grid = simulateTurn(grid);

        printGrid(grid, System.out);
    }

    private static char[][] simulateTurn(char[][] grid) {
        char[][] newgrid = new char[H][W];
        for (int i = 0; i < H; i++)
            for (int j = 0; j < W; j++)
                if (grid[i][j] == DEAD)
                    newgrid[i][j] = dead[neighbourCount(grid, i, j)] ? ALIVE : DEAD;
                else if (grid[i][j] == ALIVE)
                    newgrid[i][j] = alive[neighbourCount(grid, i, j)] ? ALIVE : DEAD;
        return newgrid;
    }

    private static int neighbourCount(char[][] grid, int y, int x) {
        int count = 0;
        for (int i = y - 1; i <= y + 1; i++)
            for (int j = x - 1; j <= x + 1; j++)
                if (i >= 0 && j >= 0 && i < H && j < W
                        && (i != y || j != x) && grid[i][j] == ALIVE)
                    count++;
        return count;
    }

    private static void printGrid(char[][] grid, java.io.PrintStream ps) {
        for (int i = 0; i < grid.length; ps.println(), i++)
            for (int j = 0; j < grid[i].length; j++)
                ps.print(grid[i][j]);
    }
}
