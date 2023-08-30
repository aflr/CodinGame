import java.util.*;

class Solution {

    private static final String abc = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static int h;
    private static int w;

    public static void main(String args[]) {
        var in = new Scanner(System.in);
        w = in.nextInt();
        h = in.nextInt();
        in.nextLine();

        // Read and store initial maze
        var maze = new char[h][w];
        for (int i = 0; i < h; i++)
            maze[i] = Arrays.copyOf(in.nextLine().toCharArray(), w);

        // Create solution matrix, initialize to 36 (always too big)
        var sol = new int[h][w];
        for (var r : sol)
            for (int i = 0; i < w; i++)
                r[i] = 36;

        // Find start, then recursively infect neighbors
        out: for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                if (maze[i][j] == 'S') {
                    sol[i][j] = 0;
                    infect(sol, maze, i, j);
                    break out;
                }

        // Print solution
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++)
                if (maze[i][j] == '#')
                    System.out.print('#');
                else if (maze[i][j] == 'S')
                    System.out.print(0);
                else if (sol[i][j] < 36)
                    System.out.print(abc.charAt(sol[i][j]));
                else
                    System.out.print('.');
            System.out.println();
        }

    }

    private static void infect(int[][] sol, char[][] maze, int i, int j) {
        int n = sol[i][j] + 1;

        int im = (i - 1 + h) % h;
        if (maze[im][j] == '.' && n < sol[im][j]) {
            sol[im][j] = n;
            infect(sol, maze, im, j);
        }

        int ip = (i + 1) % h;
        if (maze[ip][j] == '.' && n < sol[ip][j]) {
            sol[ip][j] = n;
            infect(sol, maze, ip, j);
        }

        int jm = (j - 1 + w) % w;
        if (maze[i][jm] == '.' && n < sol[i][jm]) {
            sol[i][jm] = n;
            infect(sol, maze, i, jm);
        }

        int jp = (j + 1) % w;
        if (maze[i][jp] == '.' && n < sol[i][jp]) {
            sol[i][jp] = n;
            infect(sol, maze, i, jp);
        }
    }
}
