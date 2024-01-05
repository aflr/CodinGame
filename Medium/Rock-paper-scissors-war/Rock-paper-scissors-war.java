import java.io.PrintStream;
import java.util.*;

class Solution {

    private static int W, H;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        W = in.nextInt(); H = in.nextInt();
        int n = in.nextInt(); in.nextLine();
        char[][] grid = new char[H][W];
        for (int i = 0; i < H; i++) {
            char[] line = in.nextLine().toCharArray();
            for (int j = 0; j < W; j++)
                grid[i][j] = line[j];
        }
        for (int i = 0; i < n; i++)
            grid = simulateDay(grid);
        print(grid, System.out);
    }

    private static char[][] simulateDay(char[][] grid) {
        char[][] newgrid = new char[H][W];
        for (int i = 0; i < H; i++)
            for (int j = 0; j < W; j++) {
                Set<Character> winners = new HashSet<>();
                if (i > 0 && fight(grid[i - 1][j], grid[i][j]) > 0)
                    winners.add(grid[i - 1][j]);
                if (i < H - 1 && fight(grid[i + 1][j], grid[i][j]) > 0)
                    winners.add(grid[i + 1][j]);
                if (j > 0 && fight(grid[i][j - 1], grid[i][j]) > 0)
                    winners.add(grid[i][j - 1]);
                if (j < W - 1 && fight(grid[i][j + 1], grid[i][j]) > 0)
                    winners.add(grid[i][j + 1]);
                if (winners.size() == 0)
                    newgrid[i][j] = grid[i][j];
                else if (winners.size() == 1)
                    newgrid[i][j] = winners.iterator().next();
                else if (winners.size() == 2) {
                    Character[] two = new Character[2];
                    winners.toArray(two);
                    newgrid[i][j] = fight(two[0], two[1]) > 0 ? two[0] : two[1];
                }
            }
        return newgrid;
    }

    private static void print(char[][] grid, PrintStream ps) {
        for (int i = 0; i < H; ps.println(), i++)
            for (int j = 0; j < W; j++)
                ps.print(grid[i][j]);
    }

    public static int fight(char c1, char c2) {
        switch (c1) {
            case 'R':
                if (c2 == 'L' || c2 == 'C') return 1;
                if (c2 == 'P' || c2 == 'S') return -1;
                return 0;
            case 'P':
                if (c2 == 'R' || c2 == 'S') return 1;
                if (c2 == 'C' || c2 == 'L') return -1;
                return 0;
            case 'C':
                if (c2 == 'P' || c2 == 'L') return 1;
                if (c2 == 'S' || c2 == 'R') return -1;
                return 0;
            case 'L':
                if (c2 == 'S' || c2 == 'P') return 1;
                if (c2 == 'R' || c2 == 'C') return -1;
                return 0;
            case 'S':
                if (c2 == 'C' || c2 == 'R') return 1;
                if (c2 == 'L' || c2 == 'P') return -1;
                return 0;
            default:
                throw new IllegalArgumentException();
        }
    }
}
