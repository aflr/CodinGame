import java.util.*;
class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int w = in.nextInt(), h = in.nextInt();
        in.nextLine();
        char[][] grid = new char[h][w], sol = new char[h][w];
        for (int i = 0; i < h; i++) {
            char[] line = in.nextLine().toCharArray();
            for (int j = 0; j < w; j++)
                grid[i][j] = line[j];
        }
        // Add numbers
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                char c = '0';
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        try{
                        c += (grid[k][l] == 'x') ? 1 : 0;
                        } catch (ArrayIndexOutOfBoundsException ex) {}
                    }
                }
                sol[i][j] = c;
            }
        }
        // Print solution, change '0' and 'x' to dot
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++)
                System.out.print(sol[i][j] != '0' && grid[i][j] != 'x' ? sol[i][j] : '.');
            System.out.println();
        }
    }
}
