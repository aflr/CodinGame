import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        char[][] grid = new char[5][10]; in.nextLine();
        // Read initial grid value
        for (int i = 0; i < 5; i++) {
            String ROW = in.nextLine();
            for (int j = 0; j < 5; j++)
                grid[i][j] = ROW.charAt(j + 2);
            for (int j = 0; j < 5; j++)
                grid[i][j + 5] = ROW.charAt(j + 10);
        }
        for (int i = 0; i < 3; i++) in.nextLine();
        // Subtract
        for (int i = 0; i < 5; i++) {
            String ROW = in.nextLine();
            for (int j = 0; j < 5; j++)
                if (ROW.charAt(j + 2) != ' ')
                    grid[i][j] = ' ';
            for (int j = 0; j < 5; j++)
                if (ROW.charAt(j + 10) != ' ')
                    grid[i][j + 5] = ' ';
        }
        for (int i = 0; i < 3; i++) in.nextLine();
        // Add
        for (int i = 0; i < 5; i++) {
            String ROW = in.nextLine();
            for (int j = 0; j < 5; j++)
                if (ROW.charAt(j + 2) != ' ')
                    grid[i][j] = ROW.charAt(j + 2);
            for (int j = 0; j < 5; j++)
                if (ROW.charAt(j + 10) != ' ')
                    grid[i][j + 5] = ROW.charAt(j + 10);
        }
        printGrid(grid, System.err);
        System.out.printf("%02d\n", parseNum(grid));
    }

    private static int parseNum(char[][] grid) {
        final List<Integer> DECODE = List.of(1, 79, 18, 6, 76, 36, 32, 15, 0, 4);
        int d1 = 0;
        if (grid[2][2] == ' ') d1 |= 1;
        if (grid[1][0] == ' ') d1 |= 2;
        if (grid[3][0] == ' ') d1 |= 4;
        if (grid[4][2] == ' ') d1 |= 8;
        if (grid[3][4] == ' ') d1 |= 16;
        if (grid[1][4] == ' ') d1 |= 32;
        if (grid[0][2] == ' ') d1 |= 64;
        int d2 = 0;
        if (grid[2][7] == ' ') d2 |= 1;
        if (grid[1][5] == ' ') d2 |= 2;
        if (grid[3][5] == ' ') d2 |= 4;
        if (grid[4][7] == ' ') d2 |= 8;
        if (grid[3][9] == ' ') d2 |= 16;
        if (grid[1][9] == ' ') d2 |= 32;
        if (grid[0][7] == ' ') d2 |= 64;
        return DECODE.indexOf(d1) * 10 + DECODE.indexOf(d2);
    }

    /**
     * Prints the matrix of characters 'grid' to the PrintStream 'ps'
     * This is used for debugging only
     */
    private static void printGrid(char[][] grid, java.io.PrintStream ps) {
        for (int i = 0; i < grid.length; ps.println(), i++)
            for (int j = 0; j < grid[i].length; j++)
                ps.print(grid[i][j]);
    }
}
