import java.util.*;

class Solution {
    private static int w, h;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        w = in.nextInt(); h = in.nextInt(); in.nextLine();
        char[][] grid = new char[h][];
        for (int i = 0; i < h; i++)
            grid[i] = in.nextLine().toCharArray();
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                if ((i == 0 || i == h - 1 || j == 0 || j == w - 1) && grid[i][j] == '.')
                    infect(grid, i, j);
        filterPrint(grid);
    }

    // From any '.' in the border, infect adjacents with 'z' (NO diagonals)
    private static void infect(char[][] m, int i, int j) {
        if (i < 0 || i >= h || j < 0 || j >= w || m[i][j] != '.')
            return;
        m[i][j] = 'z';
        infect(m, i - 1, j);
        infect(m, i + 1, j);
        infect(m, i, j - 1);
        infect(m, i, j + 1);
    }

    // Print matrix, only print 'z' if it's adjacent to 'B'
    private static void filterPrint(char[][] m) {
        for (int i = 0; i < h; System.out.println(), i++)
            for (int j = 0; j < w; j++)
                if (m[i][j] == 'z')
                    System.out.print(closeToB(m, i, j) ? 'z' : '.');
                else
                    System.out.print(m[i][j]);
    }

    // Is cell (i, j) adjacent to 'B'? (diagonals included)
    private static boolean closeToB(char[][] m, int y, int x) {
        for (int i = y - 1; i <= y + 1; i++) 
            for (int j = x - 1; j <= x + 1; j++) 
                try{
                    if (m[i][j] == 'B') return true;
                } catch (ArrayIndexOutOfBoundsException ex){}
        return false;
    }
}
