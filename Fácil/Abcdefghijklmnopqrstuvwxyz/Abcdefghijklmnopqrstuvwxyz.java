import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // Read and store input grid
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] m = in.next().toCharArray();
            for (int j = 0; j < n; j++)
                grid[i][j] = m[j];
        }
        char[][] sol = new char[n][n];
top:    for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 'a')
                    continue;
                for (int k = 0; k < n; k++)
                    Arrays.fill(sol[k], '-');
                if (infect(sol, grid, j, i, 'a'))
                    break top;
            }
        }
        // Print solution matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(sol[i][j]);
            System.out.println();
        }
    }

    private static boolean infect(char[][] sol, char[][] grid, int x, int y, char c) {
        sol[y][x] = c;
        if (c == 'z')
            return true;
        try {
            if (grid[y-1][x] == c + 1)      // UP
                return infect(sol, grid, x, y-1, (char) (c + 1));
        } catch (ArrayIndexOutOfBoundsException ex) {}
        try {
            if (grid[y+1][x] == c + 1)      // DOWN
                return infect(sol, grid, x, y+1, (char) (c + 1));
        } catch (ArrayIndexOutOfBoundsException ex) {}
        try {
            if (grid[y][x-1] == c + 1)      // LEFT
                return infect(sol, grid, x-1, y, (char) (c + 1));
        } catch (ArrayIndexOutOfBoundsException ex) {}
        try {
            if (grid[y][x+1] == c + 1)      // RIGHT
                return infect(sol, grid, x+1, y, (char) (c + 1));
        } catch (ArrayIndexOutOfBoundsException ex) {}
        return false;
    }
}
