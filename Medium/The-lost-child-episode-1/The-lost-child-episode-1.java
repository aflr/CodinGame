import java.util.*;

class Solution {

    private static final int H = 10;
    private static final int W = 10;
    private static char[][] map;
    private static int[][] grid;
    private static int[] m = { -1, -1 }, c = { -1, -1 };

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // Read map, save positions of M and C
        map = new char[H][W];
        for (int i = 0; i < H; i++) {
            char[] row = in.nextLine().toCharArray();
            for (int j = 0; j < W; j++) {
                map[i][j] = row[j];
                if (row[j] == 'M') {
                    m[0] = i;
                    m[1] = j;
                } else if (row[j] == 'C') {
                    c[0] = i;
                    c[1] = j;
                }
            }
        }

        // Initialize grid of distances
        grid = new int[H][W];
        for (int[] row : grid)
            Arrays.fill(row, Integer.MAX_VALUE);

        // Flood fill grid, starting at child's position
        flood(c[0], c[1], 0);

        // Print final grid state, for debugging
        for (int i = 0; i < H; System.err.println(), i++)
            for (int j = 0; j < W; j++)
                System.err.printf("%2d ",
                        grid[i][j] == Integer.MAX_VALUE ? -1 : grid[i][j]);

        // Print shortest distance to mother's position
        System.out.println(grid[m[0]][m[1]] + "0km");
    }

    private static void flood(int y, int x, int v) {
        if (y < 0 || x < 0 || y >= H || x >= W || map[y][x] == '#'
                || v >= grid[y][x] || v >= grid[m[0]][m[1]])
            return;
        grid[y][x] = v++;
        flood(y - 1, x, v);
        flood(y + 1, x, v);
        flood(y, x - 1, v);
        flood(y, x + 1, v);
    }
}
