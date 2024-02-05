import java.util.*;

class Solution {
    private static final char EMPTY = ' ', CHAR = '+';

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        // Read input
        int size = in.nextInt(), thick = in.nextInt(), N = in.nextInt(); in.nextLine();

        // Read text lines, create char matrices for the text and the logo grid
        char[][] text = new char[N][], grid = new char[N * size][];
        for (int i = 0; i < N; i++) {
            text[i] = in.nextLine().toCharArray();
            for (int j = 0; j < size; j++)
                grid[i * size + j] = new char[text[i].length * size];
        }
        // Initialize grid to empty char
        for (var row : grid)
            Arrays.fill(row, EMPTY);

        // Draw plus signs, one at a time, aware of neighbors
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < text[i].length; j++) {
                if (text[i][j] != '+')
                    continue;
                // true means close the plus sign in that direction
                boolean[] NESW = new boolean[4];
                // NORTH
                try {
                    if (i == 0 || text[i - 1][j] != '+') NESW[0] = true;
                } catch (ArrayIndexOutOfBoundsException ex) { NESW[0] = true; }
                // EAST
                try {
                    if (j == text[i].length - 1 || text[i][j + 1] != '+')  NESW[1] = true;
                } catch (ArrayIndexOutOfBoundsException ex) { NESW[1] = true; }
                // SOUTH
                try {
                    if (i == text.length - 1 || text[i + 1][j] != '+')  NESW[2] = true;
                } catch (ArrayIndexOutOfBoundsException ex) { NESW[2] = true; }
                // WEST
                try {
                    if (j == 0 || text[i][j - 1] != '+') NESW[3] = true;    
                } catch (ArrayIndexOutOfBoundsException ex) { NESW[3] = true; }

                final int V = (size - thick) / 2;
                /* --- Outer outlines --- */ 
                for (int k = 0; k < thick; k++) {
                    if (NESW[0]) grid[i * size][j * size + V + k] = CHAR;
                    if (NESW[1]) grid[i * size + V + k][(j + 1) * size - 1] = CHAR;
                    if (NESW[2]) grid[(i + 1) * size - 1][j * size + V + k] = CHAR;
                    if (NESW[3]) grid[i * size + V + k][j * size] = CHAR;
                }
                /* --- Inner outlines --- */
                // VERTICAL
                for (int ii = i * size; ii < (i + 1) * size; ii++) {
                    if (ii > i * size + V && ii < i * size + V + thick - 1)
                        continue;
                    grid[ii][j * size + V] = CHAR;
                    grid[ii][j * size + V + thick - 1] = CHAR;
                }
                // HORIZONTAL
                for (int jj = j * size; jj < (j + 1) * size; jj++) {
                    if (jj > j * size + V && jj < j * size + V + thick - 1)
                        continue;
                    grid[i * size + V][jj] = CHAR;
                    grid[i * size + V + thick - 1][jj] = CHAR;
                }
            }
        }
        // Print final logo grid
        for (int i = 0; i < grid.length; i++)
            System.out.println(String.valueOf(grid[i]).replaceFirst(EMPTY + "+$", ""));
    }
}
